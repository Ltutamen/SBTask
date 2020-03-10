package ua.axiom.taskSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.axiom.taskSB.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
