package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Child;
import pl.leszekjanczewski.reckoning.model.Class;
import pl.leszekjanczewski.reckoning.repository.ChildRepo;
import pl.leszekjanczewski.reckoning.repository.ClassRepo;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepo classRepo;

    @Autowired
    public ClassServiceImpl(ClassRepo classRepo) {
        this.classRepo = classRepo;
    }

    @Override
    public Class saveClass(Class classReco) {
        return classRepo.save(classReco);
    }

}
