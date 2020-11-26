package com.acme.technical.resource;

import com.acme.technical.domain.model.AuditModel;

public class EngineerResource extends AuditModel {
    private int incidentAmount;
    private boolean availability;
    private boolean workStatus;

    public int getIndicentAmount() {
        return incidentAmount;
    }

    public EngineerResource setIncidentAmount(int incidentAmount) {
        this.incidentAmount = incidentAmount;
        return this;
    }

    public boolean getAvailability() {
        return availability;
    }

    public EngineerResource setAvailability(boolean availability) {
        this.availability = availability;
        return this;
    }

    public boolean getWorkStatus() {
        return workStatus;
    }

    public EngineerResource setWorkStatus(boolean workStatus) {
        this.workStatus = workStatus;
        return this;
    }
}
