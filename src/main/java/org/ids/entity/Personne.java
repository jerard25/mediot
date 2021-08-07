package org.ids.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Personne implements Serializable {

	
	private static final long serialVersionUID = -706804440768761254L;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private String telephone;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String province;
	@Column(nullable = false)
	private String region;
	@Column(nullable = false)
	private String centre;
	@Column(nullable = false)
	private Date dateCreation;
	@Column(unique = true, nullable = false)
	private String cnss;
	@Column(unique = true, nullable = false)
	private String cin;
	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCentre() {
		return centre;
	}

	public void setCentre(String centre) {
		this.centre = centre;
	}

	public Date getDateCreation() {
		return dateCreation;
	}




	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Personne(String nom, String prenom, String telephone, int age, String password, String province,
			String region, String centre, Date dateCreation, String cnss, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.age = age;
		this.password = password;
		this.province = province;
		this.region = region;
		this.centre = centre;
		this.dateCreation = dateCreation;
		this.cnss = cnss;
		this.cin = cin;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", age=" + age
				+ ", password=" + password + ", province=" + province + ", region=" + region + ", centre=" + centre
				+ ", dateCreation=" + dateCreation + ", cnss=" + cnss + ", cin=" + cin + "]";
	}

}
