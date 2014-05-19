package com.cloud.clinic.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		if(id < 0)
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

	@Override
	public void runQuery(String hql) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		
		tx.commit();
		session.close();
		
	}

	public Form getTodaysForm(Patient p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String hql = "from Form where patient = " + String.valueOf(p.getPatientID()) + " order by timestamp desc";
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Form> list = (List<Form>) q.list();
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
			Form f = list.get(0);
			f.setNew(false);
			session.close();
			return f;
		} else {
			Form f = new Form();
			f.setPatient(p);
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;
		}
	}
	
	public Form getMostRecentForm(Patient p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String hql = "from Form where patient = " + String.valueOf(p.getPatientID()) + " order by timestamp desc";
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Form> list = (List<Form>) q.list();
		if(list.size() == 0){
			Form f = new Form();
			f.setPatient(p);
			f.setTimestamp(c);
			f.setNew(true);
			session.close();
			return f;
		} else {
			Form f = list.get(0);
			session.close();
			return f;
		}
	}

	public PatientHistory loadHistory(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		PatientHistory history = f2.getPatientHistory();
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
		
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		EventsActivities ea = f2.getEventsActivities();
		Hibernate.initialize(ea.getActivities());
		Hibernate.initialize(ea.getCollat_activities());
		
		session.close();
		return ea;
	}
	
	public Lifestyle loadLifestyle(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		Lifestyle l = f2.getLifestyle();
		Hibernate.initialize(l.getActivities());
		Hibernate.initialize(l.getCollatActivities());
		
		session.close();
		return l;
	}
	
	public Analysis loadAnalysis(Form f){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Form f2 = (Form) session.get(Form.class, f.getFormID());
		Analysis a = f2.getAnalysis();
		Hibernate.initialize(a.getOutcomes());
		Hibernate.initialize(a.getImpressions());
		
		session.close();
		return a;
	}
}
