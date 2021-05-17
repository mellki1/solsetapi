package com.api.solset.controller;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.model.Client;
import com.api.solset.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.listAll());
    }

    @GetMapping("/full")
    public ResponseEntity<List<ClientResponseDTO>> findAllWithRelationship(){
        return ResponseEntity.ok(clientService.listAllWithRelationship());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByIdOrElseThrow(id));
    }

    @GetMapping("/{id}/full")
    public ResponseEntity<ClientResponseDTO> findByIdWithRelationship(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByIdOrElseThrowWithRelationship(id));
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<List<ClientResponseDTO>> findByUserId(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByUserId(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientRequestDTO clientRequestDTO){
        return new ResponseEntity<>(clientService.save(clientRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ClientRequestDTO clientRequestDTO){
        clientService.update(clientRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
