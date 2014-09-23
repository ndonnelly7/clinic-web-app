package com.cloud.clinic.p2p;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.Clinician;
import com.google.appengine.api.datastore.Key;

/*
 * 
 * Represents the clinic on the peer network
 * Mostly getters and setters
 * 
 */

@Entity
public class Superpeer implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	
	private String clinicID;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sp", cascade = CascadeType.ALL)
	private ArrayList<Peer> peers;
	
	//The total number of peers signed into a super-peer
	int totalNumberOfPeers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private P2P p2p;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	public Superpeer(Clinic c){
		clinicID = c.getClinicName();
		peers = new ArrayList<Peer>();
		totalNumberOfPeers = c.getClinicians().size();
	}

	public String getClinicID() {
		return clinicID;
	}

	public void setClinicID(String clinicID) {
		this.clinicID = clinicID;
	}

	public ArrayList<Peer> getPeers() {
		if(peers == null)
			peers = new ArrayList<Peer>();
		return peers;
	}

	public void setPeers(ArrayList<Peer> peers) {
		this.peers = peers;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}
	
	public int getTotalNumberOfPeers() {
		return totalNumberOfPeers;
	}

	public void setTotalNumberOfPeers(int totalNumberOfPeers) {
		this.totalNumberOfPeers = totalNumberOfPeers;
	}

	public P2P getP2p() {
		return p2p;
	}

	public void setP2p(P2P p2p) {
		this.p2p = p2p;
	}

	//Add peer to super-peers list of peers
	public Peer signInPeer(Clinician c){
		Peer p = new Peer(c, this);
		if(peers == null)
			peers = new ArrayList<Peer>();
		peers.add(p);
		return p;
	}
	
	//Removes peer from list
	public boolean signOutPeer(String c){
		boolean notfound = true;
		if(peers == null)
			return true;
		for(int i = 0; i < peers.size() && notfound; i++){
			if(peers.get(i).getClinicianID().equals(c)){
				peers.get(i).setP2pAddress("");
				peers.remove(i);
				notfound = false;
			}
		}
		
		return !notfound;
	}
	
	
	public void updateClinic(Peer origin, String patientID){
		for(int i = 0; i < peers.size(); i++){
			if(!(peers.get(i).getClinicianID().equals(origin.getClinicianID()))){
				peers.get(i).retrievePatient(patientID, origin);
			}
		}
	}
	
	public void testPeers(){
		//Send a Ping across Google Channel to remove any disconnected peers
	}
}
