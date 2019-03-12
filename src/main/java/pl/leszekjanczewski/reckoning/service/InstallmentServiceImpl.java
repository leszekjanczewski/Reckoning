package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Installment;
import pl.leszekjanczewski.reckoning.repository.InstallmentRepo;

import java.util.List;

@Service
public class InstallmentServiceImpl implements InstallmentService {

    @Autowired InstallmentRepo installmentRepo;

    @Override
    public List<Installment> findInstallmentsByClientsClientId(Long id) {
        return installmentRepo.findInstallmentsByClientsClientId(id);
    }
}
