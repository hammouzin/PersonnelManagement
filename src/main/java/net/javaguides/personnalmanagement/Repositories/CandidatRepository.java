package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
