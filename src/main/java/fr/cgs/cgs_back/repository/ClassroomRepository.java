package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    @Query("SELECT c FROM Classroom c WHERE c.site_id=:site_id")
    List<Classroom> findAllBySiteId(int site_id);
}
