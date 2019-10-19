# Api-Client

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Alssantos482_apiclient&metric=alert_status)](https://sonarcloud.io/dashboard?id=Alssantos482_apiclient)


## Description

Api-Client is a restfull web API running with postgres and made with springboot framework.
In this Application have MVC pattern to struct code, unit tests to verify the application and Advice Controller to handle exception. For code review, the tool used is sonarcloud, for more details access [dashboard](https://sonarcloud.io/dashboard?id=Alssantos482_apiclient) 

## Installation 

> Requirements:

    1. Docker with docker-compose installed;
    2. Java 8 and maven to build and run the application;
    
> Step-by-Step

First run command to create database `docker-compose up -d`

Then run the application with maven `mvn clean spring-boot:run`
