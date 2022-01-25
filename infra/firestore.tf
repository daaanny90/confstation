resource "google_app_engine_application" "app" {
  project     = local.project
  location_id = local.location
  database_type = "CLOUD_FIRESTORE"
}