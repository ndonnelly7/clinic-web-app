package com.cloud.clinic.p2p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cloud.clinic.model.Clinician;


@Entity
public class P2P {

	@Id
	private String id;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "p2p", cascade = CascadeType.ALL)
	private ArrayList<Superpeer> sps;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private JobQueue jobQueue;
	
	private int job_tick;
	
	boolean initialised;
	
	public P2P(String id){
		sps = new ArrayList<Superpeer>();
		this.id = id;
		initialised = false;
		jobQueue = new JobQueue();
		job_tick = 0;
	}

	public boolean isInitialised() {
		return initialised;
	}

	public void setInitialised(boolean initialised) {
		this.initialised = initialised;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getJob_tick() {
		return job_tick++;
	}

	public void setJob_tick(int job_tick) {
		this.job_tick = job_tick;
	}

	public JobQueue getJobQueue() {
		if(jobQueue == null)
			jobQueue = new JobQueue();
		return jobQueue;
	}

	public void setJobQueue(JobQueue jobQueue) {
		this.jobQueue = jobQueue;
	}

	public ArrayList<Superpeer> getSps() {
		return sps;
	}

	public void setSps(ArrayList<Superpeer> sps) {
		this.sps = sps;
	}
	
	public boolean addSuperpeer(Superpeer sp){
		Iterator<Superpeer> it = sps.iterator();
		while(it.hasNext()){
			Superpeer spc = it.next();
			if(spc.getClinicID().equals(sp.getClinicID())){
				return false;
			}
		}
		return sps.add(sp);
	}
	
	public boolean removeSuperpeer(Superpeer sp){
		return sps.remove(sp);
	}
	
	public Superpeer getSuperpeer(String name, Logger log){
		if(sps == null){
			if(log != null)
				log.log(Level.WARNING, "P2P102 - List of Super-peers Empty");
			sps = new ArrayList<Superpeer>();
			return null;
		}
		Iterator<Superpeer> it = sps.iterator();
		while(it.hasNext()){
			Superpeer sp = it.next();
			if(sp.getClinicID().equals(name)){
				if(log != null)
					log.log(Level.WARNING, "P2P111 - Found Super-peer: " + sp.getClinicID());
				return sp;
			}
		}
		return null;
	}
	
	public Peer signPeerIn(Clinician c, String spName, Logger log){
		Superpeer sp = getSuperpeer(spName, log);
		if(sp == null){
			log.log(Level.WARNING, "P2P121 - Super-peer is null for some reason - " + spName);
			return null;
		}
		sp.signOutPeer(c.getClinicianID());
		
		return sp.signInPeer(c);
	}
	
	public boolean addPeer(Peer p, Superpeer sp){
		ArrayList<Peer> peers = sp.getPeers();
		if(!peers.contains(p))
			peers.add(p);
		else return false;
		sp.setPeers(peers);
		for(int i = 0; i < sps.size(); i++){
			if(sps.get(i).getClinicID().equals(sp.getClinicID()))
				sps.set(i, sp);
		}
		return true;
	}
	
	public boolean removePeer(Peer p, Superpeer sp){
		ArrayList<Peer> peers = sp.getPeers();
		boolean result = false;
		if(peers.contains(p))
			result = peers.remove(p);
		else return false;
		sp.setPeers(peers);
		return result;
	}
	
	public boolean signPeerOut(String pName, String spName){
		Superpeer sp = getSuperpeer(spName, null);
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
	
	public Peer findPeerWithP2PID(String peerID){
		Peer p = null;
		
		for(int i = 0; i < sps.size(); i++){
			ArrayList<Peer> peers = sps.get(i).getPeers();
			for(int j = 0; j < peers.size(); j++){
				if(peers.get(j).getP2pAddress().equals(peerID)){
					return peers.get(j);
				}
			}
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
