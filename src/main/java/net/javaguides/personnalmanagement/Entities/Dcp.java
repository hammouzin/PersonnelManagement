package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dcp")
public class Dcp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dcpId;
    private String dcpName;
    public Dcp() {

    }

    public Dcp(long dcpId, String dcpName) {
        this.dcpId = dcpId;
        this.dcpName = dcpName;
    }

    public long getDcpId() {
        return dcpId;
    }

    public void setDcpId(long dcpId) {
        this.dcpId = dcpId;
    }

    public String getDcpName() {
        return dcpName;
    }

    public void setDcpName(String dcpName) {
        this.dcpName = dcpName;
    }
}
