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
 * Class used for the Neurological History page of the form
 */

@Entity
public class NeuroHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "neuroHistoryID", unique = true, nullable = false)
	int neuroHistoryID;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Form form;

	@Transient
	protected Object[] jdoDetachedState;

	@Expose
	boolean blackout_check, blanks_check, blurred_vision_check, dizziness_check, fainting_check, headaches_check, falling_check, seizures_check, dexterity_check;
	@Expose
	boolean blackout_check_collat, blanks_check_collat, blurred_vision_check_collat, dizziness_check_collat;
	@Expose
	boolean fainting_check_collat, headaches_check_collat, falling_check_collat, seizures_check_collat, dexterity_check_collat;

	@Expose
	String blackout_time, blackout_freq, blackout_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String blackout_notes;

	@Expose
	String blanks_time, blanks_freq, blanks_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String blanks_notes;

	@Expose
	String blurred_vision_time, blurred_vision_freq, blurred_vision_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String blurred_vision_notes;

	@Expose
	String dizziness_time, dizziness_freq, dizziness_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String dizziness_notes;

	@Expose
	String fainting_time, fainting_freq, fainting_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String fainting_notes;

	@Expose
	String headaches_time, headaches_freq, headaches_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String headaches_notes;

	@Expose
	String falling_time, falling_freq, falling_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String falling_notes;

	@Expose
	String seizures_time, seizures_freq, seizures_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String seizures_notes;

	@Expose
	String dexterity_time, dexterity_freq, dexterity_investigated;
	@Expose
	@Column(columnDefinition="TEXT")
	String dexterity_notes;

	@Expose
	String blackout_time_collat, blackout_freq_collat, blackout_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String blackout_notes_collat;

	@Expose
	String blanks_time_collat, blanks_freq_collat, blanks_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String blanks_notes_collat;

	@Expose
	String blurred_vision_time_collat, blurred_vision_freq_collat, blurred_vision_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String blurred_vision_notes_collat;

	@Expose
	String dizziness_time_collat, dizziness_freq_collat, dizziness_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String dizziness_notes_collat;

	@Expose
	String fainting_time_collat, fainting_freq_collat, fainting_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String fainting_notes_collat;

	@Expose
	String headaches_time_collat, headaches_freq_collat, headaches_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String headaches_notes_collat;

	@Expose
	String falling_time_collat, falling_freq_collat, falling_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String falling_notes_collat;

	@Expose
	String seizures_time_collat, seizures_freq_collat, seizures_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String seizures_notes_collat;

	@Expose
	String dexterity_time_collat, dexterity_freq_collat, dexterity_investigated_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String dexterity_notes_collat;
	
	public NeuroHistory()
	{
		
	}


	public int getNeuroHistoryID() {
		return neuroHistoryID;
	}


	public void setNeuroHistoryID(int neuroHistoryID) {
		this.neuroHistoryID = neuroHistoryID;
	}


	public Form getForm() {
		return form;
	}


	public void setForm(Form form) {
		this.form = form;
	}


	public boolean isDexterity_check() {
		return dexterity_check;
	}


	public void setDexterity_check(boolean dexterity_check) {
		this.dexterity_check = dexterity_check;
	}


	public boolean isDexterity_check_collat() {
		return dexterity_check_collat;
	}


	public void setDexterity_check_collat(boolean dexterity_check_collat) {
		this.dexterity_check_collat = dexterity_check_collat;
	}


	public String getBlackout_investigated() {
		return blackout_investigated;
	}


	public void setBlackout_investigated(String blackout_investigated) {
		this.blackout_investigated = blackout_investigated;
	}


	public String getBlanks_investigated() {
		return blanks_investigated;
	}


	public void setBlanks_investigated(String blanks_investigated) {
		this.blanks_investigated = blanks_investigated;
	}


	public String getBlurred_vision_time() {
		return blurred_vision_time;
	}


	public void setBlurred_vision_time(String blurred_vision_time) {
		this.blurred_vision_time = blurred_vision_time;
	}


	public String getBlurred_vision_freq() {
		return blurred_vision_freq;
	}


	public void setBlurred_vision_freq(String blurred_vision_freq) {
		this.blurred_vision_freq = blurred_vision_freq;
	}


	public String getBlurred_vision_investigated() {
		return blurred_vision_investigated;
	}


	public void setBlurred_vision_investigated(String blurred_vision_investigated) {
		this.blurred_vision_investigated = blurred_vision_investigated;
	}


	public String getBlurred_vision_notes() {
		return blurred_vision_notes;
	}


	public void setBlurred_vision_notes(String blurred_vision_notes) {
		this.blurred_vision_notes = blurred_vision_notes;
	}


	public String getDizziness_time() {
		return dizziness_time;
	}


	public void setDizziness_time(String dizziness_time) {
		this.dizziness_time = dizziness_time;
	}


	public String getDizziness_freq() {
		return dizziness_freq;
	}


	public void setDizziness_freq(String dizziness_freq) {
		this.dizziness_freq = dizziness_freq;
	}


	public String getDizziness_investigated() {
		return dizziness_investigated;
	}


	public void setDizziness_investigated(String dizziness_investigated) {
		this.dizziness_investigated = dizziness_investigated;
	}


	public String getDizziness_notes() {
		return dizziness_notes;
	}


	public void setDizziness_notes(String dizziness_notes) {
		this.dizziness_notes = dizziness_notes;
	}


	public String getFainting_time() {
		return fainting_time;
	}


	public void setFainting_time(String fainting_time) {
		this.fainting_time = fainting_time;
	}


	public String getFainting_freq() {
		return fainting_freq;
	}


	public void setFainting_freq(String fainting_freq) {
		this.fainting_freq = fainting_freq;
	}


	public String getFainting_investigated() {
		return fainting_investigated;
	}


	public void setFainting_investigated(String fainting_investigated) {
		this.fainting_investigated = fainting_investigated;
	}


	public String getFainting_notes() {
		return fainting_notes;
	}


	public void setFainting_notes(String fainting_notes) {
		this.fainting_notes = fainting_notes;
	}


	public String getHeadaches_investigated() {
		return headaches_investigated;
	}


	public void setHeadaches_investigated(String headaches_investigated) {
		this.headaches_investigated = headaches_investigated;
	}


	public String getFalling_investigated() {
		return falling_investigated;
	}


	public void setFalling_investigated(String falling_investigated) {
		this.falling_investigated = falling_investigated;
	}


	public String getSeizures_investigated() {
		return seizures_investigated;
	}


	public void setSeizures_investigated(String seizures_investigated) {
		this.seizures_investigated = seizures_investigated;
	}


	public String getDexterity_time() {
		return dexterity_time;
	}


	public void setDexterity_time(String dexterity_time) {
		this.dexterity_time = dexterity_time;
	}


	public String getDexterity_freq() {
		return dexterity_freq;
	}


	public void setDexterity_freq(String dexterity_freq) {
		this.dexterity_freq = dexterity_freq;
	}


	public String getDexterity_investigated() {
		return dexterity_investigated;
	}


	public void setDexterity_investigated(String dexterity_investigated) {
		this.dexterity_investigated = dexterity_investigated;
	}


	public String getDexterity_notes() {
		return dexterity_notes;
	}


	public void setDexterity_notes(String dexterity_notes) {
		this.dexterity_notes = dexterity_notes;
	}


	public String getBlackout_investigated_collat() {
		return blackout_investigated_collat;
	}


	public void setBlackout_investigated_collat(String blackout_investigated_collat) {
		this.blackout_investigated_collat = blackout_investigated_collat;
	}


	public String getBlanks_investigated_collat() {
		return blanks_investigated_collat;
	}


	public void setBlanks_investigated_collat(String blanks_investigated_collat) {
		this.blanks_investigated_collat = blanks_investigated_collat;
	}


	public String getBlurred_vision_time_collat() {
		return blurred_vision_time_collat;
	}


	public void setBlurred_vision_time_collat(String blurred_vision_time_collat) {
		this.blurred_vision_time_collat = blurred_vision_time_collat;
	}


	public String getBlurred_vision_freq_collat() {
		return blurred_vision_freq_collat;
	}


	public void setBlurred_vision_freq_collat(String blurred_vision_freq_collat) {
		this.blurred_vision_freq_collat = blurred_vision_freq_collat;
	}


	public String getBlurred_vision_investigated_collat() {
		return blurred_vision_investigated_collat;
	}


	public void setBlurred_vision_investigated_collat(
			String blurred_vision_investigated_collat) {
		this.blurred_vision_investigated_collat = blurred_vision_investigated_collat;
	}


	public String getBlurred_vision_notes_collat() {
		return blurred_vision_notes_collat;
	}


	public void setBlurred_vision_notes_collat(String blurred_vision_notes_collat) {
		this.blurred_vision_notes_collat = blurred_vision_notes_collat;
	}


	public String getDizziness_time_collat() {
		return dizziness_time_collat;
	}


	public void setDizziness_time_collat(String dizziness_time_collat) {
		this.dizziness_time_collat = dizziness_time_collat;
	}


	public String getDizziness_freq_collat() {
		return dizziness_freq_collat;
	}


	public void setDizziness_freq_collat(String dizziness_freq_collat) {
		this.dizziness_freq_collat = dizziness_freq_collat;
	}


	public String getDizziness_investigated_collat() {
		return dizziness_investigated_collat;
	}


	public void setDizziness_investigated_collat(
			String dizziness_investigated_collat) {
		this.dizziness_investigated_collat = dizziness_investigated_collat;
	}


	public String getDizziness_notes_collat() {
		return dizziness_notes_collat;
	}


	public void setDizziness_notes_collat(String dizziness_notes_collat) {
		this.dizziness_notes_collat = dizziness_notes_collat;
	}


	public String getFainting_time_collat() {
		return fainting_time_collat;
	}


	public void setFainting_time_collat(String fainting_time_collat) {
		this.fainting_time_collat = fainting_time_collat;
	}


	public String getFainting_freq_collat() {
		return fainting_freq_collat;
	}


	public void setFainting_freq_collat(String fainting_freq_collat) {
		this.fainting_freq_collat = fainting_freq_collat;
	}


	public String getFainting_investigated_collat() {
		return fainting_investigated_collat;
	}


	public void setFainting_investigated_collat(String fainting_investigated_collat) {
		this.fainting_investigated_collat = fainting_investigated_collat;
	}


	public String getFainting_notes_collat() {
		return fainting_notes_collat;
	}


	public void setFainting_notes_collat(String fainting_notes_collat) {
		this.fainting_notes_collat = fainting_notes_collat;
	}


	public String getHeadaches_investigated_collat() {
		return headaches_investigated_collat;
	}


	public void setHeadaches_investigated_collat(
			String headaches_investigated_collat) {
		this.headaches_investigated_collat = headaches_investigated_collat;
	}


	public String getFalling_investigated_collat() {
		return falling_investigated_collat;
	}


	public void setFalling_investigated_collat(String falling_investigated_collat) {
		this.falling_investigated_collat = falling_investigated_collat;
	}


	public String getSeizures_investigated_collat() {
		return seizures_investigated_collat;
	}


	public void setSeizures_investigated_collat(String seizures_investigated_collat) {
		this.seizures_investigated_collat = seizures_investigated_collat;
	}


	public String getDexterity_time_collat() {
		return dexterity_time_collat;
	}


	public void setDexterity_time_collat(String dexterity_time_collat) {
		this.dexterity_time_collat = dexterity_time_collat;
	}


	public String getDexterity_freq_collat() {
		return dexterity_freq_collat;
	}


	public void setDexterity_freq_collat(String dexterity_freq_collat) {
		this.dexterity_freq_collat = dexterity_freq_collat;
	}


	public String getDexterity_investigated_collat() {
		return dexterity_investigated_collat;
	}


	public void setDexterity_investigated_collat(
			String dexterity_investigated_collat) {
		this.dexterity_investigated_collat = dexterity_investigated_collat;
	}


	public String getDexterity_notes_collat() {
		return dexterity_notes_collat;
	}


	public void setDexterity_notes_collat(String dexterity_notes_collat) {
		this.dexterity_notes_collat = dexterity_notes_collat;
	}


	public boolean isBlanks_check_collat() {
		return blanks_check_collat;
	}


	public void setBlanks_check_collat(boolean blanks_check_collat) {
		this.blanks_check_collat = blanks_check_collat;
	}


	public boolean isBlackout_check() {
		return blackout_check;
	}


	public void setBlackout_check(boolean blackout_check) {
		this.blackout_check = blackout_check;
	}


	public boolean isBlanks_check() {
		return blanks_check;
	}


	public void setBlanks_check(boolean blanks_check) {
		this.blanks_check = blanks_check;
	}


	public boolean isBlurred_vision_check() {
		return blurred_vision_check;
	}


	public void setBlurred_vision_check(boolean blurred_vision_check) {
		this.blurred_vision_check = blurred_vision_check;
	}


	public boolean isDizziness_check() {
		return dizziness_check;
	}


	public void setDizziness_check(boolean dizziness_check) {
		this.dizziness_check = dizziness_check;
	}


	public boolean isFainting_check() {
		return fainting_check;
	}


	public void setFainting_check(boolean fainting_check) {
		this.fainting_check = fainting_check;
	}


	public boolean isHeadaches_check() {
		return headaches_check;
	}


	public void setHeadaches_check(boolean headaches_check) {
		this.headaches_check = headaches_check;
	}


	public boolean isFalling_check() {
		return falling_check;
	}


	public void setFalling_check(boolean falling_check) {
		this.falling_check = falling_check;
	}


	public boolean isSeizures_check() {
		return seizures_check;
	}


	public void setSeizures_check(boolean seizures_check) {
		this.seizures_check = seizures_check;
	}


	public boolean isBlackout_check_collat() {
		return blackout_check_collat;
	}


	public void setBlackout_check_collat(boolean blackout_check_collat) {
		this.blackout_check_collat = blackout_check_collat;
	}


	public boolean isBlank_check_collat() {
		return blanks_check_collat;
	}


	public void setBlank_check_collat(boolean blank_check_collat) {
		this.blanks_check_collat = blank_check_collat;
	}


	public boolean isBlurred_vision_check_collat() {
		return blurred_vision_check_collat;
	}


	public void setBlurred_vision_check_collat(boolean blurred_vision_check_collat) {
		this.blurred_vision_check_collat = blurred_vision_check_collat;
	}


	public boolean isDizziness_check_collat() {
		return dizziness_check_collat;
	}


	public void setDizziness_check_collat(boolean dizziness_check_collat) {
		this.dizziness_check_collat = dizziness_check_collat;
	}


	public boolean isFainting_check_collat() {
		return fainting_check_collat;
	}


	public void setFainting_check_collat(boolean fainting_check_collat) {
		this.fainting_check_collat = fainting_check_collat;
	}


	public boolean isHeadaches_check_collat() {
		return headaches_check_collat;
	}


	public void setHeadaches_check_collat(boolean headaches_check_collat) {
		this.headaches_check_collat = headaches_check_collat;
	}


	public boolean isFalling_check_collat() {
		return falling_check_collat;
	}


	public void setFalling_check_collat(boolean falling_check_collat) {
		this.falling_check_collat = falling_check_collat;
	}


	public boolean isSeizures_check_collat() {
		return seizures_check_collat;
	}


	public void setSeizures_check_collat(boolean seizures_check_collat) {
		this.seizures_check_collat = seizures_check_collat;
	}


	public String getBlackout_time() {
		return blackout_time;
	}


	public void setBlackout_time(String blackout_time) {
		this.blackout_time = blackout_time;
	}


	public String getBlackout_freq() {
		return blackout_freq;
	}


	public void setBlackout_freq(String blackout_freq) {
		this.blackout_freq = blackout_freq;
	}


	public String getBlackout_notes() {
		return blackout_notes;
	}


	public void setBlackout_notes(String blackout_notes) {
		this.blackout_notes = blackout_notes;
	}


	public String getBlanks_time() {
		return blanks_time;
	}


	public void setBlanks_time(String blanks_time) {
		this.blanks_time = blanks_time;
	}


	public String getBlanks_freq() {
		return blanks_freq;
	}


	public void setBlanks_freq(String blanks_freq) {
		this.blanks_freq = blanks_freq;
	}


	public String getBlanks_notes() {
		return blanks_notes;
	}


	public void setBlanks_notes(String blanks_notes) {
		this.blanks_notes = blanks_notes;
	}


	public String getblurred_vision_time() {
		return blurred_vision_time;
	}


	public void setblurred_vision_time(String blurred_vision_time) {
		this.blurred_vision_time = blurred_vision_time;
	}


	public String getblurred_vision_freq() {
		return blurred_vision_freq;
	}


	public void setblurred_vision_freq(String blurred_vision_freq) {
		this.blurred_vision_freq = blurred_vision_freq;
	}


	public String getblurred_vision_notes() {
		return blurred_vision_notes;
	}


	public void setblurred_vision_notes(String blurred_vision_notes) {
		this.blurred_vision_notes = blurred_vision_notes;
	}


	public String getdizziness_time() {
		return dizziness_time;
	}


	public void setdizziness_time(String dizziness_time) {
		this.dizziness_time = dizziness_time;
	}


	public String getdizziness_freq() {
		return dizziness_freq;
	}


	public void setdizziness_freq(String dizziness_freq) {
		this.dizziness_freq = dizziness_freq;
	}


	public String getdizziness_notes() {
		return dizziness_notes;
	}


	public void setdizziness_notes(String dizziness_notes) {
		this.dizziness_notes = dizziness_notes;
	}


	public String getfainting_time() {
		return fainting_time;
	}


	public void setfainting_time(String fainting_time) {
		this.fainting_time = fainting_time;
	}


	public String getfainting_freq() {
		return fainting_freq;
	}


	public void setfainting_freq(String fainting_freq) {
		this.fainting_freq = fainting_freq;
	}


	public String getfainting_notes() {
		return fainting_notes;
	}


	public void setfainting_notes(String fainting_notes) {
		this.fainting_notes = fainting_notes;
	}


	public String getHeadaches_time() {
		return headaches_time;
	}


	public void setHeadaches_time(String headaches_time) {
		this.headaches_time = headaches_time;
	}


	public String getHeadaches_freq() {
		return headaches_freq;
	}


	public void setHeadaches_freq(String headaches_freq) {
		this.headaches_freq = headaches_freq;
	}


	public String getHeadaches_notes() {
		return headaches_notes;
	}


	public void setHeadaches_notes(String headaches_notes) {
		this.headaches_notes = headaches_notes;
	}


	public String getFalling_time() {
		return falling_time;
	}


	public void setFalling_time(String falling_time) {
		this.falling_time = falling_time;
	}


	public String getFalling_freq() {
		return falling_freq;
	}


	public void setFalling_freq(String falling_freq) {
		this.falling_freq = falling_freq;
	}


	public String getFalling_notes() {
		return falling_notes;
	}


	public void setFalling_notes(String falling_notes) {
		this.falling_notes = falling_notes;
	}


	public String getSeizures_time() {
		return seizures_time;
	}


	public void setSeizures_time(String seizures_time) {
		this.seizures_time = seizures_time;
	}


	public String getSeizures_freq() {
		return seizures_freq;
	}


	public void setSeizures_freq(String seizures_freq) {
		this.seizures_freq = seizures_freq;
	}


	public String getSeizures_notes() {
		return seizures_notes;
	}


	public void setSeizures_notes(String seizures_notes) {
		this.seizures_notes = seizures_notes;
	}


	public String getBlackout_time_collat() {
		return blackout_time_collat;
	}


	public void setBlackout_time_collat(String blackout_time_collat) {
		this.blackout_time_collat = blackout_time_collat;
	}


	public String getBlackout_freq_collat() {
		return blackout_freq_collat;
	}


	public void setBlackout_freq_collat(String blackout_freq_collat) {
		this.blackout_freq_collat = blackout_freq_collat;
	}


	public String getBlackout_notes_collat() {
		return blackout_notes_collat;
	}


	public void setBlackout_notes_collat(String blackout_notes_collat) {
		this.blackout_notes_collat = blackout_notes_collat;
	}


	public String getBlanks_time_collat() {
		return blanks_time_collat;
	}


	public void setBlanks_time_collat(String blanks_time_collat) {
		this.blanks_time_collat = blanks_time_collat;
	}


	public String getBlanks_freq_collat() {
		return blanks_freq_collat;
	}


	public void setBlanks_freq_collat(String blanks_freq_collat) {
		this.blanks_freq_collat = blanks_freq_collat;
	}


	public String getBlanks_notes_collat() {
		return blanks_notes_collat;
	}


	public void setBlanks_notes_collat(String blanks_notes_collat) {
		this.blanks_notes_collat = blanks_notes_collat;
	}


	public String getblurred_vision_time_collat() {
		return blurred_vision_time_collat;
	}


	public void setblurred_vision_time_collat(String blurred_vision_time_collat) {
		this.blurred_vision_time_collat = blurred_vision_time_collat;
	}


	public String getblurred_vision_freq_collat() {
		return blurred_vision_freq_collat;
	}


	public void setblurred_vision_freq_collat(String blurred_vision_freq_collat) {
		this.blurred_vision_freq_collat = blurred_vision_freq_collat;
	}


	public String getblurred_vision_notes_collat() {
		return blurred_vision_notes_collat;
	}


	public void setblurred_vision_notes_collat(String blurred_vision_notes_collat) {
		this.blurred_vision_notes_collat = blurred_vision_notes_collat;
	}


	public String getdizziness_time_collat() {
		return dizziness_time_collat;
	}


	public void setdizziness_time_collat(String dizziness_time_collat) {
		this.dizziness_time_collat = dizziness_time_collat;
	}


	public String getdizziness_freq_collat() {
		return dizziness_freq_collat;
	}


	public void setdizziness_freq_collat(String dizziness_freq_collat) {
		this.dizziness_freq_collat = dizziness_freq_collat;
	}


	public String getdizziness_notes_collat() {
		return dizziness_notes_collat;
	}


	public void setdizziness_notes_collat(String dizziness_notes_collat) {
		this.dizziness_notes_collat = dizziness_notes_collat;
	}


	public String getfainting_time_collat() {
		return fainting_time_collat;
	}


	public void setfainting_time_collat(String fainting_time_collat) {
		this.fainting_time_collat = fainting_time_collat;
	}


	public String getfainting_freq_collat() {
		return fainting_freq_collat;
	}


	public void setfainting_freq_collat(String fainting_freq_collat) {
		this.fainting_freq_collat = fainting_freq_collat;
	}


	public String getfainting_notes_collat() {
		return fainting_notes_collat;
	}


	public void setfainting_notes_collat(String fainting_notes_collat) {
		this.fainting_notes_collat = fainting_notes_collat;
	}


	public String getHeadaches_time_collat() {
		return headaches_time_collat;
	}


	public void setHeadaches_time_collat(String headaches_time_collat) {
		this.headaches_time_collat = headaches_time_collat;
	}


	public String getHeadaches_freq_collat() {
		return headaches_freq_collat;
	}


	public void setHeadaches_freq_collat(String headaches_freq_collat) {
		this.headaches_freq_collat = headaches_freq_collat;
	}


	public String getHeadaches_notes_collat() {
		return headaches_notes_collat;
	}


	public void setHeadaches_notes_collat(String headaches_notes_collat) {
		this.headaches_notes_collat = headaches_notes_collat;
	}


	public String getFalling_time_collat() {
		return falling_time_collat;
	}


	public void setFalling_time_collat(String falling_time_collat) {
		this.falling_time_collat = falling_time_collat;
	}


	public String getFalling_freq_collat() {
		return falling_freq_collat;
	}


	public void setFalling_freq_collat(String falling_freq_collat) {
		this.falling_freq_collat = falling_freq_collat;
	}


	public String getFalling_notes_collat() {
		return falling_notes_collat;
	}


	public void setFalling_notes_collat(String falling_notes_collat) {
		this.falling_notes_collat = falling_notes_collat;
	}


	public String getSeizures_time_collat() {
		return seizures_time_collat;
	}


	public void setSeizures_time_collat(String seizures_time_collat) {
		this.seizures_time_collat = seizures_time_collat;
	}


	public String getSeizures_freq_collat() {
		return seizures_freq_collat;
	}


	public void setSeizures_freq_collat(String seizures_freq_collat) {
		this.seizures_freq_collat = seizures_freq_collat;
	}


	public String getSeizures_notes_collat() {
		return seizures_notes_collat;
	}


	public void setSeizures_notes_collat(String seizures_notes_collat) {
		this.seizures_notes_collat = seizures_notes_collat;
	}	
	
}
