package com.librairy.webapp.model;

import lombok.Data;

@Data
public class Book {

    private int id;

    private String title;

    private String author;

    private int totalExemplaire;

    private int exemplaireDispo;

    private Librairy librairy;
}
