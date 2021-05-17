package com.api.solset.dto;

import lombok.Data;
import java.util.Date;

@Data
public class BudgetRequestDTO {
    private Long id;
    private Integer installationId;
    private Integer laborValue;
    private Integer proposalNumber;
    private String situation;
    private Date updatingDate;
    private Integer value;
}