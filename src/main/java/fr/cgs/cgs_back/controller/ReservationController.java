package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return reservationService.findById(id);
    }

    @GetMapping("/add")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation saveReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.ok(saveReservation);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation updateReservation) {
        try {
            Reservation reservation = reservationService.findById(id);
            reservation.setName(updateReservation.getName());
            reservation.setType(updateReservation.getType());
            reservation.setStartedAt(updateReservation.getStartedAt());
            reservation.setEndedAt(updateReservation.getEndedAt());
            reservation.setClassroom(updateReservation.getClassroom());
            reservation.setUser(updateReservation.getUser());

            Reservation savedReservation = reservationService.saveReservation(reservation);
            return ResponseEntity.ok(savedReservation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
