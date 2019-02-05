package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Group;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
}
