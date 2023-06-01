package fr.cgs.cgs_back.controllerTests;

import fr.cgs.cgs_back.entity.Promotion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import fr.cgs.cgs_back.entity.Site;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import java.util.Date;


@SpringBootTest
public class PromotionControllerTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/promotion";
    }

    @Test
    void getPromotionByIdTest() {
        int promotionId = 2;
        given()
                .pathParam("id", promotionId)
                .when()
                .request("GET","/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(promotionId))
                .log().all();
    }

    @Test
    void listTest() {
        given()
                .when()
                .request("GET","")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void createPromotionTest() {
        Promotion promotion = new Promotion();

        promotion.setName("test");
        promotion.setVolume(12);
        promotion.setStartedAt(new Date("2021/01/01"));
        promotion.setEndedAt(new Date("2024/01/01"));
        promotion.setClassroom_id(2);
        promotion.setUser_id(1);

        given()
                .contentType(ContentType.JSON)
                .body(promotion)
                .when()
                .request("POST","/add")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void updatePromotionTest() {
        int promotionId = 17;
        Promotion promotion = new Promotion();
        promotion.setName("UpdateTest");
        promotion.setVolume(2);
        promotion.setStartedAt(new Date("2023/01/01"));
        promotion.setEndedAt(new Date("2026/01/01"));
        promotion.setClassroom_id(8);
        promotion.setUser_id(10);

        given()
                .pathParam("id", promotionId)
                .contentType(ContentType.JSON)
                .body(promotion)
                .when()
                .request("PUT","/{id}" )
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void deletePromotionTest() {
        given()
                .when()
                .delete("/17")
                .then()
                .statusCode(200);
    }


}
