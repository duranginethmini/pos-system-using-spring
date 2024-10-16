# Spring-Based POS System

## Introduction
This project is a Point of Sale (POS) system built using the **Spring Framework**. It is designed to manage the operations of a typical shop, handling key functionalities like inventory management, sales tracking, and customer management. The system is built on a layered architecture and uses logging for debugging and monitoring. With **JPA** and **Hibernate**, it ensures efficient database interactions and seamless **Object Relational Mapping** (ORM).

The system coheres to best practices, with clear separation between presentation, business logic, and data layers. Configurations are handled by two main configuration classes.

## Key Features
- **Inventory Management**: CRUD operations to manage fruit shop products.
- **Sales**: Functionality to create and manage customer orders.
- **Customer Management**: Add and manage customer profiles.
- **Logging**: Integrated logging for event tracking and debugging.
- **Layered Architecture**: Separates presentation, business logic, and data layers.
- **REST API**: Provides API endpoints with JSON responses.
- **Exception Handling**: Custom exception handling and input validation using Spring Validator.

## Technologies Used
- **Backend**: Spring Framework, Spring Data JPA, Hibernate
- **Database**: MySQL
- **Communication**: AJAX
- **Logging**: Spring Loggers for application flow monitoring
- **ORM**: JPA with Hibernate for database interaction
- **Spring Data JPA**: For data repository layer
- **Lombok**: Reduces boilerplate code

## System Architecture
The project is structured into the following layers:

- **Controller Layer**: Manages HTTP requests and responses.
- **Service Layer**: Contains the business logic and service implementations.
- **DAO Layer**: Handles data persistence and database interaction.
- **Entity Layer**: Maps to database tables via Hibernate.
- **DTO Layer**: Facilitates data transfer between layers.
- **Custom Exception Layer**: Handles specific exceptions and errors.

### Configuration Classes:
- **WebAppRootConfig**: Configurations related to the application context.
- **WebAppConfig**: Handles configurations for the web layer, such as view resolvers and resource handling.

## API Endpoints

### Customer Endpoints
- `GET /customer`: Retrieve all customers or get a customer by ID.
- `POST /customer`: Create a new customer.
- `PUT /customer`: Update an existing customer.
- `DELETE /customer/{id}`: Delete a customer by ID.

### Item Endpoints
- `GET /item`: Retrieve all items or get an item by code.
- `POST /item`: Create a new item.
- `PUT /item`: Update an existing item.
- `DELETE /item/{id}`: Delete an item by code.

### Order Endpoints
- `POST /order`: Create a new order.
- `GET /order`: Retrieve all orders.

## API Documentation
For detailed API documentation, including example requests and responses, visit: **[API Documentation](https://documenter.getpostman.com/view/35948713/2sAXxV5VLv)**.


## 🛡️ License
This project is licensed under the MIT License. See the [LICENSE] file for details.
