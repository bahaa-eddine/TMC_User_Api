
# Spring Boot Project - UserAPI

## Introduction

This project is a Spring Boot application with Java 17, designed to provide a RESTful API.

## Build and Start the Project

### Prerequisites

-   Java 17
-   Maven 3.6.0 or later

### Build

1.  Clone the project from the repository.

bashCopy code

`git clone https://github.com/[username]/[project].git`

2.  Navigate to the project directory.

bashCopy code

`cd [project]`

3.  Use Maven to build the project.

Copy code

`mvn clean install`

### Start the Project

1.  Navigate to the target directory.

bashCopy code

`cd target`

2.  Start the application using the following command:

cssCopy code

`java -jar [project].jar`

The application will start on `http://localhost:8080/`.

## API Documentation

To access the API documentation, go to `http://localhost:8080/swagger-ui/index.html` when the application is running. This will provide you with the available endpoints, their parameters, and expected responses.

pour utiliser postman
vous trouverez le fichier des urls dans : `postman\ApiUserTMC.postman_collection.json`

## Future directions
- add Liquibase
- auto build and deploy with Jenkins and Heroku
- Security ...
