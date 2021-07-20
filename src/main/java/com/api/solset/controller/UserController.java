package com.api.solset.controller;

import com.api.solset.dto.UserRequestDTO;
import com.api.solset.dto.UserResponseDTO;
import com.api.solset.model.User;
import com.api.solset.service.FireBaseService;
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

    @Autowired
    private FireBaseService fireBaseService;


    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<?> findAll(@RequestParam(name = "requestToken", required = false) String requestToken){
        if (requestToken!= null /*&& fireBaseService.verifyUser(requestToken) != null*/){
            return ResponseEntity.ok(userService.findByRequestToken(requestToken));
        }else{
            return ResponseEntity.ok(userService.listAllWithRelationship());
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.save(userRequestDTO), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserRequestDTO userRequestDTO){
        userService.update(userRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam (name = "requestToken", required = true) String userToken){
        userService.delete(userToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
