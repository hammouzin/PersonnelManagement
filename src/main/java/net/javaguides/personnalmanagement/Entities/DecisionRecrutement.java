package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "decisions")
public class DecisionRecrutement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String decisionNumero ;
    private LocalDate decisionDate ;
    private LocalDate dateEffetPrevisionelle;

    private String statut;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidat_id", unique = true, nullable = false)
    private Candidat candidat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @Enumerated(EnumType.STRING)
    private Visa visa;

    @Enumerated(EnumType.STRING)
    private DecisionStatus status;


/*
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dcp_id") // Clé étrangère pour relier un DCP
    private Dcp dcp;

*/

    public DecisionRecrutement(Long id, String decisionNumero, LocalDate decisionDate, LocalDate dateEffetPrevisionelle, String statut) {
        this.id = id;
        this.decisionNumero = decisionNumero;
        this.decisionDate = decisionDate;
        this.dateEffetPrevisionelle = dateEffetPrevisionelle;
        this.statut = statut;

    }


    public DecisionRecrutement() {

    }
/*
    public Dcp getDcp() {
        return dcp;
    }

    public void setDcp(Dcp dcp) {
        this.dcp = dcp;
    }
*/
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
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

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public DecisionStatus getStatus() {
        return status;
    }

    public void setStatus(DecisionStatus status) {
        this.status = status;
    }
}
