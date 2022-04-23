package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

  @Autowired
  RentalService rentalService;

}