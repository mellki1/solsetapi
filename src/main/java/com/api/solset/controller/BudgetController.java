package com.api.solset.controller;

import com.api.solset.model.Budget;
import com.api.solset.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(budgetService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Budget budget){
        return new ResponseEntity<>(budgetService.save(budget), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Budget budget){
        return new ResponseEntity<>(budgetService.update(budget), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        budgetService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
