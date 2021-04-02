package com.api.solset.controller;

import com.api.solset.model.Client;
import com.api.solset.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findByUserId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client){
        return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
