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
import com.rdr.capas.domain.Employee;
import com.rdr.capas.services.BranchInterface;
import com.rdr.capas.services.EmployeeInterface;



@Controller
public class EmployeeController {
	
	@Autowired
	BranchInterface branchService;
	
	@Autowired
	EmployeeInterface employeeService;
	
	@RequestMapping("/create-new-employee")
	public ModelAndView createNewEmployee(@RequestParam String branch_id, Model model) {		
		ModelAndView mav = new ModelAndView();
			
		if (!model.containsAttribute("employee")) {
			mav.addObject("employee", new Employee());
		}
		
		mav.addObject("headerMessage", "Contratar Empleado");
		mav.addObject("actionMessage", "Contratar");
		mav.addObject("mensajeBoton", "Regresar");
		mav.addObject("branchId", Integer.parseInt(branch_id) );
		mav.addObject("pageToRedirect", "edit");		
		mav.setViewName("employeeInfo");	
		
		return mav;
	}	
	
	@RequestMapping("/create-employee")
	public String createEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, @RequestParam String branchId, RedirectAttributes redirectAttributes) {
		String redirect = "redirect:/";
		
		if (result.hasErrors()) {
			System.out.println("Error");
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employee", result);
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addAttribute("branch_id", branchId );	
            redirect += "create-new-employee";
		}
		else {			
			employee.setBranch(branchService.getOne(Integer.parseInt(branchId)));
			employeeService.create(employee);										
			redirectAttributes.addAttribute("id", branchId );	
			redirect += "edit";
		}
		
		
		return redirect;
	}
	
	@RequestMapping("/edit-new-employee")
	public ModelAndView editEmployee(@RequestParam String employee_id, @RequestParam String branch_id) {		
		ModelAndView mav = new ModelAndView();
			
		Employee employee =  employeeService.getOne(Integer.parseInt(employee_id));	
		System.out.println(employee.getName());
		
		mav.addObject("headerMessage", "Editar Empleado");
		mav.addObject("actionMessage", "Editar");
		mav.addObject("employee", employee);		
		mav.addObject("mensajeBoton", "Eliminar");
		mav.addObject("branchId", branch_id );
		mav.addObject("pageToRedirect", "delete-employee");
		
		mav.setViewName("employeeInfo");	
		return mav;
	}	
	
	@RequestMapping("/delete-employee")
	public String deleteEmployee(@RequestParam String employee_id, @RequestParam String branch_id,RedirectAttributes redirectAttributes) {
		
		employeeService.deleteById(Integer.parseInt(employee_id));
							
		redirectAttributes.addAttribute("id", branch_id );
		
		return "redirect:/edit";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	

	
}
