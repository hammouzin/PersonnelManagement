package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.Dcp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface DcpRepository extends JpaRepository<Dcp, Long> {
}
