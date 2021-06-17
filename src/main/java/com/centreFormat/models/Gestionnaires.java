package com.centreFormat.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idGestionnaire")
public class Gestionnaires{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGestionnaire;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private int codeId;
	private String nationnalId;
	private String compte;
	
	//FK
	@JsonIgnore
	@OneToMany(mappedBy="GestAjout")
	private Set<Statuts> statutsAjout; 
	@JsonIgnore
	@OneToMany(mappedBy="GestModif")
	private Set<Statuts> statutsModif;
	
	@OneToMany(mappedBy="gestAjout")
	private Set<Secretaires> secretairesAjout;
	
	@OneToMany(mappedBy="GestAjout")
	private Set<Formateurs> formateursAjout;
	@OneToMany(mappedBy="GestModif")
	private Set<Formateurs> formateursModif;
	@OneToMany(mappedBy="GestDelete")
	private Set<Formateurs> formateursDelete;
	
	@OneToMany(mappedBy="GestAjout")
	private Set<Formations> formationsAjout;
	@OneToMany(mappedBy="GestModif")
	private Set<Formations> formationsModif;
	@OneToMany(mappedBy="GestDelete")
	private Set<Formations> formationsDelete;
	
	@OneToMany(mappedBy="GestAjout")
	private Set<Locaux> locaux;
	
	@OneToMany(mappedBy="GestAjout")
	private Set<Sessions> sessionAjout;
	@OneToMany(mappedBy="GestModif")
	private Set<Sessions> sessionModif;
	
	
	public Gestionnaires() {}
	public Gestionnaires(int idGestionnaire, String nom, String prenom, String adresse, String telephone, 
							String email, int codeId, String nationnalId, String compte) {

		this.idGestionnaire = idGestionnaire;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.codeId = codeId;
		this.nationnalId = nationnalId;
		this.compte = compte;
	}


	// SETTERS
	public void setIdGestionnaire(int idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}
	public void setNationnalId(String nationnalId) {
		this.nationnalId = nationnalId;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}
	
		
	// GETTERS
	public int getIdGestionnaire() {
		return idGestionnaire;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getEmail() {
		return email;
	}
	public int getCodeId() {
		return codeId;
	}
	public String getNationnalId() {
		return nationnalId;
	}
	public String getCompte() {
		return compte;
	}
	
	
	//GET-SET FK
	public Set<Statuts> getStatutsAjout() {
		return statutsAjout;
	}
	public void setStatutsAjout(Set<Statuts> statutsAjout) {
		this.statutsAjout = statutsAjout;
	}
	
	public Set<Secretaires> getSecretairesAjout() {
		return secretairesAjout;
	}
	public void setSecretairesAjout(Set<Secretaires> secretairesAjout) {
		this.secretairesAjout = secretairesAjout;
	}
	public Set<Statuts> getStatutsModif() {
		return statutsModif;
	}
	public void setStatutsModif(Set<Statuts> statutsModif) {
		this.statutsModif = statutsModif;
	}
	public Set<Formateurs> getFormateursAjout() {
		return formateursAjout;
	}
	public void setFormateursAjout(Set<Formateurs> formateursAjout) {
		this.formateursAjout = formateursAjout;
	}
	public Set<Formateurs> getFormateursModif() {
		return formateursModif;
	}
	public void setFormateursModif(Set<Formateurs> formateursModif) {
		this.formateursModif = formateursModif;
	}
	public Set<Formateurs> getFormateursDelete() {
		return formateursDelete;
	}
	public void setFormateursDelete(Set<Formateurs> formateursDelete) {
		this.formateursDelete = formateursDelete;
	}
	
}
