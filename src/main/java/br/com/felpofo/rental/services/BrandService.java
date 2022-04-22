package br.com.felpofo.rental.services;

import br.com.felpofo.rental.repositories.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

  @Autowired
  private IBrandRepository repository;
}