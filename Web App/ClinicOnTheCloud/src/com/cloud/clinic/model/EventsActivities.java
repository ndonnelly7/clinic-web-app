package com.cloud.clinic.model;

import java.io.Serializable;
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
/*
 * Class used for the representation of the Events and Activities page
 */

import com.google.gson.annotations.Expose;

/*
 * Bean for Events and Activities object to be stored on DB
 * Has children tables for activities and collateral activities
 * 
 */

@Entity
public class EventsActivities implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventsActivitiesID", unique = true, nullable = false)
	private int eventsActivitiesID;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Form form;

	@Transient
	protected Object[] jdoDetachedState;

	@Expose
	boolean divorce_check, bereavement_check, moving_house_check, redundancy_check, family_disharmony_check;

	@Expose
	boolean other_disharmony_check, financial_check, retirement_check, job_stress_check;

	@Expose
	boolean divorce_collat_check, bereavement_collat_check, moving_house_collat_check, redundancy_collat_check_check, family_disharmony_collat_check;

	@Expose
	boolean other_disharmony_collat_check, financial_collat_check, retirement_collat_check, job_stress_collat_check;

	@Expose
	String other_text, other_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String other_notes;

	@Expose
	String divorce_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String divorce_notes;

	@Expose
	String bereavement_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String bereavement_notes;

	@Expose
	String moving_house_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String moving_house_notes;

	@Expose
	String redundancy_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String redundancy_notes;

	@Expose
	String family_disharmony_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String family_disharmony_notes;

	@Expose
	String other_disharmony_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String other_disharmony_notes;

	@Expose
	String financial_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String financial_notes;

	@Expose
	String retirement_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String retirement_notes;

	@Expose
	String job_stress_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String job_stress_notes;

	@Expose
	String other_collat_text, other_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String other_collat_notes;

	@Expose
	String divorce_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String divorce_collat_notes;

	@Expose
	String bereavement_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String bereavement_collat_notes;

	@Expose
	String moving_house_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String moving_house_collat_notes;

	@Expose
	String redundancy_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String redundancy_collat_notes;

	@Expose
	String family_disharmony_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String family_disharmony_collat_notes;

	@Expose
	String other_disharmony_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String other_disharmony_collat_notes;

	@Expose
	String financial_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String financial_collat_notes;

	@Expose
	String retirement_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String retirement_collat_notes;

	@Expose
	String job_stress_collat_time;
	@Expose
	@Column(columnDefinition="TEXT")
	String job_stress_collat_notes;

	@Expose
	@OneToMany(mappedBy = "eventActivity", cascade = CascadeType.ALL)
	private List<Activity> activities;

	@Expose
	@OneToMany(mappedBy = "eventActivity", cascade = CascadeType.ALL)
	private List<Activity> collat_activities;

	@Expose
	@Column(columnDefinition="TEXT")
	String social_notes;
	
	@Expose
	@Column(columnDefinition="TEXT")
	String social_notes_collat;
	
	@Expose
	String depression_yn, pleasure_yn;
	@Expose
	String worthless_yn, concentration_yn, death_yn;
	
	public EventsActivities() {
		
	}

	public int getEventsActivitiesID() {
		return eventsActivitiesID;
	}

	public void setEventsActivitiesID(int eventsActivitiesID) {
		this.eventsActivitiesID = eventsActivitiesID;
	}
	
	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getSocial_notes() {
		return social_notes;
	}

	public void setSocial_notes(String social_notes) {
		this.social_notes = social_notes;
	}

	public String getSocial_notes_collat() {
		return social_notes_collat;
	}

	public void setSocial_notes_collat(String social_notes_collat) {
		this.social_notes_collat = social_notes_collat;
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

	public boolean isJob_stress_check() {
		return job_stress_check;
	}

	public void setJob_stress_check(boolean job_stress_check) {
		this.job_stress_check = job_stress_check;
	}

	public boolean isJob_stress_collat_check() {
		return job_stress_collat_check;
	}

	public void setJob_stress_collat_check(boolean job_stress_collat_check) {
		this.job_stress_collat_check = job_stress_collat_check;
	}

	public String getJob_stress_time() {
		return job_stress_time;
	}

	public void setJob_stress_time(String job_stress_time) {
		this.job_stress_time = job_stress_time;
	}

	public String getJob_stress_notes() {
		return job_stress_notes;
	}

	public void setJob_stress_notes(String job_stress_notes) {
		this.job_stress_notes = job_stress_notes;
	}

	public String getJob_stress_collat_time() {
		return job_stress_collat_time;
	}

	public void setJob_stress_collat_time(String job_stress_collat_time) {
		this.job_stress_collat_time = job_stress_collat_time;
	}

	public String getJob_stress_collat_notes() {
		return job_stress_collat_notes;
	}

	public void setJob_stress_collat_notes(String job_stress_collat_notes) {
		this.job_stress_collat_notes = job_stress_collat_notes;
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

	public String getOther_text() {
		return other_text;
	}

	public void setOther_text(String other_text) {
		this.other_text = other_text;
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

	public String getOther_collat_text() {
		return other_collat_text;
	}

	public void setOther_collat_text(String other_collat_text) {
		this.other_collat_text = other_collat_text;
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
