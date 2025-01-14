package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dcp")
public class Dcp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dcpId;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Dcp() { }

    public Dcp(long dcpId, User user) {
        this.dcpId = dcpId;
        this.user = user;
    }

    public long getDcpId() {
        return dcpId;
    }

    public void setDcpId(long dcpId) {
        this.dcpId = dcpId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
