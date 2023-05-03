package fr.cgs.cgs_back.service;

import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.repository.PromotionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    public Promotion findById(int id) {
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        return optionalPromotion.orElseThrow(()->new EntityNotFoundException("Promotion not found with id " + id));
    }

    public void deletePromotion(int id) {
        promotionRepository.deleteById(id);
    }

    public List<Promotion> findAll(){
        return promotionRepository.findAll();
    }

    public Promotion insertPromotion(Promotion promotion){
        return promotionRepository.save(promotion);
    }
}
