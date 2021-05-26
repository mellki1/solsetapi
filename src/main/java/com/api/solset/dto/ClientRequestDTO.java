package com.api.solset.dto;

import lombok.Data;
import util.PersonType;

@Data
public class ClientRequestDTO {
    private Long Id;
    private PersonType personType;
    private String cnpj;
    private String cpf;
    private String name;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    private String requestToken;
}