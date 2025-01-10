package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;


@Table(name = "grades")
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle_grade")
    private String libelleGrade;
    private LocalDate dateObtention;
    private LocalDate dateFinValidite;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Grade() {}

    public Grade(Long id, String libelleGrade, LocalDate dateObtention, LocalDate dateFinValidite) {
        this.id = id;
        this.libelleGrade = libelleGrade;
        this.dateObtention = dateObtention;
        this.dateFinValidite = dateFinValidite;
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

    public String getLibelleGrade() {
        return libelleGrade;
    }

    public void setLibelleGrade(String libelleGrade) {
        this.libelleGrade = libelleGrade;
    }

    public LocalDate getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(LocalDate dateObtention) {
        this.dateObtention = dateObtention;
    }

    public LocalDate getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(LocalDate dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }
}
