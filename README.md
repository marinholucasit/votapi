## VotAPI App
API REST for associates to vote.

- Associate Register
- Pautas Register
- Opening Voting Session by Pauta
- Associate Voting in the session
- Get results by session


### Technologies
- Java 17
- Spring Boot Web, Data JPA, Test, Validation
- JUnit
- Swagger(OpenAPi 3)
- Postgresql
- Docker
- Lombok


### To run the API

- To clone the project;
- Inside the directory /votapi/docker to run ```docker compose up -d ```
- In the root directory to run ```./gradlew bootRun```
- Show the API documentation [localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)