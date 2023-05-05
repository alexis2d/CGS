package fr.cgs.cgs_back.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import fr.cgs.cgs_back.dto.ClassroomDto;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.service.ClassroomService;
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

    @GetMapping("/{id}")
    public Classroom findById(@PathVariable int id) {
        return classroomService.findById(id);
    }

    @GetMapping("/list")
    public List<Classroom> list() {
        return classroomService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Classroom> insertClassroom(@RequestBody Classroom classroom) {
        Classroom newClassroom = classroomService.insertClassroom(classroom);
        return ResponseEntity.ok(newClassroom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable int id, @RequestBody Classroom updatedClassroom) {
        try{
            Classroom classroom = classroomService.findById(id);
            classroom.setName(updatedClassroom.getName());
            classroom.setCapacity(updatedClassroom.getCapacity());
            classroom.setSite(updatedClassroom.getSite());
            Classroom savedClassroom = classroomService.insertClassroom(classroom);
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
