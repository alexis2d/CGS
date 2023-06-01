package fr.cgs.cgs_back.serviceTests;

import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.repository.PromotionRepository;
import fr.cgs.cgs_back.service.PromotionService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {PromotionService.class})
public class PromotionServiceTest {

    @Autowired
    private PromotionService service;

    @MockBean
    private PromotionRepository repository;

    @Test
    void findAllTest() {
        Promotion promotion = buildPromotion("test", 12);
        when(repository.findAll()).thenReturn(Arrays.asList(promotion));
        List<Promotion> result = service.findAll();

        assertAll(
                () -> assertFalse(result.isEmpty())
        );
    }

    @Test
    void getPromotionByIdTest() {
        Promotion promotion = buildPromotion("test", 12);
        when(repository.findById(promotion.getId()));

        assertThrows(EntityNotFoundException.class,
                () -> service.getPromotionById(promotion.getId())
        );
    }

    @Test
    void findAllByUserIdTest() {
        Promotion promotion = buildPromotion("test", 12);
        List<Promotion> listExpect = Arrays.asList(promotion);
        when(repository.findAllByUserId(1)).thenReturn(listExpect);
        List<Promotion> result = service.findAllByUserId(1);

        assertAll(
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals(result, listExpect)
        );
    }

    @Test
    void deletePromotionTest() {
        Promotion promotion = buildPromotion("test", 12);
        promotion.setId(19);
        service.deletePromotion(19);
        // check if promotion is deleted
    }

    @Test
    void insertPromotionTest() {
        Promotion promotion = buildPromotion("test", 12);
        when(repository.save(promotion)).thenReturn(promotion);
        Promotion result = service.insertPromotion(promotion);

        assertAll(
                () -> assertEquals(result, promotion)
        );
    }

    Promotion buildPromotion(String name, int volume) {
        Promotion promotion = new Promotion();
        promotion.setName(name);
        promotion.setVolume(volume);
        return promotion;
    }
}
