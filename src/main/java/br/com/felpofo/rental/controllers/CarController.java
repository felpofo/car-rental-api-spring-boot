package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.models.Car;
import br.com.felpofo.rental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
public class CarController {

  @Autowired
  CarService carService;

  @GetMapping
  public List<Car> getCars() {
    return carService.getCars();
  }

  @PostMapping("/create")
  public Car addCar(@RequestBody Car car) {
    return carService.addCar(car);
  }

  @PutMapping
  public Car modifyCar(@RequestParam("id") UUID id, @RequestBody Car car) {
    return carService.modifyCar(id, car);
  }

  @PatchMapping
  public HashMap<String, Object> partiallyModifyCar(@RequestParam("id") UUID id, @RequestBody Car car) {
    return carService.partiallyModifyCar(id, car);
  }

  @DeleteMapping
  public void deleteCar(@RequestParam("id") UUID id)   {
    carService.deleteCarById(id);
  }
}