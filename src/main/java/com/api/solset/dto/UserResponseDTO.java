package com.api.solset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.UserType;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {
    private Long id;
    private String cpf;
    private String name;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    private String password;
    private UserType userType;
    private String requestToken;
    private List<ClientResponseDTO> clients;
}