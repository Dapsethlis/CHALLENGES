package com.boats.repository.crudrepository;
import com.boats.model.BoatModel;


import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface BoatCrudRepository extends CrudRepository<BoatModel, Integer> {


}
