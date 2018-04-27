package ru.larionov.sbertech.library.sberlibrary.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
