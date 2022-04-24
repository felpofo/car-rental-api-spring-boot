package br.com.felpofo.rental.repositories;

import br.com.felpofo.rental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByEmail(String email);
  Optional<User> findByName(String name);

  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
}
