package com.acme.technical.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "engineers")
public class Engineer extends AuditModel {

    @NotNull
    private int incidentAmount;

    private boolean availability;

    @NotNull
    private boolean workStatus;

    public Engineer(@NotNull int incidentAmount, boolean availability, @NotNull boolean workStatus) {
        this.incidentAmount = incidentAmount;
        this.availability = availability;
        this.workStatus = workStatus;
    }

    public Engineer() {

    }

    public int getIndicentAmount() {
        return incidentAmount;
    }

    public Engineer setIncidentAmount(int incidentAmount) {
        this.incidentAmount = incidentAmount;
        return this;
    }

    public boolean getAvailability() {
        return availability;
    }

    public Engineer setAvailability(boolean availability) {
        this.availability = availability;
        return this;
    }

    public boolean getWorkStatus() {
        return workStatus;
    }

    public Engineer setWorkStatus(boolean workStatus) {
        this.workStatus = workStatus;
        return this;
    }

}
