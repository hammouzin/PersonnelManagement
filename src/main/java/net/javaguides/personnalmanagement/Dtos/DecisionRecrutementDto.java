package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class DecisionRecrutementDto {
    private Long id ;
    private String decisionNumero ;
    private LocalDate decisionDate ;
    private LocalDate dateEffetPrevisionelle ;

    @JsonIgnore
    private Long candidatId;
    private Long posteId ;

    public DecisionRecrutementDto() {

    }

    public DecisionRecrutementDto(Long id, String decisionNumero, LocalDate decisionDate, LocalDate dateEffetPrevisionelle) {
        this.id = id;
        this.decisionNumero = decisionNumero;
        this.decisionDate = decisionDate;
        this.dateEffetPrevisionelle = dateEffetPrevisionelle;
    }

    public Long getPosteId() {
        return posteId;
    }

    public void setPosteId(Long posteId) {
        this.posteId = posteId;
    }

    public Long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(Long candidatId) {
        this.candidatId = candidatId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDecisionNumero() {
        return decisionNumero;
    }

    public void setDecisionNumero(String decisionNumero) {
        this.decisionNumero = decisionNumero;
    }

    public LocalDate getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(LocalDate decisionDate) {
        this.decisionDate = decisionDate;
    }
    public LocalDate getDateEffetPrevisionelle() {
        return dateEffetPrevisionelle;
    }

    public void setDateEffetPrevisionelle(LocalDate dateEffetPrevisionelle) {
        this.dateEffetPrevisionelle = dateEffetPrevisionelle;
    }
}
