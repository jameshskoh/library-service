package com.jameshskoh.library.controller;

import com.jameshskoh.library.model.Borrower;
import com.jameshskoh.library.service.BorrowerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("borrower")
public class BorrowerController {

  private final BorrowerService borrowerService;

  public BorrowerController(BorrowerService borrowerService) {
    this.borrowerService = borrowerService;
  }

  @PostMapping("create")
  @ResponseStatus(HttpStatus.CREATED)
  public Borrower createBorrower(@RequestBody Borrower borrower) {
    return borrowerService.createBorrower(borrower);
  }
}
