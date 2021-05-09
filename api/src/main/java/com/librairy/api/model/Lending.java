package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlending")
    private int id;

    private String start;

    private String end;

    private boolean extended;

    @Column(name = "idUser")
    private User user;

    @Column(name = "idCopy")
    private Copy copy;
}
