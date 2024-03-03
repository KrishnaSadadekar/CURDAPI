package com.example.StudentCrud.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private float percentage;
}
