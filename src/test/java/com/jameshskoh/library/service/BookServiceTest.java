package com.jameshskoh.library.service;

import static org.mockito.Mockito.when;

import com.jameshskoh.library.dto.book.BorrowRequestDTO;
import com.jameshskoh.library.dto.book.BorrowResponseDTO;
import com.jameshskoh.library.dto.book.CreateRequestDTO;
import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.model.Borrower;
import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.repository.BookRepository;
import com.jameshskoh.library.repository.BorrowerRepository;
import com.jameshskoh.library.repository.IsbnRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  @InjectMocks private BookService bookService;

  @Mock private IsbnRepository isbnRepository;

  @Mock private BookRepository bookRepository;

  @Mock private BorrowerRepository borrowerRepository;

  @Mock private DateTimeService dateTimeService;

  @Test
  void createBook_whenIsbnExists_givenValidBook_shouldInsertBook() {
    // mock
    Isbn isbn = new Isbn("12-123-12345-12-1", "Existing Test Book", "Existing Author");
    when(isbnRepository.findById(isbn.getId())).thenReturn(Optional.of(isbn));

    Book validBook = new Book(null, isbn, null);
    Book returnBook = new Book(1L, isbn, null);
    when(bookRepository.save(validBook)).thenReturn(returnBook);

    // given, when
    CreateRequestDTO dto = new CreateRequestDTO("12-123-12345-12-1");
    Book result = bookService.createBook(dto);

    // then
    Assertions.assertThat(result).isEqualTo(returnBook);
  }

  @Test
  void createBook_whenIsbnNotExist_givenBook_shouldThrowEntityNotFoundException() {
    // mock
    when(isbnRepository.findById("12-123-12345-12-1")).thenReturn(Optional.empty());

    // given
    CreateRequestDTO dto = new CreateRequestDTO("12-123-12345-12-1");

    // when, then
    Assertions.assertThatThrownBy(() -> bookService.createBook(dto))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessageContaining("ISBN")
        .hasMessageContaining("12-123-12345-12-1");
  }

  @Test
  void borrowBook_whenHappyPath_thenReturnsTimestamp() {
    // mock
    Borrower borrower = new Borrower(101L, "Xiao Qiang", "xiaoqiang@gmail.com");
    when(borrowerRepository.findById(101L)).thenReturn(Optional.of(borrower));

    Isbn isbn = new Isbn("12-123-12345-12-1", "A Book", "A Guy");
    Book availableBook = new Book(201L, isbn, null);
    when(bookRepository.findById(201L)).thenReturn(Optional.of(availableBook));

    ZonedDateTime mockDateTime =
        ZonedDateTime.of(2024, 1, 2, 3, 45, 0, 0, ZoneId.ofOffset("GMT", ZoneOffset.ofHours(8)));
    when(dateTimeService.getDateTime()).thenReturn(mockDateTime);

    // given, when
    BorrowRequestDTO dto = new BorrowRequestDTO(101L, 201L);
    BorrowResponseDTO result = bookService.borrowBook(dto);

    // then
    Assertions.assertThat(result.getBorrowDateTime())
        .isEqualTo(mockDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
  }
}
