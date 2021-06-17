package com.centreFormat.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.IterableUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centreFormat.models.Formations;
import com.centreFormat.models.Gestionnaires;
import com.centreFormat.repository.FormationsRepository;
import com.centreFormat.repository.GestionnairesRepository;

@RestController
@RequestMapping(value = "/api/formations")
public class FormationsRESTController {
	
	@Autowired
	private FormationsRepository FRep;
	@Autowired
	private GestionnairesRepository GRep;
	
	@GetMapping("/allFormations")
	List<Formations> allFormations(){
		return IterableUtils.toList(FRep.findAll());
	}

	@GetMapping("/allFormations/{id}")
	Formations oneFormation(@PathVariable int id) {
		return FRep.findById(id).get();
	}
	
	@PostMapping(value = "/formations")
	Formations newFormations(@RequestBody Formations formation) {
		Gestionnaires gestio = GRep.findById(1).get();
		formation.setGestAjout(gestio);
		
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		try {
			date = SDF.parse(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formation.setDateCrea(date);
		
		return FRep.save(formation);
	}
	
	@PutMapping("/updateFormation/{id}")
	Formations modifFormations(@RequestBody Formations formation, @PathVariable int id) {
		
		Gestionnaires gestio = GRep.findById(1).get();
		Formations updatedFormation = FRep.findById(id).get();
		
		//INTITULE
		if(!formation.getIntitule().isEmpty() && (updatedFormation.getIntitule() != formation.getIntitule()) ) {
			updatedFormation.setIntitule(formation.getIntitule());
		}
		//DUREE
		if(!Integer.toString(formation.getDuree()).isEmpty() && (updatedFormation.getDuree() != formation.getDuree())  ) {
			updatedFormation.setDuree(formation.getDuree());
		}
		//PRIXBASE
		if(!Double.toString(formation.getPrixBase()).isEmpty() && (updatedFormation.getPrixBase() != formation.getPrixBase()) ) {
			updatedFormation.setPrixBase(formation.getPrixBase());
		}
		//MAXINSCRIPTION
		if(!Integer.toString(formation.getMaxInscription()).isEmpty() && (updatedFormation.getMaxInscription() != formation.getMaxInscription() ) ) {
			updatedFormation.setMaxInscription(formation.getMaxInscription());
		}
		//MINELEVE
		if(!Integer.toString(formation.getMinEleve()).isEmpty() && (updatedFormation.getMinEleve() != formation.getMinEleve()) ) {
			updatedFormation.setMinEleve(formation.getMinEleve());
		}
		
		/*
		//DATECREA
		if(formation.getDateCrea().toString().isEmpty() && (updatedFormation.getDateCrea() != formation.getDateCrea()) ) {
			updatedFormation.setDateCrea(formation.getDateCrea());
		}
		//DATECLOTURE
		if(formation.getDateCloture().toString().isEmpty() && (updatedFormation.getDateCloture() != formation.getDateCloture()) ) {
			updatedFormation.setDateCloture(formation.getDateCloture());
		}
		*/
		
		updatedFormation.setGestModif(gestio);
		
		return FRep.save(updatedFormation);
	}
	
	@DeleteMapping("/delFormation/{id}")
	void deleteFormation(@PathVariable int id) {
		Gestionnaires gestio = GRep.findById(1).get();
		Formations formation = FRep.findById(id).get();
		formation.setGestAjout(gestio);
		
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		try {
			date = SDF.parse(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formation.setDateCloture(date);
		
		FRep.save(formation);
	}
}
