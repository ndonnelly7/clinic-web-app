package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.BeanPopulate;
import project.beta.model.Patient;
import project.beta.model.PatientDAO;
import project.beta.model.PersonalDetailsPatient;

import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class PatDetailsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		Integer thePatientID = Integer.parseInt(req.getParameter("hiddenID"));
		PersonalDetailsPatient details = new PersonalDetailsPatient();
		BeanPopulate.populateBean(details, req);
		PatientDAO dao = new PatientDAO();
		
		Patient pat = dao.get(thePatientID);
		if(thePatientID < 1 || pat == null){
			pat = new Patient();
			pat.setPatientID(thePatientID);
			pat.setPersonalDetails(details);
			thePatientID = dao.create(pat);	
		} else {
			PersonalDetailsPatient d = pat.getPersonalDetails();
			details.setDetailsID(d.getDetailsID());
			pat.setPersonalDetails(details);
			dao.update(pat);
		}
		
		req.setAttribute("id", thePatientID);
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