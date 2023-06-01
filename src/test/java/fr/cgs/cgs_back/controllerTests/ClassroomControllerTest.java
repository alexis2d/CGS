package fr.cgs.cgs_back.controllerTests;

import fr.cgs.cgs_back.entity.Classroom;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClassroomControllerTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/classroom";
    }

    @Test
    void testGetAllClassrooms() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .request("GET", "/list")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testGetClassroomById() {
        int classrommId = 1;

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", classrommId)
                .when()
                .request("GET","/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(classrommId))
                .log().all();
    }

    @Test
    void testCreateClassroom() {
        Classroom classroom = new Classroom();
        classroom.setName("testName");
        classroom.setCapacity(20);
        classroom.setSite_id(3);

        given()
                .contentType(ContentType.JSON)
                .body(classroom)
                .when()
                .request("POST","/add")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testUpdateClassroom() {
        int classrommId = 19;
        Classroom updatedClassroom = new Classroom();
        updatedClassroom.setName("testNameUpdated");
        updatedClassroom.setCapacity(25);

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", classrommId)
                .body(updatedClassroom)
                .when()
                .request("PUT","/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testDeleteClassroom() {
        int classrommId = 19;

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", classrommId)
                .when()
                .request("DELETE","/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }

}
