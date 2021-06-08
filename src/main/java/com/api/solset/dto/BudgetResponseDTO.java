package com.api.solset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BudgetResponseDTO {
    private Long id;
    private String structure;
    private String technology;
    private String classes;
    private Boolean financing;
    private String voltage;
    private String fileList;
    private String createdDate;
    private String observations;
    private String postalCode;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String requestToken;
    private ClientResponseDTO client;
    private List<ProposalResponseDTO> proposalResponseDTOS;
    private String financingCnpj;
    private String financingCpf;
    private String birthDate;
}