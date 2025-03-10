# TrabajoFinalSpringSecurity

This project is a demo application built with Spring Boot, showcasing the integration of various security mechanisms including OAuth2 with Google and GitHub, JWT authentication, and database relationships.

## Features

- **OAuth2 Authentication**: Secure login using Google and GitHub OAuth2 providers.
- **JWT Authentication**: Stateless authentication using JSON Web Tokens (JWT).
- **Database Integration**: Utilizes Spring Data JPA for database interactions with MySQL.
- **Role-Based Access Control**: Manages user roles and permissions.
- **Security Configurations**: Configured with Spring Security for robust security management.

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Security**
- **Spring Data JPA**
- **OAuth2 Client**
- **JWT (JSON Web Tokens)**
- **MySQL**
- **Maven**

## Getting Started

1. **Clone the repository**:
    ```sh
    git clone https://github.com/your-username/TrabajoFinalSpringSecurity.git
    cd TrabajoFinalSpringSecurity
    ```

2. **Configure the application**:
    - Update the `application.properties` file with your database and OAuth2 credentials.

3. **Build and run the application**:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Configuration

Ensure to set the following properties in your `application.properties` file:

```ini
# Application name
spring.application.name=TrabajoFinalSpringSecurity

# Security config
spring.security.user.name=${SS_USER}
spring.security.user.password=${SS_PASSWORD}
spring.security.user.roles=${ROLE}

# OAuth2 GitHub
spring.security.oauth2.client.registration.github.client-id=${GITHUB_CLIENT_ID}
spring.security.oauth2.client.registration.github.client-secret=${GITHUB_CLIENT_SECRET}

# OAuth2 Google
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

# MySQL
spring.datasource.url=${DDBB_URL}
spring.datasource.username=${DDBB_USER}
spring.datasource.password=${DDBB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT Configurations
security.jwt.private.key=${PRIVATE_KEY}
security.jwt.user.generator=${USER_GENERATOR}
