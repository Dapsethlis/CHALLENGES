package com.boats.service;
import com.boats.model.CategoryModel;
import com.boats.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryRepository.getCategory(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryRepository.saveCategory(categoryModel);
    }

    public boolean deleteCategory(Integer id) {
        return categoryRepository.deleteCategory(id);
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) {
        return categoryRepository.updateCategory(categoryModel);
    }
}
