package yte.intern.springapplication.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springapplication.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User findOneUserByUsername(String username);

    Optional<User> findByEmail(String username);

    boolean existsByUsername(String username);

}
