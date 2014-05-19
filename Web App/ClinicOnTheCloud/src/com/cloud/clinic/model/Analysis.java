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
 * Representative of the Patient Analysis page of the form
 */
@Entity
public class Analysis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "analysisID", unique = true, nullable = false)
	private int analysisID;
	
	@OneToOne(fetch = FetchType.LAZY)
	Form form;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	@Expose
	String mmse_result, moca_result, gds_result, hads_result;
	@Expose
	String follow_up, follow_notes;
	
	@Expose
	@OneToMany(mappedBy = "analysis", cascade = CascadeType.ALL)
	List<Outcome> outcomes;
	
	@Expose
	@OneToMany(mappedBy = "analysis", cascade = CascadeType.ALL)
	List<Impression> impressions;
	
	@Expose
	@Column(name = "letter", columnDefinition="TEXT")
	String letter;
	@Expose
	@Column(name = "notes", columnDefinition="TEXT")
	String notes;
	
	public Analysis()
	{
		
	}

	public int getAnalysisID() {
		return analysisID;
	}

	public void setAnalysisID(int analysisID) {
		this.analysisID = analysisID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getMmse_result() {
		return mmse_result;
	}

	public void setMmse_result(String mmse_result) {
		this.mmse_result = mmse_result;
	}

	public String getMoca_result() {
		return moca_result;
	}

	public void setMoca_result(String moca_result) {
		this.moca_result = moca_result;
	}

	public String getGds_result() {
		return gds_result;
	}

	public void setGds_result(String gds_result) {
		this.gds_result = gds_result;
	}

	public String getHads_result() {
		return hads_result;
	}

	public void setHads_result(String hads_result) {
		this.hads_result = hads_result;
	}

	public List<Impression> getImpressions() {
		return impressions;
	}

	public void setImpressions(List<Impression> impressions) {
		this.impressions = impressions;
	}

	public String getFollow_up() {
		return follow_up;
	}

	public void setFollow_up(String follow_up) {
		this.follow_up = follow_up;
	}

	public String getFollow_notes() {
		return follow_notes;
	}

	public void setFollow_notes(String follow_notes) {
		this.follow_notes = follow_notes;
	}

	public String getLetter() {
		return letter;
	}

	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
