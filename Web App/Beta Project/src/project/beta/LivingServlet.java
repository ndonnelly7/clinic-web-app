package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.BeanPopulate;
import project.beta.model.LivingSit;
import project.beta.model.Patient;
import project.beta.model.PatientDAO;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class LivingServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		LivingSit ls = new LivingSit();
		BeanPopulate.populateBean(ls, req);
		
		LivingSit temp = pat.getLivingSit();
		if(temp != null){
			ls.setLivingSitID(temp.getLivingSitID());
		}
		
		pat.setLivingSit(ls);
		dao.update(pat);		

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/jsp/lifestyle.jsp");
		view.forward(req, resp);
	}
	
}
