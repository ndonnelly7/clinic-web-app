package project.beta.model;

import java.util.ArrayList;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

/*
 * Representative for the System User, will probably need to be updated and changed
 */

@Entity
public class SystemUser implements java.io.Serializable {

	private static final long serialVersionUID = 8238341874577331329L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key key;
	
	String userID;
	String uName;
	String uClinic;
	
	@Basic
	ArrayList<Integer> patientIDs;
	
	@Basic
	User user;
	
	public SystemUser(User u, String name, String clinic)
	{
		user = u;
		userID = u.getUserId();
		uName = name;
		uClinic = clinic;
		patientIDs = new ArrayList<Integer>();
	}
	
	public void addPatientID(int patientID){
		patientIDs.add(patientID);
	}
	
	public void removePatientID(int pID){
		patientIDs.remove(pID);
	}
	
	public String getName(){
		return uName;
	}
	
	public String getClinicName(){
		return uClinic;
	}
	
	public String getUserID()
	{
		return userID;
	}
	
	public Key getKey()
	{
		return key;
	}
	
	public User getGoogleUser()
	{
		return user;
	}
}
