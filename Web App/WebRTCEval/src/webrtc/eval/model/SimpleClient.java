package webrtc.eval.model;

import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;

public class SimpleClient {
	String Name;
	String ClinicName;
	boolean online;
	ArrayList<Long> patientIDs;
	
	public SimpleClient(Client c){
		this.Name = c.getcName();
		this.ClinicName = c.getcClinic().getName();
		this.online = c.isOnline();
		patientIDs = new ArrayList<Long>();
		ArrayList<Key> patients = c.getcPatientIDs();
		for(int i = 0; i < patients.size(); i++){
			patientIDs.add(patients.get(i).getId());
		}
	}

	public String getName() {
		return Name;
	}

	public String getClinicName() {
		return ClinicName;
	}

	public boolean isOnline() {
		return online;
	}

	public ArrayList<Long> getPatientIDs() {
		return patientIDs;
	}
}
