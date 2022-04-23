package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {

  @Autowired
  CarService carService;

}