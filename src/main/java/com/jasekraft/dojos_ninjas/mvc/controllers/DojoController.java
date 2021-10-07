package com.jasekraft.dojos_ninjas.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jasekraft.dojos_ninjas.mvc.models.Dojo;
import com.jasekraft.dojos_ninjas.mvc.services.DojoServ;

@Controller
public class DojoController {

//	Insert Link to Service Here
	private final DojoServ dojoServ;
	
	public DojoController(DojoServ dojoServ) {
		this.dojoServ = dojoServ;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/new.jsp";
	}
	
	@RequestMapping(value="/new_dojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo/new.jsp";
		}
		//Connect to Service
		dojoServ.createDojo(dojo);
		return "redirect:/";
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(Model model, 
			@PathVariable("id") Long id) {
		Dojo dojo = dojoServ.getDojoById(id);
		model.addAttribute("dojo", dojo);
		return "dojo/show.jsp";
	}
	
}
