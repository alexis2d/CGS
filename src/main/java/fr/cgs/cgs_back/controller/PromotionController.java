package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/{id}")
    public Promotion findById(int id) { return promotionService.findById(id); }

    @GetMapping("/list")
    public List<Promotion> list() { return promotionService.findAll(); }

    @PostMapping("/add")
    public ResponseEntity<Promotion> insertPromotion(@RequestBody Promotion promotion) {
        Promotion newPromotion = promotionService.insertPromotion(promotion);
        return ResponseEntity.ok(newPromotion);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable int id, @RequestBody Promotion updatedPromotion) {
        Promotion promotion = promotionService.findById(id);
        promotion.setName(updatedPromotion.getName());
        promotion.setStartedAt(updatedPromotion.getStartedAt());
        promotion.setClassroom(updatedPromotion.getClassroom());
        Promotion savedPromotion = promotionService.insertPromotion(promotion);
        return ResponseEntity.ok(savedPromotion);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deletePromotion(@PathVariable int id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.ok().build();
    }
}
