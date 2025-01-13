package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByUsername(String username);

    Optional<Agent> findByEmail(String email);
}
