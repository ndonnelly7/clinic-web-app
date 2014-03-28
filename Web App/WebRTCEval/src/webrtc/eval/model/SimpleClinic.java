package webrtc.eval.model;

import java.util.ArrayList;

public class SimpleClinic {
	String name;
	String address;
	ArrayList<String> clients;
	
	public SimpleClinic(Clinic c){
		this.name = c.getName();
		this.address = c.getAddress();
		clients = new ArrayList<String>();
		ArrayList<Client> clientList = c.getClients();
		for(int i = 0; i < clients.size(); i++){
			clients.add(clientList.get(i).getcName());
		}
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<String> getClients() {
		return clients;
	}
}