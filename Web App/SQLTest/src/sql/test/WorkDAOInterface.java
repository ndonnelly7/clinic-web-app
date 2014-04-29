package sql.test;

import java.util.List;

public interface WorkDAOInterface {

	int addFullWork(FullWork fW);
	void removeFullWork(FullWork fW);
	void removeFullWork(int id);
	void updateFullWork(FullWork fW);
	List<FullWork> listFullWorks();
	FullWork getFullWork(int id);
}
