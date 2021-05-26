package com.api.solset.mapper;

import com.api.solset.dto.BudgetRequestDTO;
import com.api.solset.dto.BudgetResponseDTO;
import com.api.solset.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BudgetMapper {
    public static final BudgetMapper INSTANCE = Mappers.getMapper(BudgetMapper.class);
    public Budget toBudget(BudgetRequestDTO budgetRequestDTO){
        return Budget.builder()
                .id(budgetRequestDTO.getId())
                .value(budgetRequestDTO.getValue())
                .proposalNumber(budgetRequestDTO.getProposalNumber())
                .situation(budgetRequestDTO.getSituation())
                .updateDate(budgetRequestDTO.getUpdateDate())
                .laborValue(budgetRequestDTO.getLaborValue())
                .installationId(budgetRequestDTO.getInstallationId())
                .requestToken(budgetRequestDTO.getRequestToken())
                .build();
    }

    public BudgetResponseDTO toBudgetResponseDTO(Budget budget){
        return BudgetResponseDTO.builder()
                .id(budget.getId())
                .value(budget.getValue())
                .proposalNumber(budget.getProposalNumber())
                .situation(budget.getSituation())
                .updateDate(budget.getUpdateDate())
                .laborValue(budget.getLaborValue())
                .installationId(budget.getInstallationId())
                .requestToken(budget.getRequestToken())
                .build();
    }

    public abstract List<BudgetResponseDTO> toBudgetResponseDTOList(List<Budget> budgetList);
}