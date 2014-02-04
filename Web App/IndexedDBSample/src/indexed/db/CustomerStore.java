package indexed.db;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;

@Entity
public class CustomerStore {

	@Id
	private String storeID = "customer_store";
	
	private ArrayList<Customer> customers;
	
	public CustomerStore() {
		customers = new ArrayList<Customer>();
	}
	
	public String getStoreID() {
		return storeID;
	}
	
	public ArrayList<Customer> getList(){
		return customers;
	}
	
	private boolean addC(Customer c) {
		return customers.add(c);
	}
	
	static public CustomerStore getStore() {
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		CustomerStore cs = null;
		
		try {
			em = emf.createEntityManager();
			cs = em.find(CustomerStore.class, "customer_store");
			
			if(cs == null) {
				cs = new CustomerStore();
				em.persist(cs);
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		return cs;
	}
	
	static public boolean addCustomer(Customer c) {
		boolean result = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		CustomerStore cs = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			cs = em.find(CustomerStore.class, "customer_store");
			
			if(cs == null){
				cs = new CustomerStore();
				cs.addC(c);
				em.persist(cs);
				result = true;
			} else {
				result = cs.addC(c);
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
	
	static public boolean removeCustomer(Customer c) {
		boolean result = false;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		CustomerStore cs = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			cs = em.find(CustomerStore.class, "customer_store");
			
			if(cs == null){
				result = false;
			} else {
				ArrayList<Customer> cList = cs.getList();
				Iterator<Customer> it = cList.iterator();
				while(it.hasNext()) {
					Customer temp = it.next();
					if(temp.getKey() == c.getKey()){
						result = cList.remove(temp);
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
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	static public Customer findCustomer(long k) {
		Customer result = null;
		
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		CustomerStore cs = null;
		
		try {
			em = emf.createEntityManager();
			cs = em.find(CustomerStore.class, "customer_store");
			
			if(cs == null){
				result = null;
			} else {
				ArrayList<Customer> cList = cs.getList();
				Iterator<Customer> it = cList.iterator();
				while(it.hasNext()) {
					Customer temp = it.next();
					if(temp.getKey() == k){
						result = temp;
					}
				}
			}
			
		} finally {
			
			if(em != null)
				em.close();
		}
		
		return result;
	}
	
	static public void ClearStore() {
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		CustomerStore cs = null;
		
		try {
			em = emf.createEntityManager();
			cs = em.find(CustomerStore.class, "customer_store");
			txn = em.getTransaction();
			txn.begin();
			
			if(cs != null) {
				cs.getList().clear();
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
	}
}
