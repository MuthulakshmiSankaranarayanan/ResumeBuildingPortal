package com.knowledgecenter.resumeportal.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String company;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean currentJob;
    @ElementCollection(targetClass = String.class)
    List<String> responsibilities = new ArrayList<>();

    public List<String> getResponsibilities(){
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return "Job{" + "Id = " + id + ", Company = " + company + ", Designation = " + designation + ", StartDate = "
                + startDate + ", EndDate = " + endDate + "}";
    }

    public boolean isCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(boolean currentJob) {
        this.currentJob = currentJob;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getFormattedStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
    }

    public String getFormattedEndDate() {
        return endDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}