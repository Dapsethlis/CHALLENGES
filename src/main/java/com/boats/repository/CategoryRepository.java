package com.boats.repository;
import com.boats.model.CategoryModel;
import com.boats.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryCrudRepository.findById(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryCrudRepository.save(categoryModel);
    }

    public boolean deleteCategory(Integer id) {
        try {
            categoryCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) {
        if (categoryModel.getId() != null) {
            Optional<CategoryModel> specialty = categoryCrudRepository.findById( categoryModel.getId());
            if (!specialty.isEmpty()) {
                if (categoryModel.getName() != null) {
                    specialty.get().setName(categoryModel.getName());
                }
                if (categoryModel.getDescription() != null) {
                    specialty.get().setDescription(categoryModel.getDescription());
                }
                if (categoryModel.getBoats() != null) {
                    specialty.get().setBoats(categoryModel.getBoats());
                }
                categoryCrudRepository.save(specialty.get());
                return specialty.get();
            } else {
                return categoryModel;
            }
        } else {
            return categoryModel;
        }
    }
}

