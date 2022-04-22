package br.com.felpofo.rental.services;

import br.com.felpofo.rental.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private IUserRepository repository;
}