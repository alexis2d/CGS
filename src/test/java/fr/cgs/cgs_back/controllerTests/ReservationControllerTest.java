package fr.cgs.cgs_back.controllerTests;

import fr.cgs.cgs_back.entity.Reservation;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import io.restassured.http.ContentType;

import java.util.Date;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class ReservationControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void testGetAllReservation() {

        given()
                .when()
                .request("GET", "/api/reservation")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();

    }

    @Test
    void testGetReservationById() {
        int reservationId = 11;

        given()
                .pathParam("id", reservationId)
                .when()
                .request("DELETE", "/api/reservation/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testGetReservationByUserId() {
        int userId = 3;

        given()
                .pathParam("userId", userId)
                .when()
                .request("GET", "/api/reservation/user/{userId}")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testGetReservationByClassroomId() {
        int classroomId = 8;

        given()
                .pathParam("classroomId", classroomId)
                .when()
                .request("GET", "/api/reservation/classroom/{classroomId}")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testCreateReservation() {
        Reservation reservation = new Reservation();
        reservation.setName("testName");
        reservation.setStartedAt(new Date());
        reservation.setEndedAt(new Date());
        reservation.setClassroom_id(7);
        reservation.setUser_id(5);

        given()
                .contentType(ContentType.JSON)
                .body(reservation)
                .when()
                .request("POST","/api/reservation")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testUpdateReservation() {
        int reservationId = 11;
        Reservation updatedReservation = new Reservation();
        updatedReservation.setName("testNameUpdated");
        updatedReservation.setStartedAt(new Date(new Date().getYear(), new Date().getMonth(), new Date().getDate() + 1));
        updatedReservation.setEndedAt(new Date(new Date().getYear(), new Date().getMonth(), new Date().getDate() + 3));
        updatedReservation.setUser_id(5);
        updatedReservation.setClassroom_id(7);

        given()
                .pathParam("id", reservationId)
                .contentType(ContentType.JSON)
                .body(updatedReservation)
                .when()
                .request("PUT","/api/reservation/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testDeleteReservation() {
        int reservationId = 11;

        given()
                .pathParam("id", reservationId)
                .when()
                .request("DELETE", "/api/reservation/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
