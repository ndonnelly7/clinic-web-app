package project.beta;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Analysis;
import project.beta.model.BeanPopulate;
import project.beta.model.Outcome;
import project.beta.model.Patient;
import project.beta.model.PatientDAO;

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
		
		Analysis temp = pat.getAnalysis();
		if(temp != null){
			a.setAnalysisID(temp.getAnalysisID());
			
			dao.runQuery("delete from Outcome where analysis= " + String.valueOf(temp.getAnalysisID()));
		}
		
		a.setOutcomes(getOutcomeList(req, a));
		pat.setAnalysis(a);
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/jsp/results.jsp");
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
