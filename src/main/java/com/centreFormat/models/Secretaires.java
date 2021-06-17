package com.centreFormat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSecretaire")
public class Secretaires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSecretaire;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private int codeId;
	private String nationnalId;
	private String compte;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestAjout")
	private Gestionnaires gestAjout;
	
	public Secretaires() {}
	public Secretaires(int idSecretaire, String nom, String prenom, String adresse, String telephone, String email,
			int codeId, String nationnalId, String compte, Gestionnaires gestAjout) {
		super();
		this.idSecretaire = idSecretaire;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.codeId = codeId;
		this.nationnalId = nationnalId;
		this.compte = compte;
		this.gestAjout = gestAjout;
	}
	
	
	public int getIdSecretaire() {
		return idSecretaire;
	}
	public void setIdSecretaire(int idSecretaire) {
		this.idSecretaire = idSecretaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCodeId() {
		return codeId;
	}
	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}
	public String getNationnalId() {
		return nationnalId;
	}
	public void setNationnalId(String nationnalId) {
		this.nationnalId = nationnalId;
	}
	public String getCompte() {
		return compte;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}
	public Gestionnaires getGestAjout() {
		return gestAjout;
	}
	public void setGestAjout(Gestionnaires gestAjout) {
		this.gestAjout = gestAjout;
	}
	
}
