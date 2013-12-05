package project.beta.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.google.appengine.api.datastore.Key;

@Entity
public class PatientStore {

	@Transient
	static String patientStoreKey = "pat_store_001";
	
	@Id
	String id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	ArrayList<Patient> patients;
	@Basic
	ArrayList<Integer> patientIDs;
	
	int nextID;
	
	public PatientStore(String id){
		this.id = id;
		nextID = 0;
		patients = new ArrayList<Patient>();
		patientIDs = new ArrayList<Integer>();
	}
	
	public Patient getPatient(String name)
	{
		Iterator<Patient> it = patients.iterator();
		while(it.hasNext()){
			Patient p = (Patient)it.next();
			if(p.getPersonalDetails().getName().equals(name)){
				return p;
			}
		}
		return new Patient(-1, null);
	}
	
	public Patient getPatient(int id)
	{
		Iterator<Patient> it = patients.iterator();
		while(it.hasNext()){
			Patient p = (Patient)it.next();
			if(p.getID() == id){
				return p;
			}
		}
		return new Patient(-1, null);
	}
	
	public int getNewID()
	{
		Random gen = new Random(System.currentTimeMillis());
		int testID = 0;
		do {
			testID = gen.nextInt();
		} while(patientIDs.contains(testID));
		
		return testID;
	}
	
	public ArrayList<Patient> getPatients(SystemUser u)
	{
		ArrayList<Patient> pList = new ArrayList<Patient>();
		Iterator<Patient> it = patients.iterator();
		while(it.hasNext()){
			Patient p = (Patient)it.next();
			if(p.getUserCreated().equals(u.getUserID())){
				pList.add(p);
			}
		}
		return pList;
	}
	
	public ArrayList<Patient> getAllPatients()
	{
		return patients;
	}
	
	static public PatientStore GetPatientStore()
	{
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PatientStore pStore = null;
		
		try {
			em = emf.createEntityManager();
			pStore = em.find(PatientStore.class, patientStoreKey);
			if(pStore == null) {
				pStore = new PatientStore(patientStoreKey);
				em.persist(pStore);
			}
		} finally {
			if(em!=null)
				em.close();
		}
		
		return pStore;
	}
	
	static public boolean RemovePatientStore()
	{
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PatientStore pStore = null;
		
		try {
			em = emf.createEntityManager();
			pStore = em.find(PatientStore.class, patientStoreKey);
			
			if(pStore == null) {
				result = false;
			} else {
				em.remove(pStore);
				result = true;
			}
		} finally {
			if(em!=null)
				em.close();
		}
		
		return result;
	}
	
	static public boolean removePatient(int id)
	{
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PatientStore pStore = null;
		EntityTransaction txn = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pStore = em.find(PatientStore.class, patientStoreKey);
			
			if(pStore == null) {
				result = false;
			} else {
				ArrayList<Patient> pats = pStore.getAllPatients();
				Iterator<Patient> it = pats.iterator();
				while(it.hasNext()){
					Patient p = it.next();
					if(p.getID() == id) {
						result = pats.remove(p);
						txn.commit();
					}
				}
			}
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em!=null)
				em.close();
		}
		
		return result;
	}
	
	static public boolean removePatient(Key k)
	{
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		PatientStore pStore = null;
		EntityTransaction txn = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pStore = em.find(PatientStore.class, patientStoreKey);
			
			if(pStore == null) {
				result = false;
			} else {
				ArrayList<Patient> pats = pStore.getAllPatients();
				Iterator<Patient> it = pats.iterator();
				while(it.hasNext()){
					Patient p = it.next();
					if(p.getKey().equals(k)) {
						result = pats.remove(p);
						txn.commit();
					}
				}
			}
		} finally {
			if(txn != null) {
				if(txn.isActive()) {
					txn.rollback();
				}
			}
			
			if(em!=null)
				em.close();
		}
		
		return result;
	}
	
	static public boolean addPatient(Patient p)
	{
		boolean result = true;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PatientStore ps = null;
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			
			ps = em.find(PatientStore.class, patientStoreKey);
			if(ps != null) {
				ps.getAllPatients().add(p);
				ps.patientIDs.add(p.getID());
				txn.commit();
				
			} else {
				result = false;
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
	
	static public boolean updatePatient(int id, Patient p)
	{
		boolean result = true;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		PatientStore ps = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			
			ps = em.find(PatientStore.class, patientStoreKey);
			if(ps != null) {
				Patient pat = ps.getPatient(id);
				if(pat != null) {
					if(pat.getID() == id)
					{
						int ind = ps.getAllPatients().indexOf(pat);
						ps.getAllPatients().set(ind, p);
						
					} else {
						result = false;
					}
				}
				txn.commit();
				
			} else {
				result = false;
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
