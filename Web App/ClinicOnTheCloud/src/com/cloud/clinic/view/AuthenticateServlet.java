package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.ClinicDAO;
import com.cloud.clinic.model.Clinician;
import com.cloud.clinic.model.ClinicianDAO;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class AuthenticateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		String destination = "";
		
		if(user == null)
			destination = "/admin/Error.jsp";
		else {
			String id = user.getUserId();
			ClinicianDAO cDao = new ClinicianDAO();
			Clinician clinician = cDao.get(id);
			if(clinician == null || cDao.getClinic(clinician) == null){
				ClinicDAO clinicDAO = new ClinicDAO();
				List<Clinic> clinics = clinicDAO.getAll();
				if(clinics.size() == 0)
					clinics.add(addClinic());
				req.setAttribute("clinicsList", loadNames(clinics));
				destination = "/admin/NewUser.jsp";
				if(clinician != null)
					req.setAttribute("name", clinician.getName());
			} else {
				destination = "/admin/home.jsp";
			}
		}
			
		RequestDispatcher view = req.getRequestDispatcher(destination);
		view.forward(req, resp);
	}
	
	public List<String> loadNames(List<Clinic> cs){
		List<String> names = new ArrayList<String>();
		
		for(int i = 0; i < cs.size(); i++){
			names.add(cs.get(0).getClinicName());
		}
		
		return names;
	}
	
	public Clinic addClinic(){
		ClinicDAO dao = new ClinicDAO();
		Clinic c = new Clinic();
		c.setClinicName("DCU");
		c.setHashedPassword(dao.hashPassword("wDPZ5h40"));
		dao.create(c);
		return c;
	}
}
