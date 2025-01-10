package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "poste")

public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String posteName ;
    private String posteDescription ;
    private int posteSalary ;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "unite_affectation_id")
    private UniteAffectation uniteAffectation;


    public Poste() {
    }

    public Poste(Long id, String posteName, String posteDescription, int posteSalary) {
        this.id = id;
        this.posteName = posteName;
        this.posteDescription = posteDescription;
        this.posteSalary = posteSalary;
    }

    public UniteAffectation getUniteAffectation() {
        return uniteAffectation;
    }

    public void setUniteAffectation(UniteAffectation uniteAffectation) {
        this.uniteAffectation = uniteAffectation;
    }

    public Agent getAgent() {
        return agent;
}
public void setAgent(Agent agent) {
        this.agent = agent;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosteName() {
        return posteName;
    }

    public void setPosteName(String posteName) {
        this.posteName = posteName;
    }

    public String getPosteDescription() {
        return posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public int getPosteSalary() {
        return posteSalary;
    }

    public void setPosteSalary(int posteSalary) {
        this.posteSalary = posteSalary;
    }
}
