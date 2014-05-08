package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cloud.clinic.model.Analysis;
import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.HibernateUtil;
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
		
		Analysis a = new Analysis();
		BeanPopulate.populateBean(a, req);
		a.setOutcomes(getOutcomeList(req, a));
		a.setPatient(pat);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		a.setTimestamp(c);
		pat = addOrUpdateAnalysis(c, pat, a);
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
	
	private Patient addOrUpdateAnalysis(Calendar c, Patient p, Analysis a){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Analysis where patient = "+String.valueOf(p.getPatientID())+" order by timestamp desc";
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Analysis> list = (List<Analysis>) q.list();
		if(list.size() == 0)
			p.addAnalysis(a);
		else if((list.get(0).getTimestamp().get(Calendar.MONTH) == c.get(Calendar.MONTH))
				&& (list.get(0).getTimestamp().get(Calendar.YEAR) == c.get(Calendar.YEAR))
				&& (list.get(0).getTimestamp().get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH))){
			a.setAnalysisID(list.get(0).getAnalysisID());
			Query r = session.createQuery("delete from Outcome where analysis= " + String.valueOf(list.get(0).getAnalysisID()));
			r.executeUpdate();
			list.set(0, a);
			p.setAnalysis(list);
		} else {
			p.addAnalysis(a);
		}
		
		session.close();
		
		return p;
	}
}
