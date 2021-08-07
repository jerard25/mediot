package org.ids.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Specialite implements Serializable {
	private static final long serialVersionUID = -1814602136747224775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSpecialite;
	@Column(unique = true, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy = "specialite")
	private List <Medecin> medecins ;

	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Medecin> getMedecins() {
		return medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Specialite(int idSpecialite, String nom, List<Medecin> medecins) {
		super();
		this.idSpecialite = idSpecialite;
		this.nom = nom;
		this.medecins = medecins;
	}

	@Override
	public String toString() {
		return "Specialite [idSpecialite=" + idSpecialite + ", nom=" + nom + ", medecins=" + medecins + "]";
	}
	
	// add convenience methods for bi-directional relationship

			public void add(Medecin tempMedecin) {
				
				if (medecins == null) {
					medecins = new ArrayList<>();
				}
				
				medecins.add(tempMedecin);
				
				tempMedecin.setSpecialite(this);
			}

}
