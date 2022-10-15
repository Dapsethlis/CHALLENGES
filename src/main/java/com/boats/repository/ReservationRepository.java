package com.boats.repository;


import com.boats.model.ClientModel;
import com.boats.model.ReservationModel;
import com.boats.model.reports.ReportClient;
import com.boats.model.reports.ReportStatus;
import com.boats.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer id) {
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(Integer id) {
        try {
            reservationCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> reservation = reservationCrudRepository.findById( reservationModel.getIdReservation());
            if (!reservation.isEmpty()) {
                if (reservationModel.getStartDate() != null) {
                    reservation.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    reservation.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus() != null) {
                    reservation.get().setStatus(reservationModel.getStatus());
                }
                if (reservationModel.getBoat() != null) {
                    reservation.get().setBoat(reservationModel.getBoat());
                }
                if (reservationModel.getClient() != null) {
                    reservation.get().setClient(reservationModel.getClient());
                }
                if (reservationModel.getScore() != null) {
                    reservation.get().setScore(reservationModel.getScore());
                }
                reservationCrudRepository.save(reservation.get());
                return reservation.get();
            } else {
                return reservationModel;
            }
        } else {
            return reservationModel;
        }
    }
    public List<ReservationModel> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<ReservationModel> getReservationPeriod(Date startDate, Date finishDate){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(startDate, finishDate);
    }

    public List<ReportClient> getTopClient(){
        List<ReportClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countReservationModelByClient();
        for (Object[] i : report) {
            res.add(new ReportClient((Long) i[1], (ClientModel) i[0]));
        }
        return  res;
    }
}
