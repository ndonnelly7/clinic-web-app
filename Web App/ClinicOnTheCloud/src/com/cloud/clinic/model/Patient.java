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
	
	private String userCreatedID;
	private String originalClinic;
	
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

	
	public String getOriginalClinic() {
		return originalClinic;
	}


	public void setOriginalClinic(String originalClinic) {
		this.originalClinic = originalClinic;
	}


	public String getUserCreatedID() {
		return userCreatedID;
	}


	public void setUserCreatedID(String userCreatedID) {
		this.userCreatedID = userCreatedID;
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
