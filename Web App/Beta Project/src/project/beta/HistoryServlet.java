package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Patient;
import project.beta.model.PatientHistory;
import project.beta.model.PatientStore;
import project.beta.model.PersonalDetailsPatient;
import project.beta.model.SystemUser;
import project.beta.model.UserStore;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class HistoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		UserStore uStore = UserStore.GetUserStore();
		SystemUser u = uStore.getSystemUser(user);
		if(u == null) {
			u = new SystemUser(user, user.getNickname(), "Somewhere");
			UserStore.addUser(u);
			System.out.println("Had to add a new user for soem reason");
		}
		
		PatientStore pStore = PatientStore.GetPatientStore();
		String thePatientID = req.getParameter("hiddenid");
		Patient pat;
		if(thePatientID == "" || thePatientID == null)
		{
			pat = new Patient(pStore.getNewID(), u.getUserID());
		} else {
			pat = pStore.getPatient(Integer.parseInt(thePatientID));
			if(pat.getID() < 0)
				pat = new Patient(pStore.getNewID(), u.getUserID());
		}		
		PatientHistory ph = buildPatientHistory(req, pat.getID());
		
		pat.setHistory(ph);
		if(!PatientStore.updatePatient(pat.getID(),pat))
			PatientStore.addPatient(pat);
		
		req.setAttribute("hiddenid", pat.getID());
		RequestDispatcher view = req.getRequestDispatcher("/jsp/medical.jsp");
		view.forward(req, resp);
	}
	
	void printStringArray(String[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	private PatientHistory buildPatientHistory(HttpServletRequest req, int id)
	{
		PatientHistory ph = new PatientHistory(id);
		
		String[] med_histories = req.getParameterValues("med_histories");
		String[] med_times = req.getParameterValues("med_time");
		String[] med_notes = req.getParameterValues("medical_notes");
		
		for(int i = 0; i < med_histories.length; i++)
		{
			ph.addMedHistory(med_histories[i], med_times[i], med_notes[i]);
		}
		
		String[] med_collat_histories = req.getParameterValues("med_collat_histories");
		String[] med_collat_times = req.getParameterValues("med_collat_time");
		String[] med_collat_notes = req.getParameterValues("medical_collat_notes");
		
		for(int i = 0; i < med_collat_histories.length; i++)
		{
			ph.addCollatMedHistory(med_collat_histories[i], med_collat_times[i], med_collat_notes[i]);
		}
		
		String[] drug_histories = req.getParameterValues("drug_histories");
		String[] drug_times = req.getParameterValues("drug_time");
		String[] drug_notes = req.getParameterValues("drug_notes");
		
		for(int i = 0; i < drug_histories.length; i++)
		{
			ph.addDrugHistory(drug_histories[i], drug_times[i], drug_notes[i]);
		}
		
		String[] drug_collat_histories = req.getParameterValues("drug_collat_histories");
		String[] drug_collat_times = req.getParameterValues("drug_collat_time");
		String[] drug_collat_notes = req.getParameterValues("drug_collat_notes");
		
		for(int i = 0; i < drug_collat_histories.length; i++)
		{
			ph.addCollatDrugHistory(drug_collat_histories[i], drug_collat_times[i], drug_collat_notes[i]);
		}
		
		String[] psych_histories = req.getParameterValues("psych_histories");
		String[] psych_times = req.getParameterValues("psych_time");
		String[] psych_notes = req.getParameterValues("psych_notes");
		
		for(int i = 0; i < psych_histories.length; i++)
		{
			ph.addPsychHistory(psych_histories[i], psych_times[i], psych_notes[i]);
		}
		
		String[] psych_collat_histories = req.getParameterValues("psych_collat_histories");
		String[] psych_collat_times = req.getParameterValues("psych_collat_time");
		String[] psych_collat_notes = req.getParameterValues("psych_collat_notes");
		
		for(int i = 0; i < psych_collat_histories.length; i++)
		{
			ph.addCollatPsychHistory(psych_collat_histories[i], psych_collat_times[i], psych_collat_notes[i]);
		}
		
		ph.setCurrent_therapy_check(req.getParameter("current_therapy_check"));
		ph.setPast_therapy_check(req.getParameter("past_therapy_check"));
		
		ph.setCollat_current_therapy_check(req.getParameter("collat_current_therapy_check"));
		ph.setCollat_past_therapy_check(req.getParameter("collat_past_therapy_check"));
		
		return ph;
	}
}