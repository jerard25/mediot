package org.ids.entity;

import java.io.Serializable;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RendezVous implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6419102273606030960L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int IdRendezVous;
	@Column(nullable = false)
	private Date dateConsultation;
	@Column(nullable = false)
	private String statut;
	@Column(nullable = false)
	private String description;

	private LocalTime heureDebut;
	private LocalTime heureFin;

	@ManyToOne
	private Medecin medecin;
	
	@OneToOne
	private Message message  ;
	
	@ManyToOne
	private Infirmier infirmier;

	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdRendezVous() {
		return IdRendezVous;
	}

	public void setIdRendezVous(int idRendezVous) {
		IdRendezVous = idRendezVous;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Infirmier getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(Infirmier infirmier) {
		this.infirmier = infirmier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RendezVous(int idRendezVous, Date dateConsultation, String statut, String description, LocalTime heureDebut,
			LocalTime heureFin, Medecin medecin, Message message, Infirmier infirmier) {
		super();
		IdRendezVous = idRendezVous;
		this.dateConsultation = dateConsultation;
		this.statut = statut;
		this.description = description;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.medecin = medecin;
		this.message = message;
		this.infirmier = infirmier;
	}

	@Override
	public String toString() {
		return "RendezVous [IdRendezVous=" + IdRendezVous + ", dateConsultation=" + dateConsultation + ", statut="
				+ statut + ", description=" + description + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin
				+ ", medecin=" + medecin + ", message=" + message + ", infirmier=" + infirmier + "]";
	}
	
	
}
