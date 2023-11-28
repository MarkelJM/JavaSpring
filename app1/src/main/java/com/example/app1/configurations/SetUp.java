package com.example.app1.configurations;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //necesito @configuration para que spring boot busque los @Bean
public class SetUp {
    @Autowired
    private ClientRepository repo;

    @Bean
    public CommandLineRunner init(){
        //Commandlinerrunner es una interface que ejecuta una lambda que no devuelve nada, void
        return args -> {
            System.out.println("Inicialización de BBDD");
            repo.save(new Client("Markel"));
            repo.save(new Client("Maite"));
            repo.save(new Client("Lai")); //repo es un repositorio
            repo.save(new Client("Ilargi"));

            //repo.save(new Client(1, "Ilargi"));
            System.out.println(repo.findAll());
        };
    }
}
