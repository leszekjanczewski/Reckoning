package pl.leszekjanczewski.reckoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.leszekjanczewski.reckoning.model.Division;
import pl.leszekjanczewski.reckoning.repository.DivisionRepo;

import java.util.List;

@Controller
public class UserControler {

    @Autowired
    DivisionRepo divisionRepo;

    @GetMapping("/user/listClass")
    public String listClass(Model model) {
        List<Division> divisionList = divisionRepo.findAll();
        model.addAttribute("classes", divisionList);
        return "index";
    }

    /*@ModelAttribute("divisions")
    public List<Division> classList() {
        List<Division> classList = classRepo.findAll();
        return classList;
    }*/
}
