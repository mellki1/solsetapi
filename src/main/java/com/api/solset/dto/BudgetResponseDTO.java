package com.api.solset.dto;

import lombok.Data;
import java.util.Date;

@Data
public class BudgetResponseDTO {
    private Long id;
    private Integer laborValue;
    private Integer proposalNumber;
    private String situation;
    private Date updatingDate;
    private Integer value;
}