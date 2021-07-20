package com.api.solset.controller;

import com.api.solset.dto.BudgetRequestDTO;
import com.api.solset.dto.BudgetResponseDTO;
import com.api.solset.model.Budget;
import com.api.solset.service.BudgetService;
import com.api.solset.service.FireBaseService;
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

    @Autowired
    private FireBaseService fireBaseService;

    @CrossOrigin
    @GetMapping("/full")
    public ResponseEntity<List<BudgetResponseDTO>> findAllWithRelationship(@RequestParam(name = "requestToken", required = false) String requestToken){
        if (requestToken !=null /*&& fireBaseService.verifyUser(requestToken) != null*/){
                return ResponseEntity.ok(budgetService.findByUserRequestToken(requestToken));
            }else{
                return ResponseEntity.ok(budgetService.findAllWithRelationship());
            }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Budget budget){
        return new ResponseEntity<>(budgetService.save(budget), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BudgetRequestDTO budgetRequestDTO){
        budgetService.update(id, budgetRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        budgetService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
