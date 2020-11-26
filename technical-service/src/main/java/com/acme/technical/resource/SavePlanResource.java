package com.acme.technical.resource;

public class SavePlanResource {
    protected Long id;
    private String planName;
    private int engineerCount;

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
}