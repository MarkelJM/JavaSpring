package com.example.appjpa;

import com.example.appjpa.entity.Author;
import com.example.appjpa.entity.Book;
import com.example.appjpa.repository.AuthorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppjpaApplication.class, args);
	}

	@PostConstruct
	public void initDB(AuthorRepository repo) {
		var auth1 = new Author("Juan");
		auth1.getBooks().add(new Book());
		repo.saveAndFlush(auth1);
	}

}
