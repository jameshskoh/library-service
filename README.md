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
* [ ] **Has data validation**
* [x] Has error handling
* [ ] Unit tests
  * [ ] For Isbn
  * [ ] For Borrower
  * [ ] For Book
* [ ] Clear documentation
* [ ] CI/CD



### Assumptions?

* Borrower ID is generated automatically
* Borrower email is assumed correct
* Book ID is generated automatically
* Justification of using Postgres
  * Pretty "flat" structure, data normalization is easy
  * Easy to use with JPA




### More

* [ ] Clean code practice
* [ ] Containerization and CI/CD
* [ ] 12 Factor Application


