package br.com.felpofo.rental.services;

import br.com.felpofo.rental.repositories.IRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

  @Autowired
  private IRentalRepository repository;
}