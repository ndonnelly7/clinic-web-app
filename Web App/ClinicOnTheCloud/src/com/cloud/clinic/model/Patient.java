package com.cloud.clinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 * Patient Class used by Program
 * This class is what's stored in the SQL
 */
@Entity(name="Patient")
public class Patient implements java.io.Serializable{
	
	@Transient
	private static final long serialVersionUID = 8153440730792060761L;

	@Id
	@Column(name = "patientID", unique = true, nullable = false)
	private int patientID;	
	
	//Supposed to hold a reference to the clinician that created it
	@ManyToOne(fetch = FetchType.LAZY)
	private Clinician clinician;
	
	//Holds a reference to the original clinic
	@ManyToOne(fetch = FetchType.LAZY)
	private Clinic clinic;
	
	//Mapping to all the forms correspond to the patient
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Form> forms;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	public Patient(){
		forms = new ArrayList<Form>();
	}
	

	public int getPatientID() {
		return patientID;
	}


	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}


	public Clinician getClinician() {
		return clinician;
	}


	public void setClinician(Clinician clinician) {
		this.clinician = clinician;
	}


	public Clinic getClinic() {
		return clinic;
	}


	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}


	public List<Form> getForms() {
		return forms;
	}


	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public void addForm(Form f) {
		forms.add(f);
	}
}
