package project.beta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
/*
 * Used for medical history of any medication taken
 */
@Entity
public class DrugHistory implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drugHistoryID", unique = true, nullable = false)
	int	drugHistoryID;
	
	String drug;
	String time;
	String notes;
	
	public DrugHistory(){
		
	}

	public int getDrugHistoryID() {
		return drugHistoryID;
	}

	public void setDrugHistoryID(int drugHistoryID) {
		this.drugHistoryID = drugHistoryID;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
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
