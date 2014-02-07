package webrtc.eval.model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Client {
	String cName;
	
	@ManyToOne
	Clinic cClinic;
	
	boolean online;
	
	@ElementCollection
	ArrayList<Key> cPatientIDs;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	public Client(String name){
		this.cName = name;
		this.cClinic = null;
		cPatientIDs = new ArrayList<Key>();
		online = false;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Key getcID() {
		return id;
	}
	
	public void setOnline(boolean on){
		online = on;
	}
	
	public boolean isOnline(){
		return online;
	}

	public Clinic getcClinic() {
		return cClinic;
	}
	
	public void setClinic(Clinic c) {
		cClinic = c;
	}

	public ArrayList<Key> getcPatientIDs() {
		return cPatientIDs;
	}
	
	public boolean addPatientID(Key k){
		return cPatientIDs.add(k);
	}
	
	public boolean isPatientPresent(Key pID){
		Iterator<Key> it = cPatientIDs.iterator();
		while(it.hasNext()){
			Key p = it.next();
			if(p.getId() == pID.getId())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Client [cName=" + cName + ", cID=" + id + ", cClinic="
				+ cClinic + ", cPatientIDs=" + cPatientIDs + "]";
	}
	
}
