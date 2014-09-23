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
 * 
 * Outcome bean for Analysis
 * 
 */

@Entity
public class Outcome implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "outcomeID", unique = true, nullable = false)
	private int outcomeID;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	Analysis analysis;
	
	@Transient
	protected Object[] jdoDetachedState;

	@Expose
	String outcome;
	@Expose
	@Column(columnDefinition="TEXT")
	String outcome_notes;
	
	public Outcome() {
		
	}

	public int getOutcomeID() {
		return outcomeID;
	}

	public void setOutcomeID(int outcomeID) {
		this.outcomeID = outcomeID;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getOutcome_notes() {
		return outcome_notes;
	}

	public void setOutcome_notes(String outcome_notes) {
		this.outcome_notes = outcome_notes;
	}
	
	
}
