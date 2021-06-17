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

import com.centreFormat.models.Types;
import com.centreFormat.repository.TypesRepository;

import org.apache.commons.collections4.IterableUtils;

@RestController
@RequestMapping(value="/api/types")
public class TypesRESTController {
	@Autowired
	private TypesRepository TRep;
	
	@GetMapping("/allTypes")
	List<Types> allTypes(){
		return IterableUtils.toList(TRep.findAll());
	}
	
	@GetMapping("/allTypes/{id}")
	Types oneType (@PathVariable int id) {
		return TRep.findById(id).get();
	}
	
	@PostMapping(value = "/type")
	Types newType(@RequestBody Types type) {
		return TRep.save(type);
	}
	
	@PutMapping("/updateType/{id}")
	Types modifType(@RequestBody Types type, @PathVariable int id) {
		
		Types updatedType = TRep.findById(id).get();
		
		if(!type.getNom().isEmpty() && (updatedType.getNom() != type.getNom())) {
			updatedType.setNom(type.getNom());
		}
		
		return TRep.save(updatedType);
	}
	
	@DeleteMapping("/delType/{id}")
	void deleteType(@PathVariable int id) {
		TRep.deleteById(id);
	}

}
