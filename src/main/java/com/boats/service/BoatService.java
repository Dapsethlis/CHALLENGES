package com.boats.service;
import com.boats.model.BoatModel;
import com.boats.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<BoatModel> getAllBoats() {
        return (List<BoatModel>) boatRepository.getAllBoats();
    }

    public Optional<BoatModel> getBoat(Integer id) {
        return boatRepository.getBoat(id);
    }

    public BoatModel saveBoat(BoatModel boatModel) {
        return boatRepository.saveBoat(boatModel);
    }

    public boolean deleteBoat(Integer id) {
        boatRepository.deleteBoat(id);
        return true;
    }

    public BoatModel updateBoat(BoatModel boatModel) {
        return boatRepository.updateBoat(boatModel);
    }
}

