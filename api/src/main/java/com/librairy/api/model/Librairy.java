package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "librairy")
public class Librairy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "adresse")
    private String adresse;
}
