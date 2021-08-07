package org.ids.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Fiche implements Serializable {

	private static final long serialVersionUID = -1814602136747224775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idFiche;
	@Column(nullable = false)
	private String courbe;
	@Column(nullable = false)
	private Date dateCreation;
	
	@ManyToOne
	private Medecin medecin;
	
	@ManyToOne
	private Infirmier infirmier;
	
	@ManyToOne
	private Patient patient;

	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getCourbe() {
		return courbe;
	}

	public void setCourbe(String courbe) {
		this.courbe = courbe;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Infirmier getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(Infirmier infirmier) {
		this.infirmier = infirmier;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Fiche(int idFiche, String courbe, Date dateCreation, Medecin medecin, Infirmier infirmier, Patient patient) {
		super();
		this.idFiche = idFiche;
		this.courbe = courbe;
		this.dateCreation = dateCreation;
		this.medecin = medecin;
		this.infirmier = infirmier;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Fiche [idFiche=" + idFiche + ", courbe=" + courbe + ", dateCreation=" + dateCreation + ", medecin="
				+ medecin + ", infirmier=" + infirmier + ", patient=" + patient + "]";
	}


	
	
	
	

}
