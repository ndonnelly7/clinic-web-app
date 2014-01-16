package peerjs;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class UserList {

	ArrayList<MExUser> users = new ArrayList<MExUser>();
	static String userListKey = "ul_01";
	
	public boolean addUser(MExUser m){
		return users.add(m);
	}
	
	public boolean removeUser(String name){
		Iterator<MExUser> it = users.iterator();
		int i = 0, index = -1;;
		boolean found = false;
		while(it.hasNext() && !found) {
			MExUser u = it.next();
			if(u.getName().equals(name)){
				found = true;
				index = i;
			}
			i++;
		}
		if(found){
			users.remove(index);
			return true;
		}
		return false;
	}
	
	public MExUser getUser(String name) {
		Iterator<MExUser> it = users.iterator();
		while(it.hasNext()) {
			MExUser u = it.next();
			if(u.getName().equals(name)){
				return u;
			}
		}
		return null;
	}
	
	static public UserList GetUserList() {
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		UserList ul = (UserList) cache.get(userListKey);
		
		if(ul == null){
			ul = new UserList();
			cache.put(userListKey, ul);
		}
		
		return ul;
	}
	
	static public void PutBackUserList(UserList ul){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.put(userListKey, ul, null, MemcacheService.SetPolicy.REPLACE_ONLY_IF_PRESENT);
	}
	
	static public void ClearCache(){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.clearAll();
	}
}