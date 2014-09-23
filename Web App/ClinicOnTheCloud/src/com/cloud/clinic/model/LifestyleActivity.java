package com.cloud.clinic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * 
 * Bean for lifestyle activity
 * 
 */

@Entity
public class LifestyleActivity implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lifestyleActivityID", unique = true, nullable = false)
	private int lifestyleActivityID;

	@Transient
	protected Object[] jdoDetachedState;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	Lifestyle lifestyle;

	@Expose
	String type, involvement, time_changed, notes;
	@Expose
	int current_hours, prev_hours;
	
	//Used to denote whether an activity is collateral on the database
	@Expose
	boolean collat;
	
	public LifestyleActivity(){
	
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCollat() {
		return collat;
	}

	public void setCollat(boolean collat) {
		this.collat = collat;
	}

	public String getInvolvement() {
		return involvement;
	}

	public void setInvolvement(String involvement) {
		this.involvement = involvement;
	}

	public String getTime_changed() {
		return time_changed;
	}

	public void setTime_changed(String time_changed) {
		this.time_changed = time_changed;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCurrent_hours() {
		return current_hours;
	}

	public void setCurrent_hours(int current_hours) {
		this.current_hours = current_hours;
	}

	public int getPrev_hours() {
		return prev_hours;
	}

	public void setPrev_hours(int prev_hours) {
		this.prev_hours = prev_hours;
	}

	public int getLifestyleActivityID() {
		return lifestyleActivityID;
	}

	public void setLifestyleActivityID(int lifestyleActivityID) {
		this.lifestyleActivityID = lifestyleActivityID;
	}

	public Lifestyle getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(Lifestyle lifestyle) {
		this.lifestyle = lifestyle;
	}
}