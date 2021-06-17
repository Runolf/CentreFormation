package com.centreFormat.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.centreFormat.tools.Password;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idStagiaire")
//@Table(name = "Stagiaires")
public class Stagiaires {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdStagiaire; 
	private String nom;
	private String prenom;
	private String Adresse;
	private String telephone;
	//@Nullable
	private String email;
	private int CodeId;
	//@Nullable
	private String pass;
	
	@ManyToOne
	@JoinColumn(name="IdStatut")
	private Statuts idStatut;
	
	@OneToMany(mappedBy="stagiaire")
	private Set<Inscriptions> inscriptions;
	
	
	public Stagiaires() {}
	public Stagiaires(int idStagiaire, String nom, String prenom, String adresse, String telephone, String email,
			int codeId, Statuts idStatut) {
		super();
		IdStagiaire = idStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		Adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		CodeId = codeId;
		this.idStatut = idStatut;
	}

	
	public String hashPswd() {
		Password pswd = new Password(pass);
		pswd.firstHash();
		this.pass = pswd.getHash();
		
		System.out.println(this.pass);
		
		return this.pass;
	}
	
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = password;
	}
	public void setIdStagiaire(int idStagiaire) {
		IdStagiaire = idStagiaire;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCodeId(int codeId) {
		CodeId = codeId;
	}

	public void setIdStatut(Statuts idStatut) {
		this.idStatut = idStatut;
	}


	public int getIdStagiaire() {
		return IdStagiaire;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return Adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public int getCodeId() {
		return CodeId;
	}

	public Statuts getIdStatut() {
		return idStatut;
	}
	public Set<Inscriptions> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<Inscriptions> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	
	
	
}
