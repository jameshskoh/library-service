package com.jameshskoh.library.service;

import com.jameshskoh.library.dto.BorrowRequestDTO;
import com.jameshskoh.library.dto.BorrowResponseDTO;
import com.jameshskoh.library.dto.ReturnRequestDTO;
import com.jameshskoh.library.dto.ReturnResponseDTO;
import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.model.Borrower;
import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.model.IsbnCode;
import com.jameshskoh.library.repository.BookRepository;
import com.jameshskoh.library.repository.BorrowerRepository;
import com.jameshskoh.library.repository.IsbnRepository;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final IsbnRepository isbnRepository;
  private final BookRepository bookRepository;
  private final BorrowerRepository borrowerRepository;

  public BookService(
      IsbnRepository isbnRepository,
      BookRepository bookRepository,
      BorrowerRepository borrowerRepository) {
    this.isbnRepository = isbnRepository;
    this.bookRepository = bookRepository;
    this.borrowerRepository = borrowerRepository;
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

  public List<Book> getAvailableBooks() {
    return bookRepository.findByBorrowerIsNull();
  }

  public BorrowResponseDTO borrowBook(BorrowRequestDTO borrowRequestDTO) {
    long borrowerId = borrowRequestDTO.getBorrowerId();

    // #TODO think what to throw here
    Borrower borrower =
        borrowerRepository
            .findById(borrowerId)
            .orElseThrow(() -> new RuntimeException("Invalid borrower!"));

    long bookId = borrowRequestDTO.getBookId();

    // #TODO think what to throw here
    Book requestedBook =
        bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found!"));

    if (requestedBook.getBorrower() != null) {
      throw new RuntimeException("Book is being borrowed.");
    }

    requestedBook.setBorrower(borrower);
    bookRepository.save(requestedBook);

    return new BorrowResponseDTO(ZonedDateTime.now());
  }

  public ReturnResponseDTO returnBook(ReturnRequestDTO returnRequestDTO) {
    long bookId = returnRequestDTO.getBookId();

    // #TODO think what to throw
    Book bookToReturn =
        bookRepository
            .findById(bookId)
            .orElseThrow(() -> new RuntimeException("Invalid borrower!"));

    if (bookToReturn.getBorrower() == null) {
      throw new RuntimeException("Book is already returned!");
    }

    bookToReturn.setBorrower(null);
    bookRepository.save(bookToReturn);

    return new ReturnResponseDTO(ZonedDateTime.now());
  }
}
