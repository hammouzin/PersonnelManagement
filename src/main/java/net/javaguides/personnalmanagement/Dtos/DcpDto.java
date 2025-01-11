package net.javaguides.personnalmanagement.Dtos;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;

import java.util.List;

public class DcpDto {


    private Long id;
    private String nom;
    private String description;
    private boolean posteValide;

    private List<DecisionRecrutement> decisionRecrutements;

    public DcpDto() {

    }

    public DcpDto(Long id, String nom, String description, boolean posteValide) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.posteValide = posteValide;
    }

    public List<DecisionRecrutement> getDecisionRecrutements() {
        return decisionRecrutements;
    }

    public void setDecisionRecrutements(List<DecisionRecrutement> decisionRecrutements) {
        this.decisionRecrutements = decisionRecrutements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPosteValide() {
        return posteValide;
    }

    public void setPosteValide(boolean posteValide) {
        this.posteValide = posteValide;
    }


}
