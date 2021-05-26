package com.api.solset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BudgetResponseDTO {
    private Long id;
    private Integer laborValue;
    private Long installationId;
    private Integer proposalNumber;
    private String situation;
    private String updateDate;
    private Integer value;
    private String requestToken;
}