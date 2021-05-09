package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbook")
    private int id;

    private String title;

    private String author;

    @Column(name = "total")
    private int totalExemplaire;

    @Column(name = "dispo")
    private int exemplaireDispo;

    @Column(name = "idLibrairy")
    private Librairy library;
}
