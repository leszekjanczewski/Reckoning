package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.TypeOfClass;

@Repository
public interface TypeOfClassRepo extends JpaRepository<TypeOfClass, Long> {
}
