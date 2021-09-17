package com.api.solset.controller;

import com.api.solset.dto.UserRequestDTO;
import com.api.solset.model.User;
import com.api.solset.service.FireBaseService;
import com.api.solset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FireBaseService fireBaseService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
            return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/full")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String requestToken, @RequestParam String masterName) {
        if (requestToken != null) {
            return ResponseEntity.ok(userService.findByRequestToken(requestToken, masterName));
        } else {
            return ResponseEntity.ok(userService.findAllWithRelationship(masterName));
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.save(userRequestDTO), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        userService.update(id, userRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam(name = "requestToken", required = true) String userToken) {
        userService.delete(userToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
