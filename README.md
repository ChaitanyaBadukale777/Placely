# Placely


# Placely Backend Documentation

## Project Name
Placely

## Description
Placely is a job portal backend application built with Java and Spring Boot. It provides RESTful APIs for user authentication and job management, supporting a scalable and secure platform for job seekers and employers.

## Explanation & Working
Placely's backend manages user registration, authentication, and job-related operations. It uses Spring Boot for rapid development and MySQL for persistent data storage. The application follows a layered architecture with controllers, services, repositories, and models.

- **Controllers** handle HTTP requests and responses.
- **Models** represent the application's data structures.
- **Repositories** interact with the database.

## Tech Stack Used
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**

## Steps to Install & Run

### Prerequisites
- Java 17 or higher
- Maven
- MySQL server

#### (Recommended) MySQL with Docker
You can run MySQL easily using Docker. Example commands:


```bash
# Pull MySQL image
docker pull mysql:8

# Run MySQL container with recommended environment variables
docker run --name jobportal-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=jobportal \
  -e MYSQL_USER=jobuser \
  -e MYSQL_PASSWORD=jobpass \
  -p 3306:3306 \
  -d mysql:8

# (Optional) Access MySQL shell inside the container
docker exec -it jobportal-mysql mysql -u jobuser -p
```

Update your `application.properties` to match the credentials above.

### 1. Clone the Repository
```bash
git clone <repo-url>
cd Placely/backend
```

### 2. Configure Database
- Create a MySQL database (e.g., `jobportal`).
- Update `src/main/resources/application.properties` with your DB credentials:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
  spring.datasource.username=jobuser
  spring.datasource.password=yourpassword
  ```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080` by default.

## API Endpoints

### Authentication
- **POST /auth/register**
  - Registers a new user.
  - Request body: `{ "username": "user", "password": "pass" }`
- **POST /auth/login**
  - Authenticates a user and returns a token.
  - Request body: `{ "username": "user", "password": "pass" }`

### User Management
- **GET /users**
  - Returns a list of all users (admin only).
- **GET /users/{id}**
  - Returns details of a specific user.

### (Add more endpoints as implemented)

## Notes
- Ensure MySQL is running before starting the backend.
- Use tools like Postman to test API endpoints.
- For production, configure environment variables and security settings as needed.

---
For further details, refer to the source code and comments within each file.
