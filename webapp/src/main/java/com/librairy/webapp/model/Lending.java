package com.librairy.webapp.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class Lending {

    private int id;

    private Calendar start;

    private Calendar end;

    private boolean extended;

    private User user;

    private Copy copy;
}
