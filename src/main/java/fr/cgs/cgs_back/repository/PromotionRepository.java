package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query("SELECT p FROM Promotion p WHERE p.user_id=:user_id")
    List<Promotion> findAllByUserId(int user_id);
}
