package com.acme.technical.resource;

import com.acme.technical.domain.model.AuditModel;

public class ManagerResource extends AuditModel {
    private int requestedAmount;

    public ManagerResource() {
    }

    public ManagerResource(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}
