package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class AffectationDto {
    private Long id;
    private String affectationName ;
    private LocalDate affectationDate ;
    private LocalDate endAffectationDate ;
    @JsonIgnore
    private Long agentId;
    @JsonIgnore
    private Long uniteAffectationId;

    public AffectationDto() {

    }

    public AffectationDto(Long id, String affectationName, LocalDate affectationDate, LocalDate endAffectationDate) {
        this.id = id;
        this.affectationName = affectationName;
        this.affectationDate = affectationDate;
        this.endAffectationDate = endAffectationDate;

    }

    public Long getUniteAffectationId() {
        return uniteAffectationId;
    }

    public void setUniteAffectationId(Long uniteAffectationId) {
        this.uniteAffectationId = uniteAffectationId;
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

    public String getAffectationName() {
        return affectationName;
    }

    public void setAffectationName(String affectationName) {
        this.affectationName = affectationName;
    }

    public LocalDate getAffectationDate() {
        return affectationDate;
    }

    public void setAffectationDate(LocalDate affectationDate) {
        this.affectationDate = affectationDate;
    }

    public LocalDate getEndAffectationDate() {
        return endAffectationDate;
    }

    public void setEndAffectationDate(LocalDate endAffectationDate) {
        this.endAffectationDate = endAffectationDate;
    }


}
