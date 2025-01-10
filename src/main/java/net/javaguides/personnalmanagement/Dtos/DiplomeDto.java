package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class DiplomeDto {
    private Long id;

    private String nomDiplome;
    private LocalDate dateObtention;
    private String etablissement;

    @JsonIgnore
    private Long agentId;


    public DiplomeDto() {
    }

    public DiplomeDto(Long id, String nomDiplome, LocalDate dateObtention, String etablissement) {
        this.id = id;
        this.nomDiplome = nomDiplome;
        this.dateObtention = dateObtention;
        this.etablissement = etablissement;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
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
