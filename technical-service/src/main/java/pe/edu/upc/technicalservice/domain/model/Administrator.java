package pe.edu.upc.technicalservice.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "administrators")
public class Administrator extends AuditModel {

    @NotNull
    private int incidentAmount;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id", nullable = false)
    @JsonIgnore
    private Plan plan;

    public Administrator(@NotNull int incidentAmount, Plan plan) {
        this.incidentAmount = incidentAmount;
        this.plan = plan;
    }

    public Administrator() {

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
