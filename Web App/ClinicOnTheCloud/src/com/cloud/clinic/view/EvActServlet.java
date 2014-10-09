package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Activity;
import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.EventsActivities;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class EvActServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		//No such patient exists
		if(pat == null){
			req.setAttribute("error", "There was no patient associated with the form");
			req.setAttribute("error_message", "Patient was potentially created incorrectly, please ensure the Personal Details form is submitted correctly before proceeding with the test");
			RequestDispatcher view = req.getRequestDispatcher("/admin/Error.jsp");
			view.forward(req, resp);
			return;
		}
		
		//Get the most recent form
		Form f = dao.getMostRecentForm(pat);
		
		//Create the EventCtivities object
		EventsActivities ea = new EventsActivities();
		BeanPopulate.populateBean(ea, req);
		//Load the activities and collat activities separate as the BeanPopulate function can't work with multiple ids
		ea.setActivities(loadActivitiesList(req, ea));
		ea.setCollat_activities(loadActivitiesCollatList(req, ea));
		
		//If the form is new, then set the EA object and add the form to the patient
		if(f.isNew()){
			ea.setForm(f);
			f.setEventsActivities(ea);
			pat.addForm(f);
		} else {
			//Otherwise, check if EA object is null
			if(f.getEventsActivities() != null){
				//Set new id to old id to replace old object on database
				ea.setEventsActivitiesID(f.getEventsActivities().getEventsActivitiesID());
				//remove all activities associated with old EA object
				dao.runQuery("delete from Activity where eventActivity= " + String.valueOf(ea.getEventsActivitiesID()));
				ea.setForm(f);
				f.setEventsActivities(ea);
			} else {
				ea.setForm(f);
				f.setEventsActivities(ea);
			}
			//Update the list of forms with new form by replacing the old form with the same ID
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
		RequestDispatcher view = req.getRequestDispatcher("/patientform/living.jsp");
		view.forward(req, resp);
	}
	
	public ArrayList<Activity> loadActivitiesList(HttpServletRequest req, EventsActivities ea){
		ArrayList<Activity> as = new ArrayList<Activity>();
		//Get the arrays of values corresponding to the names in the HTML
		String[] types = req.getParameterValues("activity");
		String[] involvements = req.getParameterValues("involvement");
		String[] times = req.getParameterValues("time_changed");
		String[] currents = req.getParameterValues("current_hours");
		String[] previous = req.getParameterValues("previous_hours");
		String[] notes = req.getParameterValues("activity_notes");
		//Keep an index of all the types of values to prevent null ointer exception from having some values in one type rather than another
		int current_ind = 0, previous_ind = 0, notes_ind = 0, times_ind = 0;
		
		if(types == null)
			return as;
		
		for(int i =0; i < types.length; i++){
			Activity a = new Activity();
			a.setType(types[i]);
			a.setCollat(false);
			if(involvements != null) {
				a.setInvolvement(involvements[i]);
				//Type is no longer being active, so get the previous time, the ntoes and the time
				if(involvements[i].equalsIgnoreCase("no")){
					
					if(previous != null) {
						if(previous_ind < previous.length && previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null && notes_ind < notes.length) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null && times_ind < times.length) {
						a.setTime_changed(times[times_ind]);
						times_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("ongoing")) {
					//The activity is ongoing so only get the current time
					if(currents != null){
						if(current_ind < currents.length && currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("decrease")) {
					//The activity has decreased so get current hours, previous hours, notes and when it changed
					if(currents != null){
						if(current_ind < currents.length && currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					if(previous != null) {
						if(previous_ind < previous.length && previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null && notes_ind < notes.length) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null && times_ind < times.length) {
						a.setTime_changed(times[times_ind]);
						times_ind++;		
					}
				}
			}
			a.setEventActivity(ea);
			as.add(a);
		}
		
		return as;
	}
	
	//Same as previous function, but for collateral activities
	public ArrayList<Activity> loadActivitiesCollatList(HttpServletRequest req, EventsActivities ea){
		ArrayList<Activity> as = new ArrayList<Activity>();
		String[] types = req.getParameterValues("activity_collat");
		String[] involvements = req.getParameterValues("involvement_collat");
		String[] times = req.getParameterValues("time_changed_collat");
		String[] currents = req.getParameterValues("current_hours_collat");
		String[] previous = req.getParameterValues("previous_hours_collat");
		String[] notes = req.getParameterValues("activity_notes_collat");
		int current_ind = 0, previous_ind = 0, notes_ind = 0, times_ind = 0;
		
		if(types == null)
			return as;
		
		for(int i =0; i < types.length; i++){
			Activity a = new Activity();
			a.setType(types[i]);
			a.setCollat(true);
			if(involvements != null) {
				a.setInvolvement(involvements[i]);
				if(involvements[i].equalsIgnoreCase("no")){
					
					if(previous != null) {
						if(previous_ind < previous.length && previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null && notes_ind < notes.length) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null && times_ind < times.length) {
						a.setTime_changed(times[times_ind]);
						times_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("ongoing")) {
					
					if(currents != null){
						if(current_ind < currents.length && currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					
				} else if(involvements[i].equalsIgnoreCase("decrease")) {
					
					if(currents != null){
						if(current_ind < currents.length && currents[current_ind] != "")
							a.setCurrent_hours(Integer.parseInt(currents[current_ind]));
						else
							a.setCurrent_hours(0);
						current_ind++;
					}
					if(previous != null) {
						if(previous_ind < previous.length && previous[previous_ind] != "")
							a.setPrev_hours(Integer.parseInt(previous[previous_ind]));
						else
							a.setPrev_hours(0);
						previous_ind++;
					}
					
					if(notes != null && notes_ind < notes.length) {
						a.setNotes(notes[notes_ind]);
						notes_ind++;
					}
					
					if(times != null && times_ind < times.length) {
						a.setTime_changed(times[times_ind]);
						times_ind++;		
					}
				}
			}
			a.setEventActivity(ea);
			as.add(a);
		}
		
		return as;
	}
}
