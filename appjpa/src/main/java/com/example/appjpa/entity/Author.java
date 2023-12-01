package com.example.appjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150 )
    private String name;
    @OneToMany(mappedBy =  "author", cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>(0);



    public Author(String name) {

        this.name = name;
    }
}
