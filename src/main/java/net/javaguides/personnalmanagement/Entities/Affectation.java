package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "affectations")
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String affectationName ;
    private LocalDate affectationDate ;
    private LocalDate endAffectationDate ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User agent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "unite_affectation_id")
    private UniteAffectation uniteAffectation;


    public Affectation() {

    }

    public Affectation(Long id, String affectationName, LocalDate affectationDate, LocalDate endAffectationDate) {
        this.id = id;
        this.affectationName = affectationName;
        this.affectationDate = affectationDate;
        this.endAffectationDate = endAffectationDate;

    }

    public UniteAffectation getUniteAffectation() {
        return uniteAffectation;
    }

    public void setUniteAffectation(UniteAffectation uniteAffectation) {
        this.uniteAffectation = uniteAffectation;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
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
