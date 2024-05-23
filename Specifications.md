# library-service

## This service supports

* [x] Registering a new borrower to the library
* [x] Registering a new book to the library
* [x] Getting a list of all books in the library
* [x] User actions
    * [x] Borrowing a book
    * [x] Returning a borrowed book



## This service uses

* [x] Java 17 and Spring Boot
* [x] Gradle as package manager/build tool
* [x] An RDBMS (tested with Postgres)



## This service also

* [x] Checks on whether ISBNs/borrowers/books ID exists before performing operations
* [x] Returns descriptive error codes

* [x] Has unit tests
* [x] Has documentation of its APIs
* [x] Runs GitHub Actions



## Assumptions?

* Request payload fields are always correct, but their values might be incorrect
* Borrower IDs are generated sequentially
* Borrower emails are assumed correct
* Book IDs are generated sequentially
* ISBN codes are assumed to follow the correct format



#### Why use Postgres?

* The relationship between Borrower/Book/ISBN are all one-to-many
* Pretty "flat" structure, data normalization is easy
* Easy to use with JPA
* Transactional queries, suitable for RDBMS


