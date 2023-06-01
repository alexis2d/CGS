package fr.cgs.cgs_back.serviceTests;

import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.repository.ReservationRepository;
import fr.cgs.cgs_back.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ReservationService.class})
public class ReservationServiceTest {
    @Autowired
    private ReservationService service;

    @MockBean
    private ReservationRepository repository;

    @Test
    void testGetProductByName() {
        String name = "Test name";
        Reservation reservation = new Reservation();
        reservation.setName(name);

        when(repository.findByName(name)).thenReturn(Arrays.asList(reservation));

        List<Reservation> result = service.getProductsByName(name);

        assertAll(
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals(result.get(0).getName(), name)
        );
    }

    @Test
    void testFindById() {
        Reservation reservation = new Reservation();
        reservation.setId(1);

        when(repository.findById(reservation.getId())).thenReturn(Optional.of(reservation));

        Reservation result = service.findById(reservation.getId());

        assertAll(
                () -> assertEquals(result, reservation)
        );
    }

    @Test
    void testGetAllReservation() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Reservation()));

        List<Reservation> result = service.getAllReservation();

        assertAll(
                () -> assertFalse(result.isEmpty())
        );
    }


    @Test
    void testSaveReservation() {
        Reservation reservation = new Reservation();

        when(repository.save(reservation)).thenReturn(reservation);

        Reservation result = service.saveReservation(reservation);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(reservation, result)
        );
    }


    @Test
    void testDeleteReservation() {
        Reservation reservation = new Reservation();
        reservation.setId(1);

        service.deleteReservation(reservation.getId());

        // Vérifie si une methode lève bien une exception
        assertThrows(EntityNotFoundException.class,
            () -> service.findById(reservation.getId())
        );
    }


    @Test
    void testFindReservationByClassroomId() {
        Classroom classroom = new Classroom();
        Reservation reservation = new Reservation();
        classroom.setId(1);
        reservation.setClassroom(classroom);

        when(repository.findByClassroomId(classroom.getId())).thenReturn(Arrays.asList(reservation));

        List<Reservation> result = service.findReservationByClassroomId(classroom.getId());

        assertAll(
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals(classroom.getId(), result.get(0).getClassroom().getId())
        );
    }
}
