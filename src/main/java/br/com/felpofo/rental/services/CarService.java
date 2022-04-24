package br.com.felpofo.rental.services;

import br.com.felpofo.rental.models.Car;
import br.com.felpofo.rental.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

  @Autowired
  private ICarRepository repository;

  public List<Car> getCars() {
    return repository.findAll();
  }

  public Car addCar(Car car) {
    if (repository.existsByLicensePlate(car.getLicensePlate()))
      return null;

    return repository.save(car);
  }

  public Car modifyCar(UUID id, Car car) {
    Optional<Car> oldCar = repository.findById(id);

    if (oldCar.isEmpty())
      return null;

    oldCar.ifPresent(dbCar -> {
      dbCar.setName(car.getName());
      dbCar.setDescription(car.getDescription());
      dbCar.setLicensePlate(car.getLicensePlate());
      dbCar.setDailyRate(car.getDailyRate());
      dbCar.setFineAmount(car.getDailyRate());
      dbCar.setImageUrl(car.getImageUrl());

      repository.flush();
    });

    return oldCar.get();
  }

  @SuppressWarnings("ConstantConditions")
  public HashMap<String, Object> partiallyModifyCar(UUID id, Car car) {
    Optional<Car> oldCar = repository.findById(id);

    if (oldCar.isEmpty())
      return null;

    HashMap<String, Object> changes = new HashMap<>();

    oldCar.ifPresent(dbCar -> {
      String name = car.getName();
      if (name != null) {
        dbCar.setName(name);
        changes.put("name", name);
      }

      String description = car.getDescription();
      if (description != null) {
        dbCar.setDescription(description);
        changes.put("description", description);
      }

      String licensePlate = car.getLicensePlate();
      if (licensePlate != null) {
        dbCar.setLicensePlate(licensePlate);
        changes.put("license_plate", licensePlate);
      }

      BigDecimal dailyRate = car.getDailyRate();
      if (dailyRate != null) {
        dbCar.setDailyRate(dailyRate);
        changes.put("daily_rate", dailyRate);
      }

      BigDecimal fineAmount = car.getFineAmount();
      if (fineAmount != null) {
        dbCar.setFineAmount(fineAmount);
        changes.put("fine_amount", fineAmount);
      }
      String imageUrl = car.getImageUrl();
      if (imageUrl != null) {
        dbCar.setImageUrl(imageUrl);
        changes.put("image_url", imageUrl);
      }

      repository.flush();
    });

    return changes;
  }

  public void deleteCarById(UUID id) {
    repository.deleteById(id);
  }
}