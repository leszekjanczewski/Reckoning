package pl.leszekjanczewski.reckoning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.leszekjanczewski.reckoning.model.*;
import pl.leszekjanczewski.reckoning.model.Division;
import pl.leszekjanczewski.reckoning.repository.*;
import pl.leszekjanczewski.reckoning.service.ChildServiceImpl;
import pl.leszekjanczewski.reckoning.service.DivisionServiceImpl;
import pl.leszekjanczewski.reckoning.service.ClientServiceImpl;
import pl.leszekjanczewski.reckoning.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ChildServiceImpl childService;

    @Autowired
    private ChildRepo childRepo;

    @Autowired
    private DivisionRepo divisionRepo;

    @Autowired
    private final DivisionServiceImpl classService;

    @Autowired
    private TypeOfDivisionRepo typeOfDivisionRepo;

    @Autowired
    private CalendarRepo calendarRepo;

    protected final Logger log = LoggerFactory.getLogger(getClass());

    public AdminController(DivisionServiceImpl classService) {
        this.classService = classService;
    }

    @GetMapping("/admin/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        List<Role> roleList = roleRepo.findAll();
        model.addAttribute("roles", roleList);
        return "admin/addUserForm";
    }

    @PostMapping("/admin/addUser")
    public String saveAddUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/admin/listUser")
    public String listUsers(Model model) {
        List<User> userList = userRepo.findAll();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/admin/editUser/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userRepo.findByUserId(id);
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
        List<Client> clientList = clientRepo.findAll();
        model.addAttribute("clients", clientList);
        List<Division> divisionList = divisionRepo.findAll();
        model.addAttribute("classes", divisionList);
        return "admin/addChildForm";
    }

    @PostMapping("/admin/addChild")
    public String saveAddChild(@ModelAttribute Child child) {
        child.setActive(true);
        childService.saveChild(child);
        return "redirect:/admin/listChildren";
    }

    @GetMapping("/admin/listChildren")
    public String listChildren(Model model) {
        List<Child> children = childRepo.findAll();
        model.addAttribute("children", children);
        List<Division> divisionList = divisionRepo.findAll();
        model.addAttribute("classes", divisionList);
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

    @GetMapping("/admin/addClass")
    public String addClass(Model model) {
        model.addAttribute("class", new Division());
        List<Division> divisionList = divisionRepo.findAll();
        model.addAttribute("classes", divisionList);
        List<TypeOfDivision> typeOfDivisionList = typeOfDivisionRepo.findAll();
        model.addAttribute("typOfClassList", typeOfDivisionList);
        return "addDivisionForm";
    }

    @PostMapping("/admin/addClass")
    public String saveAddClass(@ModelAttribute Division divisionReco) {
        String segOne = divisionReco.getDayOfWeek().substring(0, 2).toUpperCase();
        String segTwo = divisionReco.getTypeOfDivision().getTypeOfDivisionName().substring(0, 3).toUpperCase();
        String segThree;
        if (divisionReco.getTypeOfDivision().getTypeOfDivisionName().contains("Wst")) {
            segThree = "WST";
        } else if (divisionReco.getTypeOfDivision().getTypeOfDivisionName().contains("Podst")) {
            segThree = "PODST";
        } else if (divisionReco.getTypeOfDivision().getTypeOfDivisionName().contains("zaawa")) {
            segThree = "ZAAW";
        } else if (divisionReco.getTypeOfDivision().getTypeOfDivisionName().contains("pocz") || divisionReco.getTypeOfDivision().getTypeOfDivisionName().contains("pierwszy")) {
            segThree = "POCZ";
        } else {
            segThree = "WYZW";
        }
        String[] segFour = divisionReco.getStartHour().toString().split(":");
        divisionReco.setDivisionName(segOne + "-" + segTwo + "-" + segThree + "-" + segFour[0] + segFour[1]);
        classService.saveClass(divisionReco);
        return "redirect:/";
    }

    @GetMapping("/admin/addCalendar")
    public String addCalendar(Model model) {
//        Calendar kalendarz = new Calendar();
//        model.addAttribute("calendarA", kalendarz);
        List<Object[]> classList = divisionRepo.listClassWithName();
        model.addAttribute("classes", classList);
        List dateList = new ArrayList();
        log.debug("zawartosc: ", dateList);
        model.addAttribute("dateList", dateList);
        return "admin/addCalendar";
    }

//    @PostMapping("/admin/addCalendar")
//    public String saveAddCalendar(@ModelAttribute Calendar kalendarz) {
//        calendarRepo.save(kalendarz);
//        return "admin/addCalendar";
//    }

    @PostMapping("/admin/addDateToCalendar")
    public String addDateToCalendar(@ModelAttribute List<String> dateList, @ModelAttribute String date) {
        dateList.add(date);
        log.debug("zawartosc: ", dateList);
        return "redirect:/admin/addCalendar";
    }
}
