package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}