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

    @GetMapping("/full")
    public ResponseEntity<List<BudgetResponseDTO>> findAllWithRelationship(@RequestParam(name = "requestToken", required = false) String requestToken) {
        if (requestToken != null) {
            return ResponseEntity.ok(budgetService.findByUserRequestToken(requestToken));
        } else {
            return ResponseEntity.ok(budgetService.findAllWithRelationship());
        }
    }

    @PostMapping
    public ResponseEntity<Budget> save(@RequestBody Budget budget) {
        return ResponseEntity.ok(budgetService.save(budget));
    }

    @PutMapping("{id}")
    public ResponseEntity<Budget> update(@PathVariable Long id, @RequestBody BudgetRequestDTO budgetRequestDTO) {
        budgetService.update(id, budgetRequestDTO);
        return ResponseEntity.ok(budgetService.update(id, budgetRequestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        budgetService.delete(id);
        return ResponseEntity.ok(null);
    }
}
