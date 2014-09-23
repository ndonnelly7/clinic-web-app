package com.cloud.clinic.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * 
 * Interface between servlet and clinician data. Implements DAO Interface
 * 
 */

public class ClinicianDAO implements DAOInterface<Clinician, String> {

	@Override
	public String create(Clinician t) {
		if(t == null)
			return "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String returnID = "";
		
		session.saveOrUpdate(t);
		session.flush();
		returnID = t.getClinicianID();
		
		tx.commit();
		session.close();
		return returnID;
	}

	@Override
	public Clinician get(String id) {
		if(id.equals(""))
			return null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Clinician c = (Clinician)session.get(Clinician.class, id);
		
		tx.commit();
		session.close();
		
		return c;
	}

	@Override
	public void update(Clinician t) {
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
	public void remove(Clinician t) {
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
	public void removeWithID(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Clinician c = (Clinician)session.get(Clinician.class, id);
		if(c != null)
			session.delete(c);
			
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Clinician> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Clinician> list = session.createCriteria(Clinician.class).list();
		
		session.close();
		return list;
	}

	//Not really necessary for Google Datastore objects
	@Override
	public void runQuery(String sql) {
		// TODO Auto-generated method stub
		
	}
	
	public Clinic getClinic(Clinician c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Clinic clinic = c.getClinic();
		session.close();
		return clinic;
	}

}
