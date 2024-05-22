package com.jameshskoh.library.controller;

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

  @PostMapping("create")
  public Book createBook(@RequestBody IsbnCode isbnCode) {
    return bookService.createBook(isbnCode);
  }
}
