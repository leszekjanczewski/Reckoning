package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Child;
import pl.leszekjanczewski.reckoning.repository.ChildRepo;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    ChildRepo childRepo;

    @Override
    public Child saveChild(Child child) {

        return childRepo.save(child);
    }

}
