package com.cloud.clinic.model;

import java.util.List;

/*
 * 
 * Interface for DAO classes, used for Clinics, Clinicians, Patients
 * 
 */

public interface DAOInterface <T, PK> {

	PK create(T t);
	T get(PK id);
	void update(T t);
	void remove(T t);
	void removeWithID(PK id);
	List<T> getAll();
	void runQuery(String sql);
}
