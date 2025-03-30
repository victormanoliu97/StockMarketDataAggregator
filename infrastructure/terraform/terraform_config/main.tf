terraform {
  backend "s3" {
    bucket  = "vm-terraform-state-bucket"
    key     = "terraform/state.tfstate"
    region  = "eu-central-1"
    encrypt = true
  }
}
