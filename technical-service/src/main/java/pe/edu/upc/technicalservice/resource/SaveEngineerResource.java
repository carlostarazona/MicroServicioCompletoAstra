package pe.edu.upc.technicalservice.resource;

import pe.edu.upc.technicalservice.domain.model.AuditModel;

public class SaveEngineerResource extends AuditModel {
    private int incidentAmount;
    private boolean availability;
    private boolean workStatus;

    public int getIndicentAmount() {
        return incidentAmount;
    }

    public SaveEngineerResource setIncidentAmount(int incidentAmount) {
        this.incidentAmount = incidentAmount;
        return this;
    }

    public boolean getAvailability() {
        return availability;
    }

    public SaveEngineerResource setAvailability(boolean availability) {
        this.availability = availability;
        return this;
    }

    public boolean getWorkStatus() {
        return workStatus;
    }

    public SaveEngineerResource setWorkStatus(boolean workStatus) {
        this.workStatus = workStatus;
        return this;
    }
}
