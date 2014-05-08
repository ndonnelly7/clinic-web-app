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
		System.out.println("Gender: " + req.getParameter("gender"));
		details.setGender(req.getParameter("gender"));
		String dateStr = req.getParameter("dob");
		try {
			Date date = new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(dateStr);
			details.setDob(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PatientDAO dao = new PatientDAO();		
		Patient pat = dao.get(thePatientID);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		details.setTimestamp(c);
		
		if(pat != null){
			details.setPatient(pat);
			pat = addOrUpdateDetails(c, pat, details);
			dao.update(pat);	
		} else {
			pat = new Patient();
			pat.setPatientID(thePatientID);
			details.setPatient(pat);
			pat.addPersonalDetails(details);
			dao.create(pat);
		}
		
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
		
		String hql = "from PersonalDetails where patient= "+String.valueOf(p.getOriginalClinic())+" order by timestamp desc";
		Query q = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<PersonalDetails> list = (List<PersonalDetails>) q.list();
		
		if(list == null || list.size() == 0)
			p.addPersonalDetails(pd);
		else if((list.get(0).getTimestamp().get(Calendar.MONTH) == c.get(Calendar.MONTH))
				&& (list.get(0).getTimestamp().get(Calendar.YEAR) == c.get(Calendar.YEAR))
				&& (list.get(0).getTimestamp().get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH))){
			pd.setDetailsID(list.get(0).getDetailsID());
			list.set(0, pd);
			p.setPersonalDetails(list);
		} else 
			p.addPersonalDetails(pd);
		
		session.close();
		return p;
	}
}