package com.centreFormat.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
public class FormationsPrerequises {
	
	@Id
	int id;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="IdFormationPrerequise")
	private Formations formationPrerequise;

	@Nullable
	@ManyToOne
	@JoinColumn(name="IdFormationActuel")
	private Formations formationActuel;

	public FormationsPrerequises(int id, Formations formationPrerequise, Formations formationActuel) {
		super();
		this.id = id;
		this.formationPrerequise = formationPrerequise;
		this.formationActuel = formationActuel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Formations getFormationPrerequise() {
		return formationPrerequise;
	}

	public void setFormationPrerequise(Formations formationPrerequise) {
		this.formationPrerequise = formationPrerequise;
	}

	public Formations getFormationActuel() {
		return formationActuel;
	}

	public void setFormationActuel(Formations formationActuel) {
		this.formationActuel = formationActuel;
	}
	
	
}
