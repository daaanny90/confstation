variable "build" {
  type = string
}

locals {
  image_tag = var.build
}

## Create Service Account
resource "google_service_account" "run_user" {
  account_id = "cloudrun-business"
  display_name = "Cloudrun User"
  description = "User to run Cloudrun"
  depends_on = [google_project_service.services]
}

resource "google_project_iam_member" "run_user_roles" {
  for_each = toset([])

  project = local.project
  member = "serviceAccount:${google_service_account.run_user.email}"
  role   = each.key
}

## Create Run Service
resource "google_cloud_run_service" "run_service" {
  name = "app"
  location = local.region

  template {
    spec {
      containers {
        image = "eu.gcr.io/${local.project}/confware:${local.image_tag}"
      }
      service_account_name = google_service_account.run_user.email
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

  depends_on = [google_project_service.services, google_service_account.run_user]
}

## Public Access to CloudRunInstance
resource "google_cloud_run_service_iam_member" "run_all_users" {
  service  = google_cloud_run_service.run_service.name
  location = google_cloud_run_service.run_service.location
  role     = "roles/run.invoker"
  member   = "allUsers"
}

output "service_url" {
  value = google_cloud_run_service.run_service.status[0].url
}