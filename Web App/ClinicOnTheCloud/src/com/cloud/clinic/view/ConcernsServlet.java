package com.cloud.clinic.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Concerns;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class ConcernsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PatientDAO dao = new PatientDAO();
		Integer pID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(pID);	
		Form f = dao.getLatestForm(pat);
		Concerns cons = new Concerns();
		BeanPopulate.populateBean(cons, req);
		
		if(f.isNew()){
			pat.addForm(f);
			if(f.getConcerns() != null)
				cons.setConcernsID(f.getConcerns().getConcernsID());
		} 
		cons.setForm(f);
		f.setConcerns(cons);
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/neuro.jsp");
		view.forward(req, resp);
	}
	
}
