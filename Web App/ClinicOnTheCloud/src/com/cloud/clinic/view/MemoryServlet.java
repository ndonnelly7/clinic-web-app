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
import com.cloud.clinic.model.TestBattery;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class MemoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);		
		TestBattery battery = new TestBattery();
		BeanPopulate.populateBean(battery, req);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		battery.setPatient(pat);
		pat = addOrUpdateBattery(c, pat, battery);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));	
		RequestDispatcher view = req.getRequestDispatcher("/patientform/analysis.jsp");
		view.forward(req, resp);
	}
	
	private Patient addOrUpdateBattery(Calendar c, Patient p, TestBattery tb){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from TestBattery where patient = :pid order by timestamp desc";
		Query q = session.createQuery(hql);
		q.setParameter("pid", String.valueOf(p.getPatientID()));
		
		@SuppressWarnings("unchecked")
		List<TestBattery> list = (List<TestBattery>) q.list();
		
		if(list.size() == 0)
			p.addTestBattery(tb);
		else if(list.get(0).getTimestamp().equals(c)){
			tb.setTestBatteryID(list.get(0).getTestBatteryID());
		} else 
			p.addTestBattery(tb);
		
		session.close();
		return p;
	}
}