package project.beta.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


/*
 * USed to represent both the social and physical activities that a patient
 * can be involved in
 * 
 */
//TODO: Needs to be an Entity for JPA
@Entity
public class Activity implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityID;	
	
	String type, involvement, time_changed, notes;
	int current_hours, prev_hours;
	
	public Activity(String type, String involvement){
		this.type= type;
		this.involvement = involvement;
		
		time_changed = "";
		notes = "";
		current_hours = -1;
		prev_hours = -1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
}
