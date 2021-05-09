package com.librairy.webapp.model;

import lombok.Data;

@Data
public class User {

    private int id;

    private String pseudo;

    private String mdp;

    private String mail;

    private String firstName;

    private String lastName;
}
