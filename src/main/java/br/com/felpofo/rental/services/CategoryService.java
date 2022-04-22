package br.com.felpofo.rental.services;

import br.com.felpofo.rental.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private ICategoryRepository repository;
}