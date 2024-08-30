# Comment Service

The **Comment Service** is responsible for managing comments on posts and pages within the QuantumGrid platform.

## Features

- Add comments to posts and pages
- Edit and delete comments
- Moderation capabilities
- Threaded discussions

## Technology Stack

- **Java**: Programming language
- **Spring Boot**: Microservice framework
- **PostgreSQL**: Relational database for storing comment data

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** for build automation
- **PostgreSQL** installed and running

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/bobnetnetwork/quantumgrid-comment-service.git
    cd quantumgrid-comment-service
    ```

2. Configure the database connection in `src/main/resources/application.properties`:
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/quantumgrid
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    ```

3. Build the application:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### API Endpoints

- `POST /api/comments` - Add a new comment
- `GET /api/comments/{postId}` - List comments for a post
- `PUT /api/comments/{id}` - Update a comment
- `DELETE /api/comments/{id}` - Delete a comment

## Contributing

Please read the [CONTRIBUTING.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the GPL-3.0 license - see the [LICENSE.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/LICENSE.md) file for details.
