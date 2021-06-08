package com.api.solset.dto;

import com.api.solset.model.Log;
import lombok.*;
import util.PersonType;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponseDTO {
    private Long id;
    private PersonType personType;
    private String cnpj;
    private String cpf;
    private String name;
    private String fantasyName;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    private String requestToken;
    private List<BudgetResponseDTO> budgetResponseDTOList;
    private List<Log> logResponseDTOList;
}