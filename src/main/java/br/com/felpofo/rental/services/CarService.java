package br.com.felpofo.rental.services;

import br.com.felpofo.rental.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  private ICarRepository repository;
}