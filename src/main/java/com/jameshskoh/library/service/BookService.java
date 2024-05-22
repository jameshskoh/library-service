package com.jameshskoh.library.service;

import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.model.IsbnCode;
import com.jameshskoh.library.repository.BookRepository;
import com.jameshskoh.library.repository.IsbnRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final IsbnRepository isbnRepository;
  private final BookRepository bookRepository;

  public BookService(IsbnRepository isbnRepository, BookRepository bookRepository) {
    this.isbnRepository = isbnRepository;
    this.bookRepository = bookRepository;
  }

  // #TODO project and remove borrower field?
  public Book createBook(IsbnCode isbnCode) {
    // #TODO think what to throw here
    Isbn isbn =
        isbnRepository
            .findById(isbnCode.getIsbn())
            .orElseThrow(
                () -> new IllegalArgumentException("ISBN not found: %s".formatted(isbnCode)));

    Book newBook = new Book(isbn);

    return bookRepository.save(newBook);
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
