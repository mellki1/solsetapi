package com.api.solset.dto;

import lombok.Data;
import java.util.Date;

@Data
public class BudgetRequestDTO {
    private Long id;
    private Long installationId;
    private Integer laborValue;
    private Integer proposalNumber;
    private String situation;
    private String updateDate;
    private Integer value;
    private String requestToken;
}