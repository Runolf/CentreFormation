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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSession")
public class Sessions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSession;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="IdFormateur")
	private Formateurs idFormateur;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="IdLocal")
	private Locaux idLocal;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="IdFormation")
	private Formations idFormation;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestAjout")
	private Gestionnaires GestAjout;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="GestModif")
	private Gestionnaires GestModif;
	
	@OneToMany(mappedBy="sessions")
	private Set<Inscriptions> inscriptions;
	
	
	public Sessions() {}
	public Sessions(int idSession, Date startDate, Date endDate, Formateurs idFormateur, Locaux idLocal,
			Formations idFormation, Gestionnaires gestAjout, Gestionnaires gestModif) {
		super();
		this.idSession = idSession;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idFormateur = idFormateur;
		this.idLocal = idLocal;
		this.idFormation = idFormation;
		GestAjout = gestAjout;
		GestModif = gestModif;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Formateurs getIdFormateur() {
		return idFormateur;
	}
	public void setIdFormateur(Formateurs idFormateur) {
		this.idFormateur = idFormateur;
	}
	public Locaux getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Locaux idLocal) {
		this.idLocal = idLocal;
	}
	public Formations getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(Formations idFormation) {
		this.idFormation = idFormation;
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
	public Set<Inscriptions> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<Inscriptions> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	
	

}
