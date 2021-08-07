package org.ids.entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity

@Data  @AllArgsConstructor @NoArgsConstructor @ToString 
public class Medecin extends Personne {

	private static final long serialVersionUID = 5339605626082722198L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
	private long idMedecin;
	
	private String medecinId;
	
	@OneToMany(mappedBy = "medecin")
	private List <Fiche> fiches ;
	
	@OneToMany(mappedBy = "medecin")
	private List <RendezVous> rendezVous ;
	
	@ManyToOne
	private Specialite specialite;
	
//@ManyToMany(mappedBy = "medecin", fetch=FetchType.EAGER)
	//private List <Patient> patients ;
	
	@ManyToMany
	@JoinTable(
			  name = "consultation", 
			  joinColumns =@JoinColumn(name = "medecin_id"), 
			  inverseJoinColumns=@JoinColumn(name = "patient_id")
			)
	private List <Patient> patients ;
	
	@OneToMany(mappedBy = "medecin")
	private List <Infirmier> infirmiers ;

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(String nom, String prenom, String telephone, int age, String password, String province,
			String region, String centre, Date dateCreation, String cnss, String cin) {
		super(nom, prenom, telephone, age, password, province, region, centre, dateCreation, cnss, cin);
		// TODO Auto-generated constructor stub
	}

	public long getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getMedecinId() {
		return medecinId;
	}

	public void setMedecinId(String medecinId) {
		this.medecinId = medecinId;
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

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Infirmier> getInfirmiers() {
		return infirmiers;
	}

	public void setInfirmiers(List<Infirmier> infirmiers) {
		this.infirmiers = infirmiers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Medecin(long idMedecin, String medecinId, List<Fiche> fiches, List<RendezVous> rendezVous,
			Specialite specialite, List<Patient> patients, List<Infirmier> infirmiers) {
		super();
		this.idMedecin = idMedecin;
		this.medecinId = medecinId;
		this.fiches = fiches;
		this.rendezVous = rendezVous;
		this.specialite = specialite;
		this.patients = patients;
		this.infirmiers = infirmiers;
	}

	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", medecinId=" + medecinId + ", fiches=" + fiches + ", rendezVous="
				+ rendezVous + ", specialite=" + specialite + ", patients=" + patients + ", infirmiers=" + infirmiers
				+ "]";
	}
	
	// add convenience methods for bi-directional relationship

			public void add(Fiche tempFiche) {
				
				if (fiches == null) {
					fiches = new ArrayList<>();
				}
				
				fiches.add(tempFiche);
				
				tempFiche.setMedecin(this);
			}
	
			// add convenience methods for bi-directional relationship

			public void add(Infirmier tempInfirmier) {
				
				if (infirmiers == null) {
					infirmiers = new ArrayList<>();
				}
				
				infirmiers.add(tempInfirmier);
				
				tempInfirmier.setMedecin(this);
			}
			
			// add convenience methods for bi-directional relationship

			public void add(RendezVous tempRendezVous) {
				
				if (rendezVous == null) {
					rendezVous = new ArrayList<>();
				}
				
				rendezVous.add(tempRendezVous);
				
				tempRendezVous.setMedecin(this);
			}
			
			// add a convenience method
			
			public void addStudent(Patient thePatient) {
				
				if (patients == null) {
					patients = new ArrayList<>();
				}
				
				patients.add(thePatient);
	

}
}
