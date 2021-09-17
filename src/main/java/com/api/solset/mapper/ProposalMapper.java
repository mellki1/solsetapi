package com.api.solset.mapper;

import com.api.solset.dto.ProposalRequestDTO;
import com.api.solset.dto.ProposalResponseDTO;
import com.api.solset.model.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProposalMapper {
    public static final ProposalMapper INSTANCE = Mappers.getMapper(ProposalMapper.class);
    public Proposal toBudget(ProposalRequestDTO proposalRequestDTO){
        return Proposal.builder()
                .id(proposalRequestDTO.getId())
                .value(proposalRequestDTO.getValue())
                .proposalNumber(proposalRequestDTO.getProposalNumber())
                .situation(proposalRequestDTO.getSituation())
                .updateDate(proposalRequestDTO.getUpdateDate())
                .laborValue(proposalRequestDTO.getLaborValue())
                .budgetId(proposalRequestDTO.getBudgetId())
                .requestToken(proposalRequestDTO.getRequestToken())
                .pendenceDetail(proposalRequestDTO.getPendenceDetail())
                .systemPower(proposalRequestDTO.getSystemPower())
                .requiredArea(proposalRequestDTO.getRequiredArea())
                .consideredConsumption(proposalRequestDTO.getConsideredConsumption())
                .averageAccountValue(proposalRequestDTO.getAverageAccountValue())
                .newAccountValue(proposalRequestDTO.getNewAccountValue())
                .supplierName(proposalRequestDTO.getSupplierName())
                .quantityModules(proposalRequestDTO.getQuantityModules())
                .typeOfModules(proposalRequestDTO.getTypeOfModules())
                .brandOfModules(proposalRequestDTO.getBrandOfModules())
                .quantityInverter1(proposalRequestDTO.getQuantityInverter1())
                .inverterType1(proposalRequestDTO.getInverterType1())
                .quantityInverter2(proposalRequestDTO.getInverterType2())
                .inverterType2(proposalRequestDTO.getInverterType2())
                .inverterBrand(proposalRequestDTO.getInverterBrand())
                .typeOfPlant(proposalRequestDTO.getTypeOfPlant())
                .modality(proposalRequestDTO.getModality())
                .kitValue(proposalRequestDTO.getKitValue())
                .commissionValue(proposalRequestDTO.getCommissionValue())
                .observation(proposalRequestDTO.getObservation())
                .masterName(proposalRequestDTO.getMasterName())
                .build();
    }

    public ProposalResponseDTO toBudgetResponseDTO(Proposal proposal){
        return ProposalResponseDTO.builder()
                .id(proposal.getId())
                .value(proposal.getValue())
                .proposalNumber(proposal.getProposalNumber())
                .situation(proposal.getSituation())
                .updateDate(proposal.getUpdateDate())
                .laborValue(proposal.getLaborValue())
                .budgetId(proposal.getBudgetId())
                .requestToken(proposal.getRequestToken())
                .pendenceDetail(proposal.getPendenceDetail())
                .systemPower(proposal.getSystemPower())
                .requiredArea(proposal.getRequiredArea())
                .consideredConsumption(proposal.getConsideredConsumption())
                .averageAccountValue(proposal.getAverageAccountValue())
                .newAccountValue(proposal.getNewAccountValue())
                .supplierName(proposal.getSupplierName())
                .quantityModules(proposal.getQuantityModules())
                .typeOfModules(proposal.getTypeOfModules())
                .brandOfModules(proposal.getBrandOfModules())
                .quantityInverter1(proposal.getQuantityInverter1())
                .inverterType1(proposal.getInverterType1())
                .quantityInverter2(proposal.getInverterType2())
                .inverterType2(proposal.getInverterType2())
                .inverterBrand(proposal.getInverterBrand())
                .typeOfPlant(proposal.getTypeOfPlant())
                .modality(proposal.getModality())
                .kitValue(proposal.getKitValue())
                .commissionValue(proposal.getCommissionValue())
                .observation(proposal.getObservation())
                .masterName(proposal.getMasterName())
                .build();
    }

    public abstract List<ProposalResponseDTO> toBudgetResponseDTOList(List<Proposal> proposalList);
}