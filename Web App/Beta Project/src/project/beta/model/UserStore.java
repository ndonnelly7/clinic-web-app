package project.beta.model;

import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@Entity(name="UserStore")
public class UserStore {

	static String userStoreKey = "user_store_001"; 
	
	@Id
	String id;
	
	@Basic
	HashSet<SystemUser> users;
	
	public UserStore(String id){
		this.id = id;
	}
	
	public SystemUser getSystemUserFromName(String name)
	{
		Iterator<SystemUser> it = users.iterator();
		while(it.hasNext()){
			SystemUser p = (SystemUser)it.next();
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}
	
	public SystemUser getSystemUserFromID(String uID)
	{
		Iterator<SystemUser> it = users.iterator();
		while(it.hasNext()){
			SystemUser p = (SystemUser)it.next();
			if(p.getUserID().equals(uID)){
				return p;
			}
		}
		return null;
	}
	
	public SystemUser getSystemUser(User u)
	{
		Iterator<SystemUser> it = users.iterator();
		while(it.hasNext()){
			SystemUser p = (SystemUser)it.next();
			if(p.getGoogleUser().getUserId() == u.getUserId()){
				return p;
			}
		}
		return null;
	}
	
	public HashSet<SystemUser> getAllUsers()
	{
		return users;
	}
	
	static public UserStore GetUserStore()
	{
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		UserStore uStore = null;
		
		try {
			em = emf.createEntityManager();
			uStore = em.find(UserStore.class, userStoreKey);
			if(uStore == null) {
				uStore = new UserStore(userStoreKey);
				em.persist(uStore);
			}
			
		} finally {
			if(em!=null)
				em.close();
		}
		
		return uStore;
	}
	
	static public boolean RemoveUserStore()
	{
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		UserStore uStore = null;
		
		try {
			em = emf.createEntityManager();
			uStore = em.find(UserStore.class, userStoreKey);
			
			if(uStore == null) {
				result = false;
			} else {
				em.remove(uStore);
				result = true;
			}
		} finally {
			if(em!=null)
				em.close();
		}
		
		return result;
	}
	
	static public boolean removeUser(String id)
	{
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		UserStore uStore = null;
		EntityTransaction txn = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			uStore = em.find(UserStore.class, userStoreKey);
			
			if(uStore == null) {
				result = false;
			} else {
				HashSet<SystemUser> pats = uStore.getAllUsers();
				Iterator<SystemUser> it = pats.iterator();
				while(it.hasNext()){
					SystemUser u = it.next();
					if(u.getUserID().equals(id)){
						result = pats.remove(u);
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
	
	static public boolean removeUser(Key k)
	{
		boolean result = false;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		UserStore uStore = null;
		EntityTransaction txn = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			uStore = em.find(UserStore.class, userStoreKey);
			
			if(uStore == null) {
				result = false;
			} else {
				HashSet<SystemUser> pats = uStore.getAllUsers();
				Iterator<SystemUser> it = pats.iterator();
				while(it.hasNext()){
					SystemUser u = it.next();
					if(u.getKey().equals(k)){
						result = pats.remove(u);
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
	
	static public boolean addUser(SystemUser u)
	{
		boolean result = true;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		UserStore us = null;
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			
			us = em.find(UserStore.class, userStoreKey);
			if(us != null) {
				us.getAllUsers().add(u);
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
		
		System.out.println("Finishing up");
		return result;
	}
	
}