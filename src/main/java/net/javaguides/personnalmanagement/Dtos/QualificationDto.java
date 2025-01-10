package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class QualificationDto {

    private Long id;
    private String qualificationName;
    private String qualificationDescription;
    private LocalDate qualificationDate;
    private String qualificationType;

    @JsonIgnore
    private Long agentId;
    public QualificationDto() {

    }

    public QualificationDto(Long id, String qualificationName, String qualificationDescription, LocalDate qualificationDate, String qualificationType) {
        this.id = id;
        this.qualificationName = qualificationName;
        this.qualificationDescription = qualificationDescription;
        this.qualificationDate = qualificationDate;
        this.qualificationType = qualificationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationDescription() {
        return qualificationDescription;
    }

    public void setQualificationDescription(String qualificationDescription) {
        this.qualificationDescription = qualificationDescription;
    }

    public LocalDate getQualificationDate() {
        return qualificationDate;
    }

    public void setQualificationDate(LocalDate qualificationDate) {
        this.qualificationDate = qualificationDate;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }
}
