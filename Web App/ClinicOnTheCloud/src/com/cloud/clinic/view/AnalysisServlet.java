package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Analysis;
import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Outcome;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class AnalysisServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PatientDAO dao = new PatientDAO();
		Integer pID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(pID);
		
		Form f = dao.getLatestForm(pat);
		
		Analysis a = new Analysis();
		BeanPopulate.populateBean(a, req);
		a.setOutcomes(getOutcomeList(req, a));
		
		if(f.isNew()){
			a.setForm(f);
			f.setAnalysis(a);
			pat.addForm(f);
		} else {
			if(f.getAnalysis() != null) {
				dao.runQuery("delete from Outcome where Analysis= " + String.valueOf(a.getAnalysisID()));
				a.setAnalysisID(f.getAnalysis().getAnalysisID());
				a.setForm(f);
				f.setAnalysis(a);
			} else {
				a.setForm(f);
				f.setAnalysis(a);
			}
				
		}
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/results.jsp");
		view.forward(req, resp);
	}
	
	private ArrayList<Outcome> getOutcomeList(HttpServletRequest req, Analysis a){
		ArrayList<Outcome> outs = new ArrayList<Outcome>();
		
		String[] outcomes = req.getParameterValues("outcome");
		String[] outcome_notes = req.getParameterValues("outcome_notes");
		for(int i = 0; i < outcomes.length; i++){
			Outcome o = new Outcome();
			o.setOutcome(outcomes[i]);
			o.setOutcome_notes(outcome_notes[i]);
			o.setAnalysis(a);
			outs.add(o);
		}
		
		return outs;
	}
}
