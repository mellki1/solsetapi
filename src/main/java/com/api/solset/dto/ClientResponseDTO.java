package com.api.solset.dto;

import lombok.*;
import util.PersonType;
import java.util.List;

@Data
public class ClientResponseDTO {
    private Long id;
    private PersonType personType;
    private String cnpj;
    private String cpf;
    private String name;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    private Long userId;
    private List<InstallationResponseDTO> installations;
}