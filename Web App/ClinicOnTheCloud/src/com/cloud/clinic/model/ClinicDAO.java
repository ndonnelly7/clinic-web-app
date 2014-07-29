package com.cloud.clinic.model;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.DAOInterface;
import com.cloud.clinic.model.HibernateUtil;


public class ClinicDAO implements DAOInterface<Clinic, String> {

	private String salt = "{64!r<cgNcU^vP4u";
	
	@Override
	public String create(Clinic t) {
		if(t == null)
			return "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String returnID = "";
		
		session.saveOrUpdate(t);
		session.flush();
		returnID = t.getClinicName();
		
		tx.commit();
		session.close();
		return returnID;
	}

	@Override
	public Clinic get(String id) {
		if(id.equals(""))
			return null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Clinic c = (Clinic)session.get(Clinic.class, id);
		
		tx.commit();
		session.close();
		
		return c;
	}

	@Override
	public void update(Clinic t) {
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
	public void remove(Clinic t) {
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

		
		Clinic c = (Clinic)session.get(Clinic.class, id);
		if(c != null)
			session.delete(c);
			
		tx.commit();
		session.close();
	}

	@Override
	public List<Clinic> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Clinic> list = session.createCriteria(Clinic.class).list();
		
		session.close();
		return list;
	}

	@Override
	public void runQuery(String sql) {
		// TODO Auto-generated method stub
		
	}
	
	public void initClinicians() {
		
	}

	public String hashPassword(String pw) {
		return String.valueOf((pw.concat(salt)).hashCode());
	}
	
	public Pair<Clinic, String> validateClinic(String name, String pw){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Clinic c = (Clinic)session.get(Clinic.class, name);
		if(c == null){
			session.close();
			return new Pair<Clinic, String>(null, "No Clinic by that name");
		}
		if(hashPassword(pw).equals(c.getHashedPassword())){
			session.close();
			return new Pair<Clinic, String>(c, "success");
		}else {
			session.close();
			return new Pair<Clinic, String>(null, "Invalid Password");
		}
	}
}
