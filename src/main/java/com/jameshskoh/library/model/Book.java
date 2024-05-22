package com.jameshskoh.library.model;

import jakarta.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne private Isbn isbn;

  @ManyToOne private Borrower borrower;

  public Book() {}

  // constructor for creating a new Book
  public Book(Isbn isbn) {
    this.isbn = isbn;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Isbn getIsbn() {
    return isbn;
  }

  public void setIsbn(Isbn isbn) {
    this.isbn = isbn;
  }

  public Borrower getBorrower() {
    return borrower;
  }

  public void setBorrower(Borrower borrower) {
    this.borrower = borrower;
  }
}
