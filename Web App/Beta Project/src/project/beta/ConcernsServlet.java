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

import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class ConcernsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PatientDAO dao = new PatientDAO();
		Integer pID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(pID);
		
		Concerns cons = new Concerns();
		BeanPopulate.populateBean(cons, req);
		pat.setConcerns(cons);
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/jsp/neuro.jsp");
		view.forward(req, resp);
	}
}
