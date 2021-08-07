package org.ids.entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@DiscriminatorValue("Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = -250173034612508724L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long idPatient;

	@OneToOne(mappedBy = "patient")
	private Message message;
	
	@ManyToMany( mappedBy = "patients")
	private List <Medecin> medecins ;
	
	@ManyToMany
	@JoinTable(
			  name = "patient_inf", 
			  joinColumns =@JoinColumn(name = "infirmier_id"), 
			  inverseJoinColumns=@JoinColumn(name = "patients_id")
			)
	private List <Infirmier> infirmiers ;
	
	@OneToMany(mappedBy = "patient")
	private List <Fiche> fiches ;

	

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String nom, String prenom, String telephone, int age, String password, String province,
			String region, String centre, Date dateCreation, String cnss, String cin) {
		super(nom, prenom, telephone, age, password, province, region, centre, dateCreation, cnss, cin);
		// TODO Auto-generated constructor stub
	}

	public long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Medecin> getMedecins() {
		return medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	public List<Infirmier> getInfirmiers() {
		return infirmiers;
	}

	public void setInfirmiers(List<Infirmier> infirmiers) {
		this.infirmiers = infirmiers;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Patient(long idPatient, Message message, List<Medecin> medecins, List<Infirmier> infirmiers,
			List<Fiche> fiches) {
		super();
		this.idPatient = idPatient;
		this.message = message;
		this.medecins = medecins;
		this.infirmiers = infirmiers;
		this.fiches = fiches;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", message=" + message + ", medecins=" + medecins + ", infirmiers="
				+ infirmiers + ", fiches=" + fiches + "]";
	}

	// add convenience methods for bi-directional relationship

			public void add(Fiche tempFiche) {
				
				if (fiches == null) {
					fiches = new ArrayList<>();
				}
				
				fiches.add(tempFiche);
				
				tempFiche.setPatient(this);
			}
	
	
	

	
}
