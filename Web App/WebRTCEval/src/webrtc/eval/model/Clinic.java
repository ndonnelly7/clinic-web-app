package webrtc.eval.model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Clinic {

	private String name;
	private String address;
	
	@ElementCollection
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="cClinic")
	private ArrayList<Client> clients;
	
	@ElementCollection
	private ArrayList<Key> patients;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key clinicID;
	
	public Clinic(String name, String address) {
		this.name = name;
		this.address = address;
		this.clients = new ArrayList<Client>();
		this.patients = new ArrayList<Key>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Client> getClients() {
		if(clients == null){
			clients = new ArrayList<Client>();
		}
		return clients;
	}
	public boolean addClient(Client c) {
		if(clients == null){
			clients = new ArrayList<Client>();
		}
		return clients.add(c);
	}
	public boolean removeClient(Client c){
		if(clients == null){
			return false;
		}
		return clients.remove(c);
	}
	
	public Client findClient(String name){
		if(clients == null)
			return null;
		Iterator<Client> it = clients.iterator();
		while(it.hasNext()){
			Client c = it.next();
			if(c.getcName().equals(name))
				return c;
		}
		return null;
	}
	
	public Client findClient(Key id){
		if(clients == null)
			return null;
		Iterator<Client> it = clients.iterator();
		while(it.hasNext()){
			Client c = it.next();
			if(c.getcID().getId() == id.getId())
				return c;
		}
		return null;
	}
	
	public Key getClinicID(){
		return clinicID;
	}
	
	public ArrayList<Key> getPatientIDs(){
		return patients;
	}
	
	public boolean addPatientID(Key k){
		return patients.add(k);
	}
	
	@Override
	public String toString() {
		return "Clinic [name=" + name + ", address=" + address + ", clients="
				+ clients + ", clinicID=" + clinicID + "]";
	}
}
