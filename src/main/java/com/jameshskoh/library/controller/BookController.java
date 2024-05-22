package com.jameshskoh.library.controller;

import com.jameshskoh.library.dto.book.BorrowRequestDTO;
import com.jameshskoh.library.dto.book.BorrowResponseDTO;
import com.jameshskoh.library.dto.book.CreateRequestDTO;
import com.jameshskoh.library.dto.book.ReturnRequestDTO;
import com.jameshskoh.library.dto.book.ReturnResponseDTO;
import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("list")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("list-available")
  public List<Book> getAvailableBooks() {
    return bookService.getAvailableBooks();
  }

  @PostMapping("create")
  public Book createBook(@RequestBody CreateRequestDTO createRequestDTO) {
    return bookService.createBook(createRequestDTO);
  }

  @PostMapping("borrow")
  public BorrowResponseDTO borrowBook(BorrowRequestDTO borrowRequestDTO) {
    return bookService.borrowBook(borrowRequestDTO);
  }

  @PostMapping("return")
  public ReturnResponseDTO returnBook(ReturnRequestDTO returnRequestDTO) {
    return bookService.returnBook(returnRequestDTO);
  }
}
