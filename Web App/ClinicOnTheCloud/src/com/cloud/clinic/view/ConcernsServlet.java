package com.cloud.clinic.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
		
		if(pat == null){
			req.setAttribute("error", "There was no patient associated with the form");
			req.setAttribute("error_message", "Patient was potentially created incorrectly, please ensure the Personal Details form is submitted correctly before proceeding with the test");
			RequestDispatcher view = req.getRequestDispatcher("/admin/Error.jsp");
			view.forward(req, resp);
			return;
		}
		
		//Get the form corresponding to the assessment date
		String assessment = req.getParameter("assessment");
		Date ass = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH);
			ass = sdf.parse(assessment);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Form f;
		if(assessment != null){
			Calendar cAss = Calendar.getInstance();
			cAss.setTime(ass);
			f = dao.getFormWithDate(pat, cAss);
		} else {
			f = dao.getMostRecentForm(pat);
		}
		Concerns cons = new Concerns();
		BeanPopulate.populateBean(cons, req);
		
		if(f.isNew()){
			pat.addForm(f);
			if(f.getConcerns() != null)
				cons.setConcernsID(f.getConcerns().getConcernsID());
		} 
		cons.setForm(f);
		if(f.getConcerns() != null)
			cons.setConcernsID(f.getConcerns().getConcernsID());
		f.setConcerns(cons);
		List<Form> fList =  pat.getForms();
		for(int i = 0; i < fList.size(); i++){
			if(fList.get(i).getFormID() == f.getFormID())
			{
				fList.set(i, f);
				break;
			}
		}
		pat.setForms(fList);
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/neuro.jsp");
		view.forward(req, resp);
	}
	
}
