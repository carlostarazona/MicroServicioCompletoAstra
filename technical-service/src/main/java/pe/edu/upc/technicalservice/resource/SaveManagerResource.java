package pe.edu.upc.technicalservice.resource;

import pe.edu.upc.technicalservice.domain.model.AuditModel;

public class SaveManagerResource extends AuditModel {
    private int requestedAmount;

    public SaveManagerResource() {
    }

    public SaveManagerResource(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}
