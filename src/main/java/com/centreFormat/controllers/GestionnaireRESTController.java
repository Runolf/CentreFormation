package com.centreFormat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centreFormat.models.Gestionnaires;

import org.apache.commons.collections4.IterableUtils;

import com.centreFormat.repository.GestionnairesRepository;

@RestController
@RequestMapping(value = "/api/gestionnaires")
public class GestionnaireRESTController {
	
	@Autowired
	private GestionnairesRepository GRep;
	
	@GetMapping("/allGestio")
	List<Gestionnaires> allGestio(){
		return IterableUtils.toList(GRep.findAll());
	}
	
	@GetMapping("/allGestio/{id}")
	Gestionnaires oneGestion(@PathVariable int id) {
		return GRep.findById(id).get();
	}
	
	@PostMapping(value = "/gestio")
	Gestionnaires newGestio(@RequestBody Gestionnaires gestio) {
		return GRep.save(gestio);
	}
	
	@PutMapping("/updateGestio/{id}")
	Gestionnaires modifyGestio(@RequestBody Gestionnaires gestio, @PathVariable int id) {
		
		
		Gestionnaires updateGestio = GRep.findById(id).get();
		
		// NOM
		if(!gestio.getNom().isEmpty() && (updateGestio.getNom() != gestio.getNom())) 
			updateGestio.setNom(gestio.getNom()); 
		
		//PRENOM
		if(!gestio.getPrenom().isEmpty() && (updateGestio.getPrenom() != gestio.getPrenom())) 
			updateGestio.setPrenom(gestio.getPrenom()); ;
		
		// ADRESSE
		if(!gestio.getAdresse().isEmpty() && (updateGestio.getAdresse() != gestio.getAdresse())) 
			updateGestio.setAdresse(gestio.getAdresse()); 
		
		//CODEID
		if(!Integer.toString(gestio.getCodeId()).isEmpty() && (gestio.getCodeId() != updateGestio.getCodeId() )) 
			updateGestio.setCodeId(gestio.getCodeId());
		
		//COMPTE
		if(!gestio.getCompte().isEmpty() && (gestio.getCompte() != updateGestio.getCompte()) )
			updateGestio.setCompte(gestio.getCompte());
		
		//NATIONNALID
		if(!gestio.getNationnalId().isEmpty() && (gestio.getNationnalId() != updateGestio.getNationnalId()) )
			updateGestio.setNationnalId(gestio.getNationnalId());
		
		//EMAIL
		if(!gestio.getEmail().isEmpty() && ( gestio.getEmail() != updateGestio.getEmail() ))
			updateGestio.setEmail(gestio.getEmail());
		
		//TELEPHONE
		if(!gestio.getTelephone().isEmpty() && (gestio.getTelephone() != updateGestio.getTelephone() ))
			updateGestio.setTelephone(gestio.getTelephone());
		
		return GRep.save(updateGestio);
	}
	
	@DeleteMapping("/delGestio/{id}")
	void deleteGestio(@PathVariable int id) {
		GRep.deleteById(id);
	}
	
}
