package net.javaguides.personnalmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "diplomes")
@Entity
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nomDiplome;
    private LocalDate dateObtention;
    private String etablissement;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Diplome() {
    }

    public Diplome(Long id, String nomDiplome, LocalDate dateObtention, String etablissement) {
        this.id = id;
        this.nomDiplome = nomDiplome;
        this.dateObtention = dateObtention;
        this.etablissement = etablissement;
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

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public LocalDate getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(LocalDate dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

}
