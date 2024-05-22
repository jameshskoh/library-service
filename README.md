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
  * [ ] Registering a new borrower to the library
  * [ ] Registering a new book to the library
  * [ ] Getting a list of all books in the library
  * [ ] User actions
    * [ ] Borrowing a book
    * [ ] Returning a borrowed book



## Other requirements

* [ ] Uses Java 17 and Spring Boot
* [ ] Uses a package manager
* [ ] Has data validation
* [ ] Has error handling
* [ ] Uses a database to store borrower and book data
  * [ ] Justification of using Postgres
* [ ] Multiple books with the same ISBN number should be registered as books with different IDs
* [ ] No more than one member is borrowing the same book at a time
* [ ] Clear documentation



### Assumptions?

* 



### More

* [ ] Clean code practice
* [ ] Unit tests
* [ ] Containerization and CI/CD
* [ ] 12 Factor Application





