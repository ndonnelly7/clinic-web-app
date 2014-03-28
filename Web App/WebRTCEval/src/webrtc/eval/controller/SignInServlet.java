package webrtc.eval.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

import webrtc.eval.model.Client;
import webrtc.eval.model.PeerDataAccess;

@SuppressWarnings("serial")
public class SignInServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String clinic_choice = req.getParameter("clinic_list");
		String client_choice = req.getParameter("peer_list");
		String clinic = clinic_choice + " Clinic";
		
		String name = "";
		boolean signedIn = false;
		if(client_choice.equals("new")){
			System.out.println("New User wanted");
			name = req.getParameter("name");
			
			if(addPeer(clinic, name)){
				System.out.println("Successfully added Peer");
			} else {
				System.out.println("Peer already existed... probably");
			}
			if(signInPeer(clinic, name)) {
				System.out.println("Successfully signed in: " + name);
				signedIn = true;
			}
			req.setAttribute("username", name);
		} else {
			name = client_choice.replace("_", " ");
			if(signInPeer(clinic, name)) {
				System.out.println("Successfully signed in: " + name);
				signedIn = true;
			}
			req.setAttribute("username", name);
		}
		
		if(signedIn){
			ChannelService channelService = ChannelServiceFactory.getChannelService();
			String token = channelService.createChannel(getPeerChannelKey(clinic,name));
			req.setAttribute("channeltoken", token);		
			
			req.setAttribute("clinic", clinic);
			RequestDispatcher view = req.getRequestDispatcher("/main.jsp");
			view.forward(req, resp);	
		} else {
			RequestDispatcher view = req.getRequestDispatcher("/error.jsp");
			view.forward(req, resp);
		}
		
		//TODO Syncing - Send a sync token to client, if true client will send sync request to WebRTCServlet when main loaded
	}
	
	public boolean addPeer(String clinic, String name){
		boolean result = false;
		
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		result = pd.addClinician(new Client(name), clinic);
		
		return result;
	}
	
	public boolean signInPeer(String clinic, String name){
		boolean result = false;
		
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		result = pd.signClinicianIn(name, clinic);
		
		return result;
	}
	
	public String getPeerChannelKey(String clinic, String name){
		PeerDataAccess pd = new PeerDataAccess();
		Client c = pd.findClinicianInClinic(name, clinic);
		return Long.toString(c.getcID().getId());
	}
}