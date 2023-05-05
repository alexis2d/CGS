package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/{id}/promotions")
    public List<Promotion> findAllByUserId(@PathVariable int id) {
        return promotionService.findAllByUserId(id);
    }
}
