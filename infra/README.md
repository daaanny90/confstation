![Confgames](https://www.confgames.com/images/logo-cotent.png)

---
# Infrastruktur
## Terraform

das Script **terraformw** ist ein Wrapper für den Aufruf des Dockerimages von Terraform
hierfür wird **Docker** benötigt
### Benutzung

| Befehl                 | Beschreibung                                      |
|------------------------|---------------------------------------------------|
| ./terraformw init      | initialisiert Terraform mit dem State             |
| ./terraformw validate  | prüft die Configuration auf SyntaxFehler          |
| ./terraformw plan      | erstellt einen Plan was geändert wird             |
| ./terraformw apply     | führt die Änderungen durch                        |
| ./terraformw destroy   | entfernt die von Terraform erstelle InfraStruktur | 

### einmalige Einrichtung

1. Dienstkonto mit Recht **Inhaber** für Terraform anlegen
2. KeyFile erstellen und unter credentials/terraform.json ablegen
3. Api für MetaDataResources aktivieren
4. Bucket für State anlegen

---
## Links
* [Docker](https://www.docker.com/)
* [Terraform](https://www.terraform.io/)
* [Terraform Google Provider](https://registry.terraform.io/providers/hashicorp/google/latest/docs)
* [IAM Roles](https://cloud.google.com/iam/docs/understanding-roles)