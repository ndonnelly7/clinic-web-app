package webrtc.eval.model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;
@Entity
public class AnonPatientData {
	@Id
	private String id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private ArrayList<Patient> patients;
	
	public AnonPatientData(String id){
		this.id = id;
		patients = new ArrayList<Patient>();
	}
	
	public ArrayList<Patient> getPatients(){
		return patients;
	}
	
	public Patient getPatient(Key id){
		Iterator<Patient> it = patients.iterator();
		while(it.hasNext()){
			Patient p = it.next();
			if(p.getKey().getId() == id.getId()){
				return p;
			}
		}
		return null;
	}
	
	public String getKey(){
		return id;
	}
	
	public boolean addPatient(Patient p){
		return patients.add(p);
	}
	
	public boolean removePatient(Patient p){
		return patients.remove(p);
	}
	
	public Patient findPatient(String ppsn){
		Iterator<Patient> it = patients.iterator();
		while(it.hasNext()){
			Patient p = it.next();
			if(p.getPpsn().equals(ppsn))
			{
				return p;
			}
		}
		return null;
	}
	
	public Patient findPatient(Key id){
		Iterator<Patient> it = patients.iterator();
		while(it.hasNext()){
			Patient p = it.next();
			if(p.getKey().getId() == id.getId())
			{
				return p;
			}
		}
		return null;
	}
}