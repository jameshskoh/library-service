package com.jameshskoh.library.controller;

import com.jameshskoh.library.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  @PostMapping("create")
  public User createUser() {
    // #TODO implement this
    return new User();
  }
}
