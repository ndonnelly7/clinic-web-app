package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Analysis;
import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Impression;
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
		
		if(pat == null){
			req.setAttribute("error", "There was no patient associated with the form");
			req.setAttribute("error_message", "Patient was potentially created incorrectly, please ensure the Personal Details form is submitted correctly before proceeding with the test");
			RequestDispatcher view = req.getRequestDispatcher("/admin/Error.jsp");
			view.forward(req, resp);
			return;
		}
		
		Form f = dao.getMostRecentForm(pat);
		
		Analysis a = new Analysis();
		BeanPopulate.populateBean(a, req);
		a.setOutcomes(getOutcomeList(req, a));
		a.setImpressions(getImpressionList(req, a));
		
		//See concerns servlet for explanation of most of this
		if(f.isNew()){
			a.setForm(f);
			f.setAnalysis(a);
			pat.addForm(f);
		} else {
			if(f.getAnalysis() != null) {
				//Remove all outcomes and impressions from the database connected to the old analysis page
				a.setAnalysisID(f.getAnalysis().getAnalysisID());
				dao.runQuery("delete from Outcome where analysis= " + String.valueOf(a.getAnalysisID()));
				dao.runQuery("delete from Impression where analysis= " + String.valueOf(a.getAnalysisID()));
				
				a.setForm(f);
				f.setAnalysis(a);
			} else {
				a.setForm(f);
				f.setAnalysis(a);
			}
			List<Form> fList =  pat.getForms();
			for(int i = 0; i < fList.size(); i++){
				if(fList.get(i).getFormID() == f.getFormID())
				{
					fList.set(i, f);
					break;
				}
			}
			pat.setForms(fList);
				
		}
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/FormFinished.jsp");
		view.forward(req, resp);
	}
	
	//Creates the list of outcomes from the http request
	private ArrayList<Outcome> getOutcomeList(HttpServletRequest req, Analysis a){
		ArrayList<Outcome> outs = new ArrayList<Outcome>();
		
		//Outcome information comes in form of array of values with id of 'outcome' and 'outcome_notes'
		String[] outcomes = req.getParameterValues("outcome");
		String[] outcome_notes = req.getParameterValues("outcome_notes");
		for(int i = 0; i < outcomes.length; i++){
			Outcome o = new Outcome();
			o.setOutcome(outcomes[i]);
			o.setOutcome_notes(outcome_notes[i]);
			o.setAnalysis(a);
			outs.add(o);
		}
		
		//Returns list of outcome objects
		return outs;
	}
	
	//Creates the list of impressions from the http request
	private ArrayList<Impression> getImpressionList(HttpServletRequest req, Analysis a){
		ArrayList<Impression> imps = new ArrayList<Impression>();
		
		//Impression information comes in form of array of values with id of 'impression' and 'impression_notes'
		String[] impressions = req.getParameterValues("impression");
		String[] impression_notes = req.getParameterValues("impression_notes");
		for(int i = 0; i < impressions.length; i++){
			Impression impression = new Impression();
			impression.setImpression(impressions[i]);
			impression.setImpression_notes(impression_notes[i]);
			impression.setAnalysis(a);
			imps.add(impression);
		}
		
		//Returns list of impression objects
		return imps;
	}
}
