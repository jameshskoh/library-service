package com.jameshskoh.library.service;

import com.jameshskoh.library.dto.book.BorrowRequestDTO;
import com.jameshskoh.library.dto.book.BorrowResponseDTO;
import com.jameshskoh.library.dto.book.CreateRequestDTO;
import com.jameshskoh.library.dto.book.ReturnRequestDTO;
import com.jameshskoh.library.dto.book.ReturnResponseDTO;
import com.jameshskoh.library.exception.UnexpectedRequestException;
import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.model.Borrower;
import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.repository.BookRepository;
import com.jameshskoh.library.repository.BorrowerRepository;
import com.jameshskoh.library.repository.IsbnRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

// #TODO test this
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
  public Book createBook(CreateRequestDTO createRequestDTO) {
    Isbn isbn =
        isbnRepository
            .findById(createRequestDTO.getIsbn())
            .orElseThrow(
                () ->
                    new EntityNotFoundException("ISBN: %s".formatted(createRequestDTO.getIsbn())));

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
    Borrower borrower =
        borrowerRepository
            .findById(borrowerId)
            .orElseThrow(
                () -> new EntityNotFoundException("Invalid borrower ID: %d".formatted(borrowerId)));

    long bookId = borrowRequestDTO.getBookId();
    Book requestedBook =
        bookRepository
            .findById(bookId)
            .orElseThrow(
                () -> new EntityNotFoundException("Invalid book ID: %d".formatted(bookId)));

    if (requestedBook.getBorrower() != null) {
      throw new UnexpectedRequestException("Book is already borrowed! ID: %d".formatted(bookId));
    }

    requestedBook.setBorrower(borrower);
    bookRepository.save(requestedBook);

    return new BorrowResponseDTO(ZonedDateTime.now());
  }

  public ReturnResponseDTO returnBook(ReturnRequestDTO returnRequestDTO) {
    long bookId = returnRequestDTO.getBookId();
    Book bookToReturn =
        bookRepository
            .findById(bookId)
            .orElseThrow(
                () -> new EntityNotFoundException("Invalid book ID: %d".formatted(bookId)));

    if (bookToReturn.getBorrower() == null) {
      throw new UnexpectedRequestException("Book is already returned! ID: %d".formatted(bookId));
    }

    bookToReturn.setBorrower(null);
    bookRepository.save(bookToReturn);

    return new ReturnResponseDTO(ZonedDateTime.now());
  }
}
