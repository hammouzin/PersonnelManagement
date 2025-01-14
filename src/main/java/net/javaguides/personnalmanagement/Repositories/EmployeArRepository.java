package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.EmployeAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeArRepository extends JpaRepository<EmployeAR , Long> {
}
