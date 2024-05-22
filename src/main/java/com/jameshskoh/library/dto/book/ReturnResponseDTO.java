package com.jameshskoh.library.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
public class ReturnResponseDTO {

  private String returnDateTime;

  public ReturnResponseDTO(ZonedDateTime dateTime) {
    returnDateTime = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }
}
