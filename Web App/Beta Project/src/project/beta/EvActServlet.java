package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Activity;
import project.beta.model.EventsActivities;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class EvActServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		EventsActivities ea = new EventsActivities(0);
		BuildEvAct(ea, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/living.jsp");
		view.forward(req, resp);
	}
	
	private void BuildEvAct(EventsActivities ea, HttpServletRequest req)
	{
		String[] times = req.getParameterValues("time_frame");
		int time_i = 0;
		
		String divorceCheck = req.getParameter("divorce_check");
		if(divorceCheck != "" && divorceCheck != null) {
			ea.setDivorce(divorceCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isDivorce()){
				ea.setDivorce_time(times[time_i]);
				ea.setDivorce_notes(req.getParameter("divorce_notes"));
				time_i++;
			}
		}
		
		String bereavementCheck = req.getParameter("bereavement_check");
		if(bereavementCheck != "" && bereavementCheck != null) {
			ea.setBereavement(bereavementCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isBereavement()){
				ea.setBereavement_time(times[time_i]);
				ea.setBereavement_notes(req.getParameter("bereavement_notes"));
				time_i++;
			}
		}
		
		String moving_houseCheck = req.getParameter("moving_house_check");
		if(moving_houseCheck != "" && moving_houseCheck != null) {
			ea.setMoving_house(moving_houseCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isMoving_house()){
				ea.setMoving_house_time(times[time_i]);
				ea.setMoving_house_notes(req.getParameter("moving_house_notes"));
				time_i++;
			}
		}
		
		String redundancyCheck = req.getParameter("redundancy_check");
		if(redundancyCheck != "" && redundancyCheck != null) {
			ea.setRedundancy(redundancyCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isRedundancy()){
				ea.setRedundancy_time(times[time_i]);
				ea.setRedundancy_notes(req.getParameter("redundancy_notes"));
				time_i++;
			}
		}
		
		String family_disharmonyCheck = req.getParameter("family_disharmony_check");
		if(family_disharmonyCheck != "" && family_disharmonyCheck != null) {
			ea.setFamily_disharmony(family_disharmonyCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isFamily_disharmony()){
				ea.setFamily_disharmony_time(times[time_i]);
				ea.setFamily_disharmony_notes(req.getParameter("family_disharmony_notes"));
				time_i++;
			}
		}
		
		String other_disharmonyCheck = req.getParameter("other_disharmony_check");
		if(other_disharmonyCheck != "" && other_disharmonyCheck != null) {
			ea.setOther_disharmony(other_disharmonyCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isOther_disharmony()){
				ea.setOther_disharmony_time(times[time_i]);
				ea.setOther_disharmony_notes(req.getParameter("other_disharmony_notes"));
				time_i++;
			}
		}
		
		String financialCheck = req.getParameter("financial_check");
		if(financialCheck != "" && financialCheck != null) {
			ea.setFinancial(financialCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isFinancial()){
				ea.setFinancial_time(times[time_i]);
				ea.setFinancial_notes(req.getParameter("financial_notes"));
				time_i++;
			}
		}
		
		String retirementCheck = req.getParameter("retirement_check");
		if(retirementCheck != "" && retirementCheck != null) {
			ea.setRetirement(retirementCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isRetirement()){
				ea.setRetirement_time(times[time_i]);
				ea.setRetirement_notes(req.getParameter("retirement_notes"));
				time_i++;
			}
		}
		
		String job_stressCheck = req.getParameter("job_stress_check");
		if(job_stressCheck != "" && job_stressCheck != null) {
			ea.setJob(job_stressCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isJob()){
				ea.setJob_time(times[time_i]);
				ea.setJob_notes(req.getParameter("job_stress_notes"));
				time_i++;
			}
		}
		
		String otherCheck = req.getParameter("other_text");
		if(otherCheck != "" && otherCheck != null) {
			ea.setOther(otherCheck);
			ea.setOther_time(times[time_i]);
			ea.setOther_notes(req.getParameter("other_notes"));
			time_i++;
		}
		
		String divorceCollatCheck = req.getParameter("divorce_collat_check");
		if(divorceCollatCheck != "" && divorceCollatCheck != null) {
			ea.setDivorce_collat(divorceCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isDivorce_collat()){
				ea.setDivorce_collat_time(times[time_i]);
				ea.setDivorce_collat_notes(req.getParameter("divorce_collat_notes"));
				time_i++;
			}
		}
		
		String bereavementCollatCheck = req.getParameter("bereavement_collat_check");
		if(bereavementCollatCheck != "" && bereavementCollatCheck != null) {
			ea.setBereavement_collat(bereavementCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isBereavement_collat()){
				ea.setBereavement_collat_time(times[time_i]);
				ea.setBereavement_collat_notes(req.getParameter("bereavement_collat_notes"));
				time_i++;
			}
		}
		
		String moving_houseCollatCheck = req.getParameter("moving_house_collat_check");
		if(moving_houseCollatCheck != "" && moving_houseCollatCheck != null) {
			ea.setMoving_house_collat(moving_houseCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isMoving_house_collat()){
				ea.setMoving_house_collat_time(times[time_i]);
				ea.setMoving_house_collat_notes(req.getParameter("moving_house_collat_notes"));
				time_i++;
			}
		}
		
		String redundancyCollatCheck = req.getParameter("redundancy_collat_check");
		if(redundancyCollatCheck != "" && redundancyCollatCheck != null) {
			ea.setRedundancy_collat(redundancyCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isRedundancy_collat()){
				ea.setRedundancy_collat_time(times[time_i]);
				ea.setRedundancy_collat_notes(req.getParameter("redundancy_collat_notes"));
				time_i++;
			}
		}
		
		String family_disharmonyCollatCheck = req.getParameter("family_disharmony_collat_check");
		if(family_disharmonyCollatCheck != "" && family_disharmonyCollatCheck != null) {
			ea.setFamily_disharmony_collat(family_disharmonyCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isFamily_disharmony_collat()){
				ea.setFamily_disharmony_collat_time(times[time_i]);
				ea.setFamily_disharmony_collat_notes(req.getParameter("family_disharmony_collat_notes"));
				time_i++;
			}
		}
		
		String other_disharmonyCollatCheck = req.getParameter("other_disharmony_collat_check");
		if(other_disharmonyCollatCheck != "" && other_disharmonyCollatCheck != null) {
			ea.setOther_disharmony_collat(other_disharmonyCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isOther_disharmony_collat()){
				ea.setOther_disharmony_collat_time(times[time_i]);
				ea.setOther_disharmony_collat_notes(req.getParameter("other_disharmony_collat_notes"));
				time_i++;
			}
		}
		
		String financialCollatCheck = req.getParameter("financial_collat_check");
		if(financialCollatCheck != "" && financialCollatCheck != null) {
			ea.setFinancial_collat(financialCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isFinancial_collat()){
				ea.setFinancial_collat_time(times[time_i]);
				ea.setFinancial_collat_notes(req.getParameter("financial_collat_notes"));
				time_i++;
			}
		}
		
		String retirementCollatCheck = req.getParameter("retirement_collat_check");
		if(retirementCollatCheck != "" && retirementCollatCheck != null) {
			ea.setRetirement_collat(retirementCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isRetirement_collat()){
				ea.setRetirement_collat_time(times[time_i]);
				ea.setRetirement_collat_notes(req.getParameter("retirement_collat_notes"));
				time_i++;
			}
		}
		
		String job_stressCollatCheck = req.getParameter("job_stress_collat_check");
		if(job_stressCollatCheck != "" && job_stressCollatCheck != null) {
			ea.setJob_collat(job_stressCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isJob_collat()){
				ea.setJob_collat_time(times[time_i]);
				ea.setJob_collat_notes(req.getParameter("job_stress_collat_notes"));
				time_i++;
			}
		}
		
		String otherCollatCheck = req.getParameter("other_collat_text");
		if(otherCollatCheck != "" && otherCollatCheck != null) {
			ea.setOther_collat(otherCollatCheck);
			ea.setOther_collat_time(times[time_i]);
			ea.setOther_collat_notes(req.getParameter("other_collat_notes"));
			time_i++;
		}		
		
		String[] acts = req.getParameterValues("activities_list");
		String[] active = req.getParameterValues("still_active_check");
		String[] current_hours = req.getParameterValues("current_active_hours");
		String[] previous_hours = req.getParameterValues("previous_active_hours");
		String[] notes = req.getParameterValues("activity_notes");
		int current_i = 0, prev_i = 0, notes_i = 0;
		for(int i = 0; i < acts.length; i++)
		{
			Activity act = new Activity(acts[i], active[i]);
			if(active[i].equalsIgnoreCase("no")){
				act.setPrev_hours(Integer.parseInt(previous_hours[prev_i]));
				prev_i++;
				act.setTime_changed(times[time_i]);
				time_i++;
				act.setNotes(notes[notes_i]);
				notes_i++;
			}
			else if(active[i].equalsIgnoreCase("ongoing")) {
				act.setCurrent_hours(Integer.parseInt(current_hours[current_i]));
				current_i++;
			} 
			else if(active[i].equalsIgnoreCase("decrease")) {
				act.setCurrent_hours(Integer.parseInt(current_hours[current_i]));
				current_i++;
				act.setPrev_hours(Integer.parseInt(previous_hours[prev_i]));
				prev_i++;
				act.setTime_changed(times[time_i]);
				time_i++;
				act.setNotes(notes[notes_i]);
				notes_i++;
			}
			ea.addActivity(act);
		}
		
		String[] collat_acts = req.getParameterValues("activities_collat_list");
		String[] c_active = req.getParameterValues("still_active_collat_check");
		String[] c_current_hours = req.getParameterValues("current_active_hours_collat");
		String[] c_previous_hours = req.getParameterValues("previous_active_hours_collat");
		String[] c_notes = req.getParameterValues("collat_activity_notes");
		int c_current_i = 0, c_prev_i = 0, c_notes_i = 0;
		for(int i = 0; i < collat_acts.length; i++)
		{
			Activity act = new Activity(collat_acts[i], c_active[i]);
			if(c_active[i].equalsIgnoreCase("no")){
				act.setPrev_hours(Integer.parseInt(c_previous_hours[c_prev_i]));
				c_prev_i++;
				act.setTime_changed(times[time_i]);
				time_i++;
				act.setNotes(c_notes[c_notes_i]);
				c_notes_i++;
			}
			else if(c_active[i].equalsIgnoreCase("ongoing")) {
				act.setCurrent_hours(Integer.parseInt(c_current_hours[c_current_i]));
				c_current_i++;
			} 
			else if(c_active[i].equalsIgnoreCase("decrease")) {
				act.setCurrent_hours(Integer.parseInt(c_current_hours[c_current_i]));
				c_current_i++;
				act.setPrev_hours(Integer.parseInt(c_previous_hours[c_prev_i]));
				c_prev_i++;
				act.setTime_changed(times[time_i]);
				time_i++;
				act.setNotes(c_notes[c_notes_i]);
				c_notes_i++;
			}
			ea.addCollatActivity(act);
		}
		
		String anxCheck = req.getParameter("anxiety_check");
		if(anxCheck != "" && anxCheck != null) {
			ea.setAnx_check(anxCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isAnx_check()){
				ea.setAnx_time(times[time_i]);
				ea.setAnx_related(req.getParameter("life_anx_events"));
				ea.setAnx_notes(req.getParameter("anxiety_notes"));
				time_i++;
			}
		}
		
		String depCheck = req.getParameter("dep_check");
		if(depCheck != "" && depCheck != null) {
			ea.setDep_check(depCheck.equalsIgnoreCase("on") ? true : false);
			if(ea.isDep_check()){
				ea.setDep_time(times[time_i]);
				ea.setDep_related(req.getParameter("life_dep_events"));
				ea.setDep_notes(req.getParameter("depression_notes"));
				time_i++;
			}
		}
	}
}
