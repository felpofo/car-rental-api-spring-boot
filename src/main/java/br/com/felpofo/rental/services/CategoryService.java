package br.com.felpofo.rental.services;

import br.com.felpofo.rental.models.Category;
import br.com.felpofo.rental.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

  @Autowired
  private ICategoryRepository repository;

  public List<Category> getCategories() {
    return repository.findAll();
  }

  public Category addCategory(Category category) {
    if (repository.existsByName(category.getName()))
      return null;

    category.setCars(null);

    return repository.save(category);
  }

  public Category modifyCategory(UUID id, Category category) {
    Optional<Category> oldCategory = repository.findById(id);

    if (oldCategory.isEmpty())
      return null;

    oldCategory.ifPresent(dbCategory -> {
      dbCategory.setName(category.getName());
      dbCategory.setDescription(category.getDescription());

      repository.flush();
    });

    return oldCategory.get();
  }

  @SuppressWarnings("ConstantConditions")
  public HashMap<String, String> partiallyModifyCategory(UUID id, Category category) {
    Optional<Category> oldCategory = repository.findById(id);

    if (oldCategory.isEmpty())
      return null;

    HashMap<String, String> changes = new HashMap<>();

    oldCategory.ifPresent(dbCategory -> {
      if (category.getName() != null) {
        dbCategory.setName(category.getName());
        changes.put("name", category.getName());
      }

      if (category.getDescription() != null) {
        dbCategory.setDescription(category.getDescription());
        changes.put("username", category.getDescription());
      }

      repository.flush();
    });

    return changes;
  }

  public void deleteCategoryById(UUID id) {
    repository.deleteById(id);
  }
}