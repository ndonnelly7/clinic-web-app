package com.cloud.clinic.p2p;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cloud.clinic.model.Clinician;


@Entity
public class P2P {

	@Id
	private String id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private ArrayList<Superpeer> sps;
	
	public P2P(String id){
		sps = new ArrayList<Superpeer>();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Superpeer> getSps() {
		return sps;
	}

	public void setSps(ArrayList<Superpeer> sps) {
		this.sps = sps;
	}
	
	public boolean addSuperpeer(Superpeer sp){
		return sps.add(sp);
	}
	
	public boolean removeSuperpeer(Superpeer sp){
		return sps.remove(sp);
	}
	
	public Superpeer getSuperpeer(String name){
		Iterator<Superpeer> it = sps.iterator();
		while(it.hasNext()){
			Superpeer sp = it.next();
			if(sp.getClinicID().equals(name)){
				return sp;
			}
		}
		return null;
	}
	
	public Peer signPeerIn(Clinician c, String spName){
		Superpeer sp = getSuperpeer(spName);
		if(sp == null)
			return null;
		return sp.signInPeer(c);
	}
	
	public boolean signPeerOut(String pName, String spName){
		Superpeer sp = getSuperpeer(spName);
		if(sp == null)
			return false;
		return sp.signOutPeer(pName);
	}
	
	public Peer getPeer(String clinicianID, Superpeer sp){
		ArrayList<Peer> peers = sp.getPeers();
		for(int i = 0; i < peers.size(); i++){
			if(clinicianID.equals(peers.get(i).getClinicianID())){
				return peers.get(i);
			}
		}
		return null;
	}
	
	public Peer findPeer(String clinicianID){
		Peer p = null;
		int index = 0;
		while(p == null && index < sps.size()){
			p = getPeer(clinicianID, sps.get(index));
			index++;
		}
		return p;
	}
	
	public boolean addPatientKey(Peer p, Superpeer sp, int id){
		Peer peer = getPeer(p.getClinicianID(), sp);
		if(peer == null || id <= 0)
			return false;
		return peer.addPatientID(id);
	}
}
