package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.models.User;
import br.com.felpofo.rental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public User addUser(@RequestBody User user) {
    return userService.addUser(user);
  }
}