package com.api.solset.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class InstallationRequestDTO {
    private Long id;
    private String structure;
    private String technology;
    private String classes;
    private Boolean financing;
    private String fileList;
    private String voltage;
    private String createdDate;
    private String observations;
    private String postalCode;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Long clientId;
    private String requestToken;
}