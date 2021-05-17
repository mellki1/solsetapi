package com.api.solset.controller;

import com.api.solset.dto.InstallationRequestDTO;
import com.api.solset.dto.InstallationResponseDTO;
import com.api.solset.model.Installation;
import com.api.solset.service.InstallationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("installation")
public class InstallationController{

    @Autowired
    private InstallationService installationService;

    @GetMapping
    public ResponseEntity<List<Installation>> findAll(){
        return ResponseEntity.ok(installationService.findAll());
    }

    @GetMapping("/full")
    public ResponseEntity<List<InstallationResponseDTO>> findAllWithRelationship(){
        return ResponseEntity.ok(installationService.findAllWithRelationship());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Installation> findById(@PathVariable Long id){
        return ResponseEntity.ok(installationService.findByIdOrElseThrow(id));
    }

    @GetMapping("/{id}/full")
    public ResponseEntity<InstallationResponseDTO> findByIdOrElseThrowWithRelationship(@PathVariable Long id){
        return ResponseEntity.ok(installationService.findByIdOrElseThrowWithRelationship(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Installation installation){
        return new ResponseEntity<>(installationService.save(installation), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody InstallationRequestDTO installationRequestDTO){
        installationService.update(installationRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        installationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
