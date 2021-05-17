package com.api.solset.dto;

import lombok.Data;
import java.util.List;

@Data
public class InstallationResponseDTO {
    private Long id;
    private String structure;
    private String technology;
    private String classes;
    private Boolean financing;
    private String observations;
    private String postalCode;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private ClientResponseDTO client;
    private List<BudgetResponseDTO> budgets;
}