package project.beta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class DrugHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key key;
	
	String drug;
	String time;
	String notes;
	
	public DrugHistory(String drug, String time, String notes)
	{
		this.drug = drug;
		this.time = time;
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "MedHisotry [condition=" + drug
				+ ", time=" + time
				+ ", notes" + notes
				+ "]";
	}
}
