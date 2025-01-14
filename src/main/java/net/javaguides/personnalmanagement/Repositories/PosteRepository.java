package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {

}
