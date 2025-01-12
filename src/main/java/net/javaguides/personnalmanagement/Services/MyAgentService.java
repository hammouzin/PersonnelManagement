package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyAgentService implements UserDetailsService{

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return agentRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Agent not found with username: " + username));
    }



}