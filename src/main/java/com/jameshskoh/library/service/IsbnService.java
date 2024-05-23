package com.jameshskoh.library.service;

import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.repository.IsbnRepository;
import jakarta.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class IsbnService {

  private final IsbnRepository isbnRepository;

  public IsbnService(IsbnRepository isbnRepository) {
    this.isbnRepository = isbnRepository;
  }

  public Isbn createIsbn(Isbn isbn) {
    Optional<Isbn> existingIsbnOpt = isbnRepository.findById(isbn.getId());

    if (existingIsbnOpt.isPresent()) {
      throw new EntityExistsException("ISBN already exists! ID: %s".formatted(isbn.getId()));
    }

    return isbnRepository.save(isbn);
  }

  public List<Isbn> getAllIsbns() {
    return isbnRepository.findAll();
  }
}
