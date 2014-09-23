package com.cloud.clinic.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * 
 * Form object
 * Multiple held by each patient
 * Contains timestamp of when the questionnaire was administered
 * Contains every page of the questionnaire and a case number
 * 
 */

@Entity(name="Form")
public class Form implements java.io.Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FormID", unique=true, nullable=false)
	private int formID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	
	@Expose
	String case_number;

	//Just used to denote whether a form was just created and needs to be initialised by the servlets
	@Transient
	private boolean isNew;
	
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PersonalDetails personalDetails;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PatientHistory patientHistory;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private GP_Info gpInfo;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Concerns concerns;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private NeuroHistory neuroHistory;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private EventsActivities eventsActivities;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private LivingSit livingSit;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Lifestyle lifestyle;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private TestBattery testBattery;
	@OneToOne(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Analysis analysis;
	
	public Form(){
		
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getCase_number() {
		return case_number;
	}

	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public PatientHistory getPatientHistory() {
		return patientHistory;
	}

	public void setPatientHistory(PatientHistory patientHistory) {
		this.patientHistory = patientHistory;
	}

	public GP_Info getGpInfo() {
		return gpInfo;
	}

	public void setGpInfo(GP_Info gpInfo) {
		this.gpInfo = gpInfo;
	}

	public Concerns getConcerns() {
		return concerns;
	}

	public void setConcerns(Concerns concerns) {
		this.concerns = concerns;
	}

	public NeuroHistory getNeuroHistory() {
		return neuroHistory;
	}

	public void setNeuroHistory(NeuroHistory neuroHistory) {
		this.neuroHistory = neuroHistory;
	}

	public EventsActivities getEventsActivities() {
		return eventsActivities;
	}

	public void setEventsActivities(EventsActivities eventsActivities) {
		this.eventsActivities = eventsActivities;
	}

	public LivingSit getLivingSit() {
		return livingSit;
	}

	public void setLivingSit(LivingSit livingSit) {
		this.livingSit = livingSit;
	}

	public Lifestyle getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(Lifestyle lifestyle) {
		this.lifestyle = lifestyle;
	}

	public TestBattery getTestBattery() {
		return testBattery;
	}

	public void setTestBattery(TestBattery testBattery) {
		this.testBattery = testBattery;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
}
