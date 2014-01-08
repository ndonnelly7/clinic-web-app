package project.beta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/*
 * Used to represent PsychHistory's
 * 
 * This could probably just be replaced by the MedHistory as they're pretty identical
 */

@Entity
public class PsychHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key key;
	String psych;
	String time;
	String notes;
	
	public PsychHistory(String psych, String time, String notes)
	{
		this.psych = psych;
		this.time = time;
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "MedHisotry [condition=" + psych
				+ ", time=" + time
				+ ", notes" + notes
				+ "]";
	}
}
