package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

  @Autowired
  BrandService brandService;

}