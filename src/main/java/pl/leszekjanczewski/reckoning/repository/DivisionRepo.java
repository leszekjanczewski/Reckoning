package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Division;

import java.util.List;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Long> {

    Division findByDivisionId(Long id);

    @Query(value = "SELECT division_id, division_name FROM divisions", nativeQuery = true)
    List<Object[]> listDivisionWithName();
}
