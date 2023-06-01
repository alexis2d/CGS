package fr.cgs.cgs_back.serviceTests;

import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.repository.ClassroomRepository;
import fr.cgs.cgs_back.service.ClassroomService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ClassroomService.class})
public class ClassroomServiceTest {

    @Autowired
    ClassroomService classroomService;
    @MockBean
    ClassroomRepository classroomRepository;

    Classroom classroomExpect = buildClassroom(1, "test", 12, 1);
    List<Classroom> listExpect = Arrays.asList(classroomExpect);

    Classroom buildClassroom(int id, String name, int capacity, int site_id) {
        Classroom classroom = new Classroom();
        classroom.setId(id);
        classroom.setName(name);
        classroom.setCapacity(capacity);
        classroom.setSite_id(site_id);
        return classroom;
    }

    @Test
    void findByIdTest() {
        when(classroomRepository.findById(classroomExpect.getId())).thenReturn(Optional.ofNullable(classroomExpect));

        Classroom result = classroomService.findById(classroomExpect.getId());

        assertAll(
                () -> assertEquals(result, classroomExpect)
        );
    }

    @Test
    void findAllBySiteIdTest() {
        when(classroomRepository.findAllBySiteId(classroomExpect.getSite_id())).thenReturn(listExpect);

        List<Classroom> result = classroomService.findAllBySiteId(classroomExpect.getSite_id());

        assertAll(
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals(result, listExpect)
        );
    }

    @Test
    void deleteClassroomTest() {
        classroomService.deleteClassroom(classroomExpect.getId());

        assertThrows(EntityNotFoundException.class, ()->classroomService.findById(classroomExpect.getId()));
    }

    @Test
    void findAllTest() {
        when(classroomRepository.findAll()).thenReturn(listExpect);

        List<Classroom> result = classroomService.findAll();

        assertAll(
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals(result, listExpect)
        );
    }

    @Test
    void insertClassroomTest() {
        classroomService.insertClassroom(classroomExpect);

        when(classroomService.insertClassroom(classroomExpect)).thenReturn(classroomExpect);

        Classroom result = classroomService.insertClassroom(classroomExpect);

        assertEquals(result, classroomExpect);
    }

}
