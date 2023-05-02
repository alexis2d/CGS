package fr.cgs.cgs_back.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    private int id;

    @Column(name = "site_name")
    private String name;

    @Column(name = "site_city")
    private String city;

    @Column(name = "site_adress")
    private String adress;

    @Column(name = "site_description")
    private String description;
}
