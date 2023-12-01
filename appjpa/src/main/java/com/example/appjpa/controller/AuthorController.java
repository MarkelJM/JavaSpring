package com.example.appjpa.controller;

import com.example.appjpa.entity.Author;
import com.example.appjpa.repository.AuthorRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;


@CrossOrigin(originPatterns = "{http://127.0.0.1:5500/}")   //para dar permiso a un DOMINIO a hacer consultas, debido a la politica CROS
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Value("${page.size}")
    private int pageSize;
    private AuthorRepository repo;
    public AuthorController(AuthorRepository repo){
        this.repo = repo;
    }

    @GetMapping(path="{id}") //Get: /author/id
    public Author findAuthor(@PathVariable int id){  //con @PathVariable indicamos que viene del navegador
        return repo.findById(id).orElse(null);

    }
    @Operation(summary = "Solicita una lista de autores", description = "...") //para añadir texto/mensaje en el swaggel:http://localhost:8080/swagger-ui/index.html#/
    @GetMapping(path ="") //GET: /author
    public Flux<Author> findAllAuthor(@RequestParam(defaultValue = "-1") int page){ //un Flux indica una secuencia de datos y con Mono solo un dato en una comunicacion-> reactividad
        if(page < 0){
            var author =  repo.findAll();
            return Flux.fromIterable(author).delayElements(Duration.ofSeconds(5));
        }
        var pageable = Pageable.ofSize(pageSize).withPage(page);
        var pageAuthors = repo.findAll(pageable);
        if(pageAuthors.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Página vacía");
        }
       return Flux.fromIterable(pageAuthors.toList());
    }
}
