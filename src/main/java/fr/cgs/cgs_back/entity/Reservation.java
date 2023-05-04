package fr.cgs.cgs_back.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "reservation_name")
    private String name;

    @Column(name = "reservation_startedat")
    private Date startedAt;

    @Column(name = "reservation_endedat")
    private Date endedAt;

    @Column(name = "classroom_id")
    private int classroom_id;

    @ManyToOne
    @JoinColumn(name = "classroom_id", updatable = false, insertable = false)
    private Classroom classroom;

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public int getUser_id() {
        return user_id;
    }

    @Column(name = "user_id")
    private int user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Column(name = "reservation_type")
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
