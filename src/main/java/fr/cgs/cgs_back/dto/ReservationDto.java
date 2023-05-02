package fr.cgs.cgs_back.dto;

import java.util.Date;

public class ReservationDto {
    private int id;
    private String name;
    private Date startedAt;
    private Date endedAt;
    private ClassroomDto classroom;
    private UserDto user;
    private int type;

    public ReservationDto(int id, String name, Date startedAt, Date endedAt, ClassroomDto classroom, UserDto user, int type) {
        this.id = id;
        this.name = name;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.classroom = classroom;
        this.user = user;
        this.type = type;
    }
}
