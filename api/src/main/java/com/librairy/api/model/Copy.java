package com.librairy.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "copy")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcopy")
    private int id;

    @Column(name = "idBook")
    private Book book;
}
