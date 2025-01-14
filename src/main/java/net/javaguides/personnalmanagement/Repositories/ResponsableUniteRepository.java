package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.ResponsableUnite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableUniteRepository extends JpaRepository<ResponsableUnite, Long> {
}
