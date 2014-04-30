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
		
		Integer thePatientID = 0;
		Patient pat = new Patient();
		PersonalDetailsPatient details = new PersonalDetailsPatient(thePatientID);
		BeanPopulate.populateBean(details, req);
		pat.setPersonalDetails(details);
		PatientDAO dao = new PatientDAO();
		thePatientID = dao.create(pat);		
		
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