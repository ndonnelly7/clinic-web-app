package com.cloud.clinic.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class Clinician implements java.io.Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Clinic clinic;
	
	@OneToMany(mappedBy = "clinician", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Patient> patients;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastLogin;
	
	@Id
	@Column(name = "clinicianID", unique = true, nullable = false)
	private String clinicianID;
	
	@Transient
	protected Object[] jdoDetachedState;

	public Clinician() {
		patients = new ArrayList<Patient>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String getClinicianID() {
		return clinicianID;
	}

	public void setClinicianID(String clinicianID) {
		this.clinicianID = clinicianID;
	}

	public Calendar getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Calendar lastLogin) {
		this.lastLogin = lastLogin;
	}
		
	public List<Integer> getPatientIDs(){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for(int i = 0; i < patients.size(); i++){
			ids.add(patients.get(i).getPatientID());
		}
		return ids;
	}
}
