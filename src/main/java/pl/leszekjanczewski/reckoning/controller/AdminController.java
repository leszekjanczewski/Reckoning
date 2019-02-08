package pl.leszekjanczewski.reckoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.leszekjanczewski.reckoning.model.Child;
import pl.leszekjanczewski.reckoning.model.Client;
import pl.leszekjanczewski.reckoning.model.Role;
import pl.leszekjanczewski.reckoning.model.User;
import pl.leszekjanczewski.reckoning.repository.ChildRepo;
import pl.leszekjanczewski.reckoning.repository.ClientRepo;
import pl.leszekjanczewski.reckoning.repository.RoleRepo;
import pl.leszekjanczewski.reckoning.repository.UserRepo;
import pl.leszekjanczewski.reckoning.service.ChildServiceImpl;
import pl.leszekjanczewski.reckoning.service.ClientServiceImpl;
import pl.leszekjanczewski.reckoning.service.UserServiceImpl;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired private ChildServiceImpl childService;

    @Autowired private ChildRepo childRepo;

    @GetMapping("/admin/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/addUserForm";
    }

    @PostMapping("/admin/addUser")
    public String saveAddUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin/listUser";
    }

    @GetMapping("/admin/listUser")
    public String listUsers(Model model) {
        List<User> userList = userRepo.findAll();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/admin/editUser/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<User> user = userRepo.findById(id);
        model.addAttribute("user", user);
        return "redirect:/admin/addUser";
    }

    @GetMapping("/admin/removeUser/{id}")
    public String removeUser(@PathVariable Long id) {
        userRepo.delete(userRepo.findByUserId(id));
        return "redirect:/admin/listUser";
    }

    @GetMapping("/admin/addClient")
    public String addClient(Model model) {
        model.addAttribute("client", new Client());
        return "admin/addClientForm";
    }

    @PostMapping("/admin/addClient")
    public String saveAddClient(@ModelAttribute Client client) {
        clientService.saveClient(client);
        return "redirect:/admin/listClients";
    }

    @GetMapping("/admin/listClients")
    public String listClients(Model model) {
        List<Client> clientList = clientRepo.findAll();
        model.addAttribute("clients", clientList);
        return "index";
    }

    @GetMapping("/admin/editClient/{id}")
    public String editClient(@PathVariable Long id, Model model) {
        Client client = clientRepo.findByClientId(id);
        model.addAttribute("client", client);
        return "redirect:/admin/addClient";
    }

    @GetMapping("/admin/removeClient/{id}")
    public String removeClient(@PathVariable Long id) {
        clientRepo.delete(clientRepo.findByClientId(id));
        return "redirect:/admin/listUser";
    }
    /**/
    @GetMapping("/admin/addChild")
    public String addChild(Model model) {
        model.addAttribute("child", new Child());
        return "admin/addChildForm";
    }

    @PostMapping("/admin/addChild")
    public String saveAddChild(@ModelAttribute Child child) {
        childService.saveChild(child);
        return "redirect:/admin/listChildren";
    }

    @GetMapping("/admin/listChildren")
    public String listChildren(Model model) {
        List<Child> children = childRepo.findAll();
        model.addAttribute("children", children);
        return "index";
    }

    @GetMapping("/admin/editChild/{id}")
    public String editChild(@PathVariable Long id, Model model) {
        Child child = childRepo.findByChildId(id);
        model.addAttribute("child", child);
        return "redirect:/admin/addChild";
    }

    @GetMapping("/admin/removeChild/{id}")
    public String removeChild(@PathVariable Long id) {
        childRepo.delete(childRepo.findByChildId(id));
        return "redirect:/admin/listChildren";
    }

    /**/

    @ModelAttribute("roles")
    public List<Role> roleList() {
        List<Role> roleList = roleRepo.findAll();
        return roleList;
    }

}
