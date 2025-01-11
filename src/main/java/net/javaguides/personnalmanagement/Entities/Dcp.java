package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dcp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;


    private boolean posteValide;

    // Relation éventuelle si DCP peut avoir un historique des décisions
    @OneToMany(mappedBy = "dcp", cascade = CascadeType.ALL)
    private List<DecisionRecrutement> decisions;


    public Dcp(Long id, String nom, String description, boolean posteValide) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.posteValide = posteValide;
    }
    public Dcp() {

    }

    public List<DecisionRecrutement> getDecisions() {
        return decisions;
    }

    public void setDecisions(List<DecisionRecrutement> decisions) {
        this.decisions = decisions;
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
    public void addDecision(DecisionRecrutement decision) {
        decisions.add(decision);
        decision.setDcp(this); // Associer le DCP à la décision
    }
}

