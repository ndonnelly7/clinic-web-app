package com.cloud.clinic.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.GP_Info;
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
		Form f = dao.getLatestForm(pat);
		GP_Info info = new GP_Info();
		BeanPopulate.populateBean(info, req);

		if(f.isNew()){
			pat.addForm(f);
			if(f.getGpInfo() != null)
				info.setGpInfoID(f.getGpInfo().getGpInfoID());
		} 
		info.setForm(f);
		f.setGpInfo(info);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/concerns.jsp");
		view.forward(req, resp);
		
	}
	
	
}
