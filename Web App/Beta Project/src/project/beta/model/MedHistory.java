package project.beta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Medical History class used for the patient's history
 */

@Entity
public class MedHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medHistoryID", unique = true, nullable = false)
	int medHistoryID;
	
	String condition;
	String time;
	String notes;
	
	public MedHistory() {
		
	}

	public int getMedHistoryID() {
		return medHistoryID;
	}

	public void setMedHistoryID(int medHistoryID) {
		this.medHistoryID = medHistoryID;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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
