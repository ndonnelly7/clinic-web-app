package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.BeanPopulate;
import project.beta.model.Concerns;
import project.beta.model.Patient;
import project.beta.model.PatientDAO;
import project.beta.model.TestBattery;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class MemoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		TestBattery battery = new TestBattery();
		BeanPopulate.populateBean(battery, req);
		
		TestBattery temp = pat.getTestBattery();
		if(temp != null){
			battery.setTestBatteryID(temp.getTestBatteryID());
		}
		
		pat.setTestBattery(battery);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));	
		RequestDispatcher view = req.getRequestDispatcher("/jsp/analysis.jsp");
		view.forward(req, resp);
	}
}
