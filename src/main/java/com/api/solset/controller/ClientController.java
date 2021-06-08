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

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.listAll());
    }

    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<List<ClientResponseDTO>> findAllWithRelationship(@RequestParam(name = "requestToken") String requestToken){
            return ResponseEntity.ok(clientService.listAllWithRelationshipByToken(requestToken));
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByIdOrElseThrow(id));
    }

    @CrossOrigin
    @GetMapping("/{id}/full")
    public ResponseEntity<ClientResponseDTO> findByIdWithRelationship(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByIdOrElseThrowWithRelationship(id));
    }

    @CrossOrigin
    @GetMapping("/seller")
    public ResponseEntity<List<ClientResponseDTO>> findByUserId(@RequestParam(name = "requestToken") String requestToken){
        return ResponseEntity.ok(clientService.findByUserRequestToken(requestToken));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientRequestDTO clientRequestDTO){
        return new ResponseEntity<>(clientService.save(clientRequestDTO), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClientRequestDTO clientRequestDTO){
        clientService.update(clientRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
