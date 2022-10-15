package com.boats.repository.crudrepository;

import com.boats.model.ScoreModel;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<ScoreModel, Integer> {
}
