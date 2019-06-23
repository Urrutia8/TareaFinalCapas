package com.rdr.capas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rdr.capas.domain.User;
import com.rdr.capas.repositories.UserRepository;
import com.rdr.capas.services.UserInterface;



@Controller
public class MainController {
	
	@Autowired
	private UserInterface userService;
	
	@RequestMapping("/")
	public ModelAndView initMain(Model model ) {		
		ModelAndView mav = new ModelAndView();	
		
		if(!model.containsAttribute("user")) {
			
			mav.addObject("user", new User());
		}
		
		mav.setViewName("login");
		
		return mav;
	}	
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes redirectAttributes) {		
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors()) {
			System.out.println("Errore");
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", user);
			return "redirect:/";
		}
		
		List<User> usuarios = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if (usuarios.size() == 1) {
			return "redirect:/branches";
		}else {
			mav.addObject("user", user);
			mav.addObject("message", "No existe el usuario");
			mav.setViewName("login");
		}
		
		return "redirect:/";
	}	
	
	
	
	
}
