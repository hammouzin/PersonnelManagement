package net.javaguides.personnalmanagement.Repositories;

import net.javaguides.personnalmanagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email, String identifier);
    @Query("SELECT u FROM User u WHERE u.email = :email OR u.username = :username")
    User findByEmailOrUsername(@Param("email") String email, @Param("username") String username);
}
