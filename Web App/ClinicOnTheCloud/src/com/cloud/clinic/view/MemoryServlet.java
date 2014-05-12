package com.cloud.clinic.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.cloud.clinic.model.TestBattery;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class MemoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);		
		Form f = dao.getLatestForm(pat);
		TestBattery battery = new TestBattery();
		BeanPopulate.populateBean(battery, req);
		
		if(f.isNew()){
			pat.addForm(f);
			if(f.getTestBattery() != null)
				battery.setTestBatteryID(f.getTestBattery().getTestBatteryID());
		}
		battery.setForm(f);
		f.setTestBattery(battery);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));	
		RequestDispatcher view = req.getRequestDispatcher("/patientform/analysis.jsp");
		view.forward(req, resp);
	}
	
}
