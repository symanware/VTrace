package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.model.User;

public interface UserReository extends JpaRepository<User, Long> {
    public User findUserByUsername(String userName);
}
