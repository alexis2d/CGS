package fr.cgs.cgs_back.dto;

import fr.cgs.cgs_back.entity.User;

import java.util.Date;

public class ReservationDto {
    private int id;
    private String name;
    private Date startedAt;
    private Date endedAt;
    private ClassroomDto classroom;
    private User user;
    private int type;

    public ReservationDto(int id, String name, Date startedAt, Date endedAt, ClassroomDto classroom, User user, int type) {
        this.id = id;
        this.name = name;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.classroom = classroom;
        this.user = user;
        this.type = type;
    }
}
