package com.acme.technical.domain.model;


import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "managers")
public class Manager extends AuditModel {

    private int requestedtAmount;
    //List of equipment

    public Manager(int requestedtAmount) {

        this.requestedtAmount = requestedtAmount;
    }

    public Manager() {

    }

    public int getRequestedtAmount() {
        return requestedtAmount;
    }

    public void setRequestedtAmount(int requestedtAmount) {
        this.requestedtAmount = requestedtAmount;
    }
}
