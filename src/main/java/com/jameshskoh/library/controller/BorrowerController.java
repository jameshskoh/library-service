package com.jameshskoh.library.controller;

import com.jameshskoh.library.model.Borrower;
import com.jameshskoh.library.service.BorrowerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("borrower")
public class BorrowerController {

  private final BorrowerService borrowerService;

  public BorrowerController(BorrowerService borrowerService) {
    this.borrowerService = borrowerService;
  }

  @PostMapping("create")
  public Borrower createBorrower(@RequestBody Borrower borrower) {
    return borrowerService.createBorrower(borrower);
  }
}
