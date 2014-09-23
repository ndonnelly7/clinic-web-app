package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.ClinicDAO;
import com.cloud.clinic.model.Clinician;
import com.cloud.clinic.model.ClinicianDAO;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Pair;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.cloud.clinic.p2p.Job;
import com.cloud.clinic.p2p.P2P;
import com.cloud.clinic.p2p.P2PDAO;
import com.cloud.clinic.p2p.Peer;
import com.cloud.clinic.p2p.Superpeer;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * 
 * Helper servlet for loads of operations
 * the type of operation is gotten from HttpRequest using keywords from client
 * 
 * 1. Creating a clinic: NEW_CLINIC
 * 2. Creating a clinician: NEW_CLINICIAN
 * 3. Sign in peer: PEER_SIGN_IN
 * 4. Sign out peer: PEER_SIGN_OUT
 * 5. Sends a patient to the peer via Google Channel if WebRTC is not supported: SEND_PATIENT_TO_PEER
 * 6. make a patient request: REQUEST_PATIENT
 * 7. Request an update for the user: REQUEST_UPDATE
 * 8. Lets the system know of a newly added patient: ADDED_PATIENT
 * 9. Lets system know a patient has been removed: REMOVED_PATIENT
 * 10. User claims job: CLAIM_JOB
 * 11. Delete a patient from the system: DELETE
 * 
 * Operations for Evalutation purposes:
 * 12. Retrieves a page from multiple patients: MULTIPLE_TEST
 * 13. Requests peer to share loads of patients: MULTIPLE_P2P
 * 
 */

