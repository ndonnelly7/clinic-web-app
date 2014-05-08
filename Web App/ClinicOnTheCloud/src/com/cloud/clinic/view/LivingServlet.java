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
import com.cloud.clinic.model.LivingSit;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
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
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		ls.setPatient(pat);
		pat = addOrUpdateLiving(c, pat, ls);
		dao.update(pat);		

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/lifestyle.jsp");
		view.forward(req, resp);
	}
	
	public Patient addOrUpdateLiving(Calendar c, Patient p, LivingSit l) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from livingsit where patient = :pid order by timestamp desc";
		Query q = session.createQuery(hql);
		q.setParameter("pid", String.valueOf(p.getPatientID()));
		
		@SuppressWarnings("unchecked")
		List<LivingSit> list = (List<LivingSit>) q.list();
		
		if(list.size() == 0)
			p.addLivingSit(l);
		else if(list.get(0).getTimestamp().equals(c)){
			l.setLivingSitID(list.get(0).getLivingSitID());
		} else 
			p.addLivingSit(l);
		
		session.close();
		return p;
	}
}
