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

    @ManyToOne
    @JoinColumn(name = "classroom_id", updatable = false, insertable = false)
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Column(name = "reservation_type")
    private int type;
}
