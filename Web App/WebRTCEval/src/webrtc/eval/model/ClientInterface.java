package webrtc.eval.model;

import java.util.ArrayList;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;

public class ClientInterface {

	public SimplePatient[] getSimplePatientList(ArrayList<Patient> patients){
		SimplePatient[] simples = new SimplePatient[patients.size()];
		
		for(int i = 0; i < patients.size(); i++){
			simples[i] = (new SimplePatient(patients.get(i)));
		}
		
		return simples;
	}
	
	public void UpdatePatientList(String clinic, String client, String keys){
		PatientDataAccess pda = new PatientDataAccess();
		if(keys == null || !(keys.contains(":"))){
			PeerDataAccess pd = new PeerDataAccess();
			pd.replacePatientKeys(new ArrayList<Key>(), client, clinic);
			return;
		}
		String[] ppsn = keys.split(":");
		ArrayList<Key> pKeys = new ArrayList<Key>();
		Patient p = null;
		for(int i = 0; i < ppsn.length-1; i++){
			p = pda.findPatient(ppsn[i]);
			if(p == null){
				SendRemoveInstruction(client,ppsn[i]);
			} else {
				pKeys.add(p.getKey());
			}			
		}
		PeerDataAccess pd = new PeerDataAccess();
		pd.replacePatientKeys(pKeys, client, clinic);
	}
	
	public void SendRemoveInstruction(String client, String ppsn){
		PeerDataAccess pd = new PeerDataAccess();
		Client c = pd.findClinician(client);
		ChannelService service = ChannelServiceFactory.getChannelService();
		service.sendMessage(new ChannelMessage(Long.toString(c.getcID().getId()), "REMOVEPATIENT:"+ppsn+":"));
	}
	
	public void ClearPatientInfoFromClient(String ppsn, String client){
		//TODO: Make sure peers can successfully find patients before we start deleting them from the record
	}
	
	public String UpdateClient(String ppsn, String client, String clinic){
		PatientDataAccess pda = new PatientDataAccess();
		Patient p = pda.findPatient(ppsn);
		if(p == null)
			return "Problem finding patient";
		
		PeerDataAccess pd = new PeerDataAccess();
		
		if(pd.addPatientKeyToClient(p.getClinicID(), client, clinic))
			return "Updated Client";
		else return "Failed to Update Client";
	}
	
	public void PatientFoundUpdate(String ppsn, String client, String peer){
		PeerDataAccess pd = new PeerDataAccess();
		Client c = pd.findClinician(client);
		ChannelService service = ChannelServiceFactory.getChannelService();
		service.sendMessage(new ChannelMessage(Long.toString(c.getcID().getId()), "UPDATEREQUEST:TRUE:PPSN:"+ppsn+":PEER:"+peer));
	}
	
	public void RetryPatientRetrieval(String ppsn, String client){
		InterClinicService ics = new InterClinicService();
		String result = ics.retrievePatient(ppsn, client);
		
		PeerDataAccess pd = new PeerDataAccess();
		Client c = pd.findClinician(client);
		ChannelService service = ChannelServiceFactory.getChannelService();
		service.sendMessage(new ChannelMessage(Long.toString(c.getcID().getId()), "RETRIEVE:"+result));
	}
	
	public void SynchNewPatient(String clinic, String ppsn){
		InterClinicService ics = new InterClinicService();
		ics.syncNewPatient(clinic, ppsn);
	}
	
	public void SynchClient(String client, String clinic, String peer){
		InterClinicService ics = new InterClinicService();
		ics.syncNewClient(client, clinic,peer);
	}
	
	public String retrievePatient(String ppsn, String clinic, String client)
	{
		InterClinicService ics = new InterClinicService();
		return ics.retrievePatient(ppsn, clinic, client);
	}
	
	public String findPatient(String ppsn, String clinic)
	{
		PatientDataAccess pda = new PatientDataAccess();
		pda.init();
		Patient p = pda.findPatient(ppsn);
		
		if(p == null)
			return "";
		SimplePatient sp = new SimplePatient(p);
		Gson gson = new Gson();
		String json = gson.toJson(sp);
		return json;
	}
	
	public String addPatient(String ppsn, String clientName, String clinicName, String weight,
			String alcoPoints, String stress, String sleep, String mem, String dementia){
		PeerDataAccess pd = new PeerDataAccess();
		Client c = pd.findClinicianInClinic(clientName, clinicName);
		if(c==null){
			return "Couldn't find client with name " + clientName + " in clinic";
		}
		Patient p = new Patient(ppsn, c, c.getcClinic().getClinicID(), 
					weight, alcoPoints, stress, sleep, mem, dementia);
		PatientDataAccess patD = new PatientDataAccess();
		patD.init();
		if(!patD.addPatient(p)){
			return "Couldn't add patient with ppsn " + ppsn;
		}
		
		p = patD.findPatient(ppsn);
		if(p == null)
			return "Patient not added correctly";
		
		if(!pd.addPatientKey(p.getKey(), clientName, clinicName))
			return "Patient couldn't be added to clinic or client";
		
		return "Success: " + p.getPpsn();
	}
	
	//Returns a list of the clinic names in a JSON object
	public ArrayList<String> getClinicsList(){
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		ArrayList<Clinic> clinics = pd.getClinics();
		ArrayList<String> clinic_names = new ArrayList<String>();
		for(int i = 0; i < clinics.size(); i++){
			clinic_names.add(clinics.get(i).getName());
		}
		
		return clinic_names;
	}
	
	public String getClientsFromClinic(String clinic_name) {
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		
		Clinic c = pd.findClinic(clinic_name);
		if(c == null)
			return "";
		
		ArrayList<Client> clients = c.getClients();
		
		if(clients.size() <= 0)
			return "";
		
		ArrayList<String> client_names = new ArrayList<String>();
		for(int i = 0; i < clients.size(); i++){
			client_names.add(clients.get(i).getcName());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(client_names);
		return json;
	}
	
	public ArrayList<Patient> getPatients() {
		PatientDataAccess pda = new PatientDataAccess();
		pda.init();
		
		return pda.getPatients();
	}
}
