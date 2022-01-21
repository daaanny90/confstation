variable "build" {
  type = string
}

locals {
  image_tag = var.build
}

resource "google_cloud_run_service" "run_service" {
  name = "app"
  location = local.region

  template {
    spec {
      containers {
        image = "eu.gcr.io/${local.project}/confware:${local.image_tag}"
      }
    }

    metadata {
      annotations = {
        "autoscaling.knative.dev/maxScale" = "10"
        "autoscaling.knative.dev/minScale" = "1"
      }
    }
  }

  traffic {
    percent         = 100
    latest_revision = true
  }

  depends_on = [google_project_service.services]
}

resource "google_cloud_run_service_iam_member" "run_all_users" {
  service  = google_cloud_run_service.run_service.name
  location = google_cloud_run_service.run_service.location
  role     = "roles/run.invoker"
  member   = "allUsers"
}

output "service_url" {
  value = google_cloud_run_service.run_service.status[0].url
}