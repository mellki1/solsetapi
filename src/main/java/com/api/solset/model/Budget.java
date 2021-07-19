package com.api.solset.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String structure;
    private String technology;
    private String classes;
    private Boolean financing;
    private String voltage;
    private String fileList;
    private String createdDate;
    private String observations;
    private String postalCode;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String complement;
    private Long clientId;
    private String financingCnpj;
    private String financingCpf;
    private String birthDate;
    private String requestToken;
}
