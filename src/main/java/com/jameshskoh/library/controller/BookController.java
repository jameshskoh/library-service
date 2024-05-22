package com.jameshskoh.library.controller;

import com.jameshskoh.library.dto.BorrowRequestDTO;
import com.jameshskoh.library.dto.BorrowResponseDTO;
import com.jameshskoh.library.dto.ReturnRequestDTO;
import com.jameshskoh.library.dto.ReturnResponseDTO;
import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.model.IsbnCode;
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
  public Book createBook(@RequestBody IsbnCode isbnCode) {
    return bookService.createBook(isbnCode);
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
