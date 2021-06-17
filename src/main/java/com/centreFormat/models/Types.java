package com.centreFormat.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idType")
public class Types {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;
	
	private String nom;
	
	@OneToMany(mappedBy = "type")
	private Set<Locaux> locaux;
	
	public Types() {}
	public Types(int idType, String nom, Set<Locaux> locaux) {
		super();
		this.idType = idType;
		this.nom = nom;
		this.setLocaux(locaux);
	}

	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Locaux> getLocaux() {
		return locaux;
	}
	public void setLocaux(Set<Locaux> locaux) {
		this.locaux = locaux;
	}
	
}
