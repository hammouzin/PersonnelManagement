package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class ResponsableUnite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsable_unite_id")
    private Long responsableUniteId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ResponsableUnite() {}

    public ResponsableUnite(Long responsableUniteId, User user) {
        this.responsableUniteId = responsableUniteId;
        this.user = user;
    }

    public Long getResponsableUniteId() {
        return responsableUniteId;
    }

    public void setResponsableUniteId(Long responsableUniteId) {
        this.responsableUniteId = responsableUniteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
