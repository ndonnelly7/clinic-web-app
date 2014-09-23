package com.cloud.clinic.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * 
 * Interface between servlets and patient data
 * Implements DAOInterface
 * 
 */

public class PatientDAO implements DAOInterface<Patient, Integer> {

	@Override
	public Integer create(Patient t) {
		if(t == null)
			return -1;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int returnID = -1;
		
		session.saveOrUpdate(t);
		session.flush();
		returnID = t.getPatientID();
		
		tx.commit();
		session.close();
		return returnID;
	}

	@Override
	public Patient get(Integer id) {
		if(id <= 0)
			return null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Patient p = (Patient)session.get(Patient.class, id);
			
		tx.commit();
		session.close();
		
		return p;
	}

	@Override
	public void update(Patient t) {
		if(t == null)
			return;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

			session.update(t);
			session.flush();
			
		tx.commit();
		session.close();
	}

	@Override
	public void remove(Patient t) {
		if(t == null)
			return;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.delete(t);
		session.flush();
			
		tx.commit();
		session.close();
	}

	@Override
	public void removeWithID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		
		Patient p = (Patient)session.get(Patient.class, id);
		if(p != null)
			session.delete(p);
			
		tx.commit();
		session.close();
	}

	@Override
	public List<Patient> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Patient> list = session.createCriteria(Patient.class).list();
		
		session.close();
		return list;
	}

	//Runs a hibernate query on the patient data, just for updating not really selecting
	//Used mainly for removing old form pages to make room for updated ones
	@Override
	public void runQuery(String hql) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		
		tx.commit();
		session.close();
		
	}
	
	//Create session for Hibernate
	public void init(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		s.close();
	}

	//Get the form for today. If it's not there, then create a new one
	public Form getTodaysForm(Patient p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		//Creates the query to retrieve the forms with the patient it. Ordered based on most recent timestamps
		String hql = "from Form where patient = " + String.valueOf(p.getPatientID()) + " order by timestamp desc";
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Form> list = (List<Form>) q.list();
		
		//No forms found so return new one
		if(list.size() == 0){
			Form f = new Form();
			f.setPatient(p);
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;
		} else if((list.get(0).getTimestamp().get(Calendar.MONTH) == c.get(Calendar.MONTH))
				&& (list.get(0).getTimestamp().get(Calendar.YEAR) == c.get(Calendar.YEAR))
				&& (list.get(0).getTimestamp().get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH))){
			
			//The form matches todays date
			Form f = list.get(0);
			f.setNew(false);
			session.close();
			return f;
		} else {
			//No form found that's from today
			Form f = new Form();
			f.setPatient(p);
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;
		}
	}
	
	//Gets the form that's most recent
	public Form getMostRecentForm(Patient p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		//Creates the query to retrieve the forms with the patient it. Ordered based on most recent timestamps
		String hql = "from Form where patient = " + String.valueOf(p.getPatientID()) + " order by timestamp desc";
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Form> list = (List<Form>) q.list();
		
		//No form associated with patient
		if(list.size() == 0){
			Form f = new Form();
			f.setPatient(p);
			//New form so set timestamp to today
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;
		} else {
			//Returns the first form on the list as its ordered on timestamp
			Form f = list.get(0);
			session.close();
			return f;
		}
	}
	
	
	//Attempts to get a form that matches the date, if no form is found a new one is created and returned
	public Form getFormWithDate(Patient p, Calendar c){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Creates the query to retrieve the forms with the patient it. Ordered based on most recent timestamps
		String hql = "from Form where patient = " + String.valueOf(p.getPatientID()) + " order by timestamp desc";
		Query q = session.createQuery(hql);
		
		//Gets the list of forms from the query
		@SuppressWarnings("unchecked")
		List<Form> list = (List<Form>) q.list();
		
		if(list.size() == 0){
			//The list is empty so new form
			Form f = new Form();
			f.setPatient(p);
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;
		} else {
			//Goes through the list and checks the date. If found return
			for(int i = 0; i < list.size(); i++){
				Form f = list.get(i);
				if((f.getTimestamp().get(Calendar.MONTH) == c.get(Calendar.MONTH))
					&& (f.getTimestamp().get(Calendar.YEAR) == c.get(Calendar.YEAR))
					&& (f.getTimestamp().get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH))){
					f.setNew(false); //Not new so set to false and return
					session.close();
					return f;
				}
			}
			
			//No form matches the date so return
			Form f = new Form();
			f.setPatient(p);
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;			
		}
	}

	public PatientHistory loadHistory(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Get history from form. Form needs to be retrieved again as the lists have to be initialised in a session
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		PatientHistory history = f2.getPatientHistory();
		//Need to initialise these as they are lazy loaded
		Hibernate.initialize(history.med_histories);
		Hibernate.initialize(history.med_collat_histories);
		Hibernate.initialize(history.drug_histories);
		Hibernate.initialize(history.drug_collat_histories);
		Hibernate.initialize(history.psych_histories);
		Hibernate.initialize(history.psych_collat_histories);
		
		
		session.close();
		return history;
	}
	
	public EventsActivities loadEventsActivities(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Form needs to be retrieved again as the lists have to be initialised in a session
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		EventsActivities ea = f2.getEventsActivities();
		//Need to initialise these as they are lazy loaded
		Hibernate.initialize(ea.getActivities());
		Hibernate.initialize(ea.getCollat_activities());
		
		session.close();
		return ea;
	}
	
	public Lifestyle loadLifestyle(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Form needs to be retrieved again as the lists have to be initialised in a session
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		Lifestyle l = f2.getLifestyle();
		//Need to initialise these as they are lazy loaded
		Hibernate.initialize(l.getActivities());
		Hibernate.initialize(l.getCollatActivities());
		
		session.close();
		return l;
	}
	
	public Analysis loadAnalysis(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Form needs to be retrieved again as the lists have to be initialised in a session
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		Analysis a = f2.getAnalysis();
		//Need to initialise these as they are lazy loaded
		Hibernate.initialize(a.getOutcomes());
		Hibernate.initialize(a.getImpressions());
		
		session.close();
		return a;
	}
}
