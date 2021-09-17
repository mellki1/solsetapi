package com.api.solset.dto;

import com.api.solset.model.Budget;
import com.api.solset.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposalResponseDTO {
    private Long id;
    private Integer laborValue;
    private Long budgetId;
    private Integer proposalNumber;
    private String situation;
    private String updateDate;
    private Integer value;
    private String requestToken;
    private String pendenceDetail;
    private String systemPower;
    private String requiredArea;
    private String consideredConsumption;
    private String averageAccountValue;
    private String newAccountValue;
    private String supplierName;
    private String quantityModules;
    private String typeOfModules;
    private String brandOfModules;
    private String quantityInverter1;
    private String inverterType1;
    private String quantityInverter2;
    private String inverterType2;
    private String inverterBrand;
    private String typeOfPlant;
    private String modality;
    private String kitValue;
    private String commissionValue;
    private String observation;
    private Client client;
    private Budget budget;
    private String masterName;
}