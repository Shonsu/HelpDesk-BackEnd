# HELPDESK
## System to manage and handle user requests
### Modules responsibility:
1. management-module
   - simple CRUD application for ticket forms used by user to report problems
2. security-module
   - responsible for authorization and authentication of application users and IT staff
3. user-helpdesk-module
   - responsible for handling and displaying the request from the user side
### How to run
You must have a database and user created as described in the [application.yml](https://github.com/Shonsu/HelpDesk-BackEnd/blob/master/management-module/src/main/resources/application.yml).
Clone repository first. Run console app and change directory (`cd management-module`) to management-module and type command:
`mvn spring-boot:run`. </br>
After that, you should have available [Swagger API](http://localhost:8080/swagger-ui/index.html#/). </br>
To get token for further requests you need to send post login request with user: **admin**, passowrd **password** to login [endpoint](http://localhost:8080/login). 
#### TODO
1. Use cases for user-helpdesk-module
   - [ ] close ticket
   - [ ] cancel ticket

2. Request handling module for IT staff
#### Used technologies:
- Java
- Spring boot (Data JPA, Security)
- Postgresql
- Maven
- REST API
- Liquibase (documentation of database structure changes)
- Swagger
- elements of Ports and Adapters