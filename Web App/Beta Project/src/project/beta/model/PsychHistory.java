package project.beta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*
 * Used to represent PsychHistory's
 * 
 * This could probably just be replaced by the MedHistory as they're pretty identical
 */

@Entity
public class PsychHistory implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "psychHistoryID", unique = true, nullable = false)
	int psychHistoryID;
	
	String psych;
	String time;
	String notes;
	
	public PsychHistory() {
		
	}

	public int getPsychHistoryID() {
		return psychHistoryID;
	}

	public void setPsychHistoryID(int psychHistoryID) {
		this.psychHistoryID = psychHistoryID;
	}

	public String getPsych() {
		return psych;
	}

	public void setPsych(String psych) {
		this.psych = psych;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
