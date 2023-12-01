package com.example.appjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@EqualsAndHashCode(of="id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "author")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Temporal(TemporalType.DATE)
    private LocalDate date;


    @JsonIgnore  //para que no de datos en "serie", es decir dando todo el rato el dato
    @ManyToOne()
    @JoinColumn(name="authorId", referencedColumnName="id")    //authorId es la  FKey para autor
    private Author author;



}
