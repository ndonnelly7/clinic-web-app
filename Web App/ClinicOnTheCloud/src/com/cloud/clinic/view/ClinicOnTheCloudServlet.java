package com.cloud.clinic.view;

import java.io.IOException;

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
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ClinicOnTheCloudServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		String type = req.getParameter("type");
		
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
		default:
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, world");
		}
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
}
