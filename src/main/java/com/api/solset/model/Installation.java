package com.api.solset.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Installation {
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
    private Long clientId;
    private String requestToken;
}
