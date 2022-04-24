package br.com.felpofo.rental.services;

import br.com.felpofo.rental.models.User;
import br.com.felpofo.rental.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  @Autowired
  private IUserRepository repository;

  public List<User> getUsers() {
    return repository.findAll();
  }

  public User addUser(User user) {
    if (repository.existsByEmail(user.getEmail()))
      return null;

    return repository.save(user);
  }

  public User modifyUser(UUID id, User user) {
    Optional<User> oldUser = repository.findById(id);

    if (oldUser.isEmpty())
      return null;

    oldUser.ifPresent(dbUser -> {
      dbUser.setName(user.getName());
      dbUser.setUsername(user.getUsername());
      dbUser.setEmail(user.getEmail());
      dbUser.setPassword(user.getPassword());
      dbUser.setDriverLicense(user.getDriverLicense());

      repository.flush();
    });

    return oldUser.get();
  }

  @SuppressWarnings("ConstantConditions")
  public HashMap<String, Object> partiallyModifyUser(UUID id, User user) {
    Optional<User> oldUser = repository.findById(id);

    if (oldUser.isEmpty())
      return null;

    HashMap<String, Object> changes = new HashMap<>();

    oldUser.ifPresent(dbUser -> {
      if (user.getName() != null) {
        dbUser.setName(user.getName());
        changes.put("name", user.getName());
      }

      if (user.getUsername() != null) {
        dbUser.setUsername(user.getUsername());
        changes.put("username", user.getUsername());
      }

      if (user.getEmail() != null) {
        dbUser.setEmail(user.getEmail());
        changes.put("email", user.getEmail());
      }

      if (user.getPassword() != null) {
      dbUser.setPassword(user.getPassword());
      changes.put("password", user.getPassword());
      }

      if (user.getDriverLicense() != null) {
        dbUser.setDriverLicense(user.getDriverLicense());
        changes.put("driver_license", user.getDriverLicense());
      }

      repository.flush();
    });

    return changes;
  }

  public void deleteUserById(UUID id) {
    repository.deleteById(id);
  }
}