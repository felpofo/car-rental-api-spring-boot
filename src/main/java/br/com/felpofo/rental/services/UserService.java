package br.com.felpofo.rental.services;

import br.com.felpofo.rental.models.User;
import br.com.felpofo.rental.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private IUserRepository repository;

  public List<User> getUsers() {
    return repository.findAll();
  }

  public User addUser(User user) {
    if (repository.findByEmail(user.getEmail()).isPresent()) {
      return null;
    }

    return repository.save(user);
  }
}