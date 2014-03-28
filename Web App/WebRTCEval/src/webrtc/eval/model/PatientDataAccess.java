package webrtc.eval.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.google.appengine.api.datastore.Key;

public class PatientDataAccess {

	private String patient_data_key = "Patient_Data_001";
	
	public void init(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		AnonPatientData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(AnonPatientData.class, patient_data_key);
			
			if(pd == null) {
				pd = new AnonPatientData(patient_data_key);
				em.persist(pd);
			}
		} finally {
			if(em != null)
				em.close();
		}
	}
	
	public void reInit(){
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		AnonPatientData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(AnonPatientData.class, patient_data_key);
			em.remove(pd);
			
			pd = new AnonPatientData(patient_data_key);
			em.persist(pd);
				
		} finally {
			if(em != null)
				em.close();
		}
	}
	
	public boolean addPatient(Patient p) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		AnonPatientData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(AnonPatientData.class, patient_data_key);
			
			if(pd != null) {
				result = pd.addPatient(p);
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
	
	public boolean removePatient(Patient p) {
		boolean result  = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		AnonPatientData pd = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			pd = em.find(AnonPatientData.class, patient_data_key);
			
			if(pd != null) {
				result = pd.removePatient(p);
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
	
	public Patient findPatient(String ppsn) {
		Patient result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		AnonPatientData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(AnonPatientData.class, patient_data_key);
			
			if(pd != null) {
				result = pd.findPatient(ppsn);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public Patient findPatient(Key id) {
		Patient result  = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		AnonPatientData pd = null;
		
		try {
			em = emf.createEntityManager();
			pd = em.find(AnonPatientData.class, patient_data_key);
			
			if(pd != null) {
				result = pd.findPatient(id);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	public ArrayList<Patient> getPatients() {
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		AnonPatientData pd = null;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		
		try {
			em = emf.createEntityManager();
			pd = em.find(AnonPatientData.class, patient_data_key);
			
			if(pd != null) {
				patients = pd.getPatients();
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return patients;
	}
}