@SuppressWarnings("serial")
public class ClinicOnTheCloudServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ClinicOnTheCloudServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Gets user object from Google Users Service
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		//Gets the type of operation required
		String type = req.getParameter("type");
		
		log.log(Level.WARNING, "Entered Servlet with type: " + type);
		switch(type) {
		case "NEW_CLINIC":
			newClinic(req);
			resp.setContentType("text/plain");
			resp.getWriter().println("done");
			break;
		case "NEW_CLINICIAN":
			String status = newClinician(req, user); //Returns a string status
			if(status.equals("added")){
				//Redirects user to home page as user was successfully added
				req.setAttribute("name", req.getParameter("name"));
				req.setAttribute("new", "true");
				RequestDispatcher view = req.getRequestDispatcher("admin/home.jsp");
				view.forward(req, resp);
			} else {
				//User not added for some reason to redirect to error page
				req.setAttribute("error", status);
				RequestDispatcher view = req.getRequestDispatcher("admin/Error.jsp");
				view.forward(req, resp);
			}
			break;
		case "PEER_SIGN_IN":
			//Adds peer onto network
			String result = signPeerIn(req, user);
			resp.setContentType("text/plain");
			resp.getWriter().println(result);
			break;
		case "PEER_SIGN_OUT":
			//Removes peer onto network
			String signOutPeer = signPeerOut(req, user);
			resp.setContentType("text/plain");
			resp.getWriter().println(signOutPeer);
			break;
		case "SEND_PATIENT_TO_PEER":
			//Creates JSON Array of patients to be sent to a particular peer
			String jsonPatients = req.getParameter("patients");
			String peer_id = req.getParameter("peerID");
			//Sends the patients to the peer
			String response = sendPatient(jsonPatients, peer_id);
			resp.setContentType("text/plain");
			resp.getWriter().println(response);
			break;
		case "REQUEST_PATIENT":
			//pid is the patient id of the sought patient
			String pid = req.getParameter("pid");
			//the mode is either P2P or Channel
			String mode = req.getParameter("mode");
			//Sends response from attempt to request patient
			String reqResponse = requestPatient(user, pid, mode);
			resp.setContentType("text/plain");
			resp.getWriter().println(reqResponse);
			break;
		case "REQUEST_UPDATE":
			//Mode for the update can either be P2P or Channel
			String Updatemode = req.getParameter("mode");
			String updateResponse = requestUpdate(user, Updatemode);
			resp.setContentType("text/plain");
			resp.getWriter().println(updateResponse);
			break;
		case "ADDED_PATIENT":
			String patient_id = req.getParameter("PatientID");
			String addResponse = addPatient(user, patient_id);
			resp.setContentType("text/plain");
			resp.getWriter().println(addResponse);
			break;
		case "REMOVED_PATIENT":
			String rPID = req.getParameter("PatientID");
			String removeResponse = removePatient(user, rPID);
			resp.setContentType("text/plain");
			resp.getWriter().println(removeResponse);
			break;
		case "CLAIM_JOB":
			//Gets the ID for the job that the user is attempting to claim
			String jobID = req.getParameter("JobID");
			String claimResponse = claimJob(user, jobID);
			resp.setContentType("text/plain");
			resp.getWriter().println(claimResponse);
			break;
		case "DELETE":
			//Gets the id of the patient that should be removed from the system
			String delID = req.getParameter("DeleteID");
			String delResponse = deletePatient(user, delID);
			resp.setContentType("text/plain");
			resp.getWriter().println(delResponse);
			break;
		case "MULTIPLE_TEST":
			String mResponse = getMultiplePatients();
			resp.setContentType("text/plain");
			resp.getWriter().println(mResponse);
			break;
		case "MULTIPLE_P2P":
			String mpResponse = requestMultiplePatients(user);
			resp.setContentType("text/plain");
			resp.getWriter().println(mpResponse);
			break;
		default:
			//No operation found so return garbage
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, world");
		}
	}
	
	//Strictly just for an experiment, can be removed
	private String requestMultiplePatients(User user){
		boolean sentJob = false;
		P2PDAO dao = new P2PDAO();
		P2P p2p = dao.getP2P();
		ArrayList<Superpeer> sps = p2p.getSps();
		Peer requestor = dao.findPeer(user.getUserId());
		log.log(Level.WARNING, "SPS Length: " + sps.size());
		if(requestor == null)
			return "Failed to find a peer with that patientID";
		String jobString = "SEND_MULTI:PEER:"+requestor.getP2pAddress()+":";
		Job job = new Job(requestor.getClinicianID(), jobString, p2p.getJob_tick());
		dao.addJob(job);
		String toSend = "JOB_POST:PID:NA:JOBID:"+job.getJob_id()+":MODE:P2P:TYPE:MULTI:";
		log.log(Level.WARNING, "Job String: " + toSend);
		for(int i = 0; i < sps.size(); i++){
			Superpeer sp = sps.get(i);
			log.log(Level.WARNING, "Peer Length on Super-peer: " + sp.getPeers().size());
			for(int j = 0; j < sp.getPeers().size(); j++){
				Peer p = sp.getPeers().get(j);
				if(!(p.getP2pAddress().equalsIgnoreCase(requestor.getP2pAddress())))
				{
					log.log(Level.WARNING, "Peer Found: " + p.getP2pAddress());
					//if(p.getPatientIDs().contains(Integer.parseInt(patientID))){
					//Send patient request via Channel
					ChannelService service = ChannelServiceFactory.getChannelService();
					service.sendMessage(new ChannelMessage(p.getChannelID(), toSend));
					sentJob = true;
				}
			}
		}
		if(sentJob)
			return "Posted a job for multiple patients";
		else return "Failed to find a Clinician to send Job";
	}
	
	//Strictly just for an experiment, can be removed
	private String getMultiplePatients() {
		String result = "[";
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithModifiers();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		
		PatientDAO dao = new PatientDAO();
		List<Patient> patients = dao.getAll();
		for(int i = 0; i < 100; i++){
			Form f = patients.get(i).getForms().get(0);
			String json = gson.toJson(f.getPersonalDetails());
			json = json.replace("{", "{\"patient_id\":\"" + patients.get(i).getPatientID() + "\",");
			if(i < 99)
				result+= json + ",";
			else
				result += json;
		}
		result += "]";
		return result;
	}
	
	//Deletes the patient from the system with the patient ID called deleteID
	// Returns a string with the status of the result
	private String deletePatient(User u, String deleteID) {
		PatientDAO dao = new PatientDAO();
		if(deleteID != ""){
			int id = Integer.parseInt(deleteID);
			//Use the patientDAO to remove with the ID
			dao.removeWithID(id);
			if(dao.get(id) == null)
				return "REMOVED";
			else return "Error: Patient Not Removed for Some Reason";
			
		} else {
			return "Error: Empty ID";
		}
	}
	
	//Signs the peer into the network with the P2PDAO
	//Returns status string
	private String signPeerOut(HttpServletRequest req, User user) {
		P2PDAO dao = new P2PDAO();
		Peer p = dao.findPeer(user.getUserId());
		if(p != null){
			if(dao.removePeer(p, p.getSp()))
				return "Peer successfully removed";
		}
		return "Peer doesn't exist";
	}
	
	//Claim the job with a given ID
	//Returns status string
	private String claimJob(User user, String jobID){
		P2PDAO dao = new P2PDAO();
		//Get the peer for the user first
		Peer p = dao.findPeer(user.getUserId());
		if(p == null)
			return null;
		
		Job j = dao.claimJob(Integer.parseInt(jobID));
		if(j == null)
			return "Missed job";
		
		//Log the warnings for debugging
		log.log(Level.WARNING, "Claimed Job: " + j.getJob());
		log.log(Level.WARNING, "Sending job to: " + p.getClinicianID());
		
		//Send job across the Channel to the user
		ChannelService service = ChannelServiceFactory.getChannelService();
		service.sendMessage(new ChannelMessage(p.getChannelID(), j.getJob()));
		
		return "Successfully Claimed Job";
	}

	//Add patient ID to the peer's list of held patients
	public String addPatient(User user, String patientID){
		String result = "";
		
		P2PDAO dao = new P2PDAO();
		Peer p = dao.findPeer(user.getUserId());
		if(p != null) {
			//Add the
			p.addPatientID(Integer.parseInt(patientID));
			dao.updatePeer(p);
			return "Successfully added patient ID";
		}
		result = "Could not find peer";
		
		return result;
	}
	
	//Remove patient from peer's list that matches the given patient ID
	public String removePatient(User user, String patientID){
		String result = "";
		
		P2PDAO dao = new P2PDAO();
		Peer p = dao.findPeer(user.getUserId());
		if(p != null) {
			p.removePatientID(Integer.parseInt(patientID));
			dao.updatePeer(p);
			return "Successfully removed patient ID";
		}
		result = "Could not find peer";
		
		return result;
	}
	
	//Creates a patient request job for the patient with matching id for the given user using the provided transport mode
	//Should create a job string that contains the patient id, the peer's P2P address, the mode and the operation
	//This job is then stored and a job posting string is created that is distributed to all the other peers 
	//Job is distributed quite stupidly by asking every peer on the network. Could be improved
	//The Job and Job posting are seperated by colons so the client can parse out the necessary info
	public String requestPatient(User user, String patientID, String transportMode){
		
		boolean sentJob = false;
		P2PDAO dao = new P2PDAO();
		P2P p2p = dao.getP2P();
		ArrayList<Superpeer> sps = p2p.getSps();
		Peer requestor = dao.findPeer(user.getUserId());
		//Debugging
		log.log(Level.WARNING, "SPS Length: " + sps.size());
		if(requestor == null)
			return "Failed to find a peer with that patientID";
		String jobString = "";
		//Wants the data sent over P2P
		if(transportMode.equals("P2P"))
			jobString = "SEND_PATIENT:PID:"+patientID+":PEER:"+requestor.getP2pAddress()+":MODE:" + transportMode + ":TYPE:REQUEST:";
		else //Otherwise send over Channel
			jobString = "SEND_PATIENT:PID:"+patientID+":PEER:"+requestor.getChannelID()+":MODE:" + transportMode + ":TYPE:REQUEST:";
		
		//Creates the job and sets its deadline timer
		Job job = new Job(requestor.getClinicianID(), jobString, p2p.getJob_tick());
		dao.addJob(job);
		String toSend = "JOB_POST:PID:"+patientID+":JOBID:"+job.getJob_id()+":MODE:"+transportMode+":TYPE:REQUEST:";
		
		//Debugging
		log.log(Level.WARNING, "Job String: " + toSend);
		
		//Gets all super-peers
		for(int i = 0; i < sps.size(); i++){
			Superpeer sp = sps.get(i);
			//Gets all the super-peers peers
			for(int j = 0; j < sp.getPeers().size(); j++){
				Peer p = sp.getPeers().get(j);
				//Contacts peer with the job posting through the peer channel
				log.log(Level.WARNING, "Peer Found: " + p.getP2pAddress());
				ChannelService service = ChannelServiceFactory.getChannelService();
				service.sendMessage(new ChannelMessage(p.getChannelID(), toSend));
				sentJob = true;
			}
		}
		//returns the status of the job
		if(sentJob)
			return "Posted a job for patient: " + patientID;
		else return "Failed to find a Clinician to send Job";
	}
	
	//Similar to request patient, a job is created to update the peer with the latest patients from the clinic
	//Operation on the Job string is set to UPDATE and only the users peers from the same clinic are sent the request
	public String requestUpdate(User user, String transportMode){
		String result = "";
		
		P2PDAO dao = new P2PDAO();
		P2P p2p = dao.getP2P();
		Peer p = dao.findPeer(user.getUserId());
		if(p == null){
			return "Peer not found";
		}
		log.log(Level.WARNING, "Got peer: " + p.getClinicianID());
		Superpeer sp = p.getSp();
		log.log(Level.WARNING, "Got Superpeer: " + sp.getClinicID());
		String jobString = "";
		if(transportMode.equals("P2P"))
			jobString = "UPDATE_PEER:PID:"+p.getP2pAddress()+":MODE:" + transportMode + ":";		
		else
			jobString = "UPDATE_PEER:PID:"+p.getChannelID()+":MODE:" + transportMode + ":";
		Job job = new Job(p.getClinicianID(), jobString, p2p.getJob_tick());
		log.log(Level.WARNING, "Created JOB with ID: " + job.getJob_id());
		dao.addJob(job);
		String toSend = "JOB_POST:PID:NA:JOBID:"+job.getJob_id()+":MODE:"+transportMode+":TYPE:UPDATE:";
		log.log(Level.WARNING, "Job String: " + toSend);
		for(int i = 0; i < sp.getPeers().size(); i++){
			if(!(p.getId().equals(sp.getPeers().get(i).getId()))){
				Peer host = sp.getPeers().get(i);
				if(host != null){
					ChannelService service = ChannelServiceFactory.getChannelService();
					service.sendMessage(new ChannelMessage(host.getChannelID(),toSend));
				}
			}
		}
		
		result = "Request for update sent to peers";
		return result;
	}
	
	//Sends patients JSON object to a user over the Google Channel
	public String sendPatient(String patients, String peerChannel){
		ChannelService service = ChannelServiceFactory.getChannelService();
		String sendString = "RECEIVE_PATIENTS:patients:" + patients;
		service.sendMessage(new ChannelMessage(peerChannel, sendString));
		return "Patients String send successfully";
	}
	
	//Create new clinic with name and unsalted password to use, provided in HttpRequest
	public void newClinic(HttpServletRequest req){
		String name = req.getParameter("name");
		String pw = req.getParameter("password");
		
		ClinicDAO dao = new ClinicDAO();
		Clinic c = new Clinic();
		c.setClinicName(name);
		c.setHashedPassword(dao.hashPassword(pw));
		dao.create(c);
	}
	
	//Creates new Clinician from paramters in HttpServlet Request and User object
	public String newClinician(HttpServletRequest req, User user){
		String result = "";
		
		if(user == null){
			return "Invalid Login State";
		}
		String name = req.getParameter("name");
		String clinic = req.getParameter("clinic");
		
		//Checks the given password to ensure the clinician is a part of the clinic
		String pw = req.getParameter("pass");
		ClinicDAO clinicDAO = new ClinicDAO();
		Pair<Clinic, String> p = clinicDAO.validateClinic(clinic, pw);
		
		//If the clinic is null, then return the Error message
		if(p.getFirst() == null){
			result = p.getSecond();
		} else {
			
			//Add the clinician to the clinic's list of clinicians
			Clinician c = new Clinician();
			c.setClinic(p.getFirst());
			c.setName(name);
			c.setClinicianID(user.getUserId());
			ClinicianDAO dao = new ClinicianDAO();
			dao.create(c);
			result = "added";
		}
		
		return result;
	}
	
	//Signs the peer onto the network. Careful, if peers aren't finding each other, 
	//this is your first port of call to make sure the peers are being put on the network
	//and not thrashing the previous peers
	//Also creates the Google Channel for the user
	public String signPeerIn(HttpServletRequest req, User user){
		String result = "token:";
		
		//Get the clinician
		ClinicianDAO cDAO = new ClinicianDAO();
		Clinician c = cDAO.get(user.getUserId());
		if(c == null)
			return "Error: Clinician Not Found";
		log.log(Level.WARNING, "Clinician found: " + c.getName());
		
		//Get the clinic
		Clinic clinic = cDAO.getClinic(c);
		if(clinic == null)
			return "Error:Clinic not found";
		log.log(Level.WARNING, "Clinic found: " + clinic.getClinicName());
		
		
		P2PDAO p2pdao = new P2PDAO();
		P2P p2p = p2pdao.getP2P();
		//If any of this passes, the P2P object was not persisted correctly by the datastore and needs to be completely reset
		//including getting all the clinics and adding them again
		if(p2p == null || p2p.getSps() == null || p2p.getSps().isEmpty()){
			log.log(Level.WARNING, "Reinitialising p2p");
			ClinicDAO clDAO = new ClinicDAO();
			ArrayList<Clinic> clinics = (ArrayList<Clinic>) clDAO.getAll();
			for(int i = 0; i < clinics.size(); i++){
				Superpeer sp = new Superpeer(clinics.get(i));
				p2p.addSuperpeer(sp);
			}
			p2pdao.setP2P(p2p);
			if(p2pdao.getP2P().getSps().isEmpty())
				log.log(Level.WARNING, "Not flipping setting the P2P Object correctly!!!"); //I'm leaving this here in case something breaks again
			if(p2p == null)
				return "Error:P2P returning null";
		}
		Superpeer sp = p2p.getSuperpeer(clinic.getClinicName(), log);
		//Should only happen if an incorrect name is given
		if(sp == null)
			return "Error:Super-peer could not be retrieved. Servlet Line Error-503";
		
		String p2p_id = req.getParameter("P2PID");		
		//Add the peer
		Peer p = p2pdao.addPeer(c, sp, p2p_id, log);
		if(p == null)
			return "Error: Peer not created successfully";
		log.log(Level.WARNING, "Peer: " + p.getClinicianID());
		//Set the P2P address for the new peer. Sent by the client
		p2pdao.setP2PAddress(p.getClinicianID(), clinic.getClinicName(), p2p_id);
		
		String token = "";
		if(p != null) {
			//Create the Google Channel with the peers unique channel id
			ChannelService channelService = ChannelServiceFactory.getChannelService();
			token = channelService.createChannel(p.getChannelID());
		}
		
		//return the string with the created peer
		//Should contain the Channel Token and the peer address
		result += token + ":peer:";
		result += p2p_id;
		
		return result;
	}
}
