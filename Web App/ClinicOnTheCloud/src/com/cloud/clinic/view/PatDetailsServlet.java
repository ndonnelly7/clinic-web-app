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

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Clinic;
import com.cloud.clinic.model.Clinician;
import com.cloud.clinic.model.ClinicianDAO;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.cloud.clinic.model.PersonalDetails;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class PatDetailsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		
		ClinicianDAO cDAO = new ClinicianDAO();
		Clinician cl = cDAO.get(user.getUserId());
		Clinic clinic = cDAO.getClinic(cl);
		
		Integer thePatientID = Integer.parseInt(req.getParameter("hiddenID"));
		PersonalDetails details = new PersonalDetails();
		BeanPopulate.populateBean(details, req);
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
		
		
		if(pat != null){
			Form f = dao.getLatestForm(pat);
			if(f.isNew()){
				pat.addForm(f);
				if(f.getPersonalDetails() != null)
					details.setDetailsID(f.getPersonalDetails().getDetailsID());
			}
			f.setPersonalDetails(details);
			details.setForm(f);
			List<Form> fList =  pat.getForms();
			for(int i = 0; i < fList.size(); i++){
				if(fList.get(i).getFormID() == f.getFormID())
				{
					fList.set(i, f);
					break;
				}
			}
			pat.setForms(fList);
			dao.update(pat);	
		} else {
			pat = new Patient();
			pat.setPatientID(thePatientID);
			pat.setClinic(clinic);
			pat.setClinician(cl);
			Form f = new Form();
			f.setPatient(pat);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			f.setTimestamp(c);			

			f.setPersonalDetails(details);
			details.setForm(f);
			pat.addForm(f);
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
}