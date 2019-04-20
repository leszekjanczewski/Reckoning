package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Division;
import pl.leszekjanczewski.reckoning.repository.DivisionRepo;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    DivisionRepo divisionRepo;

    @Override
    public Division saveClass(Division divisionReco) {
        return divisionRepo.save(divisionReco);
    }

}
