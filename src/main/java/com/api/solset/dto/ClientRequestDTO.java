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
    private String fantasyName;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    private String postalCode;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String complement;
    private String requestToken;
    private String contactName;
}