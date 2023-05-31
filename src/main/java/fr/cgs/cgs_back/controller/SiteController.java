package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.dto.SiteDto;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.mapper.MapStructMapper;
import fr.cgs.cgs_back.service.ClassroomService;
import fr.cgs.cgs_back.service.SiteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    private MapStructMapper mapper;

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
    public ResponseEntity<Void> createSite(@RequestBody SiteDto siteDto) {
        siteService.saveSite(mapper.siteDtoToSite(siteDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable int id,@RequestBody SiteDto updatedSite) {
        try{
            Site site = siteService.getSiteById(id);

            SiteDto newSite = mapper.siteToSiteDto(site);

            newSite.setName(updatedSite.getName());
            newSite.setCity(updatedSite.getCity());
            newSite.setAdress(updatedSite.getAdress());
            newSite.setDescription(updatedSite.getDescription());

            Site mappedSite = mapper.siteDtoToSite(newSite);

            mappedSite.setId(id);

            Site savedSite = siteService.saveSite(mappedSite);

            return ResponseEntity.ok(savedSite);
        } catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public void deleteSite(@PathVariable int id) {
        siteService.deleteSite(id);
    }
}

