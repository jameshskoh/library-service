package com.jameshskoh.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Isbn {

  @Id private String id;

  private String title;
  private String author;
}
