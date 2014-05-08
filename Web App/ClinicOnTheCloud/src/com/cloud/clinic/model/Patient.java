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
	
	@Transient
	protected Object[] jdoDetachedState;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PersonalDetails> personalDetails;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PatientHistory> patientHistory;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<GP_Info> gpInfo;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Concerns> concerns;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<NeuroHistory> neuroHistory;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EventsActivities> eventsActivities;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LivingSit> livingSit;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Lifestyle> lifestyle;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TestBattery> testBattery;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Analysis> analysis;
	
	public Patient(){
		personalDetails = new ArrayList<PersonalDetails>();
		patientHistory = new ArrayList<PatientHistory>();
		gpInfo = new ArrayList<GP_Info>();
		concerns = new ArrayList<Concerns>();
		neuroHistory = new ArrayList<NeuroHistory>();
		eventsActivities = new ArrayList<EventsActivities>();
		livingSit = new ArrayList<LivingSit>();
		lifestyle = new ArrayList<Lifestyle>();
		testBattery = new ArrayList<TestBattery>();
		analysis = new ArrayList<Analysis>();
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


	public List<PersonalDetails> getPersonalDetails() {
		return personalDetails;
	}


	public void setPersonalDetails(List<PersonalDetails> personalDetails) {
		this.personalDetails = personalDetails;
	}


	public List<PatientHistory> getPatientHistory() {
		return patientHistory;
	}


	public void setPatientHistory(List<PatientHistory> patientHistory) {
		this.patientHistory = patientHistory;
	}


	public List<GP_Info> getGpInfo() {
		return gpInfo;
	}


	public void setGpInfo(List<GP_Info> gpInfo) {
		this.gpInfo = gpInfo;
	}


	public List<Concerns> getConcerns() {
		return concerns;
	}


	public void setConcerns(List<Concerns> concerns) {
		this.concerns = concerns;
	}


	public List<NeuroHistory> getNeuroHistory() {
		return neuroHistory;
	}


	public void setNeuroHistory(List<NeuroHistory> neuroHistory) {
		this.neuroHistory = neuroHistory;
	}


	public List<EventsActivities> getEventsActivities() {
		return eventsActivities;
	}


	public void setEventsActivities(List<EventsActivities> eventsActivities) {
		this.eventsActivities = eventsActivities;
	}


	public List<LivingSit> getLivingSit() {
		return livingSit;
	}


	public void setLivingSit(List<LivingSit> livingSit) {
		this.livingSit = livingSit;
	}


	public List<Lifestyle> getLifestyle() {
		return lifestyle;
	}


	public void setLifestyle(List<Lifestyle> lifestyle) {
		this.lifestyle = lifestyle;
	}


	public List<TestBattery> getTestBattery() {
		return testBattery;
	}


	public void setTestBattery(List<TestBattery> testBattery) {
		this.testBattery = testBattery;
	}


	public List<Analysis> getAnalysis() {
		return analysis;
	}


	public void setAnalysis(List<Analysis> analysis) {
		this.analysis = analysis;
	}
	
	public void addPersonalDetails(PersonalDetails p) {
		personalDetails.add(p);
	}
	
	public void addHistory(PatientHistory h) {
		patientHistory.add(h);
	}
	
	public void addGPInfo(GP_Info g) {
		gpInfo.add(g);
	}
	
	public void addConcern(Concerns c) {
		concerns.add(c);
	}
	
	public void addNeuroHistory(NeuroHistory nh){
		neuroHistory.add(nh);
	}
	
	public void addEventsActivities(EventsActivities ea) {
		eventsActivities.add(ea);
	}
	
	public void addLivingSit(LivingSit ls) {
		livingSit.add(ls);
	}
	
	public void addLifestyle(Lifestyle l) {
		lifestyle.add(l);
	}
	
	public void addTestBattery(TestBattery t){
		testBattery.add(t);
	}
	
	public void addAnalysis(Analysis a){
		analysis.add(a);
	}
}
