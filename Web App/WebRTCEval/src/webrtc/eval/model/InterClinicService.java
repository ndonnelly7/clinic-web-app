package webrtc.eval.model;

import java.util.ArrayList;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.Key;


public class InterClinicService {

	public void syncNewPatient(String pName, String clinicName){
		
		PatientDataAccess pda = new PatientDataAccess();
		PeerDataAccess pd = new PeerDataAccess();
		ChannelService service = ChannelServiceFactory.getChannelService();
		Clinic clinic = pd.findClinic(clinicName);
		if(clinic == null){
			System.out.println("Couldn't find Clinic");
			return;
		}
		Client client = pd.findClinician(pName);
		if(client == null){
			System.out.println("Couldn't find Client");
			return;
		}
		ArrayList<Key> intersection = intersection(clinic.getPatientIDs(), client.getcPatientIDs());
		for(int i = 0; i < intersection.size(); i++){
			Patient p = pda.findPatient(intersection.get(0));
			if(p!=null)
			{
				service.sendMessage(new ChannelMessage(Long.toString(client.getcID().getId()),
						"RETRIEVE:"+retrievePatient(p.getPpsn(),clinic,client)));
			}
		}
	}
	
	public String retrievePatient(String ppsn, String clinic, String requestor){
		PeerDataAccess pd = new PeerDataAccess();
		Clinic c = pd.findClinic(clinic);
		if(c == null)
			return "Error: CLINIC NOT FOUND";
		
		PatientDataAccess pda = new PatientDataAccess();
		Patient p = pda.findPatient(ppsn);
		if(p.getClinicID().getId() == c.getClinicID().getId()){
			Client foundClient = null;
			ArrayList<Client> clients = c.getClients();
			boolean found = false;
			for(int i = 0; i < clients.size() && !found; i++){
				foundClient = clients.get(i);
				if(foundClient.isPatientPresent(p.getKey()) && foundClient.isOnline()){
					found = true;
				}
			}
			if(!found){
				return "Error: COULD NOT FIND SUITABLE PEER";
			}
			if(foundClient != null){
				ChannelService channelService = ChannelServiceFactory.getChannelService();
				channelService.sendMessage(new ChannelMessage(Long.toString(foundClient.getcID().getId()), "Request:"+ppsn+":Client:"+requestor));
			}
			return "Info: Attempting contact with suitable peer";
		} else {
			return "Error: CLINIC DOES NOT MATCH";
		}
	}
	
	public String retrievePatient(String ppsn, Clinic c, Client requestor){
		PatientDataAccess pda = new PatientDataAccess();
		Patient p = pda.findPatient(ppsn);
		if(p.getClinicID().getId() == c.getClinicID().getId()){
			Client foundClient = null;
			ArrayList<Client> clients = c.getClients();
			boolean found = false;
			for(int i = 0; i < clients.size() && !found; i++){
				foundClient = clients.get(i);
				if(foundClient.isPatientPresent(p.getKey()) && foundClient.isOnline()){
					found = true;
				}
			}
			if(!found){
				return "Error: COULD NOT FIND SUITABLE PEER";
			}
			if(foundClient != null){
				ChannelService channelService = ChannelServiceFactory.getChannelService();
				channelService.sendMessage(new ChannelMessage(Long.toString(foundClient.getcID().getId()), "Request:"+ppsn+":Client:"+requestor.getcName()));
			}
			return "Info: Attempting contact with suitable peer";
		} else {
			return "Error: CLINIC DOES NOT MATCH";
		}
	}
	
	public String retrievePatient(String ppsn, String requestor){
		PeerDataAccess pd = new PeerDataAccess();
		
		PatientDataAccess pda = new PatientDataAccess();
		Patient p = pda.findPatient(ppsn);
		Clinic c = pd.findClinic(p.getClinicID());
		
		if(c != null){
			Client foundClient = null;
			ArrayList<Client> clients = c.getClients();
			boolean found = false;
			for(int i = 0; i < clients.size() && !found; i++){
				foundClient = clients.get(i);
				if(foundClient.isPatientPresent(p.getKey()) && foundClient.isOnline()){
					found = true;
				}
			}
			if(!found){
				return "Error: COULD NOT FIND SUITABLE PEER";
			}
			if(foundClient != null){
				ChannelService channelService = ChannelServiceFactory.getChannelService();
				channelService.sendMessage(new ChannelMessage(Long.toString(foundClient.getcID().getId()), "Request:"+ppsn+":Client:"+requestor));
			}
			return "Info: Attempting contact with suitable peer";
		} else {
			return "Error: CLINIC NOT FOUND";
		}
	}
	
	public <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
