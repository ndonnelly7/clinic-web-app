package webrtc.eval.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webrtc.eval.model.Client;
import webrtc.eval.model.ClientInterface;
import webrtc.eval.model.PatientDataAccess;
import webrtc.eval.model.PeerDataAccess;
import webrtc.eval.model.QueryLanguage;

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
		ClientInterface cl = new ClientInterface();
		
		QueryLanguage ql = new QueryLanguage();
		
		switch(type) {
		case "ClinicsList" :
			Gson gson = new Gson();
			String clinics = gson.toJson(cl.getClinicsList());
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(clinics);
			break;
		case "ClientsFromClinic" :
			String clients = cl.getClientsFromClinic(req.getParameter("clinic"));
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
			
			String weight = req.getParameter("weight");
			String alco_points = req.getParameter("points");
			String stress = req.getParameter("stress");
			String sleep = req.getParameter("sleep");
			String memory_score = req.getParameter("memory");
			String dementia = req.getParameter("dementia");
			
			String result = cl.addPatient(pPPSN, cName, cClinic, weight, alco_points, stress, sleep, memory_score,dementia);
			cl.SynchNewPatient(cClinic, pPPSN);
			resp.setContentType("text/plain");
			resp.getWriter().println(result);
			break;
		case "FindPatient":
			System.out.println("Finding Patient");
			String PPSN = req.getParameter("ppsn");
			String Clinic = req.getParameter("clinic");			
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(cl.findPatient(PPSN, Clinic));
			break;
		case "RetrievePatient":
			System.out.println("Retrieving Patient");
			String rPPSN = req.getParameter("ppsn");
			String rClinic = req.getParameter("clinic");
			String rClient = req.getParameter("client");
			
			resp.setContentType("text/plain");
			resp.getWriter().println(cl.retrievePatient(rPPSN, rClinic,rClient));
			break;
		case "PatientNotFound":
			System.out.println("Patient Not Found");
			String pnfPPSN = req.getParameter("ppsn");
			String pnfClient = req.getParameter("client");
			//Needed in order to remove the patient info from the super peer's records
			String prfUser = req.getParameter("user");
			cl.ClearPatientInfoFromClient(pnfPPSN, prfUser);
			
			cl.RetryPatientRetrieval(pnfPPSN, pnfClient);
			resp.setContentType("text/plain");
			resp.getWriter().println("Accepted");
			break;
		case "PatientFound":
			System.out.println("Patient Found");
			String pfPPSN = req.getParameter("ppsn");
			String pfClient = req.getParameter("client");
			String pfPeer = req.getParameter("peerID");
			cl.PatientFoundUpdate(pfPPSN, pfClient, pfPeer);
			resp.setContentType("text/plain");
			resp.getWriter().println("Accepted");
			break;
		case "SyncMe":
			System.out.println("Synching");
			String sClinic = req.getParameter("clinic");
			String sClient = req.getParameter("client");
			String sPeer = req.getParameter("peerID");
			cl.SynchClient(sClient, sClinic, sPeer);
			resp.setContentType("text/plain");
			resp.getWriter().println("Attempting to sync");
			break;
		case "UpdateClient":
			System.out.println("Updating Client with new Patient");
			String uClinic = req.getParameter("clinic");
			String uClient = req.getParameter("client");
			String uPPSN = req.getParameter("ppsn");
			resp.setContentType("text/plain");
			resp.getWriter().println(cl.UpdateClient(uPPSN, uClient, uClinic));
			break;
		case "UpdatePatientList":
			System.out.println("Updating Client's list of Patients");
			String upClinic = req.getParameter("clinic");
			String upClient = req.getParameter("client");
			String keys = req.getParameter("keys");
			cl.UpdatePatientList(upClinic, upClient, keys);
			resp.setContentType("text/plain");
			resp.getWriter().println("UPDATED");
			break;
		case "UpdatePatient":
			
			break;
		case "DeletePatient":
			
			break;
		case "SQLRequest":
			System.out.println("Received Query: ");
			String query = req.getParameter("query");
			String client = req.getParameter("client");
			System.out.println(query);
			String sqlResult = ql.ParseQuery(query, client);
			resp.setContentType("text/plain");
			resp.getWriter().println(sqlResult);
			break;
		case "RESETPEER":
			System.out.println("Resetting Peers");
			PeerDataAccess pd = new PeerDataAccess();
			pd.reInit();
			resp.setContentType("text/plain");
			resp.getWriter().println("done");
			break;
		case "RESETPATIENT":
			System.out.println("Resetting Patients");
			PatientDataAccess pda = new PatientDataAccess();
			pda.reInit();
			break;
		default:
			resp.setContentType("text/plain");
			resp.getWriter().println("Unknown Command");
		}
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