package com.jameshskoh.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Isbn {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String title;
  private String author;

  @OneToMany private Set<Book> books;
}
