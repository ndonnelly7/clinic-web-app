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
public class PeerData {	

	@Id
	private String id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private ArrayList<Clinic> clinics;
	
	public PeerData(String id){
		clinics = new ArrayList<Clinic>();
		this.id = id;
	}
		
	public String getID(){
		return id;
	}
	
	public ArrayList<Clinic> getClinics(){
		return clinics;
	}
	
	public Clinic getClinic(Key id){
		Iterator<Clinic> it = clinics.iterator();
		while(it.hasNext()){
			Clinic c = it.next();
			if(c.getClinicID().getId() == id.getId()){
				return c;
			}
		}
		return null;
	}
	
	public Clinic getClinic(String name){
		Iterator<Clinic> it = clinics.iterator();
		while(it.hasNext()){
			Clinic c = it.next();
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
	
	public boolean addClinic(Clinic c){
		return clinics.add(c);
	}
	
	public boolean removeClinic(Clinic c){
		return clinics.remove(c);
	}
	
	public boolean addClinician(Client client, String clinic){
		Clinic c = getClinic(clinic);
		if(c != null)
			return c.addClient(client);
		else return false;
	}
	
	public boolean addClinician(Client client, Clinic clinic){
		return clinic.addClient(client);
	}
	
	public boolean removeClinician(Client client, String clinic){
		Clinic c = getClinic(clinic);
		if(c != null)
			return c.removeClient(client);
		else return false;
	}
	
	public Client findClinician(String name, String clinic){
		Clinic c = getClinic(clinic);
		if(c != null)
			return c.findClient(name);
		else return null;
	}
	
	public Client findClinician(Key id, String clinic){
		Clinic c = getClinic(clinic);
		if(c != null)
			return c.findClient(id);
		else return null;
	}
	
	public Client findClinician(String name){
		Client client = null;
		Iterator<Clinic> it = clinics.iterator();
		while(it.hasNext()){
			Clinic c = it.next();
			client = findClinician(name, c.getName());
			if(client != null)
				return client;
		}
		return null;
	}
	
	public Client findClinician(Key id){
		Client client = null;
		Iterator<Clinic> it = clinics.iterator();
		while(it.hasNext()){
			Clinic c = it.next();
			client = findClinician(id, c.getName());
			if(client != null)
				return client;
		}
		return null;
	}
	
	public boolean replacePatientKeys(String clinic, String client, ArrayList<Key> patients){
		Client c = findClinician(client,clinic);
		if(c!=null){
			c.setcPatientIDs(patients);
			return true;
		}
		return false;
	}
	
	public boolean signClinicianIn(String name, String clinic){
		boolean result = false;
		Client c = findClinician(name, clinic);
		if(c != null){
			c.setOnline(true);
			result = true;
		}
		return result;
	}
	
	public boolean signClinicianOut(String name, String clinic){
		boolean result = false;
		Client c = findClinician(name, clinic);
		if(c != null){
			c.setOnline(false);
			result = true;
		}
		
		return result;
	}
	
	public boolean isClinicianOnline(String name, String clinic){
		Client c = findClinician(name, clinic);
		return c.isOnline();
	}
	
	public boolean addPatientKey(Key k, String name, String clinic){
		Client c = findClinician(name, clinic);
		if(c == null)
			return false;
		c.addPatientID(k);
		c.getcClinic().addPatientID(k);
		return true;
	}
	
	public boolean addPatientKeyToClient(Key k, String name, String clinic){
		Client c = findClinician(name, clinic);
		if(c == null)
			return false;
		c.addPatientID(k);
		return true;
	}
}