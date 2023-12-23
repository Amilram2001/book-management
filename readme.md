# Book Management REST API
This is a RESTful API for a book management system. It is built with Java, Spring Boot, Lombok, and H2 Database.

## Features
- CRUD operations for books
- Pagination support for retrieving books
- Validation for book data

## API Endpoints
- **GET /books**: Retrieves a list of books with pagination support. The default page size is 10.
    - Request Parameters: `start` (integer, default: 0), `end` (integer, default: 10)
    - Response: A JSON array of books. Each book object includes `id` (long), `title` (string), `author` (string), and `genre` (string).

- **GET /books/{id}**: Retrieves a specific book by its ID.
    - Path Parameters: `id` (long)
    - Response: A JSON object representing the book. Includes `id` (long), `title` (string), `author` (string), and `genre` (string).

- **POST /books**: Creates a new book. The request body should include the details of the book (title, author, and genre).
    - Request Body: A JSON object representing the book to be created. Includes `title` (string), `author` (string), and `genre` (string). The `genre` must be one of the following, case-insensitive: `HORROR`, `FANTASY`, `ROMANCE`, `SCIENCE_FICTION`, `MYSTERY`, `THRILLER`, `DRAMA`.
    - Response: A JSON object representing the created book. Includes `id` (long), `title` (string), `author` (string), and `genre` (string).

- **PUT /books/{id}**: Updates a specific book. The request body should include the details to be updated.
    - Path Parameters: `id` (long)
    - Request Body: A JSON object representing the book updates. Can include `title` (string), `author` (string), and `genre` (string). The `genre` must be one of the following, case-insensitive: `HORROR`, `FANTASY`, `ROMANCE`, `SCIENCE_FICTION`, `MYSTERY`, `THRILLER`, `DRAMA`.

- **DELETE /books/{id}**: Deletes a specific book by its ID.
    - Path Parameters: `id` (long)

## Setup and Installation
1. Clone the repository.
2. Navigate to the project directory.
3. Run the command `mvn spring-boot:run` to start the application.
4. The application will start running at `http://localhost:8080`.

## Credits

This project was made possible by the valuable tutorials and resources provided by [Baeldung](`https://www.baeldung.com/spring-boot`). Their comprehensive guides on Spring Boot were instrumental in the development of this REST API.
