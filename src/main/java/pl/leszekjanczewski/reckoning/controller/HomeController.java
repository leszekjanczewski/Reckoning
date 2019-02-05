package pl.leszekjanczewski.reckoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.leszekjanczewski.reckoning.model.Client;
import pl.leszekjanczewski.reckoning.repository.ClientRepo;
import pl.leszekjanczewski.reckoning.service.ClientServiceImpl;

import java.security.Principal;

@Controller
class HomeController {


    @Autowired
    ClientRepo clientRepo;

    @Autowired
    ClientServiceImpl clientService;

    /*@GetMapping("/")
    String home(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "index";
    }*/

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/search")
    public String searchClient(@RequestParam String search, Model model) {
        if (search.isEmpty()) {
            return "index";
        }
        try {
            Client client = clientService.findClientByPhoneOrEmail(search, search);
            model.addAttribute("firstName", client.getFirstName());
            model.addAttribute("lastName", client.getLastName());
            model.addAttribute("phone", client.getPhone());
            model.addAttribute("email", client.getEmail());
            return "index";
        } catch (NullPointerException e) {
            return "index";
        }

    }
}