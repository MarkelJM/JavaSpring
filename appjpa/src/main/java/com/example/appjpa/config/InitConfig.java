package com.example.appjpa.config;

import com.example.appjpa.entity.Author;
import com.example.appjpa.entity.Book;
import com.example.appjpa.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.LocalDate;

@Configuration
public class InitConfig {

    @Bean
    public CommandLineRunner init(AuthorRepository repo){ //CommandLineRunner cuando creas un bean te devuelve automaticamente el view
        return args -> {
            var auth1 = new Author("Juan");
            var book1 = new Book(0, "libro1", LocalDate.now(),auth1);
            auth1.getBooks().add(book1);
            repo.saveAndFlush(auth1);

            auth1 = new Author("Maite");
            repo.saveAndFlush(auth1);


            //var response = repo.findById(1).get();
            //response.getBooks().size();
            //repo.saveAndFlush(auth1);
            /*
            usamos size para obligar a crear todos los libros, ya que son Lazy de por si y asi forzamos a crear hasta los null, pero da errores
             */
            /*
            var client = WebClient.create("/author");
            client.get()
                    .retrieve()
                    .bodyToFlux(Author.class)
                    .delayElements(Duration.ofSeconds(5))
                    .toStream()
                    .forEach(a -> System.out.println(a));


             */

            //retrieve construye solicitudes web
            //usamos el stream ya que debemos manejar los datods de un flux a algo mas conocido
        };
    }
}
