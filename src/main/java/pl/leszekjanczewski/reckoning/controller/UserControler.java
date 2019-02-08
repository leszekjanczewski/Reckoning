package pl.leszekjanczewski.reckoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.leszekjanczewski.reckoning.model.Class;
import pl.leszekjanczewski.reckoning.repository.ClassRepo;

import java.util.List;

@Controller
public class UserControler {

    @Autowired
    ClassRepo classRepo;

    @GetMapping("/user/listClass")
    public String listClass(Model model) {
        List<Class> classList = classRepo.findAll();
        model.addAttribute("classes", classList);
        return "index";
    }

    /*@ModelAttribute("classes")
    public List<Class> classList() {
        List<Class> classList = classRepo.findAll();
        return classList;
    }*/
}
