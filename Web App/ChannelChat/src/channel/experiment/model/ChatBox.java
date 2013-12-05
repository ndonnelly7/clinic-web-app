package channel.experiment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.users.User;

public class ChatBox implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashSet<ChatUser> subscribers;
	private ArrayList<String> authorized_users;
	private String name;
	
	public ChatBox(String name){
		subscribers = new HashSet<ChatUser>();
		authorized_users = new ArrayList<String>();
		authorized_users.add("n.donnellyv3.0@gmail.com");
		authorized_users.add("scrineym@gmail.com");
		authorized_users.add("test@example.com");
		
		this.name = name;
	}
	
	public boolean subscribe(ChatUser u){
		if(u.u == null || u.channelID == null)
			return false;
		
		return subscribers.add(u);
	}
	
	public int unsubscribe(ChatUser u){
		if(subscribers.contains(u))
			return -1;
		
		if(subscribers.remove(u))
			return 0;
		else return 1;
	}
	
	public int unsub(String clientID){
		int result = 0;
		
		Iterator<ChatUser> it = subscribers.iterator();
		while(it.hasNext()){
			ChatUser u = it.next();
			if(u.channelID.equals(clientID)){
				subscribers.remove(u);
				return 1;
			}
		}
		
		return result;
	}
	
	public int unsubWithUsername(String name){
		int result = 0;
		
		Iterator<ChatUser> it = subscribers.iterator();
		while(it.hasNext()){
			ChatUser u = it.next();
			if(u.username.equals(name)){
				subscribers.remove(u);
				return 1;
			}
		}
		
		return result;
	}
	
	public ArrayList<String> getRecentMessages(){
		return new ArrayList<String>();
	}
	
	public void broadcastMessage(String message, String sender){
		System.out.println("From ChatBox broadcast: " + sender + " says " + message);
		Iterator<ChatUser> it = subscribers.iterator();
		while(it.hasNext()){
			ChatUser u = it.next();
			ChannelService channelService = ChannelServiceFactory.getChannelService();
			String chatMessage = sender + ": " + message;
            channelService.sendMessage(new ChannelMessage(u.getChannelID(),chatMessage));
		}
	}
	
	public int getNumUsers() {
		return subscribers.size();
	}
	
	public boolean validateUser(User user){
		Iterator<ChatUser> it = subscribers.iterator();
		while(it.hasNext()){
			ChatUser cu = it.next();
			if(cu.u.compareTo(user)==0){
				return true;
			}
		}
		return false;		
	}
	
	public boolean validateUser(String name){
		Iterator<ChatUser> it = subscribers.iterator();
		while(it.hasNext()){
			ChatUser cu = it.next();
			if(cu.username.equals(name)){
				return true;
			}
		}
		return false;		
	}
	
	public void addAuthorizedUser(String email){
		authorized_users.add(email);
	}
	
	public String getName(){
		return name;
	}
	
	static public ChatBox GetChatBox(String chatKey){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		ChatBox cb = (ChatBox) cache.get(chatKey);
		
		if(cb == null){
			cb = new ChatBox(chatKey);
			cache.put(chatKey, cb);
		}
		
		return cb;
	}
	
	static public void PutBackChatBox(String chatkey, ChatBox cb){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.put(chatkey, cb, null, MemcacheService.SetPolicy.REPLACE_ONLY_IF_PRESENT);
	}
	
	static public void ClearBoxFromCache(String chatKey){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.delete(chatKey, 1000);
	}
	
	static public ChatBox GetIfExistsChatBox(String chatkey){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		ChatBox cb = (ChatBox) cache.get(chatkey);
		return cb;
	}
	
	static public void ClearCache(){
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
		cache.clearAll();
		System.out.println("cache size: " + cache.getStatistics().toString());
	}
}
