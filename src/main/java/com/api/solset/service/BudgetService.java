package com.api.solset.service;

import com.api.solset.model.Budget;
import com.api.solset.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    public List<Budget> findAll(){
        return budgetRepository.findAll();
    }

    public List<Budget> findByInstallationId(Long installationId){
        return budgetRepository.findByInstallationId(installationId);
    }

    public Budget save(Budget budget){

        return budgetRepository.save(budget);
    }

    public Budget update(Budget budget){
        this.delete(budget.getId());
        return budgetRepository.save(budget);
    }

    public void delete(Long id){
        budgetRepository.deleteById(id);
    }

}
