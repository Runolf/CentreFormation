package com.centreFormat.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centreFormat.models.Gestionnaires;
import com.centreFormat.models.Statuts;
import com.centreFormat.repository.GestionnairesRepository;
import com.centreFormat.repository.StatutRepository;

import org.apache.commons.collections4.IterableUtils;

@RestController
@RequestMapping(value = "/api/statuts")
public class StatutsRESTController {
	
	@Autowired
	private StatutRepository SRep;
	@Autowired
	private GestionnairesRepository GRep;
	
	@GetMapping("/allStatut")
	List<Statuts> allStatut(){
		return IterableUtils.toList(SRep.findAll());
	} 
	
	@GetMapping("/allStatut/{id}")
	Statuts oneStatut(@PathVariable int id) {
		return SRep.findById(id).get();
	}
	
	@PostMapping(value = "/statut")
	Statuts newStatut(@RequestBody Statuts statut) {
		Gestionnaires gestio = GRep.findById(1).get();
		statut.setGestAjout(gestio);
		
		return SRep.save(statut);
	}
	
	@PutMapping("/statut/{id}")
	Statuts modifStatut(@RequestBody Statuts statut, @PathVariable int id, @RequestParam(value="idGestio", required=false) Integer idGestio) {
		
		// HttpEntity<String> httpEntity
		// String json = httpEntity.getBody();
		
		// System.out.print(json);
		
		Statuts modifStatut = SRep.findById(id).get();
		
		if(!statut.getNom().isEmpty() && (statut.getNom() != modifStatut.getNom()) ) {
			modifStatut.setNom(statut.getNom());
		}
		
		Gestionnaires gestio;
		/*
		if(Integer.toString(idGestio).isEmpty()) {
			gestio = GRep.findById(1).get(); 
		}
		else {
			gestio = GRep.findById(idGestio).get();
		} 
		*/
		gestio = GRep.findById( (idGestio == null) ? 1 : idGestio ).get();
		modifStatut.setGestModif(gestio);
		
		return SRep.save(modifStatut);
	}
	
	//desactivate
	@DeleteMapping("/delStatut/{id}")
	void deleteStatut(@PathVariable int id) {
		//SRep.deleteById(id); 
		//commented because the client doesn't want it, but left here just in case.
	}
}
