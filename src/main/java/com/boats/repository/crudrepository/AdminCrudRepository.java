package com.boats.repository.crudrepository;
import com.boats.model.AdminModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<AdminModel, Integer> {
}
