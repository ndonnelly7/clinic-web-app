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
import com.cloud.clinic.model.GP_Info;
import com.cloud.clinic.model.HibernateUtil;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class GPServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);		
		GP_Info info = new GP_Info();
		BeanPopulate.populateBean(info, req);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		info.setPatient(pat);
		pat = addOrUpdateGP(c, pat, info);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/concerns.jsp");
		view.forward(req, resp);
		
	}
	
	private Patient addOrUpdateGP(Calendar c, Patient p, GP_Info gp){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from gp_info where patient = :pid order by timestamp desc";
		Query q = session.createQuery(hql);
		q.setParameter("pid", String.valueOf(p.getPatientID()));
		
		@SuppressWarnings("unchecked")
		List<GP_Info> list = (List<GP_Info>) q.list();
		
		if(list.size() == 0)
			p.addGPInfo(gp);
		else if(list.get(0).getTimestamp().equals(c)){
			gp.setGpInfoID(list.get(0).getGpInfoID());
		} else 
			p.addGPInfo(gp);
		
		session.close();
		return p;
	}
}