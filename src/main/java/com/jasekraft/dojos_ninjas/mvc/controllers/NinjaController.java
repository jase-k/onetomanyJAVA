package com.jasekraft.dojos_ninjas.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jasekraft.dojos_ninjas.mvc.models.Dojo;
import com.jasekraft.dojos_ninjas.mvc.models.Ninja;
import com.jasekraft.dojos_ninjas.mvc.services.DojoServ;
import com.jasekraft.dojos_ninjas.mvc.services.NinjaServ;

@Controller
public class NinjaController {

//	Insert Link to Service Here
	private final NinjaServ ninjaServ;
	private final DojoServ dojoServ;
	
	public NinjaController(NinjaServ ninjaServ, DojoServ dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	@RequestMapping("/ninja")
	public String index(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServ.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "ninja/new.jsp";
	}
	
	@RequestMapping(value="/new_ninja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/ninja";
		}
		//Connect to Service
		ninjaServ.createNinja(ninja);
		return String.format("redirect:/dojos/%s", ninja.getDojo().getId());
	}
	
}