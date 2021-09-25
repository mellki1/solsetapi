package com.api.solset.service;

import com.api.solset.dto.BudgetRequestDTO;
import com.api.solset.dto.BudgetResponseDTO;
import com.api.solset.mapper.BudgetMapper;
import com.api.solset.model.Budget;
import com.api.solset.model.Client;
import com.api.solset.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    public List<BudgetResponseDTO> findAllWithRelationship(String masterName){
        List<BudgetResponseDTO> budgetResponseDTOList = new ArrayList<>();
        List<Budget> budgetList = null;
        if (masterName.equals("ALL")){
            budgetList = budgetRepository.findAll();
        }else{
            budgetList = budgetRepository.findByMasterName(masterName);
        }
        for (Budget budget : budgetList){
            BudgetResponseDTO budgetResponseDTO = BudgetMapper.INSTANCE.toBudgetResponseDTO(budget);
            if (masterName.equals("ALL")){
                budgetResponseDTO.setClient(clientService.findByIdOrElseThrowDto(budget.getClientId()));
                budgetResponseDTO.setProposalResponseDTOS(proposalService.findByBudgetId(budget.getId()));
            }else{
                budgetResponseDTO.setClient(clientService.findByIdOrElseThrowWithRelationship(budget.getClientId()));
                budgetResponseDTO.setProposalResponseDTOS(proposalService.findByBudgetId(budget.getId()));
            }
            budgetResponseDTOList.add(budgetResponseDTO);
        }
        return budgetResponseDTOList;
    }

    public List<BudgetResponseDTO> findByUserRequestToken(String requestToken){
        List<BudgetResponseDTO> budgetResponseDTOList = new ArrayList<>();
        for (Budget budget : budgetRepository.findByRequestToken(requestToken)){
            BudgetResponseDTO budgetResponseDTO = BudgetMapper.INSTANCE.toBudgetResponseDTO(budget);
            budgetResponseDTO.setClient(clientService.findByIdOrElseThrowDto(budget.getClientId()));
            budgetResponseDTO.setProposalResponseDTOS(proposalService.findByBudgetId(budget.getId()));
            budgetResponseDTOList.add(budgetResponseDTO);
        }
        return budgetResponseDTOList;
    }

    public Budget findByIdOrElseThrow(Long id){
        return budgetRepository.findById(id).orElse(new Budget());
    }

    public List<BudgetResponseDTO> findByClientId(Long clientId){
        List<BudgetResponseDTO> budgetResponseDTOList = new ArrayList<>();
        for (Budget budget : budgetRepository.findByClientId(clientId)){
            BudgetResponseDTO budgetResponseDTO = BudgetMapper.INSTANCE.toBudgetResponseDTO(budget);
            budgetResponseDTO.setProposalResponseDTOS(proposalService.findByBudgetId(budget.getId()));
            budgetResponseDTOList.add(budgetResponseDTO);
        }
        return budgetResponseDTOList;
    }

    public Budget save(Budget budget){
        return budgetRepository.save(budget);
    }

    public Budget update(Long id, BudgetRequestDTO budgetRequestDTO){
        Budget budgetSaved = findByIdOrElseThrow(id);
        Budget newBudget = BudgetMapper.INSTANCE.toBudget(budgetRequestDTO);
        newBudget.setId(budgetSaved.getId());
        budgetRepository.save(newBudget);
        return newBudget;
    }

    public void delete(Long id){
        proposalService.deleteByBudgetId(id);
        budgetRepository.deleteById(id);
    }

    public void deleteByClientId(Long clientId){
        for (Budget budget : budgetRepository.findByClientId(clientId)){
            delete(budget.getId());
        }
    }
}
