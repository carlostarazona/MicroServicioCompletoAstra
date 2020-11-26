package pe.edu.upc.technicalservice.resource;

import pe.edu.upc.technicalservice.domain.model.AuditModel;
import pe.edu.upc.technicalservice.domain.model.Plan;

import javax.validation.constraints.NotNull;

public class SaveAdministratorResource extends AuditModel {
    private int incidentAmount;
    private Plan plan;

    public SaveAdministratorResource(@NotNull int incidentAmount, Plan plan) {
        this.incidentAmount = incidentAmount;
        this.plan = plan;
    }

    public SaveAdministratorResource() {

    }
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
