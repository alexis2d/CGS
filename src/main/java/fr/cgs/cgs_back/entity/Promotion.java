package fr.cgs.cgs_back.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private int id;

    @Column(name = "promotion_name")
    private String name;

    @Column(name = "promotion_volume")
    private int volume;

    @Column(name = "promotion_startedat")
    private Date startedAt;

    @Column(name = "promotion_endedat")
    private Date endedAt;

    @Column(name = "classroom_id")
    private int classroom_id;

    @ManyToOne
    @JoinColumn(name = "classroom_id", updatable = false, insertable = false)
    private Classroom classroom;

    @Column(name = "user_id")
    private int user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getVolume() {
        return volume;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public int getUser_id() {
        return user_id;
    }

    public User getUser() {
        return user;
    }

}
