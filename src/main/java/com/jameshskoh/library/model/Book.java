package com.jameshskoh.library.model;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (!Objects.equals(id, book.id)) return false;
    if (!Objects.equals(isbn, book.isbn)) return false;
    return Objects.equals(borrower, book.borrower);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + (borrower != null ? borrower.hashCode() : 0);
    return result;
  }
}
