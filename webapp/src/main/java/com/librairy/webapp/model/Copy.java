package com.librairy.webapp.model;

import lombok.Data;

@Data
public class Copy {

    private int id;

    private Book book;

    private Librairy librairy;

    private int nbExemplaireDispo;
}
