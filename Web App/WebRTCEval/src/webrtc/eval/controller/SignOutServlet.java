package webrtc.eval.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import webrtc.eval.model.PeerDataAccess;

@SuppressWarnings("serial")
public class SignOutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Sign user out of system
		String name = req.getParameter("name");
		String clinic = req.getParameter("clinic");
		
		PeerDataAccess pd = new PeerDataAccess();
		pd.init();
		if(pd.signClinicianOut(name, clinic))
			System.out.println("Successfully signed out: " + name);
		
		String mode = req.getParameter("mode");
		
		//If the 'form' is sent under mode, then the user pressed the sign out button
		//otherwise, the user left the page so don't return anything
		if(mode.equals("form")){
			RequestDispatcher view = req.getRequestDispatcher("/signedout.jsp");
			view.forward(req, resp);
		}	
	}
}