package com.cloud.clinic.p2p;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.ClinicDAO;
import com.cloud.clinic.model.Clinician;
import com.cloud.clinic.model.ClinicianDAO;
import com.cloud.clinic.model.EMF;

public class P2PDAO {

	private String p2pdao_key = "p2pdao_key";
	
	public void init(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P p2p = null;
		
		try {
			em = emf.createEntityManager();
			p2p = em.find(P2P.class, p2pdao_key);
			
			if(!p2p.initialised){
				
				p2p = new P2P(p2pdao_key);
				ClinicDAO cDAO = new ClinicDAO();
				ArrayList<Clinic> clinics = (ArrayList<Clinic>) cDAO.getAll();
				for(int i = 0; i < clinics.size(); i++){
					Superpeer sp = new Superpeer(clinics.get(i));
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
	
	public boolean addSuperpeer(Superpeer sp){
		boolean result = false;
		
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
	
	public boolean removeSuperpeer(Superpeer sp){
		boolean result = false;
		
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
	
	public Peer addPeer(Clinician c, Superpeer sp, String p2pToken){
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
				result = p2p.signPeerIn(c, sp.getClinicID());
				//System.out.println("Number of peers:" + p2p.getSuperpeer(sp.getClinicID()).getPeers().size());
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
	
	public Peer getPeer(String id, String clinicID){
		Peer result = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		P2P pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(P2P.class, p2pdao_key);
			
			if(pd != null) {
				result = pd.getPeer(id, pd.getSuperpeer(clinicID));
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
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
				if(pd.removePeer(p, p.getSp())){
					result = pd.addPeer(p, p.getSp());
				} else result = false;
				
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
				pd.getPeer(peerName, pd.getSuperpeer(clinicName)).setP2pAddress(p2pAddress);;
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
}
