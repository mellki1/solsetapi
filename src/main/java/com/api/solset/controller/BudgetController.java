package com.api.solset.controller;

import com.api.solset.dto.BudgetRequestDTO;
import com.api.solset.model.Budget;
import com.api.solset.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Budget>> findAll(){
        return ResponseEntity.ok(budgetService.listAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Budget> findById(@PathVariable Long id){
        return ResponseEntity.ok(budgetService.findByIdOrElseThrow(id));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Budget> save(@RequestBody BudgetRequestDTO budgetDTO){
        return new ResponseEntity<>(budgetService.save(budgetDTO), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<Budget> update(@RequestBody BudgetRequestDTO budgetDTO){
        budgetService.update(budgetDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        budgetService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
