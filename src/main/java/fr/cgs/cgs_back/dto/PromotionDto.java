package fr.cgs.cgs_back.dto;

import java.util.Date;

public class PromotionDto {
    private int id;
    private String name;
    private int volume;
    private Date startedAt;
    private Date endedAt;
    private ClassroomDto classroom;
    private UserDto user;

    public PromotionDto(int id, String name, int volume, Date startedAt, Date endedAt, ClassroomDto classroom, UserDto user) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.classroom = classroom;
        this.user = user;
    }
}
