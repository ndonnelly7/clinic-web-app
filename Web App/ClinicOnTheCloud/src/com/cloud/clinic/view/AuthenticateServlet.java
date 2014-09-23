package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.ClinicDAO;
import com.cloud.clinic.model.Clinician;
import com.cloud.clinic.model.ClinicianDAO;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;

/*
 * 
 * Used to authenticate all the users as they attempt to sign in
 * 
 */

@SuppressWarnings("serial")
public class AuthenticateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Get the user object from google
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		String destination = "";
		
		//Checks the type of the request
		String type = req.getParameter("type");
		
		//Uses two steps to reduce the initial log in time for the cloud.
		//If combined, the risk of exceeding the 60s deadline for
		//Google cloud responses increases
		if(type.equals("INIT")){
			PatientDAO pDao = new PatientDAO();
			pDao.init();
			resp.setContentType("text/plain");
			resp.getWriter().println("done");
		} else if(type.equals("AUTHORISE")){
			//If the user is null, then redirect to error page
			if(user == null)
				destination = "/admin/Error.jsp";
			else {
				//Otherwise check if the user is registered
				String id = user.getUserId();
				ClinicianDAO cDao = new ClinicianDAO();
				Clinician clinician = cDao.get(id);
				
				//If they don't exist, redirect to new user page
				if(clinician == null || cDao.getClinic(clinician) == null){
					destination = "/admin/NewUser.jsp";
				} else {
					destination = "/admin/home.jsp"; //Otherwise they are a registered user and can be redirected home
				}
			}
			resp.setContentType("text/plain");
			resp.getWriter().println(destination);	
			/*RequestDispatcher view = req.getRequestDispatcher(destination);
			view.forward(req, resp);*/
		}else if(type.equals("CLINIC_LIST")){
			//Retrieves all the list of clinics
			ClinicDAO clinicDAO = new ClinicDAO();
			List<Clinic> clinics = clinicDAO.getAll();
			if(clinics.size() == 0)
				clinics.add(addClinic());
			//Creates a JSON Array of clinics
			Gson gson = new Gson();
			String list = gson.toJson(loadNames(clinics));
			resp.setContentType("text/plain");
			resp.getWriter().println(list);
		}
		
	}
	
	//Get list of all clinics
	public List<String> loadNames(List<Clinic> cs){
		List<String> names = new ArrayList<String>();
		
		for(int i = 0; i < cs.size(); i++){
			names.add(cs.get(i).getClinicName());
		}
		
		return names;
	}
	
	//Add sample clinic to system. DCU and password of wDPZ5h40
	public Clinic addClinic(){
		ClinicDAO dao = new ClinicDAO();
		Clinic c = new Clinic();
		c.setClinicName("DCU");
		c.setHashedPassword(dao.hashPassword("wDPZ5h40"));
		dao.create(c);
		return c;
	}
}
