package net.javaguides.personnalmanagement.Services.User;

import net.javaguides.personnalmanagement.Entities.Role;
import net.javaguides.personnalmanagement.Entities.User;

public interface UserService {
    User addUser(String email, String lastename, String password, Role role, String username);
    User getUserById(Long id);
    User getUserByUsername(String username);

}
