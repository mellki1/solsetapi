package com.api.solset.controller;

import com.api.solset.model.Installation;
import com.api.solset.service.InstallationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("installation")
public class InstallationController{

    @Autowired
    private InstallationService installationService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(installationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Installation installation){
        return new ResponseEntity<>(installationService.save(installation), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Installation installation){
        return new ResponseEntity<>(installationService.update(installation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        installationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
