package pl.leszekjanczewski.reckoning.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.leszekjanczewski.reckoning.model.Class;
import pl.leszekjanczewski.reckoning.repository.ClassRepo;

public class ChildClassConverter implements Converter<String, Class> {

    @Autowired
    ClassRepo classRepo;

    @Override
    public Class convert(String s) {
        return classRepo.findByClassId(Long.parseLong(s));
    }

}
