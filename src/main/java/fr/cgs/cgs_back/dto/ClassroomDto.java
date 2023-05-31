package fr.cgs.cgs_back.dto;
import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.service.SiteService;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ClassroomDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("capacity")
    private int capacity;
    private Site site;


    public ClassroomDto(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public ClassroomDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
