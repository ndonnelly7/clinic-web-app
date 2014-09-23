package com.cloud.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * Medical History class used for the patient's history
 */

@Entity
public class MedHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medHistoryID", unique = true, nullable = false)
	int medHistoryID;

	@Transient
	protected Object[] jdoDetachedState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	PatientHistory pHistory;

	@Expose
	@Column(name = "ailment")
	String condition;
	@Expose
	String time, notes;
	
	//denotes whether a Medical History row is collateral on the DB
	@Expose
	boolean collat;
	
	public MedHistory() {
		
	}

	public int getMedHistoryID() {
		return medHistoryID;
	}

	public void setMedHistoryID(int medHistoryID) {
		this.medHistoryID = medHistoryID;
	}
	
	public PatientHistory getpHistory() {
		return pHistory;
	}

	public void setpHistory(PatientHistory pHistory) {
		this.pHistory = pHistory;
	}

	public boolean isCollat() {
		return collat;
	}

	public void setCollat(boolean collat) {
		this.collat = collat;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
