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
 * Bean for Impression object
 * Parent is the Analysis
 * 
 */

@Entity
public class Impression implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "impressionID", unique = true, nullable = false)
	private int impressionID;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	Analysis analysis;
	
	@Transient
	protected Object[] jdoDetachedState;

	@Expose
	String impression;
	@Expose
	@Column(columnDefinition="TEXT")
	String impression_notes;
	
	public Impression() {
		
	}

	public int getImpressionID() {
		return impressionID;
	}

	public void setImpressionID(int impressionID) {
		this.impressionID = impressionID;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getImpression_notes() {
		return impression_notes;
	}

	public void setImpression_notes(String impression_notes) {
		this.impression_notes = impression_notes;
	}
	
	
}
