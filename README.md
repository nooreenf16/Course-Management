# Course-Management

A Spring Boot-based backend service for managing courses and instructors using a relational database. The application is containerized with Docker and integrates with Apache Kafka to publish messages on every data change (via POST and DELETE operations). All client requests are routed through a gateway to ensure scalability and control.

Key Features:

- RESTful API for course and instructor management

- Kafka integration for event-driven communication

- Dockerized for consistent deployment

- Gateway layer for secure and centralized request handling

Technologies Used

Java + Spring Boot, 
Apache Kafka, 
Docker, 
Relational Database - PostgreSQL, 
API Gateway (Spring Cloud Gateway).

