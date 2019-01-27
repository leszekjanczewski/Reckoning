package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.Child;

public interface ChildRepo extends JpaRepository<Child, Long> {
}
