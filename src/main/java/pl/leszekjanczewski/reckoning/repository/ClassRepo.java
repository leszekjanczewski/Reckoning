package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Class;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long> {

    Class findByClassId(Long id);

}
