package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.service.ClassroomService;
import fr.cgs.cgs_back.service.SiteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sites")
@CrossOrigin(origins = "http://localhost:3000")
public class SiteController {

    @Autowired
    private SiteService siteService;
    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }

    @GetMapping("/{id}")
    public Site getSiteById(@PathVariable int id) {
        return siteService.getSiteById(id);
    }

    @GetMapping("/{id}/classrooms")
    public List<Classroom> findAllBySiteId(@PathVariable int id) {
        return classroomService.findAllBySiteId(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Site> createSite(@RequestBody Site site) {
        Site savedSite = siteService.saveSite(site);
        return ResponseEntity.ok(savedSite);
    }


    @PutMapping("/{id}/update")
    public ResponseEntity<Site> updateSite(@PathVariable int id,@RequestBody Site updatedSite) {
        try{
            Site site = siteService.getSiteById(id);
            site.setName(updatedSite.getName());
            site.setCity(updatedSite.getCity());
            site.setAdress(updatedSite.getAdress());
            site.setDescription(updatedSite.getDescription());
            Site savedSite = siteService.saveSite(site);
            return ResponseEntity.ok(savedSite);
        } catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}/delete")
    public void deleteSite(@PathVariable int id) {
        siteService.deleteSite(id);
    }
}

