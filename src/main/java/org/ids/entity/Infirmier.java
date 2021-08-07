package org.ids.entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Infirmier extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = -854547182136097196L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long idInfirmier;

	@ManyToMany( mappedBy = "infirmiers")
	private List <Patient> patients ;
	
	@OneToMany(mappedBy = "infirmier")
	private List <Fiche> fiches ;
	
	@OneToMany(mappedBy = "infirmier")
	private List <RendezVous> rendezVous ;
	
	@ManyToOne
	private Medecin  medecin;

	public Infirmier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Infirmier(String nom, String prenom, String telephone, int age, String password, String province,
			String region, String centre, Date dateCreation, String cnss, String cin) {
		super(nom, prenom, telephone, age, password, province, region, centre, dateCreation, cnss, cin);
		// TODO Auto-generated constructor stub
	}

	public long getIdInfirmier() {
		return idInfirmier;
	}

	public void setIdInfirmier(long idInfirmier) {
		this.idInfirmier = idInfirmier;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Infirmier(long idInfirmier, List<Patient> patients, List<Fiche> fiches, List<RendezVous> rendezVous,
			Medecin medecin) {
		super();
		this.idInfirmier = idInfirmier;
		this.patients = patients;
		this.fiches = fiches;
		this.rendezVous = rendezVous;
		this.medecin = medecin;
	}

	@Override
	public String toString() {
		return "Infirmier [idInfirmier=" + idInfirmier + ", patients=" + patients + ", fiches=" + fiches
				+ ", rendezVous=" + rendezVous + ", medecin=" + medecin + "]";
	}
	
	// add convenience methods for bi-directional relationship

			public void add(Fiche tempFiche) {
				
				if (fiches == null) {
					fiches = new ArrayList<>();
				}
				
				fiches.add(tempFiche);
				
				tempFiche.setInfirmier(this);
			}
			
			// add convenience methods for bi-directional relationship

			public void add(RendezVous tempRendezVous) {
				
				if (rendezVous == null) {
					rendezVous= new ArrayList<>();
				}
				
				rendezVous.add(tempRendezVous);
				
				tempRendezVous.setInfirmier(this);
			}
}
