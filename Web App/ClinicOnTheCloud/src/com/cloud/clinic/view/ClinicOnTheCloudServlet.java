package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
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
import com.cloud.clinic.model.Pair;
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

@SuppressWarnings("serial")
public class ClinicOnTheCloudServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ClinicOnTheCloudServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		String type = req.getParameter("type");
		
		log.log(Level.WARNING, "Entered Servlet with type: " + type);
		switch(type) {
		case "NEW_CLINIC":
			newClinic(req);
			resp.setContentType("text/plain");
			resp.getWriter().println("done");
			break;
		case "NEW_CLINICIAN":
			String status = newClinician(req, user);
			if(status.equals("added")){
				req.setAttribute("name", req.getParameter("name"));
				req.setAttribute("new", "true");
				RequestDispatcher view = req.getRequestDispatcher("admin/home.jsp");
				view.forward(req, resp);
			} else {
				req.setAttribute("error", status);
				RequestDispatcher view = req.getRequestDispatcher("admin/Error.jsp");
				view.forward(req, resp);
			}
			break;
		case "PEER_SIGN_IN":
			String result = signPeerIn(req, user);
			resp.setContentType("text/plain");
			resp.getWriter().println(result);
			break;
		case "PEER_SIGN_OUT":
			String signOutPeer = signPeerOut(req, user);
			resp.setContentType("text/plain");
			resp.getWriter().println(signOutPeer);
			break;
		case "SEND_PATIENT_TO_PEER":
			String jsonPatients = req.getParameter("patients");
			String peer_id = req.getParameter("peerID");
			String response = sendPatient(jsonPatients, peer_id);
			resp.setContentType("text/plain");
			resp.getWriter().println(response);
			break;
		case "REQUEST_PATIENT":
			String pid = req.getParameter("pid");
			String mode = req.getParameter("mode");
			String reqResponse = requestPatient(user, pid, mode);
			resp.setContentType("text/plain");
			resp.getWriter().println(reqResponse);
			break;
		case "REQUEST_UPDATE":
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
			String jobID = req.getParameter("JobID");
			String claimResponse = claimJob(user, jobID);
			resp.setContentType("text/plain");
			resp.getWriter().println(claimResponse);
			break;
		case "DELETE":
			String delID = req.getParameter("DeleteID");
			String delResponse = deletePatient(user, delID);
			resp.setContentType("text/plain");
			resp.getWriter().println(delResponse);
		default:
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, world");
		}
	}
	
	private String deletePatient(User u, String deleteID) {
		PatientDAO dao = new PatientDAO();
		if(deleteID != ""){
			int id = Integer.parseInt(deleteID);
			dao.removeWithID(id);
			if(dao.get(id) == null)
				return "REMOVED";
			else return "Error: Patient Not Removed for Some Reason";
			
		} else {
			return "Error: Empty ID";
		}
	}
	
	private String signPeerOut(HttpServletRequest req, User user) {
		P2PDAO dao = new P2PDAO();
		Peer p = dao.findPeer(user.getUserId());
		if(p != null){
			if(dao.removePeer(p, p.getSp()))
				return "Peer successfully removed";
		}
		return "Peer doesn't exist";
	}
	
	private String claimJob(User user, String jobID){
		P2PDAO dao = new P2PDAO();
		Peer p = dao.findPeer(user.getUserId());
		if(p == null)
			return null;
		
		Job j = dao.claimJob(Integer.parseInt(jobID));
		if(j == null)
			return "Missed job";
		
		log.log(Level.WARNING, "Claimed Job: " + j.getJob());
		log.log(Level.WARNING, "Sending job to: " + p.getClinicianID());
		ChannelService service = ChannelServiceFactory.getChannelService();
		service.sendMessage(new ChannelMessage(p.getChannelID(), j.getJob()));
		
		return "Successfully Claimed Job";
	}

	public String addPatient(User user, String patientID){
		String result = "";
		
		P2PDAO dao = new P2PDAO();
		Peer p = dao.findPeer(user.getUserId());
		if(p != null) {
			p.addPatientID(Integer.parseInt(patientID));
			dao.updatePeer(p);
			return "Successfully added patient ID";
		}
		result = "Could not find peer";
		
		return result;
	}
	
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
	
	public String requestPatient(User user, String patientID, String transportMode){
		
		P2PDAO dao = new P2PDAO();
		P2P p2p = dao.getP2P();
		ArrayList<Superpeer> sps = p2p.getSps();
		Peer requestor = dao.findPeer(user.getUserId());
		if(requestor == null)
			return "Failed to find a peer with that patientID";
		String jobString = "";
		if(transportMode.equals("P2P"))
			jobString = "SEND_PATIENT:PID:"+patientID+":PEER:"+requestor.getP2pAddress()+":MODE:" + transportMode + ":TYPE:REQUEST:";
		else
			jobString = "SEND_PATIENT:PID:"+patientID+":PEER:"+requestor.getChannelID()+":MODE:" + transportMode + ":TYPE:REQUEST:";
		Job job = new Job(requestor.getClinicianID(), jobString, p2p.getJob_tick());
		dao.addJob(job);
		String toSend = "JOB_POST:JOBID:"+job.getJob_id()+"PID:"+patientID+":MODE:"+transportMode+":";
		for(int i = 0; i < sps.size(); i++){
			Superpeer sp = sps.get(i);
			for(int j = 0; j < sp.getPeers().size(); j++){
				Peer p = sp.getPeers().get(j);
				if(p.getPatientIDs().contains(Integer.parseInt(patientID))){
					//Send patient request via Channel
					ChannelService service = ChannelServiceFactory.getChannelService();
					service.sendMessage(new ChannelMessage(p.getChannelID(), toSend));
				}
			}
		}
		return "Failed to find a patient with that patientID";
	}
	
	public String requestUpdate(User user, String transportMode){
		log.log(Level.WARNING, "Entered Request Update function");
		String result = "";
		
		log.log(Level.WARNING, "Request from: " + user.getUserId());
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
		log.log(Level.WARNING, "Peers list size: " + sp.getPeers().size());
		for(int i = 0; i < sp.getPeers().size(); i++){
			log.log(Level.WARNING, "Potential host: " + sp.getPeers().get(i).getClinicianID());
			if(!(p.getId().equals(sp.getPeers().get(i).getId()))){
				Peer host = sp.getPeers().get(i);
				if(host != null){
					log.log(Level.WARNING, "Sending request to: " + host.getClinicianID());
					ChannelService service = ChannelServiceFactory.getChannelService();
					service.sendMessage(new ChannelMessage(host.getChannelID(),toSend));
				}
			}
		}
		
		result = "Request for update sent to peers";
		return result;
	}
	
	public String sendPatient(String patients, String peerChannel){
		ChannelService service = ChannelServiceFactory.getChannelService();
		String sendString = "RECEIVE_PATIENTS:patients:" + patients;
		service.sendMessage(new ChannelMessage(peerChannel, sendString));
		return "Patients String send successfully";
	}
	
	public void newClinic(HttpServletRequest req){
		String name = req.getParameter("name");
		String pw = req.getParameter("password");
		
		ClinicDAO dao = new ClinicDAO();
		Clinic c = new Clinic();
		c.setClinicName(name);
		c.setHashedPassword(dao.hashPassword(pw));
		dao.create(c);
	}
	
	public String newClinician(HttpServletRequest req, User user){
		String result = "";
		
		if(user == null){
			return "Invalid Login State";
		}
		String name = req.getParameter("name");
		String clinic = req.getParameter("clinic");
		String pw = req.getParameter("pass");
		ClinicDAO clinicDAO = new ClinicDAO();
		Pair<Clinic, String> p = clinicDAO.validateClinic(clinic, pw);
		if(p.getFirst() == null){
			result = p.getSecond();
		} else {
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
	
	public String signPeerIn(HttpServletRequest req, User user){
		String result = "token:";
		
		ClinicianDAO cDAO = new ClinicianDAO();
		Clinician c = cDAO.get(user.getUserId());
		log.log(Level.WARNING, "Clinician found: " + c.getName());
		Clinic clinic = cDAO.getClinic(c);
		log.log(Level.WARNING, "Clinic found: " + clinic.getClinicName());
		P2PDAO p2pdao = new P2PDAO();
		P2P p2p = p2pdao.getP2P();
		if(p2p == null){
			p2pdao.init();
			p2p = p2pdao.getP2P();
			if(p2p == null)
				return "Error:P2P returning null";
		}
		Superpeer sp = p2p.getSuperpeer(clinic.getClinicName());
		if(sp == null)
			return "Error:Clinic does not exist";
		String p2p_id = req.getParameter("P2PID");
		Peer p = p2pdao.addPeer(c, sp, p2p_id);
		p2pdao.setP2PAddress(p.getClinicianID(), clinic.getClinicName(), p2p_id);
		log.log(Level.WARNING, "Peer: " + p.getClinicianID());
		
		String token = "";
		if(p != null) {
			ChannelService channelService = ChannelServiceFactory.getChannelService();
			token = channelService.createChannel(p.getChannelID());
		}
		
		result += token + ":peer:";
		result += p2p_id;
		
		return result;
	}
}
