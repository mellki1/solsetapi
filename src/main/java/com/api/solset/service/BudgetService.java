package com.api.solset.service;

import com.api.solset.dto.BudgetRequestDTO;
import com.api.solset.dto.BudgetResponseDTO;
import com.api.solset.mapper.BudgetMapper;
import com.api.solset.model.Budget;
import com.api.solset.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private InstallationService installationService;

    public List<Budget> listAll(){
        return budgetRepository.findAll();
    }

    public Budget findByIdOrElseThrow(Long id){
        return budgetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Budget not found"));
    }

    public List<BudgetResponseDTO> findByInstallationId(Long installationId){
        return BudgetMapper.INSTANCE.toBudgetResponseDTOList(budgetRepository.findByInstallationId(installationId));
    }

    public List<BudgetResponseDTO> findByRequestToken(String requestToken){
        return BudgetMapper.INSTANCE.toBudgetResponseDTOList(budgetRepository.findByRequestToken(requestToken));
    }

    public Budget save(BudgetRequestDTO budgetDTO){
        return budgetRepository.save(
                BudgetMapper.INSTANCE.toBudget(budgetDTO)
        );
    }

    public void update(BudgetRequestDTO budgetRequestDTO){
        Budget budgetSaved = findByIdOrElseThrow(budgetRequestDTO.getId());
        Budget newBudget = BudgetMapper.INSTANCE.toBudget(budgetRequestDTO);
        newBudget.setId(budgetSaved.getId());
        budgetRepository.save(newBudget);
    }

    public void delete(Long id){
        budgetRepository.deleteById(id);
    }

}
