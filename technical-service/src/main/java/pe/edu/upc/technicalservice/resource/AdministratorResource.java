package pe.edu.upc.technicalservice.resource;

import pe.edu.upc.technicalservice.domain.model.AuditModel;
import pe.edu.upc.technicalservice.domain.model.Plan;

public class AdministratorResource extends AuditModel {
    private int incidentAmount;
    private Plan plan;

    public int getIncidentAmount() {
        return incidentAmount;
    }

    public void setIncidentAmount(int incidentAmount) {
        this.incidentAmount = incidentAmount;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
