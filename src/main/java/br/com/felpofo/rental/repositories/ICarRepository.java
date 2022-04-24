package br.com.felpofo.rental.repositories;

import br.com.felpofo.rental.models.Brand;
import br.com.felpofo.rental.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICarRepository extends JpaRepository<Car, UUID> {
  Optional<Car> findByName(String name);
  Optional<Car> findByLicensePlate(String license_plate);

  Optional<List<Car>> findAllAvailable(boolean available);
  Optional<List<Car>> findAllByBrand(Brand brand);
  Optional<List<Car>> findAllByBrandName(String name);
  Optional<List<Car>> findAllByBrandId(UUID id);

  boolean existsByName(String name);
  boolean existsByLicensePlate(String license_plate);
}
