package com.jameshskoh.library.repository;

import com.jameshskoh.library.model.Isbn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsbnRepository extends JpaRepository<Isbn, String> {}
