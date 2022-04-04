# Demo Application for Carl Swan

### Description

This application is a Java SpringBoot application that provides a REST API and uses and embedded H2 relational database. Data is not persisted between runs with this configuration. It makes use of port 8080, but this can be changed in the application.properties file if needed.



Base URL for all endpoints is localhost:8080/carldemo

A PostMan collection is included which includes requests for most of the endpoints available (including example JSON for POST requests) and an Open API specification can be reached at /v3/api-docs.

The application makes the H2 database console available at /h2-console (user: sa pass: password)

To run the application, execute `mvn spring-boot:run` from the project root directory. This assumes the host has Java8+ and Maven installed and configured properly.
