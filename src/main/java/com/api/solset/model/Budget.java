package com.api.solset.model;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Budget extends AbstractEntity {
    private Date updatingDate;
    private String situation;
    private Integer proposalNumber;
    private Integer laborValue;
    private Integer value;
    private Integer installationId;
}
