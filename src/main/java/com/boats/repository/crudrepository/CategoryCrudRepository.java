package com.boats.repository.crudrepository;
import com.boats.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel, Integer> {

}
