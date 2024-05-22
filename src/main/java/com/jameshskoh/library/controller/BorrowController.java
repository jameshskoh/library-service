package com.jameshskoh.library.controller;

import com.jameshskoh.library.model.borrow.BorrowInfo;
import com.jameshskoh.library.model.borrow.ReturnInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("borrow")
public class BorrowController {

  @PostMapping("borrow")
  public BorrowInfo borrowBook() {
    // #TODO implement this
    return new BorrowInfo();
  }

  @PostMapping("return")
  public ReturnInfo returnBook() {
    // #TODO implement this
    return new ReturnInfo();
  }
}
