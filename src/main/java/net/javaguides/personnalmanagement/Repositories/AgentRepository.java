package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
