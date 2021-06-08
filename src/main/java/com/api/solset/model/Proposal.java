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
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long budgetId;

    @Column(nullable = false)
    private Integer laborValue;

    @Column(nullable = false)
    private Integer proposalNumber;

    @Column(nullable = false)
    private String situation;

    @Column(nullable = false)
    private String updateDate;

    @Column(nullable = false)
    private Integer value;

    @Column(nullable = false)
    private String requestToken;

    private String pendenceDetail;

    private String systemPower;
    private String requiredArea;
    private String consideredConsumption;
    private String averageAccountValue;
    private String newAccountValue;
    private String supplierName;
    private String quantityModules;
    private String typeOfModules;
    private String brandOfModules;
    private String quantityInverter1;
    private String inverterType1;
    private String quantityInverter2;
    private String inverterType2;
    private String inverterBrand;
    private String typeOfPlant;
    private String modality;
    private String kitValue;
    private String commissionValue;
    private String observation;
}
