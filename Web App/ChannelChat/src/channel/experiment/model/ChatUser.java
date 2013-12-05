package channel.experiment.model;

import java.io.Serializable;

import com.google.appengine.api.users.User;

public class ChatUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	User u;
	String channelID;
	
	public ChatUser(String username, User u, String channelID){
		this.username = username;
		this.u = u;
		this.channelID = channelID;
	}
	
	public String getUserName(){
		return username;
	}
	
	public User getUserInfo(){
		return u;
	}
	
	public String getChannelID(){
		return channelID;
	}
}
