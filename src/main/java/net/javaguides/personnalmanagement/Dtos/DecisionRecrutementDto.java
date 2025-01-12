package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class DecisionRecrutementDto {
    private Long id ;
    private String decisionNumero ;
    private LocalDate decisionDate ;
    private LocalDate dateEffetPrevisionelle ;


    private String visaStatus;
    private String decisionStatus;

    private String statut ;

    @JsonIgnore
    private Long candidatId;
    private Long posteId ;
    /*private Long dcpId ;*/

    public DecisionRecrutementDto() {

    }

    public DecisionRecrutementDto(Long id, String decisionNumero, LocalDate decisionDate, LocalDate dateEffetPrevisionelle, String statut) {
        this.id = id;
        this.decisionNumero = decisionNumero;
        this.decisionDate = decisionDate;
        this.dateEffetPrevisionelle = dateEffetPrevisionelle;
        this.statut = statut;
    }

 /*   public Long getDcpId() {
        return dcpId;
    }

    public void setDcpId(Long dcpId) {
        this.dcpId = dcpId;
    }
*/

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getDecisionStatus() {
        return decisionStatus;
    }

    public void setDecisionStatus(String decisionStatus) {
        this.decisionStatus = decisionStatus;
    }
}
