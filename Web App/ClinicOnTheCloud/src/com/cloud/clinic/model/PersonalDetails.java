package com.cloud.clinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	
	@OneToOne(fetch = FetchType.LAZY)
	Form form;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	private String gender, study_topic, occupation, county;
	private String gp_county, who_present, testing_reason;
	public String getTesting_reason() {
		return testing_reason;
	}

	public void setTesting_reason(String testing_reason) {
		this.testing_reason = testing_reason;
	}

	private boolean family_present;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	private int age, age_left;
	
	private boolean junior_check, senior_check, third_check;
	
	public PersonalDetails(){
		
	}

	public int getDetailsID() {
		return detailsID;
	}

	public void setDetailsID(int detailsID) {
		this.detailsID = detailsID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
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

	public boolean getFamily_present() {
		return family_present;
	}

	public void setFamily_present(boolean family_present) {
		this.family_present = family_present;
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

	public String getWho_present() {
		return who_present;
	}

	public void setWho_present(String who_present) {
		this.who_present = who_present;
	}

}
