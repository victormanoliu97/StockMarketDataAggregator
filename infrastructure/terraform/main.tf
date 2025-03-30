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
    -e MYSQL_ROOT_PASSWORD=mysql \
    -e MYSQL_DATABASE=database \
    -e MYSQL_USER=mysql \
    -e MYSQL_PASSWORD=mysql \
    -p 3306:3306/tcp \
    -p 33060:33060/tcp \
    -d mysql:latest
  EOF

  tags = {
    Name = "DB"
  }
}