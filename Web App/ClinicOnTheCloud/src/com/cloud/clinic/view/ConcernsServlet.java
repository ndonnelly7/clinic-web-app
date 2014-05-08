package com.cloud.clinic.view;

import java.io.IOException;
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

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Concerns;
import com.cloud.clinic.model.HibernateUtil;
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
		Concerns cons = new Concerns();
		BeanPopulate.populateBean(cons, req);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		cons.setPatient(pat);
		pat = addOrUpdateConcern(c, pat, cons);		
		dao.update(pat);
		
		req.setAttribute("id", pID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/neuro.jsp");
		view.forward(req, resp);
	}
	
	private Patient addOrUpdateConcern(Calendar c, Patient p, Concerns co) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from concerns where patient = :pid order by timestamp desc";
		Query q = session.createQuery(hql);
		q.setParameter("pid", String.valueOf(p.getPatientID()));
		
		@SuppressWarnings("unchecked")
		List<Concerns> list = (List<Concerns>) q.list();
		
		if(list.size() == 0)
			p.addConcern(co);
		else if(list.get(0).getTimestamp().equals(c)){
			co.setConcernsID(list.get(0).getConcernsID());
		} else {
			p.addConcern(co);
		}
		
		session.close();		
		return p;
	}
}
