# library-service

## Models

* A borrower has
    * ID
    * Name
    * Email
* A book has
    * ID
    * ISBN
    * Title
    * Author
* An ISBN uniquely identifies a book's "model"
    * Title
    * Author

## Requirements

* [ ] Implement REST APIs to support
    * [x] Registering a new borrower to the library
    * [x] Registering a new book to the library
    * [x] Getting a list of all books in the library
    * [x] User actions
        * [x] Borrowing a book
        * [x] Returning a borrowed book

## Other requirements

* [x] Uses Java 17 and Spring Boot
* [x] Uses a package manager
* [x] Uses a database to store borrower and book data
* [x] Multiple books with the same ISBN number should be registered as books with different IDs
* [ ] No more than one member is borrowing the same book at a time
* [ ] Has data validation
* [ ] Has error handling
* [ ] Clear documentation

### Assumptions?

* Justification of using Postgres

### More

* [ ] Clean code practice
* [ ] Unit tests
* [ ] Containerization and CI/CD
* [ ] 12 Factor Application





