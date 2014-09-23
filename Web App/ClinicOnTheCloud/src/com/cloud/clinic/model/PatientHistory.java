package com.cloud.clinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * Used to represent the Patient's Medical history, including Drug History, Medical History and Psych History
 */

@Entity
public class PatientHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "historyID", unique = true, nullable = false)
	int historyID;

	@Transient
	protected Object[] jdoDetachedState;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Form form;
	
	
	//Children tables
	@Expose
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pHistory")
	List<MedHistory> med_histories, med_collat_histories;
	@Expose
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pHistory")
	List<DrugHistory> drug_histories, drug_collat_histories;
	@Expose
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pHistory")
	List<PsychHistory> psych_histories, psych_collat_histories;
	
	@Expose
	String current_therapy_check, past_therapy_check;
	@Expose
	String collat_current_therapy_check, collat_past_therapy_check;
	
	public PatientHistory(){
	}
	
	public int getHistoryID() {
		return historyID;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<MedHistory> getMed_histories() {
		return med_histories;
	}

	public void setMed_histories(List<MedHistory> med_histories) {
		this.med_histories = med_histories;
	}

	public List<MedHistory> getMed_collat_histories() {
		return med_collat_histories;
	}

	public void setMed_collat_histories(List<MedHistory> med_collat_histories) {
		this.med_collat_histories = med_collat_histories;
	}

	public List<DrugHistory> getDrug_histories() {
		return drug_histories;
	}

	public void setDrug_histories(List<DrugHistory> drug_histories) {
		this.drug_histories = drug_histories;
	}

	public List<DrugHistory> getDrug_collat_histories() {
		return drug_collat_histories;
	}

	public void setDrug_collat_histories(List<DrugHistory> drug_collat_histories) {
		this.drug_collat_histories = drug_collat_histories;
	}

	public List<PsychHistory> getPsych_histories() {
		return psych_histories;
	}

	public void setPsych_histories(List<PsychHistory> psych_histories) {
		this.psych_histories = psych_histories;
	}

	public List<PsychHistory> getPsych_collat_histories() {
		return psych_collat_histories;
	}

	public void setPsych_collat_histories(List<PsychHistory> psych_collat_histories) {
		this.psych_collat_histories = psych_collat_histories;
	}

	public String getCurrent_therapy_check() {
		return current_therapy_check;
	}

	public void setCurrent_therapy_check(String current_therapy_check) {
		this.current_therapy_check = current_therapy_check;
	}

	public String getPast_therapy_check() {
		return past_therapy_check;
	}

	public void setPast_therapy_check(String past_therapy_check) {
		this.past_therapy_check = past_therapy_check;
	}

	public String getCollat_current_therapy_check() {
		return collat_current_therapy_check;
	}

	public void setCollat_current_therapy_check(String collat_current_therapy_check) {
		this.collat_current_therapy_check = collat_current_therapy_check;
	}

	public String getCollat_past_therapy_check() {
		return collat_past_therapy_check;
	}

	public void setCollat_past_therapy_check(String collat_past_therapy_check) {
		this.collat_past_therapy_check = collat_past_therapy_check;
	}
	
	
}
