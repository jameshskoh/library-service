package com.jameshskoh.library.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ReturnResponseDTO {

  private String returnDateTime;

  public ReturnResponseDTO() {}

  public ReturnResponseDTO(ZonedDateTime dateTime) {
    returnDateTime = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  public String getReturnDateTime() {
    return returnDateTime;
  }

  public void setReturnDateTime(String returnDateTime) {
    this.returnDateTime = returnDateTime;
  }
}
