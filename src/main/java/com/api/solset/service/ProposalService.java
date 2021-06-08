package com.api.solset.service;

import com.api.solset.dto.BudgetResponseDTO;
import com.api.solset.dto.ProposalRequestDTO;
import com.api.solset.dto.ProposalResponseDTO;
import com.api.solset.mapper.BudgetMapper;
import com.api.solset.mapper.ProposalMapper;
import com.api.solset.model.Budget;
import com.api.solset.model.Proposal;
import com.api.solset.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private ClientService clientService;

    public List<Proposal> listAll(){
        return proposalRepository.findAll();
    }

    public Proposal findByIdOrElseThrow(Long id){
        return proposalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proposal not found"));
    }

    public List<ProposalResponseDTO> findByBudgetId(Long budgetId){
        return ProposalMapper.INSTANCE.toBudgetResponseDTOList(proposalRepository.findByBudgetId(budgetId));
    }

    public List<ProposalResponseDTO> findByRequestToken(String requestToken){
        List<ProposalResponseDTO> proposalResponseDTOList = new ArrayList<>();
        for (Proposal proposal : proposalRepository.findByRequestToken(requestToken)){
            ProposalResponseDTO proposalResponseDTO = ProposalMapper.INSTANCE.toBudgetResponseDTO(proposal);
            proposalResponseDTO.setBudget(budgetService.findByIdOrElseThrow(proposal.getBudgetId()));
            proposalResponseDTO.setClient(clientService.findByIdOrElseThrow(proposalResponseDTO.getBudget().getClientId()));
            proposalResponseDTOList.add(proposalResponseDTO);
        }
        return proposalResponseDTOList;
    }

    public Proposal save(ProposalRequestDTO budgetDTO){
        return proposalRepository.save(
                ProposalMapper.INSTANCE.toBudget(budgetDTO)
        );
    }

    public void update(ProposalRequestDTO proposalRequestDTO){
        Proposal proposalSaved = findByIdOrElseThrow(proposalRequestDTO.getId());
        Proposal newProposal = ProposalMapper.INSTANCE.toBudget(proposalRequestDTO);
        newProposal.setId(proposalSaved.getId());
        proposalRepository.save(newProposal);
    }

    public void delete(Long id){
        proposalRepository.deleteById(id);
    }

}
