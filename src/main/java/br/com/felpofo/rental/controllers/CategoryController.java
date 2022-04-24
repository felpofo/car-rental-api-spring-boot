package br.com.felpofo.rental.controllers;

import br.com.felpofo.rental.models.Category;
import br.com.felpofo.rental.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  CategoryService categoryService;

  @GetMapping
  public List<Category> getUsers() {
    return categoryService.getCategories();
  }

  @PostMapping("/create")
  public Category addUser(@RequestBody Category category) {
    return categoryService.addCategory(category);
  }

  @PutMapping
  public Category modifyUser(@RequestParam("id") UUID id, @RequestBody Category category) {
    return categoryService.modifyCategory(id, category);
  }

  @PatchMapping
  public HashMap<String, String> partiallyModifyUser(@RequestParam("id") UUID id, @RequestBody Category category) {
    return categoryService.partiallyModifyCategory(id, category);
  }

  @DeleteMapping
  public void deleteUser(@RequestParam("id") UUID id) {
    categoryService.deleteCategoryById(id);
  }

}