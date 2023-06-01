package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin(origins = "http://localhost:3000")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/{id}")
    public Promotion getPromotionById(@PathVariable int id) { return promotionService.getPromotionById(id); }

    @GetMapping
    public List<Promotion> list() { return promotionService.findAll(); }

    @PostMapping("/add")
    public ResponseEntity<Promotion> insertPromotion(@RequestBody Promotion promotion) {
        Promotion newPromotion = promotionService.insertPromotion(promotion);
        return ResponseEntity.ok(newPromotion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable int id, @RequestBody Promotion updatedPromotion) {
        try {
            Promotion promotion = promotionService.getPromotionById(id);
            promotion.setName(updatedPromotion.getName());
            promotion.setVolume(updatedPromotion.getVolume());
            promotion.setStartedAt(updatedPromotion.getStartedAt());
            promotion.setEndedAt(updatedPromotion.getEndedAt());
            promotion.setClassroom_id(updatedPromotion.getClassroom_id());
            promotion.setUser_id(updatedPromotion.getUser_id());
            return ResponseEntity.ok(updatedPromotion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotion(@PathVariable int id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.ok().build();
    }
}
