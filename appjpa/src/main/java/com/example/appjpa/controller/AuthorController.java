package com.example.appjpa.controller;

import com.example.appjpa.entity.Author;
import com.example.appjpa.entity.Book;
import com.example.appjpa.repository.AuthorRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(originPatterns = "{http://127.0.0.1:5500/}")   //para dar permiso a un DOMINIO a hacer consultas, debido a la politica CROS
@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository repo;
    public AuthorController(AuthorRepository repo){
        this.repo = repo;
    }

    @GetMapping(path="{id}") //Get: /author/id
    public Author findAuthor(@PathVariable int id){  //con @PathVariable indicamos que viene del navegador
        return repo.findById(id).orElse(null);

    }
}
