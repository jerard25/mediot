package org.ids.entity;

import java.io.Serializable;



import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

public class Message implements Serializable {

	private static final long serialVersionUID = -1814602136747224775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idMessage;
	@Column(nullable = false)
	private Date dateEnvoi;
	@Column(nullable = false)
	private String contenu;
	
	@OneToOne
	private Patient  patient;
	
	@OneToOne(mappedBy = "message")
	private RendezVous  rendezVous;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Message(int idMessage, Date dateEnvoi, String contenu, Patient patient, RendezVous rendezVous) {
		super();
		this.idMessage = idMessage;
		this.dateEnvoi = dateEnvoi;
		this.contenu = contenu;
		this.patient = patient;
		this.rendezVous = rendezVous;
	}

	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", dateEnvoi=" + dateEnvoi + ", contenu=" + contenu + ", patient="
				+ patient + ", rendezVous=" + rendezVous + "]";
	}
	
	
	

}
