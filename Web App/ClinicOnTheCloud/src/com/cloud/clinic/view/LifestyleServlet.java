package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
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

import com.cloud.clinic.model.Activity;
import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.EventsActivities;
import com.cloud.clinic.model.HibernateUtil;
import com.cloud.clinic.model.Lifestyle;
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
		
		Lifestyle l = new Lifestyle();
		BeanPopulate.populateBean(l, req);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		l.setPatient(pat);
		pat = addOrUpdateLifestyle(c, pat, l);
		dao.update(pat);
		
		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/memory_test.jsp");
		view.forward(req, resp);
	}
	
	private Patient addOrUpdateLifestyle(Calendar c, Patient p, Lifestyle l) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from lifestyle where patient = :pid order by timestamp desc";
		Query q = session.createQuery(hql);
		q.setParameter("pid", String.valueOf(p.getPatientID()));
		@SuppressWarnings("unchecked")
		List<Lifestyle> list = (List<Lifestyle>) q.list();
		if(list.size() == 0)
			p.addLifestyle(l);
		else if(list.get(0).getTimestamp().equals(c)){
			l.setLifestyleID(list.get(0).getLifestyleID());
			Query r = session.createQuery("delete from lifestyleActivity where lifestyle= " + String.valueOf(list.get(0).getLifestyleID()));
			r.executeUpdate();
		} else {
			p.addLifestyle(l);
		}
		
		session.close();
		return p;
	}
	
	public ArrayList<Activity> loadActivitiesList(HttpServletRequest req, EventsActivities ea){
		ArrayList<Activity> as = new ArrayList<Activity>();
		String[] types = req.getParameterValues("exercise");
		String[] involvements = req.getParameterValues("still_active");
		String[] times = req.getParameterValues("exercise_time");
		String[] currents = req.getParameterValues("current_hours");
		String[] previous = req.getParameterValues("previous_hours");
		String[] notes = req.getParameterValues("exercise_notes");
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
		String[] types = req.getParameterValues("exercise_collat");
		String[] involvements = req.getParameterValues("still_active_collat");
		String[] times = req.getParameterValues("exercise_time_collat");
		String[] currents = req.getParameterValues("current_hours_collat");
		String[] previous = req.getParameterValues("previous_hours_collat");
		String[] notes = req.getParameterValues("exercise_notes_collat");
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
