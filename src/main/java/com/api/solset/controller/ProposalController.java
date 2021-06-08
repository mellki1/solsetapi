package com.api.solset.controller;

import com.api.solset.dto.ProposalRequestDTO;
import com.api.solset.dto.ProposalResponseDTO;
import com.api.solset.model.Proposal;
import com.api.solset.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Proposal>> findAll(){
        return ResponseEntity.ok(proposalService.listAll());
    }

    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<List<ProposalResponseDTO>> findAllWithRelationship(@RequestParam(value = "requestToken") String requestToken){
        return ResponseEntity.ok(proposalService.findByRequestToken(requestToken));
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Proposal> findById(@PathVariable Long id){
        return ResponseEntity.ok(proposalService.findByIdOrElseThrow(id));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Proposal> save(@RequestBody ProposalRequestDTO budgetDTO){
        return new ResponseEntity<>(proposalService.save(budgetDTO), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Proposal> update(@RequestBody ProposalRequestDTO budgetDTO){
        proposalService.update(budgetDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        proposalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
