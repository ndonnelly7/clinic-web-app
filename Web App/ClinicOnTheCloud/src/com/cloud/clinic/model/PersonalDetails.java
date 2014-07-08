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

import com.google.gson.annotations.Expose;

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
	
	@Expose
	private String gender, study_topic, occupation, county;
	@Expose
	private String gp_county, who_present, testing_reason;

	@Expose
	private boolean family_present;
	
	@Expose
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Expose
	private int age, age_left;
	
	@Expose
	private boolean junior_check, senior_check, third_check;
	
	@Expose
	private String junior_cert_education, senior_cert_education, third_level_education;
	
	@Expose
	private boolean wants_reassurance, wants_assessment, wants_information;
	
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

	public Object[] getJdoDetachedState() {
		return jdoDetachedState;
	}

	public void setJdoDetachedState(Object[] jdoDetachedState) {
		this.jdoDetachedState = jdoDetachedState;
	}
	
	public String getTesting_reason() {
		return testing_reason;
	}

	public void setTesting_reason(String testing_reason) {
		this.testing_reason = testing_reason;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJunior_cert_education() {
		return junior_cert_education;
	}

	public void setJunior_cert_education(String junior_cert_education) {
		this.junior_cert_education = junior_cert_education;
	}

	public String getSenior_cert_education() {
		return senior_cert_education;
	}

	public void setSenior_cert_education(String senior_cert_education) {
		this.senior_cert_education = senior_cert_education;
	}

	public String getThird_level_education() {
		return third_level_education;
	}

	public void setThird_level_education(String third_level_education) {
		this.third_level_education = third_level_education;
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

	public boolean isWants_reassurance() {
		return wants_reassurance;
	}

	public void setWants_reassurance(boolean wants_reassurance) {
		this.wants_reassurance = wants_reassurance;
	}

	public boolean isWants_assessment() {
		return wants_assessment;
	}

	public void setWants_assessment(boolean wants_assessment) {
		this.wants_assessment = wants_assessment;
	}

	public boolean isWants_information() {
		return wants_information;
	}

	public void setWants_information(boolean wants_information) {
		this.wants_information = wants_information;
	}
}
