package com.centreFormat.controllers;

import com.centreFormat.repository.InscriptionsRepository;

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

import com.centreFormat.models.Inscriptions;

@RestController
@RequestMapping(value = "/api/inscriptions")
public class InscriptionsRESTController {
	
	@Autowired
	private InscriptionsRepository IRep;
		
	@GetMapping("/allInscriptions")
	List<Inscriptions> allGestio(){
		return IterableUtils.toList(IRep.findAll());
	}
	
	@GetMapping("/allInscriptions/{id}")
	Inscriptions oneInscriptions(@PathVariable int id) {
		return IRep.findById(id).get();
	}
	
	@PostMapping(value = "/inscriptions")
	Inscriptions newInscriptions(@RequestBody Inscriptions inscription) {
		return IRep.save(inscription);
	}
	
	@PutMapping("/updateInscriptions/{id}")
	Inscriptions modifInscription(@RequestBody Inscriptions insc, @PathVariable int id) {
		Inscriptions updatedInsc = IRep.findById(id).get();
		
		//PRIX ACTUEL
		if(!Double.toString(insc.getPrixActuel()).isEmpty() && (updatedInsc.getPrixActuel() != insc.getPrixActuel()) ) {
			updatedInsc.setPrixActuel(insc.getPrixActuel());
		}
		
		//ISPAYEE
		if(!Boolean.toString(insc.estPayee()).isEmpty() && (updatedInsc.estPayee() != insc.estPayee()) ) {
			updatedInsc.setPayee(insc.estPayee());
		}
		
		
		return IRep.save(updatedInsc);
	}
	
	@DeleteMapping("/delInscriptions/{id}")
	void deleteInscriptions(@PathVariable int id) {
		IRep.deleteById(id);
	}
	
}
