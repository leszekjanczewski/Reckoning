package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.repository.CrudRepository;
import pl.leszekjanczewski.reckoning.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
}
