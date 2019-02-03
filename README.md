# db-service
This project is a Stock Price Viewer build with Microservices Architecture using Spring Cloud, Spring Boot, Eureka, Zuul.

It has following components:
1. User
2. Web UI(angular)
3. API Gateway(Zuul Proxy/Spring Cloud + Boot)
4. Service Registry(Eureka/Spring Cloud + Boot)
5. Quote Maintenance Service(Spring Boot)
6. Stock Service(Spring Boot)
7. DB Service(Spring Boot, JPA)
8. Yahoo Finance API
9. MySQL

Use the following properties to connect to your DB:
spring.application.name=db-service
server.port=8300

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=******  //Use your password
spring.datasource.testwhileIdle=true
spring.datasource.validationQuery=SELECT 1
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
