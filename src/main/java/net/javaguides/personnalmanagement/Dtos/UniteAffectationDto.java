package net.javaguides.personnalmanagement.Dtos;

import java.util.List;

public class UniteAffectationDto {
    private Long id ;
    private String uniteAffectationName ;
    private String UniteAffectationDescription ;
    private String uniteAffectationType ;

    private List<AffectationDto> affectations;
    private List<PosteDto> postes;

    public UniteAffectationDto() {
    }

    public UniteAffectationDto(Long id, String uniteAffectationName, String uniteAffectationDescription, String uniteAffectationType) {
        this.id = id;
        this.uniteAffectationName = uniteAffectationName;
        UniteAffectationDescription = uniteAffectationDescription;
        this.uniteAffectationType = uniteAffectationType;
    }

    public List<PosteDto> getPostes() {
        return postes;
    }

    public void setPostes(List<PosteDto> postes) {
        this.postes = postes;
    }

    public List<AffectationDto> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<AffectationDto> affectations) {
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
        return UniteAffectationDescription;
    }

    public void setUniteAffectationDescription(String uniteAffectationDescription) {
        UniteAffectationDescription = uniteAffectationDescription;
    }

    public String getUniteAffectationType() {
        return uniteAffectationType;
    }

    public void setUniteAffectationType(String uniteAffectationType) {
        this.uniteAffectationType = uniteAffectationType;
    }
}
