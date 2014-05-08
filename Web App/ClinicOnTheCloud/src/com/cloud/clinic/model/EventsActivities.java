package com.cloud.clinic.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/*
 * Class used for the representation of the Events and Activities page
 */

@Entity
public class EventsActivities implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventsActivitiesID", unique = true, nullable = false)
	private int eventsActivitiesID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Patient patient;

	@Transient
	protected Object[] jdoDetachedState;
	
	boolean divorce_check, bereavement_check, moving_house_check, redundancy_check, family_disharmony_check;
	boolean other_disharmony_check, financial_check, retirement_check, job_check;
	
	boolean divorce_collat_check, bereavement_collat_check, moving_house_collat_check, redundancy_collat_check_check, family_disharmony_collat_check;
	boolean other_disharmony_collat_check, financial_collat_check, retirement_collat_check, job_collat_check;
	
	String other, other_time;
	@Column(columnDefinition="TEXT")
	String other_notes;
	
	String divorce_time;
	@Column(columnDefinition="TEXT")
	String divorce_notes;
	
	String bereavement_time;
	@Column(columnDefinition="TEXT")
	String bereavement_notes;
	
	String moving_house_time;
	@Column(columnDefinition="TEXT")
	String moving_house_notes;
	
	String redundancy_time;
	@Column(columnDefinition="TEXT")
	String redundancy_notes;
	
	String family_disharmony_time;
	@Column(columnDefinition="TEXT")
	String family_disharmony_notes;
	
	String other_disharmony_time;
	@Column(columnDefinition="TEXT")
	String other_disharmony_notes;
	
	String financial_time;
	@Column(columnDefinition="TEXT")
	String financial_notes;
	
	String retirement_time;
	@Column(columnDefinition="TEXT")
	String retirement_notes;
	
	String job_time;
	@Column(columnDefinition="TEXT")
	String job_notes;
	
	String other_collat, other_collat_time;
	@Column(columnDefinition="TEXT")
	String other_collat_notes;
	
	String divorce_collat_time;
	@Column(columnDefinition="TEXT")
	String divorce_collat_notes;
	
	String bereavement_collat_time;
	@Column(columnDefinition="TEXT")
	String bereavement_collat_notes;
	
	String moving_house_collat_time;
	@Column(columnDefinition="TEXT")
	String moving_house_collat_notes;
	
	String redundancy_collat_time;
	@Column(columnDefinition="TEXT")
	String redundancy_collat_notes;
	
	String family_disharmony_collat_time;
	@Column(columnDefinition="TEXT")
	String family_disharmony_collat_notes;
	
	String other_disharmony_collat_time;
	@Column(columnDefinition="TEXT")
	String other_disharmony_collat_notes;
	
	String financial_collat_time;
	@Column(columnDefinition="TEXT")
	String financial_collat_notes;
	
	String retirement_collat_time;
	@Column(columnDefinition="TEXT")
	String retirement_collat_notes;
	
	String job_collat_time;
	@Column(columnDefinition="TEXT")
	String job_collat_notes;
	
	@OneToMany(mappedBy = "eventActivity", cascade = CascadeType.ALL)
	private List<Activity> activities;
	
	@OneToMany(mappedBy = "eventActivity", cascade = CascadeType.ALL)
	private List<Activity> collat_activities;
	
	String depression_yn, pleasure_yn;
	String worthless_yn, concentration_yn, death_yn;
	
	public EventsActivities() {
		
	}

	public int getEventsActivitiesID() {
		return eventsActivitiesID;
	}

	public void setEventsActivitiesID(int eventsActivitiesID) {
		this.eventsActivitiesID = eventsActivitiesID;
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

	public boolean isDivorce_check() {
		return divorce_check;
	}

	public void setDivorce_check(boolean divorce_check) {
		this.divorce_check = divorce_check;
	}

	public boolean isBereavement_check() {
		return bereavement_check;
	}

	public void setBereavement_check(boolean bereavement_check) {
		this.bereavement_check = bereavement_check;
	}

	public boolean isMoving_house_check() {
		return moving_house_check;
	}

	public void setMoving_house_check(boolean moving_house_check) {
		this.moving_house_check = moving_house_check;
	}

	public boolean isRedundancy_check() {
		return redundancy_check;
	}

	public void setRedundancy_check(boolean redundancy_check) {
		this.redundancy_check = redundancy_check;
	}

	public boolean isFamily_disharmony_check() {
		return family_disharmony_check;
	}

	public void setFamily_disharmony_check(boolean family_disharmony_check) {
		this.family_disharmony_check = family_disharmony_check;
	}

	public boolean isOther_disharmony_check() {
		return other_disharmony_check;
	}

	public void setOther_disharmony_check(boolean other_disharmony_check) {
		this.other_disharmony_check = other_disharmony_check;
	}

	public boolean isFinancial_check() {
		return financial_check;
	}

	public void setFinancial_check(boolean financial_check) {
		this.financial_check = financial_check;
	}

	public boolean isRetirement_check() {
		return retirement_check;
	}

	public void setRetirement_check(boolean retirement_check) {
		this.retirement_check = retirement_check;
	}

	public boolean isJob_check() {
		return job_check;
	}

	public void setJob_check(boolean job_check) {
		this.job_check = job_check;
	}

	public boolean isDivorce_collat_check() {
		return divorce_collat_check;
	}

	public void setDivorce_collat_check(boolean divorce_collat_check) {
		this.divorce_collat_check = divorce_collat_check;
	}

	public boolean isBereavement_collat_check() {
		return bereavement_collat_check;
	}

	public void setBereavement_collat_check(boolean bereavement_collat_check) {
		this.bereavement_collat_check = bereavement_collat_check;
	}

	public boolean isMoving_house_collat_check() {
		return moving_house_collat_check;
	}

	public void setMoving_house_collat_check(boolean moving_house_collat_check) {
		this.moving_house_collat_check = moving_house_collat_check;
	}

	public boolean isRedundancy_collat_check_check() {
		return redundancy_collat_check_check;
	}

	public void setRedundancy_collat_check_check(
			boolean redundancy_collat_check_check) {
		this.redundancy_collat_check_check = redundancy_collat_check_check;
	}

	public boolean isFamily_disharmony_collat_check() {
		return family_disharmony_collat_check;
	}

	public void setFamily_disharmony_collat_check(
			boolean family_disharmony_collat_check) {
		this.family_disharmony_collat_check = family_disharmony_collat_check;
	}

	public boolean isOther_disharmony_collat_check() {
		return other_disharmony_collat_check;
	}

	public void setOther_disharmony_collat_check(
			boolean other_disharmony_collat_check) {
		this.other_disharmony_collat_check = other_disharmony_collat_check;
	}

	public boolean isFinancial_collat_check() {
		return financial_collat_check;
	}

	public void setFinancial_collat_check(boolean financial_collat_check) {
		this.financial_collat_check = financial_collat_check;
	}

	public boolean isRetirement_collat_check() {
		return retirement_collat_check;
	}

	public void setRetirement_collat_check(boolean retirement_collat_check) {
		this.retirement_collat_check = retirement_collat_check;
	}

	public boolean isJob_collat_check() {
		return job_collat_check;
	}

	public void setJob_collat_check(boolean job_collat_check) {
		this.job_collat_check = job_collat_check;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getOther_time() {
		return other_time;
	}

	public void setOther_time(String other_time) {
		this.other_time = other_time;
	}

	public String getOther_notes() {
		return other_notes;
	}

	public void setOther_notes(String other_notes) {
		this.other_notes = other_notes;
	}

	public String getDivorce_time() {
		return divorce_time;
	}

	public void setDivorce_time(String divorce_time) {
		this.divorce_time = divorce_time;
	}

	public String getDivorce_notes() {
		return divorce_notes;
	}

	public void setDivorce_notes(String divorce_notes) {
		this.divorce_notes = divorce_notes;
	}

	public String getBereavement_time() {
		return bereavement_time;
	}

	public void setBereavement_time(String bereavement_time) {
		this.bereavement_time = bereavement_time;
	}

	public String getBereavement_notes() {
		return bereavement_notes;
	}

	public void setBereavement_notes(String bereavement_notes) {
		this.bereavement_notes = bereavement_notes;
	}

	public String getMoving_house_time() {
		return moving_house_time;
	}

	public void setMoving_house_time(String moving_house_time) {
		this.moving_house_time = moving_house_time;
	}

	public String getMoving_house_notes() {
		return moving_house_notes;
	}

	public void setMoving_house_notes(String moving_house_notes) {
		this.moving_house_notes = moving_house_notes;
	}

	public String getRedundancy_time() {
		return redundancy_time;
	}

	public void setRedundancy_time(String redundancy_time) {
		this.redundancy_time = redundancy_time;
	}

	public String getRedundancy_notes() {
		return redundancy_notes;
	}

	public void setRedundancy_notes(String redundancy_notes) {
		this.redundancy_notes = redundancy_notes;
	}

	public String getFamily_disharmony_time() {
		return family_disharmony_time;
	}

	public void setFamily_disharmony_time(String family_disharmony_time) {
		this.family_disharmony_time = family_disharmony_time;
	}

	public String getFamily_disharmony_notes() {
		return family_disharmony_notes;
	}

	public void setFamily_disharmony_notes(String family_disharmony_notes) {
		this.family_disharmony_notes = family_disharmony_notes;
	}

	public String getOther_disharmony_time() {
		return other_disharmony_time;
	}

	public void setOther_disharmony_time(String other_disharmony_time) {
		this.other_disharmony_time = other_disharmony_time;
	}

	public String getOther_disharmony_notes() {
		return other_disharmony_notes;
	}

	public void setOther_disharmony_notes(String other_disharmony_notes) {
		this.other_disharmony_notes = other_disharmony_notes;
	}

	public String getFinancial_time() {
		return financial_time;
	}

	public void setFinancial_time(String financial_time) {
		this.financial_time = financial_time;
	}

	public String getFinancial_notes() {
		return financial_notes;
	}

	public void setFinancial_notes(String financial_notes) {
		this.financial_notes = financial_notes;
	}

	public String getRetirement_time() {
		return retirement_time;
	}

	public void setRetirement_time(String retirement_time) {
		this.retirement_time = retirement_time;
	}

	public String getRetirement_notes() {
		return retirement_notes;
	}

	public void setRetirement_notes(String retirement_notes) {
		this.retirement_notes = retirement_notes;
	}

	public String getJob_time() {
		return job_time;
	}

	public void setJob_time(String job_time) {
		this.job_time = job_time;
	}

	public String getJob_notes() {
		return job_notes;
	}

	public void setJob_notes(String job_notes) {
		this.job_notes = job_notes;
	}

	public String getOther_collat() {
		return other_collat;
	}

	public void setOther_collat(String other_collat) {
		this.other_collat = other_collat;
	}

	public String getOther_collat_time() {
		return other_collat_time;
	}

	public void setOther_collat_time(String other_collat_time) {
		this.other_collat_time = other_collat_time;
	}

	public String getOther_collat_notes() {
		return other_collat_notes;
	}

	public void setOther_collat_notes(String other_collat_notes) {
		this.other_collat_notes = other_collat_notes;
	}

	public String getDivorce_collat_time() {
		return divorce_collat_time;
	}

	public void setDivorce_collat_time(String divorce_collat_time) {
		this.divorce_collat_time = divorce_collat_time;
	}

	public String getDivorce_collat_notes() {
		return divorce_collat_notes;
	}

	public void setDivorce_collat_notes(String divorce_collat_notes) {
		this.divorce_collat_notes = divorce_collat_notes;
	}

	public String getBereavement_collat_time() {
		return bereavement_collat_time;
	}

	public void setBereavement_collat_time(String bereavement_collat_time) {
		this.bereavement_collat_time = bereavement_collat_time;
	}

	public String getBereavement_collat_notes() {
		return bereavement_collat_notes;
	}

	public void setBereavement_collat_notes(String bereavement_collat_notes) {
		this.bereavement_collat_notes = bereavement_collat_notes;
	}

	public String getMoving_house_collat_time() {
		return moving_house_collat_time;
	}

	public void setMoving_house_collat_time(String moving_house_collat_time) {
		this.moving_house_collat_time = moving_house_collat_time;
	}

	public String getMoving_house_collat_notes() {
		return moving_house_collat_notes;
	}

	public void setMoving_house_collat_notes(String moving_house_collat_notes) {
		this.moving_house_collat_notes = moving_house_collat_notes;
	}

	public String getRedundancy_collat_time() {
		return redundancy_collat_time;
	}

	public void setRedundancy_collat_time(String redundancy_collat_time) {
		this.redundancy_collat_time = redundancy_collat_time;
	}

	public String getRedundancy_collat_notes() {
		return redundancy_collat_notes;
	}

	public void setRedundancy_collat_notes(String redundancy_collat_notes) {
		this.redundancy_collat_notes = redundancy_collat_notes;
	}

	public String getFamily_disharmony_collat_time() {
		return family_disharmony_collat_time;
	}

	public void setFamily_disharmony_collat_time(
			String family_disharmony_collat_time) {
		this.family_disharmony_collat_time = family_disharmony_collat_time;
	}

	public String getFamily_disharmony_collat_notes() {
		return family_disharmony_collat_notes;
	}

	public void setFamily_disharmony_collat_notes(
			String family_disharmony_collat_notes) {
		this.family_disharmony_collat_notes = family_disharmony_collat_notes;
	}

	public String getOther_disharmony_collat_time() {
		return other_disharmony_collat_time;
	}

	public void setOther_disharmony_collat_time(String other_disharmony_collat_time) {
		this.other_disharmony_collat_time = other_disharmony_collat_time;
	}

	public String getOther_disharmony_collat_notes() {
		return other_disharmony_collat_notes;
	}

	public void setOther_disharmony_collat_notes(
			String other_disharmony_collat_notes) {
		this.other_disharmony_collat_notes = other_disharmony_collat_notes;
	}

	public String getFinancial_collat_time() {
		return financial_collat_time;
	}

	public void setFinancial_collat_time(String financial_collat_time) {
		this.financial_collat_time = financial_collat_time;
	}

	public String getFinancial_collat_notes() {
		return financial_collat_notes;
	}

	public void setFinancial_collat_notes(String financial_collat_notes) {
		this.financial_collat_notes = financial_collat_notes;
	}

	public String getRetirement_collat_time() {
		return retirement_collat_time;
	}

	public void setRetirement_collat_time(String retirement_collat_time) {
		this.retirement_collat_time = retirement_collat_time;
	}

	public String getRetirement_collat_notes() {
		return retirement_collat_notes;
	}

	public void setRetirement_collat_notes(String retirement_collat_notes) {
		this.retirement_collat_notes = retirement_collat_notes;
	}

	public String getJob_collat_time() {
		return job_collat_time;
	}

	public void setJob_collat_time(String job_collat_time) {
		this.job_collat_time = job_collat_time;
	}

	public String getJob_collat_notes() {
		return job_collat_notes;
	}

	public void setJob_collat_notes(String job_collat_notes) {
		this.job_collat_notes = job_collat_notes;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Activity> getCollat_activities() {
		return collat_activities;
	}

	public void setCollat_activities(List<Activity> collat_activities) {
		this.collat_activities = collat_activities;
	}

	public String getDepression_yn() {
		return depression_yn;
	}

	public void setDepression_yn(String depression_yn) {
		this.depression_yn = depression_yn;
	}

	public String getPleasure_yn() {
		return pleasure_yn;
	}

	public void setPleasure_yn(String pleasure_yn) {
		this.pleasure_yn = pleasure_yn;
	}

	public String getWorthless_yn() {
		return worthless_yn;
	}

	public void setWorthless_yn(String worthless_yn) {
		this.worthless_yn = worthless_yn;
	}

	public String getConcentration_yn() {
		return concentration_yn;
	}

	public void setConcentration_yn(String concentration_yn) {
		this.concentration_yn = concentration_yn;
	}

	public String getDeath_yn() {
		return death_yn;
	}

	public void setDeath_yn(String death_yn) {
		this.death_yn = death_yn;
	}
}
