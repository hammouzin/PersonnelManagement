package net.javaguides.personnalmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PosteDto {
    private Long id ;
    private String posteName ;
    private String posteDescription ;
    private int posteSalary ;
    private boolean disponible ;
    @JsonIgnore
    private Long agentId;
    @JsonIgnore
    private Long uniteAffectationId;



    public PosteDto() {

    }

    public PosteDto(Long id, String posteName, String posteDescription, int posteSalary, boolean disponible) {
        this.id = id;
        this.posteName = posteName;
        this.posteDescription = posteDescription;
        this.posteSalary = posteSalary;
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Long getUniteAffectationId() {
        return uniteAffectationId;
    }

    public void setUniteAffectationId(Long uniteAffectationId) {
        this.uniteAffectationId = uniteAffectationId;
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
