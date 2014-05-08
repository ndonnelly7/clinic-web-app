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
import com.cloud.clinic.model.NeuroHistory;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class NeuroServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		NeuroHistory neuro = new NeuroHistory();
		BeanPopulate.populateBean(neuro, req);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		neuro.setTimestamp(c);
		neuro.setPatient(pat);
		pat = addOrUpdateNeuro(c, pat, neuro);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/events_activities.jsp");
		view.forward(req, resp);
	}
	
	private Patient addOrUpdateNeuro(Calendar c, Patient p, NeuroHistory nh){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from NeuroHistory where patient = "+String.valueOf(p.getPatientID())+" order by timestamp desc";
		Query q = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<NeuroHistory> list = (List<NeuroHistory>) q.list();
		
		if(list.size() == 0)
			p.addNeuroHistory(nh);
		else if((list.get(0).getTimestamp().get(Calendar.MONTH) == c.get(Calendar.MONTH))
				&& (list.get(0).getTimestamp().get(Calendar.YEAR) == c.get(Calendar.YEAR))
				&& (list.get(0).getTimestamp().get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH))){
			nh.setNeuroHistoryID(list.get(0).getNeuroHistoryID());
			list.set(0, nh);
			p.setNeuroHistory(list);
		} else 
			p.addNeuroHistory(nh);
		
		session.close();
		return p;
	}
}
