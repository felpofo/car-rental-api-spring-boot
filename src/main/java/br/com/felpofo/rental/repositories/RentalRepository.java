package br.com.felpofo.rental.repositories;

import br.com.felpofo.rental.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentalRepository extends JpaRepository<Rental, UUID> {
}
