package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {

}
