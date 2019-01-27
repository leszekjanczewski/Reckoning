package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.Class;

public interface ClassRepo extends JpaRepository<Class, Long> {
}
