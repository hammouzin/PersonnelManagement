package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.UniteAffectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteAffectationRepository extends JpaRepository<UniteAffectation, Long> {

}
