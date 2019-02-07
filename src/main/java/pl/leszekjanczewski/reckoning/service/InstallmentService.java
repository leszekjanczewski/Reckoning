package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.Installment;

import java.util.List;

public interface InstallmentService {

    List<Installment> findInstallmentsByClientsClientId(Long id);

}
