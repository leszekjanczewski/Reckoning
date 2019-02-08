package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Installment;

import java.util.List;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {

    @Query(value = "SELECT installments.installment_id, installments.paymant_day, installments.amount, installments.payment_id FROM installments, clients_installments INNER JOIN clients ON clients_installments.client_id = clients.client_id WHERE clients.client_id = :clientid AND clients_installments.installment_id = installments.installment_id", nativeQuery = true)
    List<Installment> findInstallmentsByClientsClientId(@Param("clientid") Long id);

}
