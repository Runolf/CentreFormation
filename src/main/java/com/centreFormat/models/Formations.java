package com.centreFormat.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFormation")
public class Formations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idFormation;
	
	String intitule;
	int duree;
	double prixBase;
	int maxInscription;
	int minEleve;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date dateCrea;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date dateCloture;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestAjout")
	private Gestionnaires GestAjout;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestModif")
	private Gestionnaires GestModif;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestDelete")
	private Gestionnaires GestDelete;
	
	@OneToMany(mappedBy="idFormation")
	private Set<Sessions> sessions;

	@OneToMany(mappedBy="formationPrerequise")
	private Set<FormationsPrerequises> formationsPrerequises;
	
	
	public Formations() {}
	public Formations(int idFormation, String intitule, int duree, double prixBase, int maxInscription, int minEleve,
			Date dateCrea, Date dateCloture, Gestionnaires gestAjout, Gestionnaires gestModif,
			Gestionnaires gestDelete) {
		super();
		this.idFormation = idFormation;
		this.intitule = intitule;
		this.duree = duree;
		this.prixBase = prixBase;
		this.maxInscription = maxInscription;
		this.minEleve = minEleve;
		this.dateCrea = dateCrea;
		this.dateCloture = dateCloture;
		GestAjout = gestAjout;
		GestModif = gestModif;
		GestDelete = gestDelete;
	}

	
	
	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getPrixBase() {
		return prixBase;
	}

	public void setPrixBase(double prixBase) {
		this.prixBase = prixBase;
	}

	public int getMaxInscription() {
		return maxInscription;
	}

	public void setMaxInscription(int maxInscription) {
		this.maxInscription = maxInscription;
	}

	public int getMinEleve() {
		return minEleve;
	}

	public void setMinEleve(int minEleve) {
		this.minEleve = minEleve;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
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

	public Gestionnaires getGestDelete() {
		return GestDelete;
	}

	public void setGestDelete(Gestionnaires gestDelete) {
		GestDelete = gestDelete;
	}


	public Set<Sessions> getSessions() {
		return sessions;
	}


	public void setSessions(Set<Sessions> sessions) {
		this.sessions = sessions;
	}
	
	
	
}	
