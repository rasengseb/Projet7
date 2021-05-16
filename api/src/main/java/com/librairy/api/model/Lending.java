package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start")
    private String start;

    @Column(name = "end")
    private String end;

    private boolean extended;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToOne
    @JoinColumn(name = "idCopy")
    private Copy copy;
}
