package project.beta;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Patient;
import project.beta.model.PatientStore;
import project.beta.model.PersonalDetailsPatient;
import project.beta.model.SystemUser;
import project.beta.model.UserStore;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class PatDetailsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		//Gets user
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		PatientStore.RemovePatientStore();
		
		//Gets the user store and retrieves the appropriate user
		UserStore uStore = UserStore.GetUserStore();
		SystemUser u = uStore.getSystemUser(user);
		//If u is null, then the user doesn't exist. In dev this should never happen and 
		//authentication exception will be triggered
		if(u == null) {
			u = new SystemUser(user, user.getNickname(), "Somewhere");
			UserStore.addUser(u);
		}
		
		//PatientStore is retrieved
		PatientStore pStore = PatientStore.GetPatientStore();
		//The patient id is retrieved from the hidden input field from the JSP
		String thePatientID = req.getParameter("hiddenid");
		Patient pat;
		
		//Checks to see if the id was given, if not, then a new patient is created
		if(thePatientID == null || thePatientID == "")
		{
			pat = new Patient(pStore.getNewID(), u.getUserID());
		} else {
			//Patient is retrieved from store
			pat = pStore.getPatient(Integer.parseInt(thePatientID));
			if(pat.getID() < 0)
				pat = new Patient(pStore.getNewID(), u.getUserID());
		}
		PersonalDetailsPatient p = new PersonalDetailsPatient(pat.getID());
		
		
		//Retrieves all the values from the JSP
		p.setName(req.getParameter("name"));
		if(req.getParameter("dob") != null && req.getParameter("dob") != "") {
			try {
				p.setDOB(new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(req.getParameter("dob")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		p.setGender(req.getParameter("gender"));
		if(req.getParameter("age") != "")
			p.setAge(Integer.parseInt(req.getParameter("age")));
		p.setAddress(req.getParameter("address"));
		p.setCounty(req.getParameterValues("county")[0]);
		p.setHomeTelNumber(req.getParameter("home_tel"));
		p.setMobNumber(req.getParameter("mob_number"));
		p.setEmail(req.getParameter("email"));		
		
		System.out.println(req.getParameter("age_left"));
		if(req.getParameter("age_left") != "")
			p.setAgeLeftEdu(Integer.parseInt(req.getParameter("age_left")));
		
		String jCheck = req.getParameter("junior_check");
		String sCheck = req.getParameter("leaving_check");
		String tCheck = req.getParameter("third_check");
		if(jCheck!=null){
			p.setJunior(jCheck.equalsIgnoreCase("on") ? true : false);
		} else p.setJunior(false);
		
		if(sCheck!=null){
			p.setJunior(sCheck.equalsIgnoreCase("on") ? true : false);
		} else p.setSenior(false);
		if(tCheck!=null){
			p.setJunior(tCheck.equalsIgnoreCase("on") ? true : false);
		} else p.setJunior(false);
		
		p.setAreaOfStudy(req.getParameter("study_topic"));
		p.setOccupation(req.getParameter("occupation"));
		
		p.setGpName(req.getParameter("gp_name"));
		p.setGpAddress(req.getParameter("gp_address"));
		p.setGpCounty(req.getParameterValues("county")[1]);
		
		String fCheck = req.getParameter("family_present_check");
		if(fCheck!=null){
			p.setIsFamilyPresent(fCheck.equalsIgnoreCase("on") ? true : false);
			p.setFamilyPresent(req.getParameter("who_present"));
		} else {
			p.setIsFamilyPresent(false);
			p.setFamilyPresent("");
		}
		
		System.out.println(p);		
		pat.setPersonalDetails(p);
		
		//If the patient exists, it will be updated, otherwise a new patient with the details are added
		if(!PatientStore.updatePatient(pat.getID(),pat))
			PatientStore.addPatient(pat);
		
		req.setAttribute("hiddenid", pat.getID());
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/jsp/history.jsp");
		view.forward(req, resp);		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		doPost(req, resp);
	}
}