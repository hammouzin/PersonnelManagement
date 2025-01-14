package net.javaguides.personnalmanagement.Services.User;

import lombok.Builder;
import net.javaguides.personnalmanagement.Entities.Role;
import net.javaguides.personnalmanagement.Entities.User;
import net.javaguides.personnalmanagement.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
@Builder
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User addUser(String email, String lastename, String password, Role role, String username) {
        Collection<Role> roles = new ArrayList<>();
        roles.add(Role.USER);

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setLastName(lastename);
        user.setPassword(password);
        user.setRole(role);


        /*
        User user = User.builder()
                .username(username)
                .lastName(lastename)
                .email(email)
                .password(password)
                .role(role)
                .build();
        */
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
