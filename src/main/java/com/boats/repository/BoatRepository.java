package com.boats.repository;
import com.boats.model.BoatModel;
import com.boats.repository.crudrepository.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class BoatRepository {

    @Autowired //inyeccion de dependecias este se encarga de inicializar el Crud
    private BoatCrudRepository boatCrudRepository;

    public List<BoatModel> getAllBoats() {
        return (List<BoatModel>) boatCrudRepository.findAll();// nos devuelve toda la lista del crud almacenado en getAll para llamar

    }

    public Optional<BoatModel> getBoat(Integer id) {
        return boatCrudRepository.findById(id);
    }

    public BoatModel saveBoat(BoatModel boatModel) {
        return boatCrudRepository.save(boatModel);
    }

    public boolean deleteBoat(Integer id) {
        try {
            boatCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /*
    public DoctorModel updateDoctor(DoctorModel doctorModel){
        return doctorCrudRepository.save(doctorModel);
    }
    */
    public BoatModel updateBoat(BoatModel boatModel) {
        if (boatModel.getId() != null) {
            Optional<BoatModel> boat = boatCrudRepository.findById(boatModel.getId());
            if (!boat.isEmpty()) {
                if (boatModel.getName() != null) {
                    boat.get().setName(boatModel.getName());
                }
                if (boatModel.getBrand() != null) {
                    boat.get().setBrand(boatModel.getBrand());
                }
                if (boatModel.getYear() != null) {
                    boat.get().setYear(boatModel.getYear());
                }
                if (boatModel.getDescription() != null) {
                    boat.get().setDescription(boatModel.getDescription());
                }
//                if (boatModel.getCategory() != null) {
//                    boat.get().setCategory(boatModel.getCategory());
//                }
                if (boatModel.getMessages() != null) {
                    boat.get().setMessages(boatModel.getMessages());
                }
                if (boatModel.getReservations() != null) {
                    boat.get().setReservations(boatModel.getReservations());
                }
                boatCrudRepository.save(boat.get());
                return boat.get();
            } else {
                return boatModel;
            }
        } else {
            return boatModel;
        }
    }
}
