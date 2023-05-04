package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Iterable<Reservation> findByName(String name);

    List<Reservation> findByUserId(int userId);

    List<Reservation> findByClassroomId(int classroomId);

}