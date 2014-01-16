package peerjs;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class MovieList {

	ArrayList<Movie> movies = new ArrayList<Movie>();
	static String movieListKey = "ml_01";
	
	public boolean addMovie(Movie m){
		return movies.add(m);
	}
	
	public boolean removeMovie(String t){
		Iterator<Movie> it = movies.iterator();
		int i = 0, index = -1;
		boolean found = false;
		while(it.hasNext() && !found) {
			Movie m = it.next();
			if(m.getTitle().equals(t)){
				found = true;
				index = i;
			}
			i++;
		}
		if(found) {
			movies.remove(index);
			return true;
		}
		return false;
	}
	
	public Movie getMovie(String title) {
		Iterator<Movie> it = movies.iterator();
		while(it.hasNext()) {
			Movie m = it.next();
			if(m.getTitle().equals(title)){
				return m;
			}
		}
		return null;
	}
	
	static public MovieList GetMovieList() {
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		MovieList ml = (MovieList) cache.get(movieListKey);
		
		if(ml == null){
			ml = new MovieList();
			cache.put(movieListKey, ml);
		}
		
		return ml;
	}
	
	static public void PutBackUserList(MovieList ml){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.put(movieListKey, ml, null, MemcacheService.SetPolicy.REPLACE_ONLY_IF_PRESENT);
	}
	
	static public void ClearCache(){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.clearAll();
	}
}
