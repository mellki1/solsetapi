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


    public Date getUpdatingDate() {
        return updatingDate;
    }

    public void setUpdatingDate(Date updatingDate) {
        this.updatingDate = updatingDate;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Integer getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(Integer proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public Integer getLaborValue() {
        return laborValue;
    }

    public void setLaborValue(Integer laborValue) {
        this.laborValue = laborValue;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
