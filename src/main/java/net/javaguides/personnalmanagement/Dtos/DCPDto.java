package net.javaguides.personnalmanagement.Dtos;

import net.javaguides.personnalmanagement.Entities.User;

public class DCPDto {
    private Long dcpId;
    private User user;

    public Long getDcpId() {
        return dcpId;
    }

    public void setDcpId(Long dcpId) {
        this.dcpId = dcpId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
