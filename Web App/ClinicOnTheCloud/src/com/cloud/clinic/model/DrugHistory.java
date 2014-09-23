package com.cloud.clinic.model;

import java.io.Serializable;

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
 * Used for medical history of any medication taken
 */
@Entity
public class DrugHistory implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drugHistoryID", unique = true, nullable = false)
	int	drugHistoryID;

	@Transient
	protected Object[] jdoDetachedState;

	@ManyToOne(fetch = FetchType.LAZY)
	PatientHistory pHistory;
	
	@Expose
	String drug, time, notes, sleep_med, benzo_med;
	
	//Used to define Collateral Drug History on DB
	@Expose
	boolean collat;
	
	public boolean isCollat() {
		return collat;
	}

	public void setCollat(boolean collat) {
		this.collat = collat;
	}

	public DrugHistory(){
		
	}

	public int getDrugHistoryID() {
		return drugHistoryID;
	}

	public void setDrugHistoryID(int drugHistoryID) {
		this.drugHistoryID = drugHistoryID;
	}
	
	public PatientHistory getpHistory() {
		return pHistory;
	}

	public void setpHistory(PatientHistory pHistory) {
		this.pHistory = pHistory;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
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
	
	public String getSleep_med() {
		return sleep_med;
	}

	public void setSleep_med(String sleep_med) {
		this.sleep_med = sleep_med;
	}

	public String getBenzo_med() {
		return benzo_med;
	}

	public void setBenzo_med(String benzo_med) {
		this.benzo_med = benzo_med;
	}
}
