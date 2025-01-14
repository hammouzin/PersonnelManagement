package net.javaguides.personnalmanagement.Dtos;

import net.javaguides.personnalmanagement.Entities.User;

public class ResponsableUniteDto {
    public Long responsableUniteId;
    private User user;

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
