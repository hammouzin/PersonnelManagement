package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRecrutementRepository extends JpaRepository<DecisionRecrutement, Long> {

}
