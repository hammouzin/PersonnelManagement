package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

}
