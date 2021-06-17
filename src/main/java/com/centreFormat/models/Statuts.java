package com.centreFormat.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idStatut")
public class Statuts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdStatut;
	private String Nom;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestAjout")
	private Gestionnaires GestAjout;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestModif")
	private Gestionnaires GestModif;
	
	@OneToMany(mappedBy="idStatut")
	@Nullable
	private Set<Stagiaires> stagiaires;
	
	
	public Statuts() {}
	public Statuts(int idStatut, String nom, Gestionnaires gestAjout, Gestionnaires gestModif, Set<Stagiaires> stagiaires) {
		super();
		IdStatut = idStatut;
		Nom = nom;
		GestAjout = gestAjout;
		GestModif = gestModif;
		this.stagiaires = stagiaires;
	}
	

	public Gestionnaires getGestAjout() {
		return GestAjout;
	}
	public void setGestAjout(Gestionnaires gestAjout) {
		GestAjout = gestAjout;
	}
	
	public Gestionnaires getGestModif() {
		return GestModif;
	}
	public void setGestModif(Gestionnaires gestModif) {
		GestModif = gestModif;
	}
	
	public Set<Stagiaires> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(Set<Stagiaires> stagiaires) {
		this.stagiaires = stagiaires;
	}
	
	public int getIdStatut() {
		return IdStatut;
	}
	public void setIdStatut(int idStatut) {
		IdStatut = idStatut;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
}
