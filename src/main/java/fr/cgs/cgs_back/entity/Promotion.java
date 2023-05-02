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

    @ManyToOne
    @JoinColumn(name = "classroom_id", updatable = false, insertable = false)
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;
}
