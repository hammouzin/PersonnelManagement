package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class EmployeAR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id")
    private Long emloyeArId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public EmployeAR() {}

    public EmployeAR(Long emloyeArId, User user) {
        this.emloyeArId = emloyeArId;
        this.user = user;
    }

    public Long getEmloyeArId() {
        return emloyeArId;
    }

    public void setEmloyeArId(Long emloyeArId) {
        this.emloyeArId = emloyeArId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
