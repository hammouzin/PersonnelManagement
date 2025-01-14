package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {

}
