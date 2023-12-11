package com.example.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {


    @Autowired
    ClientRepository clientRepository;


    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client findById(@PathVariable  Long id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(() -> new
                Exception("Client inexistnt"));
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
