package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

import project.beta.model.BeanPopulate;
import project.beta.model.EventsActivities;
import project.beta.model.Patient;
import project.beta.model.PatientDAO;

@SuppressWarnings("serial")
public class EvActServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		EventsActivities ea = new EventsActivities();
		BeanPopulate.populateBean(ea, req);
		pat.setEventsActivities(ea);
		dao.update(pat);
		
		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/jsp/living.jsp");
		view.forward(req, resp);
	}
}
