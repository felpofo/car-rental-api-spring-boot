package br.com.felpofo.rental.repositories;

import br.com.felpofo.rental.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, UUID> {
  Optional<Brand> findByName(String name);

  boolean existsByName(String name);
}
