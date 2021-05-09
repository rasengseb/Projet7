package com.librairy.webapp.model;

import lombok.Data;

@Data
public class Lending {

    private int id;

    private String start;

    private String end;

    private boolean extended;

    private User user;

    private Copy copy;
}
