package com.cloud.clinic.p2p;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.ClinicDAO;
import com.cloud.clinic.model.Clinician;
import com.cloud.clinic.model.EMF;

public class P2PDAO {

	//Needs to be used to get same P2P from datastore
	private String p2pdao_key = "p2pdao_key";
	
	//This is the bane of my existence for P2P on the cloud. It persists for a while but when it's stored by the cloud
	//while the server is stopped, it forgets a bunch of the stuff it should know. Including the list of super-peers
	//in the P2P object. So the super-peer list has to be constantly re-initialised and refilled
	public void init(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p == null || !p2p.initialised){
				
				p2p = new P2P(p2pdao_key);
				
				//Gets all the clinics and creates super-peers for each
				ClinicDAO cDAO = new ClinicDAO();
				ArrayList<Clinic> clinics = (ArrayList<Clinic>) cDAO.getAll();
				for(int i = 0; i < clinics.size(); i++){
					Superpeer sp = new Superpeer(clinics.get(i));
					//Add each super-peer to P2P's sps list
					p2p.addSuperpeer(sp);
				}
				p2p.setInitialised(true);
				em.persist(p2p);
			}
			
		} finally {
			if(em!=null)
				em.close();
		}
	}
	
	//Get the P2P
	public P2P getP2P(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			p2p = em.find(P2P.class, p2pdao_key);
			
		} finally {
			if(em != null)
				em.close();
		}
		
		return p2p;
	}
	
	//Update the P2P
	public void setP2P(P2P newP2p){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			p2p = em.find(P2P.class, p2pdao_key);
			txn.begin();
			
			//Set the new set of super-peers
			p2p.setSps(newP2p.getSps());
			txn.commit();
			
		} finally {
			if(txn != null){
				if(txn.isActive()){
					txn.rollback();
				}
			}
			
			if(em!=null)
				em.close();
		}
	}
	
	//Adds super-peer
	public boolean addSuperpeer(Superpeer sp){
		boolean result = false;
		
		//Make sure the super-peer is not null or incomplete
		if(sp == null || sp.getClinicID() == null || sp.getId() == null){
			return false;
		}
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				result = p2p.addSuperpeer(sp);
				txn.commit();
			}
		} finally {
			if(txn != null){
				if(txn.isActive()){
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Removes super-peer
	public boolean removeSuperpeer(Superpeer sp){
		boolean result = false;

		//Make sure the super-peer is not null or incomplete
		if(sp == null || sp.getClinicID() == null || sp.getId() == null){
			return false;
		}
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				result = p2p.removeSuperpeer(sp);
				txn.commit();
			}
		} finally {
			if(txn != null){
				if(txn.isActive()){
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Adds a peer using the clinician object, the super-peer it should be a part of and the log for debugging
	//The P2PToken is there but it's legacy for resetting the P2PAddress
	public Peer addPeer(Clinician c, Superpeer sp, String p2pToken, Logger log){
		Peer result = null;
		
		if(c == null || c.getClinicianID() == null)
			return result;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				result = p2p.signPeerIn(c, sp.getClinicID(), log); //Attempts to sign peer in
				if(result != null)
					log.log(Level.WARNING, "P2PDAO200 - Signed in peer - result = " + result.getClinicianID());
				else
					log.log(Level.WARNING, "P2PDAO202 - Peer is NULL - " + c.getClinicianID());
				//result.setP2pAddress(p2pToken);
				txn.commit();
			}
			
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Removes peer from network
	public boolean removePeer(Peer p, Superpeer sp) {
		boolean result = false;
		
		if(p == null || p.getId().equals(null) || p.getClinicianID().equals(null)){
			return false;
		}
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				result = p2p.signPeerOut(p.getClinicianID(), sp.getClinicID());
				txn.commit();
			}
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Find a peer from the network with name
	public Peer findPeer(String id) {
		Peer result = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(P2P.class, p2pdao_key);
			
			if(pd != null) {
				result = pd.findPeer(id);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Find a peer with a certain ID
	public Peer findPeerWithP2PID(String peerID) {
		Peer result = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(P2P.class, p2pdao_key);
			
			if(pd != null) {
				result = pd.findPeerWithP2PID(peerID);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Find a peer with a certain name and from a certain clinic
	public Peer getPeer(String id, String clinicID){
		Peer result = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(P2P.class, p2pdao_key);
			
			if(pd != null) {
				result = pd.getPeer(id, pd.getSuperpeer(clinicID, null));
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Finds the old instance of the peer and updates it on the datastore
	public boolean updatePeer(Peer p){
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(P2P.class, p2pdao_key);
			txn = em.getTransaction();
			txn.begin();
			if(pd != null) {
				//Remove old peer
				if(pd.removePeer(p, p.getSp())){
					//If it was removed, then add the new version
					result = pd.addPeer(p, p.getSp());
				} else result = false; //No peer found so can't be updated
				
				txn.commit();
			}
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Sets the P2P Address on a peer for WebRTC communications
	public boolean setP2PAddress(String peerName, String clinicName, String p2pAddress){
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(P2P.class, p2pdao_key);
			txn = em.getTransaction();
			txn.begin();
			if(pd != null) {
				//Finds the peer from a certain clinic and sets the P2P address
				pd.getPeer(peerName, pd.getSuperpeer(clinicName, null)).setP2pAddress(p2pAddress);;
				txn.commit();
			}
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Adds patient id to a peer
	public boolean addPatientKeyToPeer(Peer p, Superpeer sp, int pID){
		boolean result = false;
		
		if(p == null || p.getClinicianID() == null || sp == null)
			return result;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				result = p2p.addPatientKey(p, sp, pID);
				txn.commit();
			}
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	//Adds a job to the job queue
	public void addJob(Job j){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				p2p.getJobQueue().addJob(j);
				txn.commit();
			}
			
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
	}
	
	//Makes a claim for the job.
	//If the job is there, remove and return it. Otherwise return null
	public Job claimJob(int id){
		Job result = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(p2p != null) {
				
				JobQueue jQueue = p2p.getJobQueue();
				result = jQueue.claimJob(id);
				jQueue.cleanQueue();
				
				txn.commit();
			}
			
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
}
