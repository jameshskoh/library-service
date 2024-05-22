package com.jameshskoh.library.exception;

public class UnexpectedRequestException extends IllegalStateException {

  public UnexpectedRequestException(String errorMessage) {
    super(errorMessage);
  }
}
