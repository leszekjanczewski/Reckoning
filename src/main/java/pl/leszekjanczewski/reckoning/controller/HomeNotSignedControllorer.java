package pl.leszekjanczewski.reckoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.leszekjanczewski.reckoning.model.Client;
import pl.leszekjanczewski.reckoning.repository.ClientRepo;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeNotSignedControllorer {


    @Autowired
    ClientRepo clientRepo;

    @PostMapping("/")
    public String findClientByPhoneOrEmail(@RequestParam String phone, Model model) {
        Client client = clientRepo.findClientByPhoneOrEmail(phone, phone);
        String name = client.getFirstName();
        model.addAttribute(name);
//        session.setAttribute("name", name);
        return "home/homeNotSignedIn";
    }
}
