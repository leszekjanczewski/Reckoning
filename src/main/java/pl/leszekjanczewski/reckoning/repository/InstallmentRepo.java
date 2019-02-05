package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Installment;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {
}
