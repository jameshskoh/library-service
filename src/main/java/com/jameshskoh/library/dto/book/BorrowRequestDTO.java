package com.jameshskoh.library.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowRequestDTO {
  private long borrowerId;
  private long bookId;
}
