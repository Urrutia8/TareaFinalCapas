package com.rdr.capas.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rdr.capas.domain.Branch;

import com.rdr.capas.services.BranchInterface;



@Controller
public class BranchController {
	
	@Autowired
	BranchInterface branchService;
	
	@RequestMapping("/branches")
	public ModelAndView branches() {		
		ModelAndView mav = new ModelAndView();
		
		List<Branch> branches = branchService.findAll();
		
		mav.addObject("branches", branches);
		mav.setViewName("branches");	
		return mav;
	}	
	
	@RequestMapping("/create-new-branch")
	public ModelAndView createNewBranches(Model model) {		
		ModelAndView mav = new ModelAndView();
		
		if (!model.containsAttribute("branch")) {
			mav.addObject("branch", new Branch());
		}
		
		mav.setViewName("newBranch");	
		return mav;
	}	
	
	@RequestMapping("/create-branch")
	public String createBranch(@Valid @ModelAttribute Branch branch, BindingResult result, RedirectAttributes redirectAttributes) {
		String redirect = "redirect:/"; 
		
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.branch", result);
            redirectAttributes.addFlashAttribute("branch", branch);
			redirect += "create-new-branch";
		}
		else {
			branchService.create(branch);
			redirect += "branches"; 
		}
		
		return redirect;
	}	
	
	@RequestMapping("/edit")
	public ModelAndView editBranch(@RequestParam String id, Model model) {		
		ModelAndView mav = new ModelAndView();				
		
		if (!model.containsAttribute("branch")) {
			mav.addObject("branch", branchService.getOne(Integer.parseInt(id)));
		}				
		
		mav.addObject("headerMessage", "Editar Sucursal #" + id);		
		mav.setViewName("editBranch");
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteBranch(@RequestParam String id) {				
		branchService.deleteById(Integer.parseInt(id));
				
		return "redirect:/branches";
	}
	
	@RequestMapping("/edit-branch")
	public String edit(@Valid @ModelAttribute Branch branch, BindingResult result,RedirectAttributes redirectAttributes ) {		
		String redirect = "redirect:/edit";
		
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.branch", result);
            redirectAttributes.addFlashAttribute("branch", branch);
            redirectAttributes.addAttribute("id", branch.getId());
			
		}
		else {
			redirectAttributes.addAttribute("id", branch.getId());
			branchService.update(branch);			
		}																			
		
		return redirect;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
}
