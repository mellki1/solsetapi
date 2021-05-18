package com.api.solset.dto;

import lombok.Data;
import util.UserType;

@Data
public class UserRequestDTO {
    private Long id;
    private String cpf;
    private String name;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    private String password;
    private UserType userType;
    private String requestToken;
}