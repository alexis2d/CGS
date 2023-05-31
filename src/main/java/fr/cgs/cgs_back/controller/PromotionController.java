package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.dto.PromotionDto;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.mapper.MapStructMapper;
import fr.cgs.cgs_back.service.ClassroomService;
import fr.cgs.cgs_back.service.PromotionService;
import fr.cgs.cgs_back.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin(origins = "http://localhost:3000")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private UserService userService;
    @Autowired
    private MapStructMapper mapper;

    @GetMapping("/{id}")
    public Promotion getPromotionById(@PathVariable int id) { return promotionService.getPromotionById(id); }

    @GetMapping
    public List<Promotion> list() { return promotionService.findAll(); }

    @PostMapping("/add")
    public ResponseEntity<Promotion> insertPromotion(@RequestBody PromotionDto promotionDto) {
        promotionService.insertPromotion(mapper.promotionDtoToPromotion(promotionDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable int id, @RequestBody PromotionDto updatedPromotion) {
        try{
            Promotion promotion = promotionService.getPromotionById(id);

            PromotionDto newPromotion = mapper.promotionToPromotionDto(promotion);

            newPromotion.setName(updatedPromotion.getName());
            newPromotion.setVolume(updatedPromotion.getVolume());
            newPromotion.setStartedAt(updatedPromotion.getStartedAt());
            newPromotion.setEndedAt(updatedPromotion.getEndedAt());
            newPromotion.setClassroom_id(updatedPromotion.getClassroom_id());
            newPromotion.setUser_id(updatedPromotion.getUser_id());
            newPromotion.setClassroom(classroomService.findById(newPromotion.getClassroom_id()));
            newPromotion.setUser(userService.findById(newPromotion.getUser_id()));

            Promotion mappedPromotion = mapper.promotionDtoToPromotion(newPromotion);
            mappedPromotion.setId(id);

            Promotion savedPromotion = promotionService.insertPromotion(mappedPromotion);
            return ResponseEntity.ok(savedPromotion);

        } catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotion(@PathVariable int id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.ok().build();
    }
}
