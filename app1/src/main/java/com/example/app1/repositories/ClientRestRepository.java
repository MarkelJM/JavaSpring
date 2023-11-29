package com.example.app1.repositories;

import com.example.app1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
import java.util.stream.Stream;

/*
despues de añadir en el pom para el api rest(apuntado en el cuaderno con dependencia RestRepositories)
creamos la interface que extiende el jparepositoy para la url.

Está en la guia del profesor.
 */
@RepositoryRestResource(path = "rest", collectionResourceRel = "clients")
public interface ClientRestRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByName(String name);

}


