locals {
  project = "confware-stage"
  region  = "europe-west1"
  location = "europe-west"
}

terraform {
  required_version = ">= 1.1.4"

  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

terraform {
  backend "gcs" {
    bucket = "confware-stage-terraform"
    prefix = "states"
    credentials = "./credentials/terraform.json"
  }
}

provider "google" {
  credentials = file("./credentials/terraform.json")
  project     = local.project
  region      = local.region
}

resource "google_project_service" "services" {
  for_each = toset([
    "firestore.googleapis.com",
    "iam.googleapis.com",
    "run.googleapis.com",
    "appengine.googleapis.com"
  ])

  service            = each.key
  disable_on_destroy = true
}
