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
import com.cloud.clinic.model.HibernateUtil;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.cloud.clinic.model.PersonalDetails;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class PatDetailsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		Integer thePatientID = Integer.parseInt(req.getParameter("hiddenID"));
		PersonalDetails details = new PersonalDetails();
		BeanPopulate.populateBean(details, req);
		PatientDAO dao = new PatientDAO();		
		Patient pat = dao.get(thePatientID);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		pat = addOrUpdateDetails(c, pat, details);
		dao.update(pat);		
		
		req.setAttribute("id", thePatientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/history.jsp");
		view.forward(req, resp);		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		doPost(req, resp);
	}
	
	private Patient addOrUpdateDetails(Calendar c, Patient p, PersonalDetails pd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from personaldetails where patient = :pid order by timestamp desc";
		Query q = session.createQuery(hql);
		q.setParameter("pid", String.valueOf(p.getPatientID()));
		
		@SuppressWarnings("unchecked")
		List<PersonalDetails> list = (List<PersonalDetails>) q.list();
		
		if(list.size() == 0)
			p.addPersonalDetails(pd);
		else if(list.get(0).getTimestamp().equals(c)){
			pd.setDetailsID(list.get(0).getDetailsID());
		} else 
			p.addPersonalDetails(pd);
		
		session.close();
		return p;
	}
}