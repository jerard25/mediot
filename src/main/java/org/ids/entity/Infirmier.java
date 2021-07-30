package org.ids.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

  @AllArgsConstructor @NoArgsConstructor @ToString
public class Infirmier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true,nullable = false)
	private long idInfirmier;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private  String telephone;
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
	@Column(unique = true,nullable = false)
	private String cin;
	@Column(unique = true,nullable = false)
	private String cnss;
	
}
