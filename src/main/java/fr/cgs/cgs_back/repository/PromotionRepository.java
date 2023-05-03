package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
}
