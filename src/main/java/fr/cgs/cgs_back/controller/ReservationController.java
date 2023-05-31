package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.dto.PromotionDto;
import fr.cgs.cgs_back.dto.ReservationDto;
import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.mapper.MapStructMapper;
import fr.cgs.cgs_back.service.ClassroomService;
import fr.cgs.cgs_back.service.ReservationService;
import fr.cgs.cgs_back.service.UserService;
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
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private UserService userService;
    @Autowired
    private MapStructMapper mapper;

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return reservationService.findById(id);
    }
    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationByUserId(@PathVariable int userId){
        return reservationService.findReservationByUserId(userId);
    }

    @GetMapping("/classroom/{classroomId}")
    public List<Reservation> getReservationByClassroomId(@PathVariable int classroomId){
        return reservationService.findReservationByClassroomId(classroomId);
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDto reservationDto){
        reservationService.saveReservation(mapper.reservationDtoToReservation(reservationDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody ReservationDto updateReservation) {
        try{
            Reservation reservation = reservationService.findById(id);
            ReservationDto newReservation = mapper.reservationToReservationDto(reservation);

            newReservation.setName(updateReservation.getName());
            newReservation.setStartedAt(updateReservation.getStartedAt());
            newReservation.setEndedAt(updateReservation.getEndedAt());
            newReservation.setClassroom_id(updateReservation.getClassroom_id());
            newReservation.setUser_id(updateReservation.getUser_id());
            newReservation.setClassroom(classroomService.findById(newReservation.getClassroom_id()));
            newReservation.setUser(userService.findById(newReservation.getUser_id()));

            Reservation mappedReservation = mapper.reservationDtoToReservation(newReservation);
            mappedReservation.setId(id);

            Reservation savedReservation = reservationService.saveReservation(mappedReservation);
            return ResponseEntity.ok(savedReservation);

        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
