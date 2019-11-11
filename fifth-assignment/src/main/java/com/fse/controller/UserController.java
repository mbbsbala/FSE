package com.iiht.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iiht.model.dao.User;
import com.iiht.model.dto.LoginDTO;
import com.iiht.model.dto.RegistrationDTO;
import com.iiht.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public RegistrationDTO userRegistrationDto() {
		return new RegistrationDTO();
	}
	
	@GetMapping
	public String showHomePage(Model model) {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		return "register";
	}

	@PostMapping("/register")
	public String register(final ModelMap model,
	        				@Valid final RegistrationDTO registrationDto,
	        						final BindingResult result, 
	        						RedirectAttributes redirectAttributes) {

		User existing = userService.findByEmail(registrationDto.getEmail());
		if (existing != null) {
			result.rejectValue("email", "USER001", "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", registrationDto);
			redirectAttributes.addFlashAttribute("errorMessage", "Registraion Failed");
			
			return "register";
		}

		userService.save(registrationDto);
		redirectAttributes.addFlashAttribute("confirmationMessage", "Registered successfully !!");

		return "redirect:/user/register?success";
	}

	@GetMapping("/login")
	public String showLoginPage(Model model) {
		return "login";
	}

	@PostMapping("/login")
	public String login(@Valid LoginDTO loginDto, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "login";
		}

		User existing = userService.findByUsername(loginDto.getUsername());
		if (existing == null) {
			result.rejectValue("username", null, "Invalid Username / Password");
		}

		if (result.hasErrors()) {
			return "login";
		}

		return "redirect:/user";
	}
}