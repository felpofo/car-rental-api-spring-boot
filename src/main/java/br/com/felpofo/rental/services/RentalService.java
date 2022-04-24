package br.com.felpofo.rental.services;

import br.com.felpofo.rental.models.Rental;
import br.com.felpofo.rental.repositories.IRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RentalService {

  @Autowired
  private IRentalRepository repository;

  public List<Rental> getRentals() {
    return repository.findAll();
  }

  public Rental addRental(Rental rental) {
    return repository.save(rental);
  }

  @SuppressWarnings("ConstantConditions")
  public HashMap<String, Object> partiallyModifyRental(UUID id, Rental rental) {
    Optional<Rental> oldRental = repository.findById(id);

    if (oldRental.isEmpty())
      return null;

    HashMap<String, Object> changes = new HashMap<>();

    oldRental.ifPresent(dbRental -> {
      if (rental.getStartDate() != null) {
        dbRental.setStartDate(rental.getStartDate());
        changes.put("start_date", rental.getStartDate());
      }

      if (rental.getEndDate() != null) {
        dbRental.setEndDate(rental.getEndDate());
        changes.put("end_date", rental.getEndDate());
      }

      if (rental.getExpectedReturnDate() != null) {
        dbRental.setExpectedReturnDate(rental.getExpectedReturnDate());
        changes.put("expected_return_date", rental.getExpectedReturnDate());
      }

      repository.flush();
    });

    return changes;
  }

  public void deleteRentalById(UUID id) {
    repository.deleteById(id);
  }
}