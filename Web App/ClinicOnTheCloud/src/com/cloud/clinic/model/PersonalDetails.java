package com.cloud.clinic.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
 * Used to keep the personal details of the patient
 */

@Entity
public class PersonalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detailsID", unique = true, nullable = false)
	int detailsID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Patient patient;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	private String gender, study_topic, occupation, county;
	private String gp_county;
	private boolean family_present_check;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	private int age, age_left;
	
	private boolean junior_check, senior_check, third_check, pIsFamilyPresent;
	
	public PersonalDetails(){
		
	}

	public int getDetailsID() {
		return detailsID;
	}

	public void setDetailsID(int detailsID) {
		this.detailsID = detailsID;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge_left() {
		return age_left;
	}

	public void setAge_left(int age_left) {
		this.age_left = age_left;
	}

	public String getStudy_topic() {
		return study_topic;
	}

	public void setStudy_topic(String study_topic) {
		this.study_topic = study_topic;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getGp_county() {
		return gp_county;
	}

	public void setGp_county(String gp_county) {
		this.gp_county = gp_county;
	}

	public boolean getFamily_present_check() {
		return family_present_check;
	}

	public void setFamily_present_check(boolean family_present_check) {
		this.family_present_check = family_present_check;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isJunior_check() {
		return junior_check;
	}

	public void setJunior_check(boolean junior_check) {
		this.junior_check = junior_check;
	}

	public boolean isSenior_check() {
		return senior_check;
	}

	public void setSenior_check(boolean senior_check) {
		this.senior_check = senior_check;
	}

	public boolean isThird_check() {
		return third_check;
	}

	public void setThird_check(boolean third_check) {
		this.third_check = third_check;
	}

	public boolean ispIsFamilyPresent() {
		return pIsFamilyPresent;
	}

	public void setpIsFamilyPresent(boolean pIsFamilyPresent) {
		this.pIsFamilyPresent = pIsFamilyPresent;
	}

}
