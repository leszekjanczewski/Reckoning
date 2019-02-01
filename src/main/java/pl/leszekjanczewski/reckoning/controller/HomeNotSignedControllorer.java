package pl.leszekjanczewski.reckoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.leszekjanczewski.reckoning.model.Client;
import pl.leszekjanczewski.reckoning.repository.ClientRepo;


@Controller
public class HomeNotSignedControllorer {

    @Autowired
    ClientRepo clientRepo;

    @PostMapping("/")
    public String findClientByPhoneOrEmail(@RequestParam String phone, Model model) {
        Client client = clientRepo.findClientByPhoneOrEmail(phone, phone);
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String clientPhone = client.getPhone();
        String email = client.getEmail();
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("phone", clientPhone);
        model.addAttribute("email", email);
        return "home/homeNotSignedIn";
    }
}
