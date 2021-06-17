package com.centreFormat.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idInscription")
public class Inscriptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInscription;
	
	@Column(name="EstPayee")
	private boolean estPayee;
	private double prixActuel;
	
	/*
	@JsonIgnore
	private Date dateInscription;
	*/
	@ManyToOne
	@JoinColumn(name="IdStagiaire")
	private Stagiaires stagiaire;
	
	@ManyToOne
	@JoinColumn(name="IdSession")
	private Sessions sessions;

	public Inscriptions() {}
	public Inscriptions(int idInscription, boolean isPayee, double prixActuel,
			Stagiaires stagiaire, Sessions session) {
		super();
		this.idInscription = idInscription;
		this.estPayee = isPayee;
		this.prixActuel = prixActuel;
		this.stagiaire = stagiaire;
		this.sessions = session;
	}

	public int getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public boolean estPayee() {
		return estPayee;
	}

	public void setPayee(boolean isPayee) {
		this.estPayee = isPayee;
	}

	public double getPrixActuel() {
		return prixActuel;
	}

	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}

	public Stagiaires getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaires stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Sessions getSession() {
		return sessions;
	}

	public void setSession(Sessions session) {
		this.sessions = session;
	}
	
}
