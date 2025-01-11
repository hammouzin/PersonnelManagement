package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class GradeDto {

    private Long id;
    private String libelleGrade;
    private LocalDate dateObtention;
    private LocalDate dateFinValidite;
    @JsonIgnore
    private Long agentId;


    public GradeDto() {
    }

    public GradeDto(Long id, String libelleGrade, LocalDate dateObtention, LocalDate dateFinValidite) {
        this.id = id;
        this.libelleGrade = libelleGrade;
        this.dateObtention = dateObtention;
        this.dateFinValidite = dateFinValidite;
    }


    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleGrade() {
        return libelleGrade;
    }

    public void setLibelleGrade(String libelleGrade) {
        this.libelleGrade = libelleGrade;
    }

    public LocalDate getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(LocalDate dateObtention) {
        this.dateObtention = dateObtention;
    }

    public LocalDate getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(LocalDate dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }
}
