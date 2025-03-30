terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }
}

provider "aws" {
  region = "eu-central-1"
}

#Database variables
variable "db_username" {}
variable "db_password" {}
variable "db_root_password" {}
variable "db_database" {}

#Stock API Key variable
variable "stock_api_key" {}

resource "aws_instance" "db_server" {
  ami           = "ami-0bade3941f267d2b8"
  instance_type = "t2.micro"
  key_name      = "ec2_connect_key"
  user_data     = <<-EOF
  #!/bin/bash
  sudo yum update -y
  sudo yum install -y docker
  sudo service docker start

  # Add the ec2-user to the docker group so that I can run Docker commands without using sudo.
  sudo usermod -a -G docker ec2-user

  # Pull MySQL image
  docker pull mysql

  # Run MySQL container with the specified parameters
  docker run --name some-mysql \
    -e MYSQL_ROOT_PASSWORD=${var.db_root_password} \
    -e MYSQL_DATABASE=${var.db_database} \
    -e MYSQL_USER=${var.db_username} \
    -e MYSQL_PASSWORD=${var.db_password} \
    -p 3306:3306/tcp \
    -p 33060:33060/tcp \
    -d mysql:latest
  EOF

  tags = {
    Name = "DB"
  }
}

resource "aws_ssm_parameter" "db_username" {
  name = "/config/dev/stock-data-market-aggregator/spring.datasource.username"
  type = "String"
  value = var.db_username
}

resource "aws_ssm_parameter" "db_password" {
  name = "/config/dev/stock-data-market-aggregator/spring.datasource.password"
  type = "String"
  value = var.db_password
}

resource "aws_ssm_parameter" "db_url" {
  name = "/config/dev/stock-data-market-aggregator/spring.datasource.url"
  type = "String"
  value = "jdbc:mysql://${aws_instance.db_server.public_ip}:3306/${var.db_database}"
}

resource "aws_ssm_parameter" "stock_api_key" {
  name = "/config/dev/stock-data-market-aggregator/vantage.api-key"
  type = "String"
  value = var.stock_api_key
}