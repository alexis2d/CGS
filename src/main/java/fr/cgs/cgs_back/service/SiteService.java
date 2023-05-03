package fr.cgs.cgs_back.service;

import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.repository.SiteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;

    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public Site getSiteById(int id) {
        Optional<Site> optionalSite = siteRepository.findById(id);
        return optionalSite.orElseThrow(()->new EntityNotFoundException("Site not found with id " + id));
    }

    public Site saveSite(Site site) {
        return siteRepository.save(site);
    }

    public void deleteSite(int id) {
        siteRepository.deleteById(id);
    }
}
