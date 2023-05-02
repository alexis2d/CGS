package fr.cgs.cgs_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private int id;

    @Column(name = "classroom_name")
    private String name;

    @Column(name = "classroom_capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "site_id", updatable = false, insertable = false)
    private Site site;
}
