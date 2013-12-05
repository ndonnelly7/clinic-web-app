package project.beta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class MedHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key key;
	
	String condition;
	String time;
	String notes;
	
	public MedHistory(String condition, String time, String notes)
	{
		this.condition = condition;
		this.time = time;
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "MedHisotry [condition=" + condition
				+ ", time=" + time
				+ ", notes" + notes
				+ "]";
	}
}
