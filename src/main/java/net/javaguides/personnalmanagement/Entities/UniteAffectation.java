package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "uniteAffectation")
public class UniteAffectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String uniteAffectationName ;
    private String uniteAffectationDescription ;
    private String uniteAffectationType ;

    @JsonIgnore
    @OneToMany(mappedBy = "uniteAffectation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Affectation> affectations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "uniteAffectation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Poste> postes = new ArrayList<>();

    public UniteAffectation(Long id, String uniteAffectationName, String uniteAffectationDescription, String uniteAffectationType) {
        this.id = id;
        this.uniteAffectationName = uniteAffectationName;
        this.uniteAffectationDescription = uniteAffectationDescription;
        this.uniteAffectationType = uniteAffectationType;
    }
    public UniteAffectation() {

    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniteAffectationName() {
        return uniteAffectationName;
    }

    public void setUniteAffectationName(String uniteAffectationName) {
        this.uniteAffectationName = uniteAffectationName;
    }

    public String getUniteAffectationDescription() {
        return uniteAffectationDescription;
    }

    public void setUniteAffectationDescription(String uniteAffectationDescription) {
        this.uniteAffectationDescription = uniteAffectationDescription;
    }

    public String getUniteAffectationType() {
        return uniteAffectationType;
    }

    public void setUniteAffectationType(String uniteAffectationType) {
        this.uniteAffectationType = uniteAffectationType;
    }
}
