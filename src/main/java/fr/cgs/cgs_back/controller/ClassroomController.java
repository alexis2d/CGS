package fr.cgs.cgs_back.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import fr.cgs.cgs_back.dto.ClassroomDto;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.mapper.MapStructMapper;
import fr.cgs.cgs_back.service.ClassroomService;
import fr.cgs.cgs_back.service.SiteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classroom")
@CrossOrigin(origins = "http://localhost:3000")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private MapStructMapper mapper;
    @Autowired
    private SiteService siteService;

    @GetMapping("/{id}")
    public Classroom findById(@PathVariable int id) {
        return classroomService.findById(id);
    }

    @GetMapping("/list")
    public List<Classroom> list() {
        return classroomService.findAll();
    }

    @PostMapping("{siteId}/add")
    public ResponseEntity<Void> insertClassroom(@PathVariable int siteId, @RequestBody ClassroomDto classroomDto) {
        Site site = siteService.getSiteById(siteId);
        classroomDto.setSite(site);
        classroomService.insertClassroom(mapper.classroomDtoToClassroom(classroomDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable int id, @RequestBody ClassroomDto updatedClassroom) {
        try{
            Classroom classroom = classroomService.findById(id);

            ClassroomDto newClassroom = mapper.classroomToClassroomDto(classroom);

            newClassroom.setName(updatedClassroom.getName());
            newClassroom.setCapacity(updatedClassroom.getCapacity());

            Classroom mappedClassroom = mapper.classroomDtoToClassroom(newClassroom);

            mappedClassroom.setId(id);

            Classroom savedClassroom = classroomService.insertClassroom(mappedClassroom);
            return ResponseEntity.ok(savedClassroom);
        } catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable int id) {
        classroomService.deleteClassroom(id);
    }

}
