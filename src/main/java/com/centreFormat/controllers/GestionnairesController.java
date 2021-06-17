package com.centreFormat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centreFormat.models.Gestionnaires;
import com.centreFormat.repository.GestionnairesRepository;

@Controller
@RequestMapping(value = "/gestionnaires")
public class GestionnairesController {
	
	@Autowired
	GestionnairesRepository GR;
	
	@RequestMapping(value = "allGestio", method = RequestMethod.GET)
	public String getAllGestionnaires(Model model) {
		
		model.addAttribute("gestio", GR.findAll());
		
		return "gestionnaires";
	}
	
	/*
	@RequestMapping(value = "newgest", method = RequestMethod.POST)
	public String postNewGestionnaire(Model model, Gestionnaires gest) {
		model.addAttribute("newgest", GR.save(gest));
		return "newgest";
	}
	*/
}
