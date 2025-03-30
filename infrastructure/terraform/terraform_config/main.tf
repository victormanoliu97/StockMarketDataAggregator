variable "region" {}

provider "aws" {
  region = var.region
}

resource "aws_s3_bucket" "terraform_state" {
  bucket = "my-terraform-state-bucket"

  lifecycle {
    prevent_destroy = false  #This is because we want to destroy everything to reduce costs
  }
}

resource "aws_s3_bucket_acl" "terraform_state_bucket_acl" {
  bucket = aws_s3_bucket.terraform_state.id
  acl = "private"
}

resource "aws_s3_bucket_versioning" "terraform_state_bucket_versioning" {
  bucket = aws_s3_bucket.terraform_state.id
  versioning_configuration {
    status = "Enabled"
  }
}

terraform {
  backend "s3" {
    bucket  = "my-terraform-state-bucket"
    key     = "terraform/state.tfstate"
    region  = var.region
    encrypt = true
  }
}
