package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Agent;
import net.javaguides.personnalmanagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
