package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.TypeOfDivision;

@Repository
public interface TypeOfDivisionRepo extends JpaRepository<TypeOfDivision, Long> {
}
