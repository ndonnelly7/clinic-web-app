package com.cloud.clinic.model;

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
 * Lifestyle Class for corresponding page
 */

@Entity
public class Lifestyle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lifestyleID", unique = true, nullable = false)
	private int lifestyleID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;

	@ManyToOne(fetch = FetchType.LAZY)
	Patient patient;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	//Sleep
	boolean difficulty_sleep, night_waking, early_waking, meds_check, nap_check;
	boolean collat_sleep, collat_exercise, collat_alcohol, collat_smoking, collat_drug, collat_diet;
	
	@Column(columnDefinition="TEXT")
	String difficulty_sleep_notes;
	@Column(columnDefinition="TEXT")
	String difficulty_reason_notes;
	@Column(columnDefinition="TEXT")
	String difficulty_freq_notes;
	@Column(columnDefinition="TEXT")
	String difficulty_time_notes;
	String difficulty_reason, difficulty_freq, difficulty_time;

	@Column(columnDefinition="TEXT")
	String night_waking_notes;
	@Column(columnDefinition="TEXT")
	String night_waking_reason_notes;
	@Column(columnDefinition="TEXT")
	String night_waking_freq_notes;
	@Column(columnDefinition="TEXT")
	String night_waking_time_notes;
	String night_waking_reason, night_waking_freq, night_waking_time;

	@Column(columnDefinition="TEXT")
	String early_waking_notes;
	@Column(columnDefinition="TEXT")
	String early_waking_reason_notes;
	@Column(columnDefinition="TEXT")
	String early_waking_freq_notes;
	@Column(columnDefinition="TEXT")
	String early_waking_time_notes;
	String early_waking_reason, early_waking_freq, early_waking_time;

	@Column(columnDefinition="TEXT")
	String sleep_med_notes;
	@Column(columnDefinition="TEXT")
	String nap_notes;
	String sleep_length, sleep_meds, nap_length, nap_time;
	
	//Collateral Sleep
	boolean difficulty_sleep_collat, night_waking_collat, early_waking_collat, meds_check_collat, nap_check_collat;

	@Column(columnDefinition="TEXT")
	String difficulty_sleep_notes_collat;
	@Column(columnDefinition="TEXT")
	String difficulty_reason_notes_collat;
	@Column(columnDefinition="TEXT")
	String difficulty_freq_notes_collat;
	@Column(columnDefinition="TEXT")
	String difficulty_time_notes_collat;
	String difficulty_reason_collat, difficulty_freq_collat, difficulty_time_collat;

	@Column(columnDefinition="TEXT")
	String night_waking_notes_collat;
	@Column(columnDefinition="TEXT")
	String night_waking_reason_notes_collat;
	@Column(columnDefinition="TEXT")
	String night_waking_freq_notes_collat;
	@Column(columnDefinition="TEXT")
	String night_waking_time_notes_collat;
	String night_waking_reason_collat, night_waking_freq_collat, night_waking_time_collat;

	@Column(columnDefinition="TEXT")
	String early_waking_notes_collat;
	@Column(columnDefinition="TEXT")
	String early_waking_reason_notes_collat;
	@Column(columnDefinition="TEXT")
	String early_waking_freq_notes_collat;
	@Column(columnDefinition="TEXT")
	String early_waking_time_notes_collat;
	String early_waking_reason_collat, early_waking_freq_collat, early_waking_time_collat;

	@Column(columnDefinition="TEXT")
	String sleep_med_notes_collat;
	@Column(columnDefinition="TEXT")
	String nap_notes_collat;
	String sleep_length_collat, sleep_meds_collat, nap_length_collat, nap_time_collat;
	
	//Exercise
	String exercise;
	
	@OneToMany(mappedBy = "lifestyle", cascade = CascadeType.ALL)
	List<LifestyleActivity> activities;
	@OneToMany(mappedBy = "lifestyle", cascade = CascadeType.ALL)
	List<LifestyleActivity> collatActivities;
	
	//Diet
	String breakfast, lunch, dinner;
	@Column(columnDefinition="TEXT")
	String diet_notes;
	boolean miss_meals, sweets, fried, takeaway, cakes, weight, weight_interest;
	String weight_time;
	String miss_meals_freq, sweets_freq, fried_freq, takeaway_freq, cakes_freq, fruit_veg_amount;
	
	String breakfast_collat, lunch_collat, dinner_collat;
	@Column(columnDefinition="TEXT")
	String diet_notes_collat;
	boolean miss_meals_collat, sweets_collat, fried_collat, takeaway_collat, cakes_collat, weight_collat, weight_interest_collat;
	String weight_time_collat;
	String miss_meals_freq_collat, sweets_freq_collat, fried_freq_collat, takeaway_freq_collat, cakes_freq_collat, fruit_veg_amount_collat;
	
	//Alcohol
	String alcohol, alcohol_collat;
	float beer_pint_units, beer_bottle_units, spirits_units, wine_glass_units, pop_units;
	float beer_pint_units_collat, beer_bottle_units_collat, spirits_units_collat, wine_glass_units_collat, pop_units_collat;
	float total_units, total_units_collat;
	@Column(columnDefinition="TEXT")
	String alcohol_notes;
	@Column(columnDefinition="TEXT")
	String alcohol_notes_collat;
	boolean alcohol_reduce_interest, alcohol_reduce_interest_collat;
	
	//Smoking
	String smoking, smoking_collat;
	String packets, packets_collat;
	@Column(columnDefinition="TEXT")
	String smoking_notes;
	@Column(columnDefinition="TEXT")
	String smoking_notes_Collat;
	boolean smoking_reduce_interest, smoking_reduce_interest_collat;
	
	//Drugs
	boolean drugs, drugs_collat;
	@Column(columnDefinition="TEXT")
	String drugs_notes;
	@Column(columnDefinition="TEXT")
	String drugs_notes_collat;
	
	public Lifestyle()
	{
		
	}

	public int getLifestyleID() {
		return lifestyleID;
	}

	public void setLifestyleID(int lifestyleID) {
		this.lifestyleID = lifestyleID;
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

	public boolean isDifficulty_sleep() {
		return difficulty_sleep;
	}

	public void setDifficulty_sleep(boolean difficulty_sleep) {
		this.difficulty_sleep = difficulty_sleep;
	}

	public boolean isNight_waking() {
		return night_waking;
	}

	public void setNight_waking(boolean night_waking) {
		this.night_waking = night_waking;
	}

	public boolean isEarly_waking() {
		return early_waking;
	}

	public void setEarly_waking(boolean early_waking) {
		this.early_waking = early_waking;
	}

	public boolean isMeds_check() {
		return meds_check;
	}

	public void setMeds_check(boolean meds_check) {
		this.meds_check = meds_check;
	}

	public boolean isNap_check() {
		return nap_check;
	}

	public void setNap_check(boolean nap_check) {
		this.nap_check = nap_check;
	}

	public boolean isCollat_sleep() {
		return collat_sleep;
	}

	public void setCollat_sleep(boolean collat_sleep) {
		this.collat_sleep = collat_sleep;
	}

	public boolean isCollat_exercise() {
		return collat_exercise;
	}

	public void setCollat_exercise(boolean collat_exercise) {
		this.collat_exercise = collat_exercise;
	}

	public boolean isCollat_alcohol() {
		return collat_alcohol;
	}

	public void setCollat_alcohol(boolean collat_alcohol) {
		this.collat_alcohol = collat_alcohol;
	}

	public boolean isCollat_smoking() {
		return collat_smoking;
	}

	public void setCollat_smoking(boolean collat_smoking) {
		this.collat_smoking = collat_smoking;
	}

	public boolean isCollat_drug() {
		return collat_drug;
	}

	public void setCollat_drug(boolean collat_drug) {
		this.collat_drug = collat_drug;
	}

	public boolean isCollat_diet() {
		return collat_diet;
	}

	public void setCollat_diet(boolean collat_diet) {
		this.collat_diet = collat_diet;
	}

	public String getDifficulty_sleep_notes() {
		return difficulty_sleep_notes;
	}

	public void setDifficulty_sleep_notes(String difficulty_sleep_notes) {
		this.difficulty_sleep_notes = difficulty_sleep_notes;
	}

	public String getDifficulty_reason_notes() {
		return difficulty_reason_notes;
	}

	public void setDifficulty_reason_notes(String difficulty_reason_notes) {
		this.difficulty_reason_notes = difficulty_reason_notes;
	}

	public String getDifficulty_freq_notes() {
		return difficulty_freq_notes;
	}

	public void setDifficulty_freq_notes(String difficulty_freq_notes) {
		this.difficulty_freq_notes = difficulty_freq_notes;
	}

	public String getDifficulty_time_notes() {
		return difficulty_time_notes;
	}

	public void setDifficulty_time_notes(String difficulty_time_notes) {
		this.difficulty_time_notes = difficulty_time_notes;
	}

	public String getDifficulty_reason() {
		return difficulty_reason;
	}

	public void setDifficulty_reason(String difficulty_reason) {
		this.difficulty_reason = difficulty_reason;
	}

	public String getDifficulty_freq() {
		return difficulty_freq;
	}

	public void setDifficulty_freq(String difficulty_freq) {
		this.difficulty_freq = difficulty_freq;
	}

	public String getDifficulty_time() {
		return difficulty_time;
	}

	public void setDifficulty_time(String difficulty_time) {
		this.difficulty_time = difficulty_time;
	}

	public String getNight_waking_notes() {
		return night_waking_notes;
	}

	public void setNight_waking_notes(String night_waking_notes) {
		this.night_waking_notes = night_waking_notes;
	}

	public String getNight_waking_reason_notes() {
		return night_waking_reason_notes;
	}

	public void setNight_waking_reason_notes(String night_waking_reason_notes) {
		this.night_waking_reason_notes = night_waking_reason_notes;
	}

	public String getNight_waking_freq_notes() {
		return night_waking_freq_notes;
	}

	public void setNight_waking_freq_notes(String night_waking_freq_notes) {
		this.night_waking_freq_notes = night_waking_freq_notes;
	}

	public String getNight_waking_time_notes() {
		return night_waking_time_notes;
	}

	public void setNight_waking_time_notes(String night_waking_time_notes) {
		this.night_waking_time_notes = night_waking_time_notes;
	}

	public String getNight_waking_reason() {
		return night_waking_reason;
	}

	public void setNight_waking_reason(String night_waking_reason) {
		this.night_waking_reason = night_waking_reason;
	}

	public String getNight_waking_freq() {
		return night_waking_freq;
	}

	public void setNight_waking_freq(String night_waking_freq) {
		this.night_waking_freq = night_waking_freq;
	}

	public String getNight_waking_time() {
		return night_waking_time;
	}

	public void setNight_waking_time(String night_waking_time) {
		this.night_waking_time = night_waking_time;
	}

	public String getEarly_waking_notes() {
		return early_waking_notes;
	}

	public void setEarly_waking_notes(String early_waking_notes) {
		this.early_waking_notes = early_waking_notes;
	}

	public String getEarly_waking_reason_notes() {
		return early_waking_reason_notes;
	}

	public void setEarly_waking_reason_notes(String early_waking_reason_notes) {
		this.early_waking_reason_notes = early_waking_reason_notes;
	}

	public String getEarly_waking_freq_notes() {
		return early_waking_freq_notes;
	}

	public void setEarly_waking_freq_notes(String early_waking_freq_notes) {
		this.early_waking_freq_notes = early_waking_freq_notes;
	}

	public String getEarly_waking_time_notes() {
		return early_waking_time_notes;
	}

	public void setEarly_waking_time_notes(String early_waking_time_notes) {
		this.early_waking_time_notes = early_waking_time_notes;
	}

	public String getEarly_waking_reason() {
		return early_waking_reason;
	}

	public void setEarly_waking_reason(String early_waking_reason) {
		this.early_waking_reason = early_waking_reason;
	}

	public String getEarly_waking_freq() {
		return early_waking_freq;
	}

	public void setEarly_waking_freq(String early_waking_freq) {
		this.early_waking_freq = early_waking_freq;
	}

	public String getEarly_waking_time() {
		return early_waking_time;
	}

	public void setEarly_waking_time(String early_waking_time) {
		this.early_waking_time = early_waking_time;
	}

	public String getSleep_med_notes() {
		return sleep_med_notes;
	}

	public void setSleep_med_notes(String sleep_med_notes) {
		this.sleep_med_notes = sleep_med_notes;
	}

	public String getNap_notes() {
		return nap_notes;
	}

	public void setNap_notes(String nap_notes) {
		this.nap_notes = nap_notes;
	}

	public String getSleep_length() {
		return sleep_length;
	}

	public void setSleep_length(String sleep_length) {
		this.sleep_length = sleep_length;
	}

	public String getSleep_meds() {
		return sleep_meds;
	}

	public void setSleep_meds(String sleep_meds) {
		this.sleep_meds = sleep_meds;
	}

	public String getNap_length() {
		return nap_length;
	}

	public void setNap_length(String nap_length) {
		this.nap_length = nap_length;
	}

	public String getNap_time() {
		return nap_time;
	}

	public void setNap_time(String nap_time) {
		this.nap_time = nap_time;
	}

	public boolean isDifficulty_sleep_collat() {
		return difficulty_sleep_collat;
	}

	public void setDifficulty_sleep_collat(boolean difficulty_sleep_collat) {
		this.difficulty_sleep_collat = difficulty_sleep_collat;
	}

	public boolean isNight_waking_collat() {
		return night_waking_collat;
	}

	public void setNight_waking_collat(boolean night_waking_collat) {
		this.night_waking_collat = night_waking_collat;
	}

	public boolean isEarly_waking_collat() {
		return early_waking_collat;
	}

	public void setEarly_waking_collat(boolean early_waking_collat) {
		this.early_waking_collat = early_waking_collat;
	}

	public boolean isMeds_check_collat() {
		return meds_check_collat;
	}

	public void setMeds_check_collat(boolean meds_check_collat) {
		this.meds_check_collat = meds_check_collat;
	}

	public boolean isNap_check_collat() {
		return nap_check_collat;
	}

	public void setNap_check_collat(boolean nap_check_collat) {
		this.nap_check_collat = nap_check_collat;
	}

	public String getDifficulty_sleep_notes_collat() {
		return difficulty_sleep_notes_collat;
	}

	public void setDifficulty_sleep_notes_collat(
			String difficulty_sleep_notes_collat) {
		this.difficulty_sleep_notes_collat = difficulty_sleep_notes_collat;
	}

	public String getDifficulty_reason_notes_collat() {
		return difficulty_reason_notes_collat;
	}

	public void setDifficulty_reason_notes_collat(
			String difficulty_reason_notes_collat) {
		this.difficulty_reason_notes_collat = difficulty_reason_notes_collat;
	}

	public String getDifficulty_freq_notes_collat() {
		return difficulty_freq_notes_collat;
	}

	public void setDifficulty_freq_notes_collat(String difficulty_freq_notes_collat) {
		this.difficulty_freq_notes_collat = difficulty_freq_notes_collat;
	}

	public String getDifficulty_time_notes_collat() {
		return difficulty_time_notes_collat;
	}

	public void setDifficulty_time_notes_collat(String difficulty_time_notes_collat) {
		this.difficulty_time_notes_collat = difficulty_time_notes_collat;
	}

	public String getDifficulty_reason_collat() {
		return difficulty_reason_collat;
	}

	public void setDifficulty_reason_collat(String difficulty_reason_collat) {
		this.difficulty_reason_collat = difficulty_reason_collat;
	}

	public String getDifficulty_freq_collat() {
		return difficulty_freq_collat;
	}

	public void setDifficulty_freq_collat(String difficulty_freq_collat) {
		this.difficulty_freq_collat = difficulty_freq_collat;
	}

	public String getDifficulty_time_collat() {
		return difficulty_time_collat;
	}

	public void setDifficulty_time_collat(String difficulty_time_collat) {
		this.difficulty_time_collat = difficulty_time_collat;
	}

	public String getNight_waking_notes_collat() {
		return night_waking_notes_collat;
	}

	public void setNight_waking_notes_collat(String night_waking_notes_collat) {
		this.night_waking_notes_collat = night_waking_notes_collat;
	}

	public String getNight_waking_reason_notes_collat() {
		return night_waking_reason_notes_collat;
	}

	public void setNight_waking_reason_notes_collat(
			String night_waking_reason_notes_collat) {
		this.night_waking_reason_notes_collat = night_waking_reason_notes_collat;
	}

	public String getNight_waking_freq_notes_collat() {
		return night_waking_freq_notes_collat;
	}

	public void setNight_waking_freq_notes_collat(
			String night_waking_freq_notes_collat) {
		this.night_waking_freq_notes_collat = night_waking_freq_notes_collat;
	}

	public String getNight_waking_time_notes_collat() {
		return night_waking_time_notes_collat;
	}

	public void setNight_waking_time_notes_collat(
			String night_waking_time_notes_collat) {
		this.night_waking_time_notes_collat = night_waking_time_notes_collat;
	}

	public String getNight_waking_reason_collat() {
		return night_waking_reason_collat;
	}

	public void setNight_waking_reason_collat(String night_waking_reason_collat) {
		this.night_waking_reason_collat = night_waking_reason_collat;
	}

	public String getNight_waking_freq_collat() {
		return night_waking_freq_collat;
	}

	public void setNight_waking_freq_collat(String night_waking_freq_collat) {
		this.night_waking_freq_collat = night_waking_freq_collat;
	}

	public String getNight_waking_time_collat() {
		return night_waking_time_collat;
	}

	public void setNight_waking_time_collat(String night_waking_time_collat) {
		this.night_waking_time_collat = night_waking_time_collat;
	}

	public String getEarly_waking_notes_collat() {
		return early_waking_notes_collat;
	}

	public void setEarly_waking_notes_collat(String early_waking_notes_collat) {
		this.early_waking_notes_collat = early_waking_notes_collat;
	}

	public String getEarly_waking_reason_notes_collat() {
		return early_waking_reason_notes_collat;
	}

	public void setEarly_waking_reason_notes_collat(
			String early_waking_reason_notes_collat) {
		this.early_waking_reason_notes_collat = early_waking_reason_notes_collat;
	}

	public String getEarly_waking_freq_notes_collat() {
		return early_waking_freq_notes_collat;
	}

	public void setEarly_waking_freq_notes_collat(
			String early_waking_freq_notes_collat) {
		this.early_waking_freq_notes_collat = early_waking_freq_notes_collat;
	}

	public String getEarly_waking_time_notes_collat() {
		return early_waking_time_notes_collat;
	}

	public void setEarly_waking_time_notes_collat(
			String early_waking_time_notes_collat) {
		this.early_waking_time_notes_collat = early_waking_time_notes_collat;
	}

	public String getEarly_waking_reason_collat() {
		return early_waking_reason_collat;
	}

	public void setEarly_waking_reason_collat(String early_waking_reason_collat) {
		this.early_waking_reason_collat = early_waking_reason_collat;
	}

	public String getEarly_waking_freq_collat() {
		return early_waking_freq_collat;
	}

	public void setEarly_waking_freq_collat(String early_waking_freq_collat) {
		this.early_waking_freq_collat = early_waking_freq_collat;
	}

	public String getEarly_waking_time_collat() {
		return early_waking_time_collat;
	}

	public void setEarly_waking_time_collat(String early_waking_time_collat) {
		this.early_waking_time_collat = early_waking_time_collat;
	}

	public String getSleep_med_notes_collat() {
		return sleep_med_notes_collat;
	}

	public void setSleep_med_notes_collat(String sleep_med_notes_collat) {
		this.sleep_med_notes_collat = sleep_med_notes_collat;
	}

	public String getNap_notes_collat() {
		return nap_notes_collat;
	}

	public void setNap_notes_collat(String nap_notes_collat) {
		this.nap_notes_collat = nap_notes_collat;
	}

	public String getSleep_length_collat() {
		return sleep_length_collat;
	}

	public void setSleep_length_collat(String sleep_length_collat) {
		this.sleep_length_collat = sleep_length_collat;
	}

	public String getSleep_meds_collat() {
		return sleep_meds_collat;
	}

	public void setSleep_meds_collat(String sleep_meds_collat) {
		this.sleep_meds_collat = sleep_meds_collat;
	}

	public String getNap_length_collat() {
		return nap_length_collat;
	}

	public void setNap_length_collat(String nap_length_collat) {
		this.nap_length_collat = nap_length_collat;
	}

	public String getNap_time_collat() {
		return nap_time_collat;
	}

	public void setNap_time_collat(String nap_time_collat) {
		this.nap_time_collat = nap_time_collat;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public List<LifestyleActivity> getActivities() {
		return activities;
	}

	public void setActivities(List<LifestyleActivity> activities) {
		this.activities = activities;
	}

	public List<LifestyleActivity> getCollatActivities() {
		return collatActivities;
	}

	public void setCollatActivities(List<LifestyleActivity> collatActivities) {
		this.collatActivities = collatActivities;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getDiet_notes() {
		return diet_notes;
	}

	public void setDiet_notes(String diet_notes) {
		this.diet_notes = diet_notes;
	}

	public boolean isMiss_meals() {
		return miss_meals;
	}

	public void setMiss_meals(boolean miss_meals) {
		this.miss_meals = miss_meals;
	}

	public boolean isSweets() {
		return sweets;
	}

	public void setSweets(boolean sweets) {
		this.sweets = sweets;
	}

	public boolean isFried() {
		return fried;
	}

	public void setFried(boolean fried) {
		this.fried = fried;
	}

	public boolean isTakeaway() {
		return takeaway;
	}

	public void setTakeaway(boolean takeaway) {
		this.takeaway = takeaway;
	}

	public boolean isCakes() {
		return cakes;
	}

	public void setCakes(boolean cakes) {
		this.cakes = cakes;
	}

	public boolean isWeight() {
		return weight;
	}

	public void setWeight(boolean weight) {
		this.weight = weight;
	}

	public boolean isWeight_interest() {
		return weight_interest;
	}

	public void setWeight_interest(boolean weight_interest) {
		this.weight_interest = weight_interest;
	}

	public String getWeight_time() {
		return weight_time;
	}

	public void setWeight_time(String weight_time) {
		this.weight_time = weight_time;
	}

	public String getMiss_meals_freq() {
		return miss_meals_freq;
	}

	public void setMiss_meals_freq(String miss_meals_freq) {
		this.miss_meals_freq = miss_meals_freq;
	}

	public String getSweets_freq() {
		return sweets_freq;
	}

	public void setSweets_freq(String sweets_freq) {
		this.sweets_freq = sweets_freq;
	}

	public String getFried_freq() {
		return fried_freq;
	}

	public void setFried_freq(String fried_freq) {
		this.fried_freq = fried_freq;
	}

	public String getTakeaway_freq() {
		return takeaway_freq;
	}

	public void setTakeaway_freq(String takeaway_freq) {
		this.takeaway_freq = takeaway_freq;
	}

	public String getCakes_freq() {
		return cakes_freq;
	}

	public void setCakes_freq(String cakes_freq) {
		this.cakes_freq = cakes_freq;
	}

	public String getFruit_veg_amount() {
		return fruit_veg_amount;
	}

	public void setFruit_veg_amount(String fruit_veg_amount) {
		this.fruit_veg_amount = fruit_veg_amount;
	}

	public String getBreakfast_collat() {
		return breakfast_collat;
	}

	public void setBreakfast_collat(String breakfast_collat) {
		this.breakfast_collat = breakfast_collat;
	}

	public String getLunch_collat() {
		return lunch_collat;
	}

	public void setLunch_collat(String lunch_collat) {
		this.lunch_collat = lunch_collat;
	}

	public String getDinner_collat() {
		return dinner_collat;
	}

	public void setDinner_collat(String dinner_collat) {
		this.dinner_collat = dinner_collat;
	}

	public String getDiet_notes_collat() {
		return diet_notes_collat;
	}

	public void setDiet_notes_collat(String diet_notes_collat) {
		this.diet_notes_collat = diet_notes_collat;
	}

	public boolean isMiss_meals_collat() {
		return miss_meals_collat;
	}

	public void setMiss_meals_collat(boolean miss_meals_collat) {
		this.miss_meals_collat = miss_meals_collat;
	}

	public boolean isSweets_collat() {
		return sweets_collat;
	}

	public void setSweets_collat(boolean sweets_collat) {
		this.sweets_collat = sweets_collat;
	}

	public boolean isFried_collat() {
		return fried_collat;
	}

	public void setFried_collat(boolean fried_collat) {
		this.fried_collat = fried_collat;
	}

	public boolean isTakeaway_collat() {
		return takeaway_collat;
	}

	public void setTakeaway_collat(boolean takeaway_collat) {
		this.takeaway_collat = takeaway_collat;
	}

	public boolean isCakes_collat() {
		return cakes_collat;
	}

	public void setCakes_collat(boolean cakes_collat) {
		this.cakes_collat = cakes_collat;
	}

	public boolean isWeight_collat() {
		return weight_collat;
	}

	public void setWeight_collat(boolean weight_collat) {
		this.weight_collat = weight_collat;
	}

	public boolean isWeight_interest_collat() {
		return weight_interest_collat;
	}

	public void setWeight_interest_collat(boolean weight_interest_collat) {
		this.weight_interest_collat = weight_interest_collat;
	}

	public String getWeight_time_collat() {
		return weight_time_collat;
	}

	public void setWeight_time_collat(String weight_time_collat) {
		this.weight_time_collat = weight_time_collat;
	}

	public String getMiss_meals_freq_collat() {
		return miss_meals_freq_collat;
	}

	public void setMiss_meals_freq_collat(String miss_meals_freq_collat) {
		this.miss_meals_freq_collat = miss_meals_freq_collat;
	}

	public String getSweets_freq_collat() {
		return sweets_freq_collat;
	}

	public void setSweets_freq_collat(String sweets_freq_collat) {
		this.sweets_freq_collat = sweets_freq_collat;
	}

	public String getFried_freq_collat() {
		return fried_freq_collat;
	}

	public void setFried_freq_collat(String fried_freq_collat) {
		this.fried_freq_collat = fried_freq_collat;
	}

	public String getTakeaway_freq_collat() {
		return takeaway_freq_collat;
	}

	public void setTakeaway_freq_collat(String takeaway_freq_collat) {
		this.takeaway_freq_collat = takeaway_freq_collat;
	}

	public String getCakes_freq_collat() {
		return cakes_freq_collat;
	}

	public void setCakes_freq_collat(String cakes_freq_collat) {
		this.cakes_freq_collat = cakes_freq_collat;
	}

	public String getFruit_veg_amount_collat() {
		return fruit_veg_amount_collat;
	}

	public void setFruit_veg_amount_collat(String fruit_veg_amount_collat) {
		this.fruit_veg_amount_collat = fruit_veg_amount_collat;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getAlcohol_collat() {
		return alcohol_collat;
	}

	public void setAlcohol_collat(String alcohol_collat) {
		this.alcohol_collat = alcohol_collat;
	}

	public float getBeer_pint_units() {
		return beer_pint_units;
	}

	public void setBeer_pint_units(float beer_pint_units) {
		this.beer_pint_units = beer_pint_units;
	}

	public float getBeer_bottle_units() {
		return beer_bottle_units;
	}

	public void setBeer_bottle_units(float beer_bottle_units) {
		this.beer_bottle_units = beer_bottle_units;
	}

	public float getSpirits_units() {
		return spirits_units;
	}

	public void setSpirits_units(float spirits_units) {
		this.spirits_units = spirits_units;
	}

	public float getWine_glass_units() {
		return wine_glass_units;
	}

	public void setWine_glass_units(float wine_glass_units) {
		this.wine_glass_units = wine_glass_units;
	}

	public float getPop_units() {
		return pop_units;
	}

	public void setPop_units(float pop_units) {
		this.pop_units = pop_units;
	}

	public float getBeer_pint_units_collat() {
		return beer_pint_units_collat;
	}

	public void setBeer_pint_units_collat(float beer_pint_units_collat) {
		this.beer_pint_units_collat = beer_pint_units_collat;
	}

	public float getBeer_bottle_units_collat() {
		return beer_bottle_units_collat;
	}

	public void setBeer_bottle_units_collat(float beer_bottle_units_collat) {
		this.beer_bottle_units_collat = beer_bottle_units_collat;
	}

	public float getSpirits_units_collat() {
		return spirits_units_collat;
	}

	public void setSpirits_units_collat(float spirits_units_collat) {
		this.spirits_units_collat = spirits_units_collat;
	}

	public float getWine_glass_units_collat() {
		return wine_glass_units_collat;
	}

	public void setWine_glass_units_collat(float wine_glass_units_collat) {
		this.wine_glass_units_collat = wine_glass_units_collat;
	}

	public float getPop_units_collat() {
		return pop_units_collat;
	}

	public void setPop_units_collat(float pop_units_collat) {
		this.pop_units_collat = pop_units_collat;
	}

	public float getTotal_units() {
		return total_units;
	}

	public void setTotal_units(float total_units) {
		this.total_units = total_units;
	}

	public float getTotal_units_collat() {
		return total_units_collat;
	}

	public void setTotal_units_collat(float total_units_collat) {
		this.total_units_collat = total_units_collat;
	}

	public String getAlcohol_notes() {
		return alcohol_notes;
	}

	public void setAlcohol_notes(String alcohol_notes) {
		this.alcohol_notes = alcohol_notes;
	}

	public String getAlcohol_notes_collat() {
		return alcohol_notes_collat;
	}

	public void setAlcohol_notes_collat(String alcohol_notes_collat) {
		this.alcohol_notes_collat = alcohol_notes_collat;
	}

	public boolean isAlcohol_reduce_interest() {
		return alcohol_reduce_interest;
	}

	public void setAlcohol_reduce_interest(boolean alcohol_reduce_interest) {
		this.alcohol_reduce_interest = alcohol_reduce_interest;
	}

	public boolean isAlcohol_reduce_interest_collat() {
		return alcohol_reduce_interest_collat;
	}

	public void setAlcohol_reduce_interest_collat(
			boolean alcohol_reduce_interest_collat) {
		this.alcohol_reduce_interest_collat = alcohol_reduce_interest_collat;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getSmoking_collat() {
		return smoking_collat;
	}

	public void setSmoking_collat(String smoking_collat) {
		this.smoking_collat = smoking_collat;
	}

	public String getPackets() {
		return packets;
	}

	public void setPackets(String packets) {
		this.packets = packets;
	}

	public String getPackets_collat() {
		return packets_collat;
	}

	public void setPackets_collat(String packets_collat) {
		this.packets_collat = packets_collat;
	}

	public String getSmoking_notes() {
		return smoking_notes;
	}

	public void setSmoking_notes(String smoking_notes) {
		this.smoking_notes = smoking_notes;
	}

	public String getSmoking_notes_Collat() {
		return smoking_notes_Collat;
	}

	public void setSmoking_notes_Collat(String smoking_notes_Collat) {
		this.smoking_notes_Collat = smoking_notes_Collat;
	}

	public boolean isSmoking_reduce_interest() {
		return smoking_reduce_interest;
	}

	public void setSmoking_reduce_interest(boolean smoking_reduce_interest) {
		this.smoking_reduce_interest = smoking_reduce_interest;
	}

	public boolean isSmoking_reduce_interest_collat() {
		return smoking_reduce_interest_collat;
	}

	public void setSmoking_reduce_interest_collat(
			boolean smoking_reduce_interest_collat) {
		this.smoking_reduce_interest_collat = smoking_reduce_interest_collat;
	}

	public boolean isDrugs() {
		return drugs;
	}

	public void setDrugs(boolean drugs) {
		this.drugs = drugs;
	}

	public boolean isDrugs_collat() {
		return drugs_collat;
	}

	public void setDrugs_collat(boolean drugs_collat) {
		this.drugs_collat = drugs_collat;
	}

	public String getDrugs_notes() {
		return drugs_notes;
	}

	public void setDrugs_notes(String drugs_notes) {
		this.drugs_notes = drugs_notes;
	}

	public String getDrugs_notes_collat() {
		return drugs_notes_collat;
	}

	public void setDrugs_notes_collat(String drugs_notes_collat) {
		this.drugs_notes_collat = drugs_notes_collat;
	}

}
