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

import com.centreFormat.models.Gestionnaires;
import com.centreFormat.models.Secretaires;
import com.centreFormat.repository.GestionnairesRepository;
import com.centreFormat.repository.SecretairesRepository;

@RestController
@RequestMapping(value = "/api/secretaires")
public class SecretairesRESTController {
	
	@Autowired
	private SecretairesRepository SRep;
	@Autowired
	private GestionnairesRepository GRep;
	
	@GetMapping("/allSecre")
	List<Secretaires> allSecre(){
		return IterableUtils.toList(SRep.findAll());
	}
	
	@GetMapping("/allSecre/{id}")
	Secretaires oneSecre(@PathVariable int id) {
		return SRep.findById(id).get();
	}
	
	@PostMapping(value = "/secretaire")
	Secretaires newSecre(@RequestBody Secretaires secretaire) {
		
		Gestionnaires gest = GRep.findById(1).get();
		
		secretaire.setGestAjout(gest);
		
		return SRep.save(secretaire);
	}
	
	@PutMapping("/updateSecre/{id}")
	Secretaires modifySecre(@RequestBody Secretaires secretaire, @PathVariable int id) {
		Secretaires updatedSecre = SRep.findById(id).get();
		
		//NOM
		if(!secretaire.getNom().isEmpty() && (updatedSecre.getNom() != secretaire.getNom()) ) {
			updatedSecre.setNom(secretaire.getNom());
		}
		
		//PRENOM
		if(!secretaire.getPrenom().isEmpty() && (updatedSecre.getPrenom() != secretaire.getPrenom()) ) {
			updatedSecre.setPrenom(secretaire.getPrenom());
		}
		
		//ADRESSE
		if(!secretaire.getAdresse().isEmpty() && (updatedSecre.getAdresse() != secretaire.getAdresse()) ) {
			updatedSecre.setAdresse(secretaire.getAdresse());
		}
		
		//TELEPHONE
		if(!secretaire.getTelephone().isEmpty() && (updatedSecre.getTelephone() != secretaire.getTelephone()) ) {
			updatedSecre.setTelephone(secretaire.getTelephone());
		}
		
		//EMAIL
		if(!secretaire.getEmail().isEmpty() && (updatedSecre.getEmail() != secretaire.getEmail()) ) {
			updatedSecre.setEmail(secretaire.getEmail());
		}
		
		//CODEID
		if(updatedSecre.getCodeId() != secretaire.getCodeId() ) {
			updatedSecre.setCodeId(secretaire.getCodeId());
		}
		//NATIONALID
		if(!secretaire.getNationnalId().isEmpty() && (updatedSecre.getNationnalId() != secretaire.getNationnalId()) ) {
			updatedSecre.setNationnalId(secretaire.getNationnalId());
		}
		
		//COMPTE
		if(!secretaire.getCompte().isEmpty() && (updatedSecre.getCompte() != secretaire.getCompte()) ) {
			updatedSecre.setCompte(secretaire.getCompte());
		}
		
		
		return SRep.save(updatedSecre);
	}

	@DeleteMapping("/delSecretaire/{id}")
	void deleteSecretaire(@PathVariable int id) {
		//SRep.deleteById(id);
		// desactivate because the client does'nt want it but left here just in case
	}

}
