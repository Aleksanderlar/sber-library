package ru.larionov.sbertech.library.sberlibrary.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;
}
