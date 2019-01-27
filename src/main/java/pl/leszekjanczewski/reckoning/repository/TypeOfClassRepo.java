package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.TypeOfClass;

public interface TypeOfClassRepo extends JpaRepository<TypeOfClass, Long> {
}
