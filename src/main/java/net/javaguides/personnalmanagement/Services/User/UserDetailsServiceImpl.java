package net.javaguides.personnalmanagement.Services.User;

import net.javaguides.personnalmanagement.Entities.User;
import net.javaguides.personnalmanagement.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmailOrUsername(username , username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username : " + username);
        }

        return null;
    }
}
