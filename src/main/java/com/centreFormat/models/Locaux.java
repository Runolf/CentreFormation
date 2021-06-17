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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idLocal")
public class Locaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLocal;
	
	private String nom; 
	private int etage;
	private boolean estPermanent;
	
	@ManyToOne
	@JoinColumn(name="IdType")
	private Types type;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestAjout")
	private Gestionnaires GestAjout;

	@OneToMany(mappedBy="idLocal")
	private Set<Sessions> sessions;
	
	public Locaux() {}
	public Locaux(int idLocal, String nom, int etage, boolean estPermanent, Types type, Gestionnaires gestAjout) {
		super();
		this.idLocal = idLocal;
		this.nom = nom;
		this.etage = etage;
		this.estPermanent = estPermanent;
		this.type = type;
		GestAjout = gestAjout;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public boolean isEstPermanent() {
		return estPermanent;
	}

	public void setEstPermanent(boolean estPermanent) {
		this.estPermanent = estPermanent;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public Gestionnaires getGestAjout() {
		return GestAjout;
	}

	public void setGestAjout(Gestionnaires gestAjout) {
		GestAjout = gestAjout;
	}

	public Set<Sessions> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Sessions> sessions) {
		this.sessions = sessions;
	}
	
	
}
