package pe.edu.upc.technicalservice.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    private String planName;

    @NotNull
    private int engineerCount;

    public Plan(Long id, @NotNull String planName, @NotNull int engineerCount) {
        this.id = id;
        this.planName = planName;
        this.engineerCount = engineerCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getEngineerCount() {
        return engineerCount;
    }

    public void setEngineerCount(int engineerCount) {
        this.engineerCount = engineerCount;
    }


    public Plan() {

    }



}
