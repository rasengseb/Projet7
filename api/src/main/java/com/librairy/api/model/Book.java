package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "total")
    private int totalExemplaire;

    @Column(name = "dispo")
    private int exemplaireDispo;

    @OneToOne
    @JoinColumn(name = "idLibrairy")
    private Librairy librairy;

}
