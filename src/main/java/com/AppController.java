package com;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {

	private User currentUser;
	private final UserService userService;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private EquipmentsRepository equiRepo;
	
	@Autowired
	private IssuesRepository issuesRepo;
	
	@GetMapping("")
	public String viewHomePage(){
		return "login";
	}
	@GetMapping ("/login")
	public String viewLogin(){
		return "login";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegistration (User user) {

		try {
			userService.save(user);
			return "redirect:/register?success";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/register?emailError";
		}
	}
	
	@GetMapping("list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/open_dashboard")
	public String openDashboard() {
		
		return "dashboard";
	}

	@GetMapping("/try")
	public String openTry() {

		return "try";
	}

	
	@GetMapping("/equipments")
	public String openEquipment(Model model) {
		model.addAttribute("equipments", new Equipments());
		
		List<Equipments> listEquipments = equiRepo.findAll();
		model.addAttribute("listEquipments", listEquipments);
		
		
		return "equipments";
		
	}


	@GetMapping("/about")
	public String viewAboutUs() {
		return "about";
	}
	
	/*@PostMapping("/process_equipments")
	public String processEquipments(Equipments equipments) {
		equiRepo.save(equipments);
		
		return "equipment_added";
	}*/
	@PostMapping("/process_equipments")
	public String processEquipments(Equipments equipments) {
		equiRepo.save(equipments);

		return "redirect:/equipments?success";
	}
	
	@GetMapping("/issues")
	public String viewIssues(Model model) {
		model.addAttribute("issues", new Issues());
		
		List<Issues> listIssues = issuesRepo.findAll(); 
		model.addAttribute("listIssues",listIssues);
/*
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (userService.validation(user).equals("Supervisor")) {
				return "supervisor_issues";
			}
			else
				return "superviso";
		} catch (Exception e){*/

		return "issues";
		}
	/*@PostMapping("/process_issues")
	public String processIssues(Issues issues) {
		issuesRepo.save(issues);

		return "issue_added";
	}*/
	@PostMapping("/process_issues")
	public String processIssues(Issues issues) {
		issuesRepo.save(issues);
		return "redirect:/issues?success";
	}


	@ModelAttribute("listEquipments")
	public List <Equipments> getEquipments() {
		List <Equipments> listEquip = equiRepo.findAll();
		
		return listEquip;
		
	}
	
	@Autowired
	public AppController(UserService userService) {
		
		this.userService= userService;
	}
	

/*	@GetMapping("/process_register")
	public String returnError(User user) {
		
		if (userService.userExists(user.getEmail())) {
			return "error";
		}
		
		return "index";
		
	}
	*/
}
