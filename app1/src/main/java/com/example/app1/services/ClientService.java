package com.example.app1.services;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements iClientService {

    private final ClientRepository repo;

    @Autowired
    public ClientService(final ClientRepository repo){

        this.repo = repo;
    }

    @Override
    public void patch(Client client){
        /* debido a la arquitectura no mandamos mensajes con @responseentity, ya que estamos en el controller de MVC, pero sí pasamos excepciones*/
        var optional = repo.findById(client.getId());
        if (!optional.isEmpty()) {
            throw new RuntimeException("No existe el registro");
        }

        var c = optional.get();

        if (client.getName() != null){
            c.setName(client.getName());
        }

        repo.save(c);
    }

}
