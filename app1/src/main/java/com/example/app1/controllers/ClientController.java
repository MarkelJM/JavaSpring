package com.example.app1.controllers;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "clients") //al controlador se le añade un path
public class ClientController {
    @Autowired private ClientRepository repoCliente;

    @RequestMapping(path = "/")  //....../client/
    public List<Client> allClient(){
        System.out.println("repoClient");
        return repoCliente.findAll();

    }

    @RequestMapping(path = "{id:\\d{0,5}}") // \\ == \ y la d -> indica un número
    public Client selectClient(@PathVariable("id") int codigo){ //si el path y el parametro son distintos en PathVariable("id")
        //return new Client("Markel"); //actualizado a find byID
        return repoCliente.findById(codigo).orElse(null);

    }



}
