package com.api.solset.controller;

import com.api.solset.dto.UserRequestDTO;
import com.api.solset.dto.UserResponseDTO;
import com.api.solset.model.User;
import com.api.solset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/full")
    public ResponseEntity<List<UserResponseDTO>> listAllWithRelationship(){
        return ResponseEntity.ok(userService.listAllWithRelationship());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.save(userRequestDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserRequestDTO userRequestDTO){
        userService.update(userRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
