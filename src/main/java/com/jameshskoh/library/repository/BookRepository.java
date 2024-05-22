package com.jameshskoh.library.repository;

import com.jameshskoh.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByBorrowerIsNull();
}
