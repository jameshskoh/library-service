package com.jameshskoh.library.controller;

import com.jameshskoh.library.model.Book;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

  @GetMapping("list")
  public List<Book> getAllBooks() {
    // #TODO implement this
    return List.of();
  }

  @PostMapping("create")
  public Book createBook() {
    // #TODO implement this
    return new Book();
  }
}
