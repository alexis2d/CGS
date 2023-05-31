package fr.cgs.cgs_back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.User;

import java.util.Date;

public class PromotionDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("volume")
    private int volume;
    @JsonProperty("startedAt")
    private Date startedAt;
    @JsonProperty("endedAt")
    private Date endedAt;
    @JsonProperty("user_id")
    private int user_id;
    @JsonProperty("classroom_id")
    private int classroom_id;

    private Classroom classroom;
    private User user;

    public PromotionDto(String name, int volume, Date startedAt, Date endedAt) {
        this.name = name;
        this.volume = volume;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    public PromotionDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }
}
