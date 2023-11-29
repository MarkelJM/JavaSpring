package com.example.app1.repositories;

import com.example.app1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestResource(path = "rest", collectionResourceRel = "clients")
public interface ClientRestRepository extends JpaRepository<Client, Integer> {


}


