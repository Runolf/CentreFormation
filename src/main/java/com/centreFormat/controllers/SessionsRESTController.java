package com.centreFormat.controllers;

import java.util.List;

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

import com.centreFormat.models.Gestionnaires;
import com.centreFormat.models.Sessions;
import com.centreFormat.repository.GestionnairesRepository;
import com.centreFormat.repository.SessionsRepository;
import org.apache.commons.collections4.IterableUtils;

@RestController
@RequestMapping(value = "/api/sessions")
public class SessionsRESTController {
	
	@Autowired
	private SessionsRepository SRep;
	@Autowired
	private GestionnairesRepository GRep;
	
	@GetMapping("/allSessions")
	List<Sessions> allSessions(){
	
		return IterableUtils.toList(SRep.findAll());
	}
	
	@GetMapping("/allSessions/{id}")
	Sessions oneSessions(@PathVariable int id) {
		return SRep.findById(id).get();
	}
	
	@GetMapping("/getByFormation/{idFormat}")
	List<Sessions> getByFormation(@PathVariable int idFormat) {
		return IterableUtils.toList(SRep.findByIdFormation(idFormat).get());
	}
	
	@PostMapping(value = "/sessions")
	Sessions newSessions(@RequestBody Sessions session) {
		Gestionnaires gestio = GRep.findById(1).get();
		session.setGestAjout(gestio);
		return SRep.save(session);
	}
	
	@PutMapping("/updateSessions/{id}")
	Sessions modifSessions(@RequestBody Sessions session, @PathVariable int id) {
		Gestionnaires gestio = GRep.findById(1).get();
		
		Sessions updatedSession = SRep.findById(id).get();
		
		//STARTDATE
		if(!session.getStartDate().toString().isEmpty() && (updatedSession.getStartDate() != session.getStartDate())  ) {
			updatedSession.setStartDate(session.getStartDate());
		}
		
		//ENDDATE
		if(!session.getEndDate().toString().isEmpty() && (updatedSession.getEndDate() != session.getEndDate())  ) {
			updatedSession.setEndDate(session.getEndDate());
		}
			
		//LOCAL
		
		if(!session.getIdLocal().toString().isEmpty() && (updatedSession.getIdLocal() != session.getIdLocal())  ) {
			updatedSession.setIdLocal(session.getIdLocal());
		}
			
		//FORMATION
		if(!session.getIdFormation().toString().isEmpty() && (updatedSession.getIdFormation() != session.getIdFormation())  ) {
			updatedSession.setIdFormation(session.getIdFormation());
		}
		
		//FORMATEUR
		if(!session.getIdFormateur().toString().isEmpty() && (updatedSession.getIdFormateur() != session.getIdFormateur())  ) {
			updatedSession.setIdFormateur(session.getIdFormateur());
		}
		
		
		updatedSession.setGestModif(gestio);
		
		return SRep.save(updatedSession);
	}
	
	@DeleteMapping("/delSessions/{id}")
	void deleteSessions(@PathVariable int id) {
		
		SRep.deleteById(id);
	}
}
