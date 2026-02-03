# E-commerce Microservices Project

This project is a comprehensive e-commerce platform built using a microservices architecture. It includes various services for user management, authentication, inventory management, product information, cart processing, order placement, and notifications. The project utilizes a range of technologies and frameworks to ensure scalability, security, and performance.

## Tech Stack

- **Spring Boot**: For building microservices.
- **Spring Security**: For securing the services and implementing role-based access control (RBAC).
- **Keycloak**: For authentication and authorization.
- **PostgreSQL**: As the relational database for storing user and product data.
- **Elasticsearch**: For search functionalities and suggestions.
- **Redis**: For caching and session management.
- **Kafka/RabbitMQ**: For messaging and event-driven architecture.
- **Saga Pattern**: For managing distributed transactions across microservices.
- **API Gateway**: For routing requests to appropriate services.
- **Circuit Breaker**: For fault tolerance and resilience.
- **Database per Service**: Each microservice has its own database schema.

## Services Overview

1. **API Gateway**: Acts as a single entry point for all client requests, routing them to the appropriate microservices.
2. **User Service**: Manages user accounts, profiles, and role assignments.
3. **Auth Service**: Handles authentication and token generation using JWT and OAuth2.
4. **Inventory Service**: Manages product inventory, including stock levels and product details.
5. **Product Service**: Provides product information and manages product-related operations.
6. **Search Service**: Implements search functionalities and suggestions using Elasticsearch.
7. **Cart Service**: Manages user shopping carts, including adding and removing items.
8. **Order Service**: Handles order placement, processing, and management.
9. **Notification Service**: Sends email and push notifications to users.
10. **Analytics Service**: Collects and processes events for real-time analytics and reporting.

## Event Tracking and Analytics

The project includes a data collection and processing module that tracks user events and interactions. This module leverages Kafka/RabbitMQ for event streaming and processes events in real-time to provide insights and analytics.

## Setup and Running the Project

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd mall-microservices
   ```

2. **Build the project**:
   ```
   mvn clean install
   ```

3. **Run the services**:
   Use Docker Compose to start all services:
   ```
   docker-compose up
   ```

4. **Access the API Gateway**:
   The API Gateway will be available at `http://localhost:8080`.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.