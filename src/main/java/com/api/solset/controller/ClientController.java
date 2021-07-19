package com.api.solset.controller;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.model.Client;
import com.api.solset.service.ClientService;
import com.api.solset.service.FireBaseService;
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

    @Autowired
    private FireBaseService fireBaseService;

    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<List<ClientResponseDTO>> findAllWithRelationship(@RequestParam(name = "requestToken", required = false) String requestToken){
        if (requestToken !=null && fireBaseService.verifyUser(requestToken) != null) {
            return ResponseEntity.ok(clientService.listAllWithRelationshipByToken(requestToken));
        }else{
            return ResponseEntity.ok(clientService.listAllWithRelationship());
        }
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
