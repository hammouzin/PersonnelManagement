package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String congeType ;
    private LocalDate congeDateDebut ;
    private LocalDate congeDateFin ;
    private String congeDescription ;
    private int congeNbJours ;
    private String congeStatus ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Conge() {
    }

    public Conge(Long id, String congeType, LocalDate congeDateDebut, LocalDate congeDateFin, String congeDescription, int congeNbJours, String congeStatus) {
        this.id = id;
        this.congeType = congeType;
        this.congeDateDebut = congeDateDebut;
        this.congeDateFin = congeDateFin;
        this.congeDescription = congeDescription;
        this.congeNbJours = congeNbJours;
        this.congeStatus = congeStatus;
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

    public String getCongeType() {
        return congeType;
    }

    public void setCongeType(String congeType) {
        this.congeType = congeType;
    }

    public LocalDate getCongeDateDebut() {
        return congeDateDebut;
    }

    public void setCongeDateDebut(LocalDate congeDateDebut) {
        this.congeDateDebut = congeDateDebut;
    }

    public LocalDate getCongeDateFin() {
        return congeDateFin;
    }

    public void setCongeDateFin(LocalDate congeDateFin) {
        this.congeDateFin = congeDateFin;
    }

    public String getCongeDescription() {
        return congeDescription;
    }

    public void setCongeDescription(String congeDescription) {
        this.congeDescription = congeDescription;
    }

    public int getCongeNbJours() {
        return congeNbJours;
    }

    public void setCongeNbJours(int congeNbJours) {
        this.congeNbJours = congeNbJours;
    }

    public String getCongeStatus() {
        return congeStatus;
    }

    public void setCongeStatus(String congeStatus) {
        this.congeStatus = congeStatus;
    }
}
