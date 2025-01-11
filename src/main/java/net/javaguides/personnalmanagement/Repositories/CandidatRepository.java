package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
