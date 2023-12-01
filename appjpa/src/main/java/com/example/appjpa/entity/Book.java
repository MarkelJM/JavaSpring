package com.example.appjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;
@Entity
@EqualsAndHashCode(of="id")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne()
    @JoinColumn(name="authorId", referencedColumnName="id")    //authorId es la  FKey para autor
    private Author author;
}
