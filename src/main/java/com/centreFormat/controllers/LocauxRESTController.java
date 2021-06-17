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
import com.centreFormat.models.Locaux;
import com.centreFormat.models.Types;
import com.centreFormat.repository.GestionnairesRepository;
import com.centreFormat.repository.LocauxRepository;
import com.centreFormat.repository.TypesRepository;

@RestController
@RequestMapping(value = "/api/locaux")
public class LocauxRESTController {
	
	@Autowired
	private LocauxRepository LRep;
	@Autowired
	private GestionnairesRepository GRep;
	@Autowired 
	private TypesRepository TRep;
	
	@GetMapping("/allLocaux")
	List<Locaux> allLocaux(){
		return IterableUtils.toList(LRep.findAll());
	}

	@GetMapping("/allLocaux/{id}")
	Locaux oneLocaux(@PathVariable int id) {
		return LRep.findById(id).get();
	}

	@PostMapping(value = "/locaux")
	Locaux newLocal(@RequestBody Locaux locaux) {
		Gestionnaires gestio = GRep.findById(1).get();
		locaux.setGestAjout(gestio);
		
		Types type = TRep.findById(locaux.getType().getIdType()).get();
		locaux.setType(type);
		
		return LRep.save(locaux);
	}
	
	@PutMapping("/locaux/{id}")
	Locaux modifLocaux(@RequestBody Locaux locaux, @PathVariable int id) {
		
		Locaux updatedLocaux = LRep.findById(id).get();
		
		//NOM
		if(!locaux.getNom().isEmpty() && (updatedLocaux.getNom() != locaux.getNom()) ) {
			updatedLocaux.setNom(locaux.getNom());
		}
		
		//ETAGE
		if(!Integer.toString(locaux.getEtage()).isEmpty() && (updatedLocaux.getEtage() != locaux.getEtage()) ) {
			updatedLocaux.setEtage(locaux.getEtage());
		}
		
		
		//TYPE
		if(updatedLocaux.getType() != locaux.getType() ) {
			updatedLocaux.setType(locaux.getType());
		}
		
		//ESTPERMANENT
		if(updatedLocaux.isEstPermanent() != locaux.isEstPermanent()  ) {
			updatedLocaux.setEstPermanent(locaux.isEstPermanent());
		}
		
		return LRep.save(updatedLocaux);
	}

	@DeleteMapping("/delLocaux/{id}")
	void deleteLocaux(@PathVariable int id) {
		LRep.deleteById(id);
	}
}
