package fr.cgs.cgs_back.dto;

public class ClassroomDto {
    private String name;
    private int capacity;
    private SiteDto site;

    public ClassroomDto(String name, int capacity, SiteDto site) {
        this.name = name;
        this.capacity = capacity;
        this.site = site;
    }

}
