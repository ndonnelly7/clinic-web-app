package com.cloud.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * Concerns Bean for the Concerns page of the form
 */
@Entity
public class Concerns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "concernsID", unique = true, nullable = false)
	int concernsID;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Form form;

	@Transient
	protected Object[] jdoDetachedState;
	
	@Expose
	String wants_memory_investigation;
	@Expose
	boolean rec_events_check, faces_check, names_check, losing_things_check, follow_conv_check;
	@Expose
	boolean right_words_check, decisions_check, calculations_check, prospective_check, anxiety_check, comments_check;
	
	@Expose
	String rec_events_time, rec_events_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String rec_events_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String rec_events_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String rec_events_notes;
	
	@Expose
	String faces_time, faces_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String faces_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String faces_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String faces_notes;
	
	@Expose
	String names_time, names_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String names_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String names_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String names_notes;

	@Expose
	String losing_things_time, losing_things_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String losing_things_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String losing_things_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String losing_things_notes;

	@Expose
	String follow_conv_time, follow_conv_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String follow_conv_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String follow_conv_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String follow_conv_notes;

	@Expose
	String right_words_time, right_words_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String right_words_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String right_words_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String right_words_notes;
	
	@Expose	
	String decisions_time, decisions_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String decisions_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String decisions_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String decisions_notes;

	@Expose
	String calculations_time, calculations_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String calculations_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String calculations_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String calculations_notes;

	@Expose
	String prospective_time, prospective_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String prospective_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String prospective_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String prospective_notes;

	@Expose
	String anxiety_time, anxiety_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String anxiety_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String anxiety_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String anxiety_notes;

	@Expose
	String comments_time, comments_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String comments_severity;
	@Expose
	@Column(columnDefinition="TEXT")
	String comments_worsening;
	@Expose
	@Column(columnDefinition="TEXT")
	String comments_notes;

	@Expose
	boolean rec_events_check_collat, faces_check_collat, names_check_collat, losing_things_check_collat, follow_conv_check_collat;

	@Expose
	boolean right_words_check_collat, decisions_check_collat, calculations_check_collat, prospective_check_collat, anxiety_check_collat, comments_check_collat;

	@Expose
	String rec_events_time_collat, rec_events_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String rec_events_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String rec_events_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String rec_events_notes_collat;

	@Expose
	String faces_time_collat, faces_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String faces_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String faces_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String faces_notes_collat;

	@Expose
	String names_time_collat, names_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String names_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String names_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String names_notes_collat;

	@Expose
	String losing_things_time_collat, losing_things_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String losing_things_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String losing_things_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String losing_things_notes_collat;

	@Expose
	String follow_conv_time_collat, follow_conv_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String follow_conv_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String follow_conv_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String follow_conv_notes_collat;

	@Expose
	String right_words_time_collat, right_words_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String right_words_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String right_words_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String right_words_notes_collat;

	@Expose
	String decisions_time_collat, decisions_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String decisions_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String decisions_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String decisions_notes_collat;

	@Expose
	String calculations_time_collat, calculations_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String calculations_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String calculations_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String calculations_notes_collat;

	@Expose
	String prospective_time_collat, prospective_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String prospective_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String prospective_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String prospective_notes_collat;

	@Expose
	String anxiety_time_collat, anxiety_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String anxiety_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String anxiety_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String anxiety_notes_collat;

	@Expose
	String comments_time_collat, comments_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String comments_severity_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String comments_worsening_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String comments_notes_collat;
	
	@Expose
	String most_impactful_concern, most_impactful_concern_collat;
	
	public Concerns(){
		
	}

	public int getConcernsID() {
		return concernsID;
	}

	public void setConcernsID(int concernsID) {
		this.concernsID = concernsID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}
	
	public String getMost_impactful_concern() {
		return most_impactful_concern;
	}

	public void setMost_impactful_concern(String most_impactful_concern) {
		this.most_impactful_concern = most_impactful_concern;
	}

	public String getMost_impactful_concern_collat() {
		return most_impactful_concern_collat;
	}

	public void setMost_impactful_concern_collat(
			String most_impactful_concern_collat) {
		this.most_impactful_concern_collat = most_impactful_concern_collat;
	}

	public String getWants_memory_investigation() {
		return wants_memory_investigation;
	}

	public void setWants_memory_investigation(String wants_memory_investigation) {
		this.wants_memory_investigation = wants_memory_investigation;
	}

	public boolean isRec_events_check() {
		return rec_events_check;
	}

	public String getRec_events_severity() {
		return rec_events_severity;
	}

	public void setRec_events_severity(String rec_events_severity) {
		this.rec_events_severity = rec_events_severity;
	}

	public String getRec_events_worsening() {
		return rec_events_worsening;
	}

	public void setRec_events_worsening(String rec_events_worsening) {
		this.rec_events_worsening = rec_events_worsening;
	}

	public String getFaces_severity() {
		return faces_severity;
	}

	public void setFaces_severity(String faces_severity) {
		this.faces_severity = faces_severity;
	}

	public String getFaces_worsening() {
		return faces_worsening;
	}

	public void setFaces_worsening(String faces_worsening) {
		this.faces_worsening = faces_worsening;
	}

	public String getNames_severity() {
		return names_severity;
	}

	public void setNames_severity(String names_severity) {
		this.names_severity = names_severity;
	}

	public String getNames_worsening() {
		return names_worsening;
	}

	public void setNames_worsening(String names_worsening) {
		this.names_worsening = names_worsening;
	}

	public String getLosing_things_severity() {
		return losing_things_severity;
	}

	public void setLosing_things_severity(String losing_things_severity) {
		this.losing_things_severity = losing_things_severity;
	}

	public String getLosing_things_worsening() {
		return losing_things_worsening;
	}

	public void setLosing_things_worsening(String losing_things_worsening) {
		this.losing_things_worsening = losing_things_worsening;
	}

	public String getFollow_conv_severity() {
		return follow_conv_severity;
	}

	public void setFollow_conv_severity(String follow_conv_severity) {
		this.follow_conv_severity = follow_conv_severity;
	}

	public String getFollow_conv_worsening() {
		return follow_conv_worsening;
	}

	public void setFollow_conv_worsening(String follow_conv_worsening) {
		this.follow_conv_worsening = follow_conv_worsening;
	}

	public String getRight_words_severity() {
		return right_words_severity;
	}

	public void setRight_words_severity(String right_words_severity) {
		this.right_words_severity = right_words_severity;
	}

	public String getRight_words_worsening() {
		return right_words_worsening;
	}

	public void setRight_words_worsening(String right_words_worsening) {
		this.right_words_worsening = right_words_worsening;
	}

	public String getDecisions_severity() {
		return decisions_severity;
	}

	public void setDecisions_severity(String decisions_severity) {
		this.decisions_severity = decisions_severity;
	}

	public String getDecisions_worsening() {
		return decisions_worsening;
	}

	public void setDecisions_worsening(String decisions_worsening) {
		this.decisions_worsening = decisions_worsening;
	}

	public String getCalculations_severity() {
		return calculations_severity;
	}

	public void setCalculations_severity(String calculations_severity) {
		this.calculations_severity = calculations_severity;
	}

	public String getCalculations_worsening() {
		return calculations_worsening;
	}

	public void setCalculations_worsening(String calculations_worsening) {
		this.calculations_worsening = calculations_worsening;
	}

	public String getProspective_severity() {
		return prospective_severity;
	}

	public void setProspective_severity(String prospective_severity) {
		this.prospective_severity = prospective_severity;
	}

	public String getProspective_worsening() {
		return prospective_worsening;
	}

	public void setProspective_worsening(String prospective_worsening) {
		this.prospective_worsening = prospective_worsening;
	}

	public String getAnxiety_severity() {
		return anxiety_severity;
	}

	public void setAnxiety_severity(String anxiety_severity) {
		this.anxiety_severity = anxiety_severity;
	}

	public String getAnxiety_worsening() {
		return anxiety_worsening;
	}

	public void setAnxiety_worsening(String anxiety_worsening) {
		this.anxiety_worsening = anxiety_worsening;
	}

	public String getComments_severity() {
		return comments_severity;
	}

	public void setComments_severity(String comments_severity) {
		this.comments_severity = comments_severity;
	}

	public String getComments_worsening() {
		return comments_worsening;
	}

	public void setComments_worsening(String comments_worsening) {
		this.comments_worsening = comments_worsening;
	}

	public String getRec_events_severity_collat() {
		return rec_events_severity_collat;
	}

	public void setRec_events_severity_collat(String rec_events_severity_collat) {
		this.rec_events_severity_collat = rec_events_severity_collat;
	}

	public String getRec_events_worsening_collat() {
		return rec_events_worsening_collat;
	}

	public void setRec_events_worsening_collat(String rec_events_worsening_collat) {
		this.rec_events_worsening_collat = rec_events_worsening_collat;
	}

	public String getFaces_severity_collat() {
		return faces_severity_collat;
	}

	public void setFaces_severity_collat(String faces_severity_collat) {
		this.faces_severity_collat = faces_severity_collat;
	}

	public String getFaces_worsening_collat() {
		return faces_worsening_collat;
	}

	public void setFaces_worsening_collat(String faces_worsening_collat) {
		this.faces_worsening_collat = faces_worsening_collat;
	}

	public String getNames_severity_collat() {
		return names_severity_collat;
	}

	public void setNames_severity_collat(String names_severity_collat) {
		this.names_severity_collat = names_severity_collat;
	}

	public String getNames_worsening_collat() {
		return names_worsening_collat;
	}

	public void setNames_worsening_collat(String names_worsening_collat) {
		this.names_worsening_collat = names_worsening_collat;
	}

	public String getLosing_things_severity_collat() {
		return losing_things_severity_collat;
	}

	public void setLosing_things_severity_collat(
			String losing_things_severity_collat) {
		this.losing_things_severity_collat = losing_things_severity_collat;
	}

	public String getLosing_things_worsening_collat() {
		return losing_things_worsening_collat;
	}

	public void setLosing_things_worsening_collat(
			String losing_things_worsening_collat) {
		this.losing_things_worsening_collat = losing_things_worsening_collat;
	}

	public String getFollow_conv_severity_collat() {
		return follow_conv_severity_collat;
	}

	public void setFollow_conv_severity_collat(String follow_conv_severity_collat) {
		this.follow_conv_severity_collat = follow_conv_severity_collat;
	}

	public String getFollow_conv_worsening_collat() {
		return follow_conv_worsening_collat;
	}

	public void setFollow_conv_worsening_collat(String follow_conv_worsening_collat) {
		this.follow_conv_worsening_collat = follow_conv_worsening_collat;
	}

	public String getRight_words_severity_collat() {
		return right_words_severity_collat;
	}

	public void setRight_words_severity_collat(String right_words_severity_collat) {
		this.right_words_severity_collat = right_words_severity_collat;
	}

	public String getRight_words_worsening_collat() {
		return right_words_worsening_collat;
	}

	public void setRight_words_worsening_collat(String right_words_worsening_collat) {
		this.right_words_worsening_collat = right_words_worsening_collat;
	}

	public String getDecisions_severity_collat() {
		return decisions_severity_collat;
	}

	public void setDecisions_severity_collat(String decisions_severity_collat) {
		this.decisions_severity_collat = decisions_severity_collat;
	}

	public String getDecisions_worsening_collat() {
		return decisions_worsening_collat;
	}

	public void setDecisions_worsening_collat(String decisions_worsening_collat) {
		this.decisions_worsening_collat = decisions_worsening_collat;
	}

	public String getCalculations_severity_collat() {
		return calculations_severity_collat;
	}

	public void setCalculations_severity_collat(String calculations_severity_collat) {
		this.calculations_severity_collat = calculations_severity_collat;
	}

	public String getCalculations_worsening_collat() {
		return calculations_worsening_collat;
	}

	public void setCalculations_worsening_collat(
			String calculations_worsening_collat) {
		this.calculations_worsening_collat = calculations_worsening_collat;
	}

	public String getProspective_severity_collat() {
		return prospective_severity_collat;
	}

	public void setProspective_severity_collat(String prospective_severity_collat) {
		this.prospective_severity_collat = prospective_severity_collat;
	}

	public String getProspective_worsening_collat() {
		return prospective_worsening_collat;
	}

	public void setProspective_worsening_collat(String prospective_worsening_collat) {
		this.prospective_worsening_collat = prospective_worsening_collat;
	}

	public String getAnxiety_severity_collat() {
		return anxiety_severity_collat;
	}

	public void setAnxiety_severity_collat(String anxiety_severity_collat) {
		this.anxiety_severity_collat = anxiety_severity_collat;
	}

	public String getAnxiety_worsening_collat() {
		return anxiety_worsening_collat;
	}

	public void setAnxiety_worsening_collat(String anxiety_worsening_collat) {
		this.anxiety_worsening_collat = anxiety_worsening_collat;
	}

	public String getComments_severity_collat() {
		return comments_severity_collat;
	}

	public void setComments_severity_collat(String comments_severity_collat) {
		this.comments_severity_collat = comments_severity_collat;
	}

	public String getComments_worsening_collat() {
		return comments_worsening_collat;
	}

	public void setComments_worsening_collat(String comments_worsening_collat) {
		this.comments_worsening_collat = comments_worsening_collat;
	}

	public void setRec_events_check(boolean rec_events_check) {
		this.rec_events_check = rec_events_check;
	}

	public boolean isFaces_check() {
		return faces_check;
	}

	public void setFaces_check(boolean faces_check) {
		this.faces_check = faces_check;
	}

	public boolean isNames_check() {
		return names_check;
	}

	public void setNames_check(boolean names_check) {
		this.names_check = names_check;
	}

	public boolean isLosing_things_check() {
		return losing_things_check;
	}

	public void setLosing_things_check(boolean losing_things_check) {
		this.losing_things_check = losing_things_check;
	}

	public boolean isFollow_conv_check() {
		return follow_conv_check;
	}

	public void setFollow_conv_check(boolean follow_conv_check) {
		this.follow_conv_check = follow_conv_check;
	}

	public boolean isRight_words_check() {
		return right_words_check;
	}

	public void setRight_words_check(boolean right_words_check) {
		this.right_words_check = right_words_check;
	}

	public boolean isDecisions_check() {
		return decisions_check;
	}

	public void setDecisions_check(boolean decisions_check) {
		this.decisions_check = decisions_check;
	}

	public boolean isCalculations_check() {
		return calculations_check;
	}

	public void setCalculations_check(boolean calculations_check) {
		this.calculations_check = calculations_check;
	}

	public boolean isProspective_check() {
		return prospective_check;
	}

	public void setProspective_check(boolean prospective_check) {
		this.prospective_check = prospective_check;
	}

	public boolean isAnxiety_check() {
		return anxiety_check;
	}

	public void setAnxiety_check(boolean anxiety_check) {
		this.anxiety_check = anxiety_check;
	}

	public boolean isComments_check() {
		return comments_check;
	}

	public void setComments_check(boolean comments_check) {
		this.comments_check = comments_check;
	}

	public String getRec_events_time() {
		return rec_events_time;
	}

	public void setRec_events_time(String rec_events_time) {
		this.rec_events_time = rec_events_time;
	}

	public String getRec_events_freq() {
		return rec_events_freq;
	}

	public void setRec_events_freq(String rec_events_freq) {
		this.rec_events_freq = rec_events_freq;
	}

	public String getRec_events_notes() {
		return rec_events_notes;
	}

	public void setRec_events_notes(String rec_events_notes) {
		this.rec_events_notes = rec_events_notes;
	}

	public String getFaces_time() {
		return faces_time;
	}

	public void setFaces_time(String faces_time) {
		this.faces_time = faces_time;
	}

	public String getFaces_freq() {
		return faces_freq;
	}

	public void setFaces_freq(String faces_freq) {
		this.faces_freq = faces_freq;
	}

	public String getFaces_notes() {
		return faces_notes;
	}

	public void setFaces_notes(String faces_notes) {
		this.faces_notes = faces_notes;
	}

	public String getNames_time() {
		return names_time;
	}

	public void setNames_time(String names_time) {
		this.names_time = names_time;
	}

	public String getNames_freq() {
		return names_freq;
	}

	public void setNames_freq(String names_freq) {
		this.names_freq = names_freq;
	}

	public String getNames_notes() {
		return names_notes;
	}

	public void setNames_notes(String names_notes) {
		this.names_notes = names_notes;
	}

	public String getLosing_things_time() {
		return losing_things_time;
	}

	public void setLosing_things_time(String losing_things_time) {
		this.losing_things_time = losing_things_time;
	}

	public String getLosing_things_freq() {
		return losing_things_freq;
	}

	public void setLosing_things_freq(String losing_things_freq) {
		this.losing_things_freq = losing_things_freq;
	}

	public String getLosing_things_notes() {
		return losing_things_notes;
	}

	public void setLosing_things_notes(String losing_things_notes) {
		this.losing_things_notes = losing_things_notes;
	}

	public String getFollow_conv_time() {
		return follow_conv_time;
	}

	public void setFollow_conv_time(String follow_conv_time) {
		this.follow_conv_time = follow_conv_time;
	}

	public String getFollow_conv_freq() {
		return follow_conv_freq;
	}

	public void setFollow_conv_freq(String follow_conv_freq) {
		this.follow_conv_freq = follow_conv_freq;
	}

	public String getFollow_conv_notes() {
		return follow_conv_notes;
	}

	public void setFollow_conv_notes(String follow_conv_notes) {
		this.follow_conv_notes = follow_conv_notes;
	}

	public String getRight_words_time() {
		return right_words_time;
	}

	public void setRight_words_time(String right_words_time) {
		this.right_words_time = right_words_time;
	}

	public String getRight_words_freq() {
		return right_words_freq;
	}

	public void setRight_words_freq(String right_words_freq) {
		this.right_words_freq = right_words_freq;
	}

	public String getRight_words_notes() {
		return right_words_notes;
	}

	public void setRight_words_notes(String right_words_notes) {
		this.right_words_notes = right_words_notes;
	}

	public String getDecisions_time() {
		return decisions_time;
	}

	public void setDecisions_time(String decisions_time) {
		this.decisions_time = decisions_time;
	}

	public String getDecisions_freq() {
		return decisions_freq;
	}

	public void setDecisions_freq(String decisions_freq) {
		this.decisions_freq = decisions_freq;
	}

	public String getDecisions_notes() {
		return decisions_notes;
	}

	public void setDecisions_notes(String decisions_notes) {
		this.decisions_notes = decisions_notes;
	}

	public String getCalculations_time() {
		return calculations_time;
	}

	public void setCalculations_time(String calculations_time) {
		this.calculations_time = calculations_time;
	}

	public String getCalculations_freq() {
		return calculations_freq;
	}

	public void setCalculations_freq(String calculations_freq) {
		this.calculations_freq = calculations_freq;
	}

	public String getCalculations_notes() {
		return calculations_notes;
	}

	public void setCalculations_notes(String calculations_notes) {
		this.calculations_notes = calculations_notes;
	}

	public String getProspective_time() {
		return prospective_time;
	}

	public void setProspective_time(String prospective_time) {
		this.prospective_time = prospective_time;
	}

	public String getProspective_freq() {
		return prospective_freq;
	}

	public void setProspective_freq(String prospective_freq) {
		this.prospective_freq = prospective_freq;
	}

	public String getProspective_notes() {
		return prospective_notes;
	}

	public void setProspective_notes(String prospective_notes) {
		this.prospective_notes = prospective_notes;
	}

	public String getAnxiety_time() {
		return anxiety_time;
	}

	public void setAnxiety_time(String anxiety_time) {
		this.anxiety_time = anxiety_time;
	}

	public String getAnxiety_freq() {
		return anxiety_freq;
	}

	public void setAnxiety_freq(String anxiety_freq) {
		this.anxiety_freq = anxiety_freq;
	}

	public String getAnxiety_notes() {
		return anxiety_notes;
	}

	public void setAnxiety_notes(String anxiety_notes) {
		this.anxiety_notes = anxiety_notes;
	}

	public String getComments_time() {
		return comments_time;
	}

	public void setComments_time(String comments_time) {
		this.comments_time = comments_time;
	}

	public String getComments_freq() {
		return comments_freq;
	}

	public void setComments_freq(String comments_freq) {
		this.comments_freq = comments_freq;
	}

	public String getComments_notes() {
		return comments_notes;
	}

	public void setComments_notes(String comments_notes) {
		this.comments_notes = comments_notes;
	}

	public boolean isRec_events_check_collat() {
		return rec_events_check_collat;
	}

	public void setRec_events_check_collat(boolean rec_events_check_collat) {
		this.rec_events_check_collat = rec_events_check_collat;
	}

	public boolean isFaces_check_collat() {
		return faces_check_collat;
	}

	public void setFaces_check_collat(boolean faces_check_collat) {
		this.faces_check_collat = faces_check_collat;
	}

	public boolean isNames_check_collat() {
		return names_check_collat;
	}

	public void setNames_check_collat(boolean names_check_collat) {
		this.names_check_collat = names_check_collat;
	}

	public boolean isLosing_things_check_collat() {
		return losing_things_check_collat;
	}

	public void setLosing_things_check_collat(boolean losing_things_check_collat) {
		this.losing_things_check_collat = losing_things_check_collat;
	}

	public boolean isFollow_conv_check_collat() {
		return follow_conv_check_collat;
	}

	public void setFollow_conv_check_collat(boolean follow_conv_check_collat) {
		this.follow_conv_check_collat = follow_conv_check_collat;
	}

	public boolean isRight_words_check_collat() {
		return right_words_check_collat;
	}

	public void setRight_words_check_collat(boolean right_words_check_collat) {
		this.right_words_check_collat = right_words_check_collat;
	}

	public boolean isDecisions_check_collat() {
		return decisions_check_collat;
	}

	public void setDecisions_check_collat(boolean decisions_check_collat) {
		this.decisions_check_collat = decisions_check_collat;
	}

	public boolean isCalculations_check_collat() {
		return calculations_check_collat;
	}

	public void setCalculations_check_collat(boolean calculations_check_collat) {
		this.calculations_check_collat = calculations_check_collat;
	}

	public boolean isProspective_check_collat() {
		return prospective_check_collat;
	}

	public void setProspective_check_collat(boolean prospective_check_collat) {
		this.prospective_check_collat = prospective_check_collat;
	}

	public boolean isAnxiety_check_collat() {
		return anxiety_check_collat;
	}

	public void setAnxiety_check_collat(boolean anxiety_check_collat) {
		this.anxiety_check_collat = anxiety_check_collat;
	}

	public boolean isComments_check_collat() {
		return comments_check_collat;
	}

	public void setComments_check_collat(boolean comments_check_collat) {
		this.comments_check_collat = comments_check_collat;
	}

	public String getRec_events_time_collat() {
		return rec_events_time_collat;
	}

	public void setRec_events_time_collat(String rec_events_time_collat) {
		this.rec_events_time_collat = rec_events_time_collat;
	}

	public String getRec_events_freq_collat() {
		return rec_events_freq_collat;
	}

	public void setRec_events_freq_collat(String rec_events_freq_collat) {
		this.rec_events_freq_collat = rec_events_freq_collat;
	}

	public String getRec_events_notes_collat() {
		return rec_events_notes_collat;
	}

	public void setRec_events_notes_collat(String rec_events_notes_collat) {
		this.rec_events_notes_collat = rec_events_notes_collat;
	}

	public String getFaces_time_collat() {
		return faces_time_collat;
	}

	public void setFaces_time_collat(String faces_time_collat) {
		this.faces_time_collat = faces_time_collat;
	}

	public String getFaces_freq_collat() {
		return faces_freq_collat;
	}

	public void setFaces_freq_collat(String faces_freq_collat) {
		this.faces_freq_collat = faces_freq_collat;
	}

	public String getFaces_notes_collat() {
		return faces_notes_collat;
	}

	public void setFaces_notes_collat(String faces_notes_collat) {
		this.faces_notes_collat = faces_notes_collat;
	}

	public String getNames_time_collat() {
		return names_time_collat;
	}

	public void setNames_time_collat(String names_time_collat) {
		this.names_time_collat = names_time_collat;
	}

	public String getNames_freq_collat() {
		return names_freq_collat;
	}

	public void setNames_freq_collat(String names_freq_collat) {
		this.names_freq_collat = names_freq_collat;
	}

	public String getNames_notes_collat() {
		return names_notes_collat;
	}

	public void setNames_notes_collat(String names_notes_collat) {
		this.names_notes_collat = names_notes_collat;
	}

	public String getLosing_things_time_collat() {
		return losing_things_time_collat;
	}

	public void setLosing_things_time_collat(String losing_things_time_collat) {
		this.losing_things_time_collat = losing_things_time_collat;
	}

	public String getLosing_things_freq_collat() {
		return losing_things_freq_collat;
	}

	public void setLosing_things_freq_collat(String losing_things_freq_collat) {
		this.losing_things_freq_collat = losing_things_freq_collat;
	}

	public String getLosing_things_notes_collat() {
		return losing_things_notes_collat;
	}

	public void setLosing_things_notes_collat(String losing_things_notes_collat) {
		this.losing_things_notes_collat = losing_things_notes_collat;
	}

	public String getFollow_conv_time_collat() {
		return follow_conv_time_collat;
	}

	public void setFollow_conv_time_collat(String follow_conv_time_collat) {
		this.follow_conv_time_collat = follow_conv_time_collat;
	}

	public String getFollow_conv_freq_collat() {
		return follow_conv_freq_collat;
	}

	public void setFollow_conv_freq_collat(String follow_conv_freq_collat) {
		this.follow_conv_freq_collat = follow_conv_freq_collat;
	}

	public String getFollow_conv_notes_collat() {
		return follow_conv_notes_collat;
	}

	public void setFollow_conv_notes_collat(String follow_conv_notes_collat) {
		this.follow_conv_notes_collat = follow_conv_notes_collat;
	}

	public String getRight_words_time_collat() {
		return right_words_time_collat;
	}

	public void setRight_words_time_collat(String right_words_time_collat) {
		this.right_words_time_collat = right_words_time_collat;
	}

	public String getRight_words_freq_collat() {
		return right_words_freq_collat;
	}

	public void setRight_words_freq_collat(String right_words_freq_collat) {
		this.right_words_freq_collat = right_words_freq_collat;
	}

	public String getRight_words_notes_collat() {
		return right_words_notes_collat;
	}

	public void setRight_words_notes_collat(String right_words_notes_collat) {
		this.right_words_notes_collat = right_words_notes_collat;
	}

	public String getDecisions_time_collat() {
		return decisions_time_collat;
	}

	public void setDecisions_time_collat(String decisions_time_collat) {
		this.decisions_time_collat = decisions_time_collat;
	}

	public String getDecisions_freq_collat() {
		return decisions_freq_collat;
	}

	public void setDecisions_freq_collat(String decisions_freq_collat) {
		this.decisions_freq_collat = decisions_freq_collat;
	}

	public String getDecisions_notes_collat() {
		return decisions_notes_collat;
	}

	public void setDecisions_notes_collat(String decisions_notes_collat) {
		this.decisions_notes_collat = decisions_notes_collat;
	}

	public String getCalculations_time_collat() {
		return calculations_time_collat;
	}

	public void setCalculations_time_collat(String calculations_time_collat) {
		this.calculations_time_collat = calculations_time_collat;
	}

	public String getCalculations_freq_collat() {
		return calculations_freq_collat;
	}

	public void setCalculations_freq_collat(String calculations_freq_collat) {
		this.calculations_freq_collat = calculations_freq_collat;
	}

	public String getCalculations_notes_collat() {
		return calculations_notes_collat;
	}

	public void setCalculations_notes_collat(String calculations_notes_collat) {
		this.calculations_notes_collat = calculations_notes_collat;
	}

	public String getProspective_time_collat() {
		return prospective_time_collat;
	}

	public void setProspective_time_collat(String prospective_time_collat) {
		this.prospective_time_collat = prospective_time_collat;
	}

	public String getProspective_freq_collat() {
		return prospective_freq_collat;
	}

	public void setProspective_freq_collat(String prospective_freq_collat) {
		this.prospective_freq_collat = prospective_freq_collat;
	}

	public String getProspective_notes_collat() {
		return prospective_notes_collat;
	}

	public void setProspective_notes_collat(String prospective_notes_collat) {
		this.prospective_notes_collat = prospective_notes_collat;
	}

	public String getAnxiety_time_collat() {
		return anxiety_time_collat;
	}

	public void setAnxiety_time_collat(String anxiety_time_collat) {
		this.anxiety_time_collat = anxiety_time_collat;
	}

	public String getAnxiety_freq_collat() {
		return anxiety_freq_collat;
	}

	public void setAnxiety_freq_collat(String anxiety_freq_collat) {
		this.anxiety_freq_collat = anxiety_freq_collat;
	}

	public String getAnxiety_notes_collat() {
		return anxiety_notes_collat;
	}

	public void setAnxiety_notes_collat(String anxiety_notes_collat) {
		this.anxiety_notes_collat = anxiety_notes_collat;
	}

	public String getComments_time_collat() {
		return comments_time_collat;
	}

	public void setComments_time_collat(String comments_time_collat) {
		this.comments_time_collat = comments_time_collat;
	}

	public String getComments_freq_collat() {
		return comments_freq_collat;
	}

	public void setComments_freq_collat(String comments_freq_collat) {
		this.comments_freq_collat = comments_freq_collat;
	}

	public String getComments_notes_collat() {
		return comments_notes_collat;
	}

	public void setComments_notes_collat(String comments_notes_collat) {
		this.comments_notes_collat = comments_notes_collat;
	}

}
