package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start")
    private Calendar start;

    @Column(name = "end")
    private Calendar end;

    private boolean extended;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToOne
    @JoinColumn(name = "idCopy")
    private Copy copy;

    public Lending(int id, Calendar start, Calendar end, boolean extended, User user, Copy copy) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.extended = extended;
        this.user = user;
        this.copy = copy;
    }

    public Lending() {
    }
}
