package com.jameshskoh.library.service;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;

@Service
public class DateTimeService {

  public ZonedDateTime getDateTime() {
    return ZonedDateTime.now();
  }
}
