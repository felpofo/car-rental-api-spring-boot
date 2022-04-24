package br.com.felpofo.rental.repositories;

import br.com.felpofo.rental.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, UUID> {
  Optional<Category> findByName(String name);

  boolean existsByName(String name);
}
