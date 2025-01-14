package net.javaguides.personnalmanagement.Services.User;

import net.javaguides.personnalmanagement.Entities.Role;
import net.javaguides.personnalmanagement.Entities.User;

public interface AccountService {
    User addNewUser(String email , String lastname , String password , Role role , String username);

    User findUserByUsername(String username);
}
