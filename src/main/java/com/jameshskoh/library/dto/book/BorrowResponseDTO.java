package com.jameshskoh.library.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
public class BorrowResponseDTO {
  private String borrowDateTime;

  public BorrowResponseDTO(ZonedDateTime dateTime) {
    borrowDateTime = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }
}
