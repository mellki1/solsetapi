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
    public abstract Budget toBudget(BudgetRequestDTO budgetRequestDTO);
    public abstract List<BudgetResponseDTO> toBudgetResponseDTOList(List<Budget> budgetList);
}