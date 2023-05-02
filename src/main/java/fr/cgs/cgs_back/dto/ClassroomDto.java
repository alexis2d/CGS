package fr.cgs.cgs_back.dto;

public class ClassroomDto {

    private int id;
    private String name;
    private int capacity;
    private SiteDto site;

    public ClassroomDto(int id, String name, int capacity, SiteDto site) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.site = site;
    }

}
