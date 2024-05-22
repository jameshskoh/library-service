package com.jameshskoh.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne private Isbn isbn;

  @ManyToOne private Borrower borrower;

  // constructor for creating a new Book
  public Book(Isbn isbn) {
    this.isbn = isbn;
  }
}
