package project.beta.model;

import java.util.List;

public interface DAOInterface <T, PK> {

	PK create(T t);
	T get(PK id);
	void update(T t);
	void remove(T t);
	void removeWithID(PK id);
	List<T> getAll();
	
}
