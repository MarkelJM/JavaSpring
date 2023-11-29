package com.example.app1.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

//@Data //Lombok-> lomboken erabiltzeko
@Entity //Si la tabla de sql y la clase se llaman distinto hay que hacer esto: @Table("OtroNombre")
//@AllArgsConstructor
@NoArgsConstructor
@ToString()  //@Data tambien lo incluye el metodo automaticamente
@EqualsAndHashCode(of = {"id"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private  int id;
    @Setter @Getter private  String name;



    public Client(String name){
        this.name = name;
    }

    public int getCodigo(){
        return id;
    }



}
