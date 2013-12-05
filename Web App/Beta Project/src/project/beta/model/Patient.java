package project.beta.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.google.appengine.api.datastore.Key;

@Entity(name="Patient")
public class Patient implements java.io.Serializable{
	
	private static final long serialVersionUID = 8153440730792060761L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key pKey;
	
	private int pID;	
	
	//TODO: will need to change this to use User ID 
	private String userCreatedID;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PersonalDetailsPatient personalDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PatientHistory patientHistory;
	
	
	public Patient(int patientID, String u){
		pID = patientID;
		userCreatedID = u;
		
		personalDetails = new PersonalDetailsPatient(pID);
		patientHistory = new PatientHistory(pID);
	}

	public String getUserCreated() {
		return userCreatedID;
	}

	public void setUserCreated(String userCreated) {
		this.userCreatedID = userCreated;
	}

	public int getID() {
		return pID;
	}

	public void setID(int pID) {
		this.pID = pID;
	}
	
	public PersonalDetailsPatient getPersonalDetails()
	{
		return personalDetails;
	}
	
	public void setPersonalDetails(PersonalDetailsPatient p)
	{
		personalDetails = p;
	}
	
	public Key getKey()
	{
		return pKey;
	}
	
	public PatientHistory getHistory()
	{
		return patientHistory;
	}
	
	public void setHistory(PatientHistory history)
	{
		patientHistory = history;
	}
}
