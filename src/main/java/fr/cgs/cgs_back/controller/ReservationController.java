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
import java.util.Optional;

@RestController
@RequestMapping("api/reservation")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationByUserId(@PathVariable int userId){
        return reservationService.findReservationByUserId(userId);
    }

    @GetMapping("/classroom/{classroomId}")
    public List<Reservation> getReservationByClassroomId(@PathVariable int classroomId){
        return reservationService.findReservationByClassroomId(classroomId);
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation saveReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.ok(saveReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation updateReservation) {
        try {
            Reservation reservation = reservationService.findById(id);
            reservation.setName(updateReservation.getName());
            reservation.setType(updateReservation.getType());
            reservation.setStartedAt(updateReservation.getStartedAt());
            reservation.setEndedAt(updateReservation.getEndedAt());
            reservation.setClassroom_id(updateReservation.getClassroom_id());
            reservation.setUser_id(updateReservation.getUser_id());

            Reservation savedReservation = reservationService.saveReservation(reservation);
            return ResponseEntity.ok(savedReservation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
