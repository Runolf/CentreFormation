package com.centreFormat.controllers;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centreFormat.models.Formateurs;
import com.centreFormat.models.Gestionnaires;
import com.centreFormat.repository.FormateursRepository;
import com.centreFormat.repository.GestionnairesRepository;

@RestController
@RequestMapping(value = "/api/formateurs")
public class FormateursRESTController {
	
	@Autowired
	private FormateursRepository FRep; 
	@Autowired
	private GestionnairesRepository GRep;
	
	@GetMapping("/allFormateurs")
	List<Formateurs> allFormateurs(){
		return IterableUtils.toList(FRep.findAll());
	}
	
	@GetMapping("/allFormateurs/{id}")
	Formateurs oneFormateurs(@PathVariable int id) {
		return FRep.findById(id).get();
	}
	
	@PostMapping(value = "/formateurs")
	Formateurs newFormateurs(@RequestBody Formateurs formateur) {
		
		Gestionnaires gestio = GRep.findById(1).get();
		formateur.setGestAjout(gestio);
		return FRep.save(formateur);
	}
	
	@PutMapping("/updateFormateurs/{id}")
	Formateurs modifyFormateurs(@RequestBody Formateurs formateur, @PathVariable int id) {
			
		Formateurs updatedFormateur = FRep.findById(id).get();
		Gestionnaires gestio = GRep.findById(1).get();
		
		//NOM
		if(!formateur.getNom().isEmpty() && (updatedFormateur.getNom() != formateur.getNom()) ) {
			updatedFormateur.setNom(formateur.getNom());
		}
		//PRENOM		
		if(!formateur.getPrenom().isEmpty() && (updatedFormateur.getPrenom() != formateur.getPrenom()) ) {
			updatedFormateur.setPrenom(formateur.getPrenom());
		}
		//ADRESSE 
		if(!formateur.getAdresse().isEmpty() && (updatedFormateur.getAdresse() != formateur.getAdresse())  ) {
			updatedFormateur.setAdresse(formateur.getAdresse());	
		}
		//TELEPHONE
		if(!formateur.getTelephone().isEmpty() && (updatedFormateur.getTelephone() != formateur.getTelephone())  ) {
			updatedFormateur.setTelephone(formateur.getTelephone());
		}
		//EMAIL
		if(!formateur.getEmail().isEmpty() && (updatedFormateur.getEmail() != formateur.getEmail()) ) {
			updatedFormateur.setEmail(formateur.getEmail());
		}
		//CODEID
		if(!Integer.toString(formateur.getCodeId()).isEmpty() && (updatedFormateur.getCodeId() != formateur.getCodeId()) ) {
			updatedFormateur.setCodeId(formateur.getCodeId());
		}
		//NATIONNALID
		if(!formateur.getNationnalId().isEmpty() && (updatedFormateur.getNationnalId() != formateur.getNationnalId()) ) {
			updatedFormateur.setNationnalId(formateur.getNationnalId());
		}
		//COMPTE
		if(!formateur.getCompte().isEmpty() && (updatedFormateur.getCompte() != formateur.getCompte()) ) {
			updatedFormateur.setNationnalId(formateur.getCompte());
		}
		
		updatedFormateur.setGestModif(gestio);
		
		return FRep.save(updatedFormateur);
	}

	@DeleteMapping("/delFormateur/{id}")
	void deleteFormateur(@PathVariable int id) {
		
		//Gestionnaires gestio = GRep.findById(1).get();
		
		//Formateurs formateur = FRep.findById(id).get();
		
		// FRep.deleteById(id);
	}
}
