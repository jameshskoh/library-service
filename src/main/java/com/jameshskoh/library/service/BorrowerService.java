package com.jameshskoh.library.service;

import com.jameshskoh.library.model.Borrower;
import com.jameshskoh.library.repository.BorrowerRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

  private final BorrowerRepository borrowerRepository;

  public BorrowerService(BorrowerRepository borrowerRepository) {
    this.borrowerRepository = borrowerRepository;
  }

  public Borrower createBorrower(Borrower borrower) {
    return borrowerRepository.save(borrower);
  }
}
