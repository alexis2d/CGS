package fr.cgs.cgs_back.service;

import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    public Reservation findById(int id){
        Optional<Reservation> optionnalReservation = reservationRepository.findById(id);
        return optionnalReservation.orElseThrow(()->new EntityNotFoundException("Reservation not found with id " + id));
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(int id){reservationRepository.deleteById(id);}

}
