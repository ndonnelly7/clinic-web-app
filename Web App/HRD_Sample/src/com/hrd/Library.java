package com.hrd;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Library")
public class Library {
	
	@Transient
	static String libraryKey = "lib_001";
	
	@Id
	private String libID;
	
	@Basic
	private ArrayList<Book> bookList;
	
	public Library(String libID)
	{
		this.libID = libID;
		bookList = new ArrayList<Book>();
	}
	
	public ArrayList<Book> findBookByName(String name)
	{
		Iterator<Book> it = bookList.iterator();
		ArrayList<Book> books = new ArrayList<Book>();
		
		while(it.hasNext())
		{
			Book b = it.next();
			if(b.getbName().equalsIgnoreCase(name)){
				books.add(b);
			}
			else if(b.getbName().contains(name)){
				books.add(b);
			}
		}		
		return books;
	}

	@Override
	public String toString() {
		return "Library [libID=" + libID + ", bookList=" + bookList + "]";
	}

	public String getLibID() {
		return libID;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}
	
	static public Library getLibrary()
	{
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		Library l = null;
		System.out.println("Initing stuff");
		
		try {
			em = emf.createEntityManager();
			l = em.find(Library.class, libraryKey);
			System.out.println("Inited em and transaction");
			
			if(l == null) {
				l = new Library(libraryKey);
				em.persist(l);
				
				System.out.println("Created new library and persist it");
			}
		} finally {
			if(em != null)
				em.close();
		}
		
		System.out.println("Finishing up");
		return l;
	}
	
	static public boolean addBook(Book b)
	{
		boolean result = true;
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		Library l = null;
		System.out.println("Initing stuff");
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			System.out.println("Inited em and transaction: " + txn);
			
			l = em.find(Library.class, libraryKey);
			if(l != null) {
				l.getBookList().add(b);
				System.out.println("Just about to Commit the transaction: " + txn.isActive());
				txn.commit();
				
				System.out.println("Added Book and commited change");
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
	
	static public boolean removeBook(String name)
	{
		boolean result = false;
		System.out.println("RemovePatientStore method");
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		EntityTransaction txn = null;
		Library l = null;
		System.out.println("Declared stuff");
		
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			
			l = em.find(Library.class, libraryKey);
			System.out.println("Inited Entity Manager and Patient Store");
			
			if(l == null) {
				result = false;
			} else {
				ArrayList<Book> pats = l.getBookList();
				Iterator<Book> it = pats.iterator();
				while(it.hasNext()){
					Book b = it.next();
					if(b.getbName().equalsIgnoreCase(name)){
						result = pats.remove(b);
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
	
	static public boolean ClearLibrary()
	{
		boolean result = false;
		System.out.println("RemovePatientStore method");
		EntityManagerFactory emf = EMF.get();
		EntityManager em = null;
		Library l = null;
		System.out.println("Declared stuff");
		
		try {
			em = emf.createEntityManager();
			l = em.find(Library.class, libraryKey);
			System.out.println("Inited Entity Manager and Patient Store");
			
			if(l == null) {
				result = false;
			} else {
				em.remove(l);
				result = true;
			}
		} finally {
			if(em!=null)
				em.close();
		}
		
		return result;
	}
}
