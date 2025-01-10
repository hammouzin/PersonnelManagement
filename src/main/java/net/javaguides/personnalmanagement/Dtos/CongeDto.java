package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class CongeDto {
    private Long id ;
    private String congeType ;
    private LocalDate congeDateDebut ;
    private LocalDate congeDateFin ;
    private String congeDescription ;
    private int congeNbJours ;
    private String congeStatus ;
    @JsonIgnore
    private Long agentId;
    public CongeDto() {

    }

    public CongeDto(Long id, String congeType, LocalDate congeDateDebut, LocalDate congeDateFin, String congeDescription, int congeNbJours, String congeStatus) {
        this.id = id;
        this.congeType = congeType;
        this.congeDateDebut = congeDateDebut;
        this.congeDateFin = congeDateFin;
        this.congeDescription = congeDescription;
        this.congeNbJours = congeNbJours;
        this.congeStatus = congeStatus;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCongeType() {
        return congeType;
    }

    public void setCongeType(String congeType) {
        this.congeType = congeType;
    }

    public LocalDate getCongeDateDebut() {
        return congeDateDebut;
    }

    public void setCongeDateDebut(LocalDate congeDateDebut) {
        this.congeDateDebut = congeDateDebut;
    }

    public LocalDate getCongeDateFin() {
        return congeDateFin;
    }

    public void setCongeDateFin(LocalDate congeDateFin) {
        this.congeDateFin = congeDateFin;
    }

    public String getCongeDescription() {
        return congeDescription;
    }

    public void setCongeDescription(String congeDescription) {
        this.congeDescription = congeDescription;
    }

    public int getCongeNbJours() {
        return congeNbJours;
    }

    public void setCongeNbJours(int congeNbJours) {
        this.congeNbJours = congeNbJours;
    }

    public String getCongeStatus() {
        return congeStatus;
    }

    public void setCongeStatus(String congeStatus) {
        this.congeStatus = congeStatus;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }
}
