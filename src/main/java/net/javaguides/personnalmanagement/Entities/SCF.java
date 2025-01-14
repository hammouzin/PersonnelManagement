package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class SCF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scf_id")
    private Long scfId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SCF() {}

    public SCF(Long scfId, User user) {
        this.scfId = scfId;
        this.user = user;
    }

    public Long getScfId() {
        return scfId;
    }

    public void setScfId(Long scfId) {
        this.scfId = scfId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
