package fr.cgs.cgs_back.service;

import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.repository.ClassroomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom findById(int id) {
        Optional<Classroom> optionalClassroom = classroomRepository.findById(id);
        return optionalClassroom.orElseThrow(()->new EntityNotFoundException("Classroom not found with id " + id));
    }

    public List<Classroom> findAllBySiteId(int id){
        return classroomRepository.findAllBySiteId(id);
    }

    public void deleteClassroom(int id) {
        classroomRepository.deleteById(id);
    }

    public List<Classroom> findAll(){
        return classroomRepository.findAll();
    }

    public Classroom insertClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }

}
