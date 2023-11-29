package com.example.app1.controllers;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "client") //al controlador se le añade un path
public class ClientController {
    @Autowired
    private ClientRepository repoCliente;

    //@RequestMapping(path = "/", method = RequestMethod.GET)  //....../client/  @GetMapping(path = "/")
    @GetMapping(path = "/") //--> esto o esto: @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Client> allClient() {
        System.out.println("repoClient");
        return repoCliente.findAll();

    }

    @GetMapping(path = "/{id:\\d{0,5}}") // \\ == \ y la d -> indica un número
    public Client selectClient(@PathVariable("id") int codigo) { //si el path y el parametro son distintos en PathVariable("id")
        //return new Client("Markel"); //actualizado a find byID
        return repoCliente.findById(codigo).get();

    }

    /*
    @PostMapping(path = "/") //POST: client
    //No funciona, solucion abajo
    public void insertClient(Client client){
        repoCliente.save(client);
    }
    */
    @PostMapping(path = "/") //POST: client
    public ResponseEntity<Client> inserClient(@RequestBody Client client) {
        client.setId(-1);//si el usuario  indica en el json un id, aqui indicamos que el id se cambia a-1 y como no acepta menor de 0 crea un nuevo seguido al ultimo
        var c = repoCliente.save(client); //@RequestBody busca objetos json o algo asi
        return ResponseEntity.ok(c);

    }

    // actualizar todo con un PUT
    @PutMapping(path = "/") //POST: client
    public ResponseEntity<Void> updateClient(@RequestBody Client client) {
        if (!repoCliente.existsById(client.getId())) {
            return ResponseEntity.notFound().build();
            //throw new RuntimeException("No existe el registro");
        }
        repoCliente.save(client); //@RequestBody busca objetos json o algo asi
        return ResponseEntity.ok(null);


    }

    @PatchMapping (path = "/") //POST: client
    public ResponseEntity<Void> patchClient(@RequestBody Client client) {
        var optional = repoCliente.findById(client.getId());
        if (!optional.isEmpty()) {
            return ResponseEntity.notFound().build();
            //throw new RuntimeException("No existe el registro");
        }

        var c = optional.get();

        if (client.getName() != null){
            client.setName(client.getName());
        }
        repoCliente.save(client); //@RequestBody busca objetos json o algo asi
        return ResponseEntity.ok(null);


    }









}
