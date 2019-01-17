package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
