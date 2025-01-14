package net.javaguides.personnalmanagement.Dtos;

import net.javaguides.personnalmanagement.Entities.User;

public class SCFDto {
    private Long scfId;
    private User user;

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
