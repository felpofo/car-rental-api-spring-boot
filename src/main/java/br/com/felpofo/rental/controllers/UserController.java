package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.models.User;
import br.com.felpofo.rental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping("/create")
  public User addUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping("/{id}")
  public User modifyUser(@PathVariable("id") UUID id, @RequestBody User user) {
    return userService.modifyUser(id, user);
  }

  @PatchMapping("/{id}")
  public HashMap<String, String> partiallyModifyUser(@PathVariable("id") UUID id, @RequestBody User user) {
    return userService.partiallyModifyUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") UUID id) {
    userService.deleteUserById(id);
  }
}