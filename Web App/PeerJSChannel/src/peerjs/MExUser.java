package peerjs;

public class MExUser {

	String name, channelID;
	
	public MExUser(String name, String channelID) {
		name = this.name;
		channelID = this.channelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
}
