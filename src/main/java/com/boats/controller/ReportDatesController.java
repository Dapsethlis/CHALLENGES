package com.boats.controller;
import com.boats.model.ReservationModel;
import com.boats.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation/report-dates")
@CrossOrigin(origins = "*")
public class ReportDatesController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("all")
    @PostMapping("/all")
    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationService.getAllReservations();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ReservationModel> getAllReservations2() {
        return (List<ReservationModel>) reservationService.getAllReservations();
    }

    @GetMapping("{idReservation}")
    public Optional<ReservationModel> getReservation(@PathVariable Integer idReservation) {
        return reservationService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel) {
        return reservationService.saveReservation(reservationModel);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable Integer idReservation) {
        reservationService.deleteReservation(idReservation);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel updateReservation(@RequestBody ReservationModel reservationModel) {
        return reservationService.updateReservation(reservationModel);
    }
}
