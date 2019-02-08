package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Child;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {

    Child findByChildId(Long id);

}
