package com.example.appjpa.config;

import com.example.appjpa.entity.Author;
import com.example.appjpa.entity.Book;
import com.example.appjpa.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {

    @Bean
    public CommandLineRunner init(AuthorRepository repo){ //CommandLineRunner cuando creas un bean te devuelve automaticamente el view
        return args -> {
            var auth1 = new Author("Juan");
            auth1.getBooks().add(new Book());
            repo.saveAndFlush(auth1);
        };
    }
}
