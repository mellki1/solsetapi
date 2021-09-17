package com.api.solset.controller;

import com.api.solset.dto.ProposalRequestDTO;
import com.api.solset.dto.ProposalResponseDTO;
import com.api.solset.model.Proposal;
import com.api.solset.service.FireBaseService;
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

    @Autowired
    private FireBaseService fireBaseService;

    @GetMapping("/full")
    public ResponseEntity<List<ProposalResponseDTO>> findAllWithRelationship(@RequestParam(required = false) String requestToken,
                                                                             @RequestParam String masterName) {
        if (requestToken != null) {
            return ResponseEntity.ok(proposalService.findByRequestToken(requestToken));
        } else {
            return ResponseEntity.ok(proposalService.listAllWithRelationship(masterName));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Proposal> findById(@PathVariable Long id) {
        return ResponseEntity.ok(proposalService.findByIdOrElseThrow(id));
    }

    @PostMapping
    public ResponseEntity<Proposal> save(@RequestBody ProposalRequestDTO budgetDTO) {
        return new ResponseEntity<>(proposalService.save(budgetDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Proposal> update(@PathVariable Long id, @RequestBody ProposalRequestDTO proposalRequestDTO) {
        proposalService.update(id, proposalRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        proposalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
