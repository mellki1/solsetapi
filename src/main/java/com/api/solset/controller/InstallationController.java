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

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Installation>> findAll(){
        return ResponseEntity.ok(installationService.findAll());
    }

    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<List<InstallationResponseDTO>> findAllWithRelationship(@RequestParam(name = "requestToken") String requestToken){
        if (requestToken !=null){
            return ResponseEntity.ok(installationService.findByUserRequestToken(requestToken));
        }else{
            return ResponseEntity.ok(installationService.findAllWithRelationship());
        }

    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Installation installation){
        return new ResponseEntity<>(installationService.save(installation), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InstallationRequestDTO installationRequestDTO){
        installationService.update(id, installationRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        installationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
