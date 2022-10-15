package com.boats.controller;
import com.boats.model.BoatModel;
import com.boats.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Controlador de tipo Rest, nos permite llamados HTTP
@RequestMapping("/api/Boat") //api/boat es el path
@CrossOrigin(origins = "*")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    @PostMapping("/all")
    public List<BoatModel> getAllBoats() {
        return boatService.getAllBoats();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BoatModel> getAllBoats2() {
        return boatService.getAllBoats();
    }

    @GetMapping("/{id}")
    public Optional<BoatModel> getBoats(@PathVariable Integer id) { //
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel saveBoat(@RequestBody BoatModel boatModel) {
        return boatService.saveBoat(boatModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBoat(@PathVariable Integer id) {
        boatService.deleteBoat(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel updateBoat(@RequestBody BoatModel boatModel) {
        return boatService.updateBoat(boatModel);
    }
}