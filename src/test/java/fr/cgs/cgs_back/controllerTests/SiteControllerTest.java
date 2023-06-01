package fr.cgs.cgs_back.controllerTests;
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


@SpringBootTest
public class SiteControllerTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost:8081/api/sites";
    }


// Le format de test ci dessous ne fonctionne qu'avec CGSBackApplication lancée en fond.
    //il ne fonctionne pas avec MockMvc


//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        RestAssuredMockMvc.mockMvc(mockMvc);
//    }
    @Test
    void testGetAllSites() {
        given()
                .when()
                .request("GET", "")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testGetSiteById() {
        int siteId = 1;

        given()
                .pathParam("id", siteId)
                .when()
                .request("GET","/api/sites/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(siteId))
                .log().all();
    }

    @Test
    void testFindAllClassroomBySiteId() {
        int siteId = 1;

        given()
                .pathParam("id", siteId)
                .when()
                .request("GET","/api/sites/{id}/classrooms")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testCreateSite() {
        Site site = new Site();
        site.setName("testName");
        site.setCity("testCity");
        site.setAdress("testAdress");
        site.setDescription("testDescription");

        given()
                .contentType(ContentType.JSON)
                .body(site)
                .when()
                .request("POST","/api/sites/add")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testUpdateSite() {
        int siteId = 9;
        Site updatedSite = new Site();
        updatedSite.setName("testNameUpdated");
        updatedSite.setCity("testCityUpdated");
        updatedSite.setAdress("testAdressUpdated");
        updatedSite.setDescription("testDescriptionUpdated");

        given()
                .pathParam("id", siteId)
                .contentType(ContentType.JSON)
                .body(updatedSite)
                .when()
                .request("PUT","/api/sites/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    void testDeleteSite() {
        int siteId = 9;

        given()
                .pathParam("id", siteId)
                .when()
                .request("DELETE","/api/sites/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
