package com.boats.controller;

import com.boats.model.CategoryModel;
import com.boats.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    @PostMapping("/all")
    public List<CategoryModel> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<CategoryModel> getAllCategory2() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<CategoryModel> getSpecialty(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel saveSpecialty(@RequestBody CategoryModel categoryModel) {
        return categoryService.saveCategory(categoryModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteSpecialty(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel updateSpecialty(@RequestBody CategoryModel categoryModel) {
        return categoryService.updateCategory(categoryModel);
    }
}
