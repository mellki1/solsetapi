package com.api.solset.mapper;

import com.api.solset.dto.BudgetRequestDTO;
import com.api.solset.dto.BudgetResponseDTO;
import com.api.solset.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BudgetMapper {
    public static final BudgetMapper INSTANCE = Mappers.getMapper(BudgetMapper.class);
    public Budget toBudget(BudgetRequestDTO budgetRequestDTO){
        return Budget.builder()
                .address1(budgetRequestDTO.getAddress1())
                .address2(budgetRequestDTO.getAddress2())
                .city(budgetRequestDTO.getCity())
                .classes(budgetRequestDTO.getClasses())
                .clientId(budgetRequestDTO.getClientId())
                .financing(budgetRequestDTO.getFinancing())
                .observations(budgetRequestDTO.getObservations())
                .technology(budgetRequestDTO.getTechnology())
                .postalCode(budgetRequestDTO.getPostalCode())
                .state(budgetRequestDTO.getState())
                .complement(budgetRequestDTO.getComplement())
                .structure(budgetRequestDTO.getStructure())
                .requestToken(budgetRequestDTO.getRequestToken())
                .voltage(budgetRequestDTO.getVoltage())
                .fileList(budgetRequestDTO.getFileList())
                .createdDate(budgetRequestDTO.getCreatedDate())
                .financingCnpj(budgetRequestDTO.getFinancingCnpj())
                .financingCpf(budgetRequestDTO.getFinancingCpf())
                .birthDate(budgetRequestDTO.getBirthDate())
                .id(budgetRequestDTO.getId())
                .build();
    }
    public BudgetResponseDTO toBudgetResponseDTO(Budget budget){
        return BudgetResponseDTO.builder()
                .address1(budget.getAddress1())
                .address2(budget.getAddress2())
                .city(budget.getCity())
                .classes(budget.getClasses())
                .financing(budget.getFinancing())
                .observations(budget.getObservations())
                .technology(budget.getTechnology())
                .postalCode(budget.getPostalCode())
                .state(budget.getState())
                .complement(budget.getComplement())
                .structure(budget.getStructure())
                .requestToken(budget.getRequestToken())
                .voltage(budget.getVoltage())
                .fileList(budget.getFileList())
                .createdDate(budget.getCreatedDate())
                .financingCnpj(budget.getFinancingCnpj())
                .financingCpf(budget.getFinancingCpf())
                .birthDate(budget.getBirthDate())
                .id(budget.getId())
                .build();
    }
}
