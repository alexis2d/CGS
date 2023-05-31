package fr.cgs.cgs_back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.entity.User;

import java.util.Date;

public class ReservationDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("startedAt")
    private Date startedAt;
    @JsonProperty("endedAt")
    private Date endedAt;
    @JsonProperty("type")
    private int type;
    @JsonProperty("classroom_id")
    private int classroom_id;
    @JsonProperty("user_id")
    private int user_id;
    private Classroom classroom;
    private User user;

    public ReservationDto(String name, Date startedAt, Date endedAt, int type) {
        this.name = name;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.type = type;
    }

    public ReservationDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
