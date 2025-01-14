package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

}
