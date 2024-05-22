package com.jameshskoh.library.dto.book;

public class BorrowRequestDTO {

  private long borrowerId;
  private long bookId;

  public long getBorrowerId() {
    return borrowerId;
  }

  public void setBorrowerId(int borrowerId) {
    this.borrowerId = borrowerId;
  }

  public long getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
}
