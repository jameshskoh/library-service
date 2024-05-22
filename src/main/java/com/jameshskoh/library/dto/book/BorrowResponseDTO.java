package com.jameshskoh.library.dto.book;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BorrowResponseDTO {
  private String borrowDateTime;

  public BorrowResponseDTO() {}

  public BorrowResponseDTO(ZonedDateTime dateTime) {
    borrowDateTime = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  public String getBorrowDateTime() {
    return borrowDateTime;
  }

  public void setBorrowDateTime(String borrowDateTime) {
    this.borrowDateTime = borrowDateTime;
  }
}
