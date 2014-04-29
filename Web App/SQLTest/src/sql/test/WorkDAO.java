package sql.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class WorkDAO implements WorkDAOInterface {

	public int addFullWork(FullWork fW){
		if(fW == null)
			return -1;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int returnID;

			session.save(fW);
			session.flush();
			returnID = fW.getWorkID();
			
		tx.commit();
		session.close();
		return returnID;
	}

	@Override
	public void removeFullWork(FullWork fW) {
		if(fW == null)
			return;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.delete(fW);
		session.flush();
			
		tx.commit();
		session.close();
		
	}
	
	@Override
	public void removeFullWork(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		
		FullWork FW = (FullWork)session.get(FullWork.class, id);
		if(FW != null)
			session.delete(FW);
			
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateFullWork(FullWork fW) {
		if(fW == null)
			return;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

			session.update(fW);
			session.flush();
			
		tx.commit();
		session.close();
		
	}

	@Override
	public List<FullWork> listFullWorks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<FullWork> list = session.createCriteria(FullWork.class).list();
		
		session.close();
		return list;
	}

	@Override
	public FullWork getFullWork(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		
		FullWork FW = (FullWork)session.get(FullWork.class, id);
			
		tx.commit();
		session.close();
		
		return FW;
	}
}
