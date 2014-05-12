package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;

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
		Form f = dao.getLatestForm(pat);
		EventsActivities ea = new EventsActivities();
		BeanPopulate.populateBean(ea, req);
		ea.setActivities(loadActivitiesList(req, ea));
		ea.setCollat_activities(loadActivitiesCollatList(req, ea));
		
		if(f.isNew()){
			ea.setForm(f);
			f.setEventsActivities(ea);
			pat.addForm(f);
		} else {
			if(f.getEventsActivities() != null){
				dao.runQuery("delete from Activity where Lifestyle= " + String.valueOf(ea.getEventsActivitiesID()));
				ea.setEventsActivitiesID(f.getEventsActivities().getEventsActivitiesID());
				ea.setForm(f);
				f.setEventsActivities(ea);
			} else {
				ea.setForm(f);
				f.setEventsActivities(ea);
			}
		}
		dao.update(pat);
		
		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/living.jsp");
		view.forward(req, resp);
	}
	
	public ArrayList<Activity> loadActivitiesList(HttpServletRequest req, EventsActivities ea){
		ArrayList<Activity> as = new ArrayList<Activity>();
		String[] types = req.getParameterValues("activity");
		String[] involvements = req.getParameterValues("involvement");
		String[] times = req.getParameterValues("time_changed");
		String[] currents = req.getParameterValues("current_hours");
		String[] previous = req.getParameterValues("previous_hours");
		String[] notes = req.getParameterValues("activity_notes");
		int current_ind = 0, previous_ind = 0, notes_ind = 0, times_ind = 0;
		
		if(types == null)
			return as;
		
		for(int i =0; i < types.length; i++){
			Activity a = new Activity();
			a.setType(types[i]);
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
			a.setEventActivity(ea);
			as.add(a);
		}
		
		return as;
	}
	
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
			a.setEventActivity(ea);
			as.add(a);
		}
		
		return as;
	}
}
