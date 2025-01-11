package net.javaguides.personnalmanagement.Dtos;

public class DcpDto {


    private Long id;
    private String nom;
    private String description;
    private boolean posteValide;
    public DcpDto() {

    }

    public DcpDto(Long id, String nom, String description, boolean posteValide) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.posteValide = posteValide;
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


}
