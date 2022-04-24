package br.com.felpofo.rental.services;

import br.com.felpofo.rental.models.Brand;
import br.com.felpofo.rental.repositories.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandService {

  @Autowired
  private IBrandRepository repository;

  public List<Brand> getBrands() {
    return repository.findAll();
  }

  public Brand addBrand(Brand brand) {
    if (repository.existsByName(brand.getName()))
      return null;

    brand.setCars(null);

    return repository.save(brand);
  }

  public Brand modifyBrand(UUID id, Brand brand) {
    Optional<Brand> oldBrand = repository.findById(id);

    if (oldBrand.isEmpty())
      return null;

    oldBrand.ifPresent(dbBrand -> {
      dbBrand.setName(brand.getName());
      dbBrand.setImageUrl(brand.getImageUrl());

      repository.flush();
    });

    return oldBrand.get();
  }

  @SuppressWarnings("ConstantConditions")
  public HashMap<String, Object> partiallyModifyBrand(UUID id, Brand brand) {
    Optional<Brand> oldBrand = repository.findById(id);

    if (oldBrand.isEmpty())
      return null;

    HashMap<String, Object> changes = new HashMap<>();

    oldBrand.ifPresent(dbBrand -> {
      if (brand.getName() != null) {
        dbBrand.setName(brand.getName());
        changes.put("name", brand.getName());
      }

      if (brand.getImageUrl() != null) {
        dbBrand.setImageUrl(brand.getImageUrl());
        changes.put("image_url", brand.getImageUrl());
      }

      repository.flush();
    });

    return changes;
  }

  public void deleteBrandById(UUID id) {
    repository.deleteById(id);
  }
}