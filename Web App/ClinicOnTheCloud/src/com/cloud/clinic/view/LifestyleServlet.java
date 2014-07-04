package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Lifestyle;
import com.cloud.clinic.model.LifestyleActivity;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class LifestyleServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		if(pat == null){
			req.setAttribute("error", "There was no patient associated with the form");
			req.setAttribute("error_message", "Patient was potentially created incorrectly, please ensure the Personal Details form is submitted correctly before proceeding with the test");
			RequestDispatcher view = req.getRequestDispatcher("/admin/Error.jsp");
			view.forward(req, resp);
			return;
		}
		
		Form f = dao.getMostRecentForm(pat);
		Lifestyle l = new Lifestyle();
		BeanPopulate.populateBean(l, req);
		l.setActivities(loadActivitiesList(req, l));
		
		if(f.isNew()){
			l.setForm(f);
			f.setLifestyle(l);
			pat.addForm(f);
		} else {
			if(f.getLifestyle() != null){
				l.setLifestyleID(f.getLifestyle().getLifestyleID());
				dao.runQuery("delete from LifestyleActivity where lifestyle= " + String.valueOf(l.getLifestyleID()));
			}
			
			l.setForm(f);
			f.setLifestyle(l);
			List<Form> fList =  pat.getForms();
			for(int i = 0; i < fList.size(); i++){
				if(fList.get(i).getFormID() == f.getFormID())
				{
					fList.set(i, f);
					break;
				}
			}
			pat.setForms(fList);
		}
		
		dao.update(pat);
		
		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/memory_test.jsp");
		view.forward(req, resp);
	}
	
	public ArrayList<LifestyleActivity> loadActivitiesList(HttpServletRequest req, Lifestyle l){
		ArrayList<LifestyleActivity> as = new ArrayList<LifestyleActivity>();
		String[] types = req.getParameterValues("exercise");
		String[] involvements = req.getParameterValues("still_active");
		String[] times = req.getParameterValues("exercise_time");
		String[] currents = req.getParameterValues("current_hours");
		String[] previous = req.getParameterValues("previous_hours");
		String[] notes = req.getParameterValues("exercise_act_notes");
		int current_ind = 0, previous_ind = 0, notes_ind = 0, times_ind = 0;
		
		if(types == null)
			return as;
		
		for(int i =0; i < types.length; i++){
			LifestyleActivity a = new LifestyleActivity();
			a.setType(types[i]);
			a.setCollat(false);
			if(involvements != null) {
				a.setInvolvement(involvements[i]);
				if(involvements[i].equalsIgnoreCase("no")){
					
					if(previous != null) {
						if(previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null && notes[notes_ind] != null) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null && times[times_ind] != null) {
						a.setTime_changed(times[times_ind]);
						times_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("ongoing")) {
					
					if(currents != null){
						if(currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("decrease")) {
					
					if(currents != null){
						if(currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					if(previous != null) {
						if(previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null && notes[notes_ind] != null) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null && times[times_ind] != null) {
						a.setTime_changed(times[times_ind]);
						times_ind++;		
					}
				}
			}
			a.setLifestyle(l);
			as.add(a);
		}
		
		return as;
	}
	
	public ArrayList<LifestyleActivity> loadActivitiesCollatList(HttpServletRequest req, Lifestyle l){
		ArrayList<LifestyleActivity> as = new ArrayList<LifestyleActivity>();
		String[] types = req.getParameterValues("exercise_collat");
		String[] involvements = req.getParameterValues("still_active_collat");
		String[] times = req.getParameterValues("exercise_time_collat");
		String[] currents = req.getParameterValues("current_hours_collat");
		String[] previous = req.getParameterValues("previous_hours_collat");
		String[] notes = req.getParameterValues("exercise_act_notes_collat");
		int current_ind = 0, previous_ind = 0, notes_ind = 0, times_ind = 0;
		
		if(types == null)
			return as;
		
		for(int i =0; i < types.length; i++){
			LifestyleActivity a = new LifestyleActivity();
			a.setType(types[i]);
			a.setCollat(true);
			if(involvements != null) {
				a.setInvolvement(involvements[i]);
				if(involvements[i].equalsIgnoreCase("no")){
					
					if(previous != null) {
						if(previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null) {
						a.setTime_changed(times[times_ind]);
						times_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("ongoing")) {
					
					if(currents != null){
						if(currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("decrease")) {
					
					if(currents != null){
						if(currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					if(previous != null) {
						if(previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null) {
						a.setTime_changed(times[times_ind]);
						times_ind++;		
					}
				}
			}
			a.setLifestyle(l);
			as.add(a);
		}
		
		return as;
	}
}
