package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByName(String name);

    List<Reservation> findByUserId(int userId);

    List<Reservation> findByClassroomId(int classroomId);

}