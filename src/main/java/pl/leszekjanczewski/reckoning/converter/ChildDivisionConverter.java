package pl.leszekjanczewski.reckoning.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.leszekjanczewski.reckoning.model.Division;
import pl.leszekjanczewski.reckoning.repository.DivisionRepo;

public class ChildDivisionConverter implements Converter<String, Division> {

    @Autowired
    DivisionRepo divisionRepo;

    @Override
    public Division convert(String s) {
        return divisionRepo.findByDivisionId(Long.parseLong(s));
    }

}
