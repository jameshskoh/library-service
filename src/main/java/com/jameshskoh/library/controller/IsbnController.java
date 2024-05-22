package com.jameshskoh.library.controller;

import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.service.IsbnService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("isbn")
public class IsbnController {

  private final IsbnService isbnService;

  public IsbnController(IsbnService isbnService) {
    this.isbnService = isbnService;
  }

  @PostMapping("create")
  public Isbn createIsbn(@RequestBody Isbn isbn) {
    return isbnService.createIsbn(isbn);
  }

  @GetMapping("list")
  public List<Isbn> getAllIsbns() {
    return isbnService.getAllIsbns();
  }
}
