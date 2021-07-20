package com.api.solset.controller;

import com.api.solset.model.Log;
import com.api.solset.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogService logService;

    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<List<Log>> findAll(@RequestParam(value = "requestToken", required = false) String requestToken){
        if (requestToken!=null){
            return ResponseEntity.ok(logService.findByRequestToken(requestToken));
        }else{
            return ResponseEntity.ok(logService.listAll());
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Log> save(@RequestBody Log log){
        return new ResponseEntity<>(logService.save(log), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Log> update(@RequestBody Log log){
        logService.update(log);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        logService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
