# Evolvice
Evolvice REST APIs

- APIs implemented using:
1) Spring BOOT
2) Spring Data JPA
3) MySQL Database
4) Swagger Documentation
5) Actuator for Monitoring APIs
6) Basic Authentication with Spring security
7) Dozer Mapper


- To run and test the APIs:
1) Go to /evolvice-web-services/src/main/java/com/evolvice/rest/webservices/EvolviceWebServicesApplication.java
and right click to choose "Run as java application"
2) Go to the postman collection to test the APIs.


- Swagger Docmentation:
1) Run the application
2) Go to http://localhost:8080/swagger-ui.html
3) Or Go to http://localhost:8080/v2/api-docs for the JSON format


- For APIs monitoring:
1) Run the application
2) Go to http://localhost:8080/browser/index.html#/actuator


- To run the unit test:
1) Go to /evolvice-web-services/src/test/java/com/evolvice/rest/webservices/evolvicewebservices/EvolviceWebServicesApplicationTests.java
   and right click to choose "Run JUnit Test"


- Postman Collection and Swagger json file found in the documentation folder


- Username and Password for the basic authentication:
  username: evolvice
  password: evolvice_2018