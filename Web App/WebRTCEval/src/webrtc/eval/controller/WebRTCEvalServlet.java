package webrtc.eval.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webrtc.eval.model.Client;
import webrtc.eval.model.Clinic;
import webrtc.eval.model.InterClinicService;
import webrtc.eval.model.Patient;
import webrtc.eval.model.PatientDataAccess;
import webrtc.eval.model.PeerDataAccess;
import webrtc.eval.model.SimplePatient;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class WebRTCEvalServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*
		 * Request requirements: 
		 * Request type - ClinicsList, ClientsFromClinic, Synch, Retrieve, FindPatient, FindClient
		 */
		
		String type = req.getParameter("type");
		
		switch(type) {
		case "ClinicsList" :
			String clinics = getClinicsList();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(clinics);
			break;
		case "ClientsFromClinic" :
			String clients = getClientsFromClinic(req.getParameter("clinic"));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(clients);
			break;
		case "ChannelCheck":
			System.out.println("ChannelCheck entered");
			String clinic = req.getParameter("clinic");
			String name = req.getParameter("user");
			
			resp.setContentType("text/plain");
			resp.getWriter().println(sendChannelPing(clinic,name));
			break;
		case "AddPatient":
			System.out.println("Adding Patient");
			String pPPSN = req.getParameter("ppsn");
			String cName = req.getParameter("client");
			String cClinic = req.getParameter("clinic");
			
			resp.setContentType("text/plain");
			resp.getWriter().println(addPatient(pPPSN, cName, cClinic));
			//TODO: Need to add the synch stuff here as well
			break;
		case "FindPatient":
			System.out.println("Finding Patient");
			String PPSN = req.getParameter("ppsn");
			String Clinic = req.getParameter("clinic");			
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(findPatient(PPSN, Clinic));
			break;
		case "RetrievePatient":
			System.out.println("Retrieving Patient");
			String rPPSN = req.getParameter("ppsn");
			String rClinic = req.getParameter("clinic");
			String rClient = req.getParameter("client");
			
			resp.setContentType("text/plain");
			resp.getWriter().println(retrievePatient(rPPSN, rClinic,rClient));
			break;
		case "PatientNotFound":
			System.out.println("Patient Not Found");
			String pnfPPSN = req.getParameter("ppsn");
			String pnfClient = req.getParameter("client");
			//Needed in order to remove the patient info from the super peer's records
			String prfUser = req.getParameter("user");
			ClearPatientInfoFromClient(pnfPPSN, prfUser);
			
			RetryPatientRetrieval(pnfPPSN, pnfClient);
			resp.setContentType("text/plain");
			resp.getWriter().println("Accepted");
			break;
		case "PatientFound":
			System.out.println("Patient Found");
			String pfPPSN = req.getParameter("ppsn");
			String pfClient = req.getParameter("client");
			String pfPeer = req.getParameter("peerID");
			PatientFoundUpdate(pfPPSN, pfClient, pfPeer);
			resp.setContentType("text/plain");
			resp.getWriter().println("Accepted");
			break;
		case "SyncMe":
			System.out.println("Synching");
			String sClinic = req.getParameter("clinic");
			String sClient = req.getParameter("client");
			SynchClient(sClient, sClinic);
			resp.setContentType("text/plain");
			resp.getWriter().println("Attempting to sync");
		default:
			resp.setContentType("text/plain");
			resp.getWriter().println("Unkown Command");
		}
	}
	
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*
		 * Request requirements: 
		 * Request type - AddPatient
		 */
		
		
	}
	
	public void ClearPatientInfoFromClient(String ppsn, String client){
		//TODO: Make sure peers can successfully find patients before we start deleting them from the record
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
	
	public void SynchClient(String client, String clinic){
		InterClinicService ics = new InterClinicService();
		ics.syncNewPatient(client, clinic);
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
	
	public String addPatient(String ppsn, String clientName, String clinicName){
		PeerDataAccess pd = new PeerDataAccess();
		Client c = pd.findClinicianInClinic(clientName, clinicName);
		if(c==null){
			return "Couldn't find client with name " + clientName + " in clinic";
		}
		Patient p = new Patient(ppsn, c, c.getcClinic().getClinicID());
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
		
		return "Success: " + p.getKey().getId();
	}
	
	//Returns a list of the clinic names in a JSON object
	public String getClinicsList(){
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		ArrayList<Clinic> clinics = pd.getClinics();
		ArrayList<String> clinic_names = new ArrayList<String>();
		for(int i = 0; i < clinics.size(); i++){
			clinic_names.add(clinics.get(i).getName());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(clinic_names);
		return json;
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
	
	public String sendChannelPing(String clinic, String client){
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		Client c = pd.findClinicianInClinic(client, clinic);
		if(c == null)
			return "Couldn't find";
		
		channelService.sendMessage(new ChannelMessage(Long.toString(c.getcID().getId()), "Ping: Sent at " + System.currentTimeMillis()));
		
		return "Success";
	}
}
