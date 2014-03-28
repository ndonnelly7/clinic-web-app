package webrtc.eval.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

public class PeerDataAccess {

	private String peer_data_key = "peer_data_01";
	
	public void init(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd == null) {
				pd = new PeerData(peer_data_key);
				Clinic c1 = new Clinic("DCU Clinic", "DCU, Nursing Building, Glasnevin");
				Clinic c2 = new Clinic("Mayo Clinic", "Alzheimer Society of Ireland, Castlebar");
				Clinic c3 = new Clinic("Waterford Clinic", "Near that bridge, Waterford");
				Clinic c4 = new Clinic("Kerry Clinic", "Rose Gardens, Tralee");
				pd.addClinic(c1);
				pd.addClinic(c2);
				pd.addClinic(c3);
				pd.addClinic(c4);
				em.persist(pd);
			} 
		}
		finally {
			if(em != null)
				em.close();
		}
	}
	
	public void reInit(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			em.remove(pd);
			
			if(true) {
				pd = new PeerData(peer_data_key);
				Clinic c1 = new Clinic("DCU Clinic", "DCU, Nursing Building, Glasnevin");
				Clinic c2 = new Clinic("Mayo Clinic", "Alzheimer Society of Ireland, Castlebar");
				Clinic c3 = new Clinic("Waterford Clinic", "Near that bridge, Waterford");
				Clinic c4 = new Clinic("Kerry Clinic", "Rose Gardens, Tralee");
				pd.addClinic(c1);
				pd.addClinic(c2);
				pd.addClinic(c3);
				pd.addClinic(c4);
				em.persist(pd);
			} 
		} finally {
			if(em != null)
				em.close();
		}
	}
	
	public boolean addClinic(Clinic c) {
		boolean result  = false;
		
		if(c == null || c.getClinicID() == null || c.getName().equals(null))
			return false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.addClinic(c);
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
	
	public boolean removeClinic(Clinic c) {
		boolean result  = false;
		
		if(c == null || c.getClinicID() == null || c.getName().equals(null))
			return false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.removeClinic(c);
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
	
	public ArrayList<Clinic> getClinics() {
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				return pd.getClinics();
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return new ArrayList<Clinic>();
	}
	
	public Clinic findClinic(Key id) {
		Clinic result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.getClinic(id);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public Clinic findClinic(String name) {
		Clinic result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.getClinic(name);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public boolean addClinician(Client c, Clinic clinic) {
		boolean result  = false;
		
		if(c == null || c.getcName().equals(null))
			return false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.addClinician(c, clinic.getName());
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
	
	public boolean addClinician(Client c, String clinic) {
		boolean result  = false;
		
		if(c == null || c.getcName().equals(null))
			return false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.addClinician(c, clinic);
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
	
	public boolean removeClinician(Client c) {
		boolean result  = false;
		
		if(c == null || c.getcName().equals(null) || c.getcClinic().equals(null))
			return false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.removeClinician(c, c.getcClinic().getName());
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
	
	public Client findClinician(Key id) {
		Client result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.findClinician(id);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public Client findClinician(String name) {
		Client result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.findClinician(name);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public Client findClinicianInClinic(Key id, String clinic) {
		Client result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.findClinician(id, clinic);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public Client findClinicianInClinic(String name, String clinic) {
		Client result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.findClinician(name, clinic);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public boolean signClinicianIn(String name, String clinic) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.signClinicianIn(name, clinic);
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
	
	public boolean signClinicianOut(String name, String clinic) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.signClinicianOut(name, clinic);
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
	
	public boolean isClinicianOnline(String name, String clinic) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.isClinicianOnline(name,clinic);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public boolean addPatientKey(Key k, String name, String clinic) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.addPatientKey(k, name, clinic);
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
	
	public boolean replacePatientKeys(ArrayList<Key> patients, String name, String clinic) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.replacePatientKeys(clinic, name, patients);
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
	
	public boolean addPatientKeyToClient(Key k, String name, String clinic){
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PeerData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(PeerData.class, peer_data_key);
			
			if(pd != null) {
				result = pd.addPatientKey(k, name, clinic);
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