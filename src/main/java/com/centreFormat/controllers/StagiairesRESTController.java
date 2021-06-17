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

import com.centreFormat.models.Stagiaires;
import com.centreFormat.repository.StagiairesRepository;

import org.apache.commons.collections4.IterableUtils;
@RestController
@RequestMapping(value="/api/stagiaires")
public class StagiairesRESTController {
	
	@Autowired
	private StagiairesRepository SRep;
	
	@GetMapping("/allStagiaire")
	List<Stagiaires> allStagiaire(){
		return IterableUtils.toList(SRep.findAll());
	}
	
	@GetMapping("/getByEmail/{email}")
	Stagiaires getStagiaireByEmail(@PathVariable String email) {
		return SRep.findByEmail(email).get();
	}
	
	@GetMapping("/allStagiaire/{id}")
	Stagiaires oneStagiaire(@PathVariable int id) {
		
		return SRep.findById(id).get();
	}
	
	@PostMapping(value="/stagiaire")
	Stagiaires newStagiaire(@RequestBody Stagiaires stagiaire) {
		stagiaire.hashPswd();
		return SRep.save(stagiaire);
	}

	@PutMapping("/updateStagiaire/{id}")
	Stagiaires modifyStagiaire(@RequestBody Stagiaires stagiaire, @PathVariable int id) {
		
		Stagiaires updatedStagiaire = SRep.findById(id).get();
		
		//NOM
		if(!stagiaire.getNom().isEmpty() && (updatedStagiaire.getNom() != stagiaire.getNom())  ) {
			updatedStagiaire.setNom(stagiaire.getNom());
		}
		
		//PRENOM
		if(!stagiaire.getPrenom().isEmpty() && (updatedStagiaire.getPrenom() != stagiaire.getPrenom()) ) {
			updatedStagiaire.setPrenom(stagiaire.getPrenom());
		}
		
		//ADRESSE
		if(!stagiaire.getAdresse().isEmpty() && (updatedStagiaire.getAdresse() != stagiaire.getAdresse() )) {
			updatedStagiaire.setAdresse(stagiaire.getAdresse());
		}
		
		//CODEID 
		if(!Integer.toString(stagiaire.getCodeId()).isEmpty() && (updatedStagiaire.getCodeId() != stagiaire.getCodeId())) {
			updatedStagiaire.setCodeId(stagiaire.getCodeId());
		}
		
		//EMAIL
		if(!stagiaire.getEmail().isEmpty() && (updatedStagiaire.getEmail() != stagiaire.getEmail())) {
			updatedStagiaire.setEmail(stagiaire.getEmail());
		}
		
		//TELEPHONE
		if(!stagiaire.getTelephone().isEmpty() && (updatedStagiaire.getTelephone() != stagiaire.getTelephone())) {
			updatedStagiaire.setTelephone(stagiaire.getTelephone());
		}
		
		if(!(stagiaire.getIdStatut()!=null) && (updatedStagiaire.getIdStatut() != stagiaire.getIdStatut() )) {
			updatedStagiaire.setIdStatut(stagiaire.getIdStatut());
		}
		
		return SRep.save(updatedStagiaire); 
	}
	
	@DeleteMapping("/delStagiaire/{id}")
	void deleteStagiaire(@PathVariable int id) {
		
		Stagiaires sta = SRep.findById(id).get();
		sta.setNom("anonyme");
		sta.setPrenom("anonyme");
		sta.setAdresse("anonyme");
		sta.setEmail("anonyme");
		sta.setTelephone("anonyme");
		SRep.save(sta);
	}	
	
}
