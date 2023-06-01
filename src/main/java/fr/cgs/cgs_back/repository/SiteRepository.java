package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Integer> {
}
