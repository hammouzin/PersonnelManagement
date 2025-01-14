package net.javaguides.personnalmanagement.Dtos.User;

import lombok.Builder;
import net.javaguides.personnalmanagement.Entities.Role;


@Builder
public record UserResponse(String username , String lastname , String email , Role role) {
}
