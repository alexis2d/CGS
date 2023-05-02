package fr.cgs.cgs_back.dto;

public class SiteDto {

    private int id;
    private String name;
    private String city;
    private String adress;
    private String description;

    public SiteDto(int id, String name, String city, String adress, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.description = description;
    }
}
