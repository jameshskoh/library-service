package com.jameshskoh.library.service;

import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.repository.IsbnRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IsbnService {

  private final IsbnRepository isbnRepository;

  public IsbnService(IsbnRepository isbnRepository) {
    this.isbnRepository = isbnRepository;
  }

  public Isbn createIsbn(Isbn isbn) {
    // #TODO should throw error when isbn already exists
    return isbnRepository.save(isbn);
  }

  public List<Isbn> getAllIsbns() {
    return isbnRepository.findAll();
  }
}
