package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.Installment;

public interface InstallmentRepo extends JpaRepository<Installment, Long> {
}
