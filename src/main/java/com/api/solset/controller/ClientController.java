package com.api.solset.controller;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
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

    @GetMapping("/full")
    public ResponseEntity<List<ClientResponseDTO>> findAllWithRelationship(@RequestParam(name = "requestToken", required = false) String requestToken) {
        if (requestToken != null /*&& fireBaseService.verifyUser(requestToken) != null*/) {
            return ResponseEntity.ok(clientService.listAllWithRelationshipByToken(requestToken));
        } else {
            return ResponseEntity.ok(clientService.listAllWithRelationship());
        }
    }

    @GetMapping("/seller")
    public ResponseEntity<List<ClientResponseDTO>> findByUserId(@RequestParam(name = "requestToken") String requestToken) {
        return ResponseEntity.ok(clientService.findByUserRequestToken(requestToken));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientRequestDTO clientRequestDTO) {
        return new ResponseEntity<>(clientService.save(clientRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ClientRequestDTO clientRequestDTO) {
        clientService.update(id, clientRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
