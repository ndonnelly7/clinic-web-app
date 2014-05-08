package com.cloud.clinic.model;

import java.util.List;

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

	

}
