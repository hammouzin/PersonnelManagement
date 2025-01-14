package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

}
