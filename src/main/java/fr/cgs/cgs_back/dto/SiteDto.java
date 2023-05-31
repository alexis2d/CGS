package fr.cgs.cgs_back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
public class SiteDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("adress")
    private String adress;
    @JsonProperty("description")
    private String description;

    public SiteDto(String name, String city, String adress, String description) {
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.description = description;
    }

    public SiteDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
