package com.cloud.clinic.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*
 * EntityManagerFactory Singleton as only one should be used
 * Used for managing persistence objects
 */
public final class EMF {
	private static final EntityManagerFactory emfInstance =
			Persistence.createEntityManagerFactory("transactions-optional");
	
	private EMF() {}
	
	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
