package com.cloud.clinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/*
 * 
 * Represents a clinic
 * 
 * Getters and setters mostly
 * 
 */

@Entity
public class Clinic implements java.io.Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ClinicID", unique = true, nullable = false)
	private String clinicName;
	
	private String hashedPassword;
	
	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Clinician> clinicians;
	
	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Patient> patients;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	public Clinic() {
		clinicians = new ArrayList<Clinician>();
		patients = new ArrayList<Patient>();
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public List<Clinician> getClinicians() {
		return clinicians;
	}

	public void setClinicians(List<Clinician> clinicians) {
		this.clinicians = clinicians;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}	
}
