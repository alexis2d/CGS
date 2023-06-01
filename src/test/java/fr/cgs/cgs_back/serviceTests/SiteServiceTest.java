package fr.cgs.cgs_back.serviceTests;

import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.service.SiteService;
import fr.cgs.cgs_back.repository.SiteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest (classes = {SiteService.class})
public class SiteServiceTest {
    @Autowired
    SiteService service;
    @MockBean
    SiteRepository repository;

    Site buildSite(String name, String city, String adress, String description) {
        Site site = new Site();
        site.setName(name);
        site.setCity(city);
        site.setAdress(adress);
        site.setDescription(description);
        return site;
    }


    @Test
    void findAllTest() {
        Site site1 = buildSite("testName1", "testCity1", "testAdress1", "testDescription1");
        Site site2 = buildSite("testName2", "testCity2", "testAdress2", "testDescription2");
        Site site3 = buildSite("testName3", "testCity3", "testAdress3", "testDescription3");
        List<Site> sites = Arrays.asList(site1, site2, site3);

        when(repository.findAll()).thenReturn(sites);
        List<Site> result = service.getAllSites();

        assertAll(
                ()->assertFalse(result.isEmpty()),
                ()->assertEquals(sites, result),
                ()->assertEquals("testName1", result.get(0).getName()),
                ()->assertEquals("testCity1", result.get(0).getCity()),
                ()->assertEquals("testAdress1", result.get(0).getAdress()),
                ()->assertEquals("testDescription1", result.get(0).getDescription()),
                ()->assertEquals("testName2", result.get(1).getName()),
                ()->assertEquals("testCity2", result.get(1).getCity()),
                ()->assertEquals("testAdress2", result.get(1).getAdress()),
                ()->assertEquals("testDescription2", result.get(1).getDescription()),
                ()->assertEquals("testName3", result.get(2).getName()),
                ()->assertEquals("testCity3", result.get(2).getCity()),
                ()->assertEquals("testAdress3", result.get(2).getAdress()),
                ()->assertEquals("testDescription3", result.get(2).getDescription())
        );
    }


    @Test
    void findByIdTest() {
        Site site = buildSite("testName", "testCity", "testAdress", "testDescription");

        when(repository.findById(1)).thenReturn(java.util.Optional.of(site));
        Site result = service.getSiteById(1);

        assertAll(
                ()->assertEquals(site, result),
                ()->assertEquals("testName", result.getName()),
                ()->assertEquals("testCity", result.getCity()),
                ()->assertEquals("testAdress", result.getAdress()),
                ()->assertEquals("testDescription", result.getDescription())
        );
    }

    @Test
    void saveTest() {
        Site site = buildSite("testName", "testCity", "testAdress", "testDescription");

        when(repository.save(site)).thenReturn(site);
        Site result = service.saveSite(site);

        assertAll(
                ()->assertEquals(site, result),
                ()->assertEquals("testName", result.getName()),
                ()->assertEquals("testCity", result.getCity()),
                ()->assertEquals("testAdress", result.getAdress()),
                ()->assertEquals("testDescription", result.getDescription())
        );
    }

    @Test
    void deleteTest() {
        Site site = new Site();
        site.setId(1);

        service.deleteSite(site.getId());

        assertThrows(EntityNotFoundException.class, ()->service.getSiteById(site.getId()));
    }



}
