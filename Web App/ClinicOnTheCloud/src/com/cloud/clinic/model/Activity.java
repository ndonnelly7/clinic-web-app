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
 * USed to represent both the social and physical activities that a patient
 * can be involved in
 * 
 */

@Entity
public class Activity implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activityID", unique = true, nullable = false)
	private int activityID;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	EventsActivities eventActivity;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	@Expose
	String type, involvement, time_changed, notes;
	@Expose
	int current_hours, prev_hours;
	@Expose
	boolean collat;
	
	public Activity(){
		
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
	
	public void setEventActivity(EventsActivities eventActivity){
		this.eventActivity = eventActivity;
	}
	
	public EventsActivities getEventActivity(){
		return eventActivity;
	}

	public int getActivityID() {
		return activityID;
	}

	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
}
