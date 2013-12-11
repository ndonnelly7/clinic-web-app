package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Activity;
import project.beta.model.Lifestyle;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LifestyleServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		Lifestyle l = new Lifestyle(0);
		BuildLifestyle(l, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/memory_test.jsp");
		view.forward(req, resp);
	}
	
	private void BuildLifestyle(Lifestyle l, HttpServletRequest req)
	{
		l.setSleep_length(req.getParameter("sleep_length"));
		String difficulty_check = req.getParameter("difficulty_sleep_check");
		if(difficulty_check.equalsIgnoreCase("on")) {
			l.setDifficulty_sleep(true);
			l.setDifficulty_reason(req.getParameter("difficulty_reason"));
			l.setDifficulty_reason_notes(req.getParameter("difficulty_reason_notes"));
			l.setDifficulty_time(req.getParameter("difficulty_time"));
			l.setDifficulty_time_notes(req.getParameter("difficulty_time_notes"));
			l.setDifficulty_freq(req.getParameter("difficulty_freq"));
			l.setDifficulty_freq_notes(req.getParameter("difficulty_freq_notes"));
		}
		l.setDifficulty_sleep_notes(req.getParameter("difficulty_sleep_notes"));
		
		String night_waking_check = req.getParameter("night_waking_check");
		if(night_waking_check.equalsIgnoreCase("on")) {
			l.setNight_waking(true);
			l.setNight_waking_reason(req.getParameter("night_waking_reason"));
			l.setNight_waking_reason_notes(req.getParameter("night_waking_reason_notes"));
			l.setNight_waking_time(req.getParameter("night_waking_time"));
			l.setNight_waking_time_notes(req.getParameter("night_waking_time_notes"));
			l.setNight_waking_freq(req.getParameter("night_waking_freq"));
			l.setNight_waking_freq_notes(req.getParameter("night_waking_freq_notes"));
		}
		l.setNight_waking_notes(req.getParameter("night_waking_notes"));
		
		String early_waking_check = req.getParameter("early_waking_check");
		if(early_waking_check.equalsIgnoreCase("on")) {
			l.setEarly_waking(true);
			l.setEarly_waking_reason(req.getParameter("early_waking_reason"));
			l.setEarly_waking_reason_notes(req.getParameter("early_waking_reason_notes"));
			l.setEarly_waking_time(req.getParameter("early_waking_time"));
			l.setEarly_waking_time_notes(req.getParameter("early_waking_time_notes"));
			l.setEarly_waking_freq(req.getParameter("early_waking_freq"));
			l.setEarly_waking_freq_notes(req.getParameter("early_waking_freq_notes"));
		}
		l.setEarly_waking_notes(req.getParameter("early_waking_notes"));
		
		String meds_check = req.getParameter("meds_check");
		if(meds_check.equalsIgnoreCase("on")) {
			l.setMeds_check(true);
			l.setSleep_meds(req.getParameter("sleep_meds"));
			l.setSleep_med_notes(req.getParameter("sleep_meds_notes"));
		}
		
		String nap_check = req.getParameter("nap_check");
		if(nap_check.equalsIgnoreCase("on")) {
			l.setNap_check(true);
			l.setNap_length(req.getParameter("nap_length"));
			l.setNap_time(req.getParameter("nap_time"));
			l.setNap_notes(req.getParameter("nap_notes"));
		}
		
		String sleep_collat = req.getParameter("sleep_collat");
		if(sleep_collat.equalsIgnoreCase("shown")) {
			l.setCollat_sleep(true);
			
			l.setSleep_length_collat(req.getParameter("sleep_length"));
			String difficulty_check_collat = req.getParameter("difficulty_sleep_check_collat");
			if(difficulty_check_collat.equalsIgnoreCase("on")) {
				l.setDifficulty_sleep(true);
				l.setDifficulty_reason_collat(req.getParameter("difficulty_reason"));
				l.setDifficulty_reason_notes_collat(req.getParameter("difficulty_reason_notes"));
				l.setDifficulty_time_collat(req.getParameter("difficulty_time"));
				l.setDifficulty_time_notes_collat(req.getParameter("difficulty_time_notes"));
				l.setDifficulty_freq_collat(req.getParameter("difficulty_freq"));
				l.setDifficulty_freq_notes_collat(req.getParameter("difficulty_freq_notes"));
			}
			l.setDifficulty_sleep_notes_collat(req.getParameter("difficulty_sleep_notes"));
			
			String night_waking_check_collat = req.getParameter("night_waking_check_collat");
			if(night_waking_check_collat.equalsIgnoreCase("on")) {
				l.setNight_waking(true);
				l.setNight_waking_reason_collat(req.getParameter("night_waking_reason"));
				l.setNight_waking_reason_notes_collat(req.getParameter("night_waking_reason_notes"));
				l.setNight_waking_time_collat(req.getParameter("night_waking_time"));
				l.setNight_waking_time_notes_collat(req.getParameter("night_waking_time_notes"));
				l.setNight_waking_freq_collat(req.getParameter("night_waking_freq"));
				l.setNight_waking_freq_notes_collat(req.getParameter("night_waking_freq_notes"));
			}
			l.setNight_waking_notes_collat(req.getParameter("night_waking_notes"));
			
			String early_waking_check_collat = req.getParameter("early_waking_check_collat");
			if(early_waking_check_collat.equalsIgnoreCase("on")) {
				l.setEarly_waking(true);
				l.setEarly_waking_reason_collat(req.getParameter("early_waking_reason"));
				l.setEarly_waking_reason_notes_collat(req.getParameter("early_waking_reason_notes"));
				l.setEarly_waking_time_collat(req.getParameter("early_waking_time"));
				l.setEarly_waking_time_notes_collat(req.getParameter("early_waking_time_notes"));
				l.setEarly_waking_freq_collat(req.getParameter("early_waking_freq"));
				l.setEarly_waking_freq_notes_collat(req.getParameter("early_waking_freq_notes"));
			}
			l.setEarly_waking_notes_collat(req.getParameter("early_waking_notes"));
			
			String meds_check_collat = req.getParameter("meds_check_collat");
			if(meds_check_collat.equalsIgnoreCase("on")) {
				l.setMeds_check_collat(true);
				l.setSleep_meds_collat(req.getParameter("sleep_meds"));
				l.setSleep_med_notes_collat(req.getParameter("sleep_meds_notes"));
			}
			
			String nap_check_collat = req.getParameter("nap_check_collat");
			if(nap_check_collat.equalsIgnoreCase("on")) {
				l.setNap_check_collat(true);
				l.setNap_length_collat(req.getParameter("nap_length"));
				l.setNap_time_collat(req.getParameter("nap_time"));
				l.setNap_notes_collat(req.getParameter("nap_notes"));
			}
		}
		
		//Exercise
		String[] activities = req.getParameterValues("activities_list");
		String[] involvements = req.getParameterValues("still_active_check");
		String[] current_hours = req.getParameterValues("current_active_hours");
		String[] previous_hours = req.getParameterValues("previous_active_hours");
		String[] exercise_time = req.getParameterValues("exercise_time");
		String[] activity_notes = req.getParameterValues("activity_notes");
		
		int current_i = 0, previous_i = 0, time_i = 0, notes_i = 0;
		for(int i = 0; i < activities.length; i++)
		{
			Activity a = new Activity(activities[i], involvements[i]);
			String involve = involvements[i];
			if(involve.equalsIgnoreCase("no")){
				a.setPrev_hours(Integer.parseInt(previous_hours[previous_i]));
				previous_i++;
				a.setTime_changed(exercise_time[time_i]);
				time_i++;
				a.setNotes(activity_notes[notes_i]);
				notes_i++;
			} else if(involve.equalsIgnoreCase("ongoing")) {
				a.setCurrent_hours(Integer.parseInt(current_hours[current_i]));
				current_i++;
			} else if(involve.equalsIgnoreCase("decrease")) {
				a.setCurrent_hours(Integer.parseInt(current_hours[current_i]));
				current_i++;
				a.setPrev_hours(Integer.parseInt(previous_hours[previous_i]));
				previous_i++;
				a.setTime_changed(exercise_time[time_i]);
				time_i++;
				a.setNotes(activity_notes[notes_i]);
				notes_i++;
			}
			l.addActivity(a);
		}
		
		//Exercise Collat
		String exercise_collat = req.getParameter("exercise_collat");
		if(exercise_collat.equalsIgnoreCase("shown"))
		{
			l.setCollat_exercise(true);
			String[] activities_collat = req.getParameterValues("activities_list_collat");
			String[] involvements_collat = req.getParameterValues("still_active_check_collat");
			String[] current_hours_collat = req.getParameterValues("current_active_hours_collat");
			String[] previous_hours_collat = req.getParameterValues("previous_active_hours_collat");
			String[] exercise_time_collat = req.getParameterValues("exercise_time_collat");
			String[] activity_notes_collat = req.getParameterValues("activity_notes_collat");
			
			current_i = 0; previous_i = 0; time_i = 0; notes_i = 0;
			for(int i = 0; i < activities_collat.length; i++)
			{
				Activity a = new Activity(activities_collat[i], involvements_collat[i]);
				String involve = involvements_collat[i];
				if(involve.equalsIgnoreCase("no")){
					a.setPrev_hours(Integer.parseInt(previous_hours_collat[previous_i]));
					previous_i++;
					a.setTime_changed(exercise_time_collat[time_i]);
					time_i++;
					a.setNotes(activity_notes_collat[notes_i]);
					notes_i++;
				} else if(involve.equalsIgnoreCase("ongoing")) {
					a.setCurrent_hours(Integer.parseInt(current_hours_collat[current_i]));
					current_i++;
				} else if(involve.equalsIgnoreCase("decrease")) {
					a.setCurrent_hours(Integer.parseInt(current_hours_collat[current_i]));
					current_i++;
					a.setPrev_hours(Integer.parseInt(previous_hours_collat[previous_i]));
					previous_i++;
					a.setTime_changed(exercise_time_collat[time_i]);
					time_i++;
					a.setNotes(activity_notes_collat[notes_i]);
					notes_i++;
				}
				l.addCollatActivity(a);
			}			
			
		}
		
		//Diet
		l.setBreakfast(req.getParameter("diet_breakfast_notes"));
		l.setLunch(req.getParameter("diet_lunch_notes"));
		l.setDinner(req.getParameter("diet_dinner_notes"));
		
		String miss_meals = req.getParameter("miss_meals_check");
		if(miss_meals.equalsIgnoreCase("on")){
			l.setMiss_meals(true);
			l.setMiss_meals_freq(req.getParameter("miss_meals_freq"));
		}
		
		String sweets = req.getParameter("sweets_check");
		if(sweets.equalsIgnoreCase("on")){
			l.setSweets(true);
			l.setSweets_freq(req.getParameter("sweets_freq"));
		}
		
		String fried = req.getParameter("fried_check");
		if(fried.equalsIgnoreCase("on")){
			l.setFried(true);
			l.setFried_freq(req.getParameter("fried_freq"));
		}
		
		String takeaway = req.getParameter("takeaway_check");
		if(takeaway.equalsIgnoreCase("on")){
			l.setTakeaway(true);
			l.setTakeaway_freq(req.getParameter("takeaway_freq"));
		}
		
		String cakes = req.getParameter("cakes_check");
		if(cakes.equalsIgnoreCase("on")){
			l.setCakes(true);
			l.setCakes_freq(req.getParameter("cakes_freq"));
		}
		
		l.setFruit_veg_amount(req.getParameter("fruit_veg_amount"));
		l.setDiet_notes(req.getParameter("diet_notes"));
		
		String diet_collat = req.getParameter("diet_collat");
		if(diet_collat.equalsIgnoreCase("shown"))
		{
			l.setCollat_diet(true);
			l.setBreakfast_collat(req.getParameter("diet_breakfast_notes_collat"));
			l.setLunch_collat(req.getParameter("diet_lunch_notes_collat"));
			l.setDinner_collat(req.getParameter("diet_dinner_notes_collat"));
			
			String miss_meals_collat = req.getParameter("miss_meals_check_collat");
			if(miss_meals_collat.equalsIgnoreCase("on")){
				l.setMiss_meals_collat(true);
				l.setMiss_meals_freq_collat(req.getParameter("miss_meals_freq_collat"));
			}
			
			String sweets_collat = req.getParameter("sweets_check_collat");
			if(sweets_collat.equalsIgnoreCase("on_collat")){
				l.setSweets_collat(true);
				l.setSweets_freq_collat(req.getParameter("sweets_freq_collat"));
			}
			
			String fried_collat = req.getParameter("fried_check_collat");
			if(fried_collat.equalsIgnoreCase("on")){
				l.setFried_collat(true);
				l.setFried_freq_collat(req.getParameter("fried_freq_collat"));
			}
			
			String takeaway_collat = req.getParameter("takeaway_check_collat");
			if(takeaway_collat.equalsIgnoreCase("on")){
				l.setTakeaway_collat(true);
				l.setTakeaway_freq_collat(req.getParameter("takeaway_freq_collat"));
			}
			
			String cakes_collat = req.getParameter("cakes_check_collat");
			if(cakes_collat.equalsIgnoreCase("on")){
				l.setCakes_collat(true);
				l.setCakes_freq_collat(req.getParameter("cakes_freq_collat"));
			}
			
			l.setFruit_veg_amount_collat(req.getParameter("fruit_veg_amount_collat"));
			l.setDiet_notes_collat(req.getParameter("diet_notes_collat"));
		}
		
		//Alcohol
		String alcohol_check = req.getParameter("alcohol_check");
		if(alcohol_check.equalsIgnoreCase("on"))
		{
			l.setAlcohol(true);
			l.setPint_units(Float.parseFloat(req.getParameter("beer_pint_units")));
			l.setBottle_units(Float.parseFloat(req.getParameter("beer_bottle_units")));
			l.setSpirits_units(Float.parseFloat(req.getParameter("spirit_units")));
			l.setWine_units(Float.parseFloat(req.getParameter("wine_glass_units")));
			l.setAlcopop_units(Float.parseFloat(req.getParameter("pop_units")));
			l.setTotal_units(Float.parseFloat(req.getParameter("total_units")));
		}
		l.setAlcohol_notes(req.getParameter("alcohol_notes"));
		
		String collat_alcohol = req.getParameter("alcohol_collat");
		if(collat_alcohol.equalsIgnoreCase("shown"))
		{
			l.setAlcohol_collat(true);
			String alcohol_check_collat = req.getParameter("alcohol_check_collat");
			if(alcohol_check_collat.equalsIgnoreCase("on"))
			{
				l.setAlcohol_collat(true);
				l.setPint_units_collat(Float.parseFloat(req.getParameter("beer_pint_units_collat")));
				l.setBottle_units_collat(Float.parseFloat(req.getParameter("beer_bottle_units_collat")));
				l.setSpirits_units_collat(Float.parseFloat(req.getParameter("spirit_units_collat")));
				l.setWine_units_collat(Float.parseFloat(req.getParameter("wine_glass_units_collat")));
				l.setAlcopop_units_collat(Float.parseFloat(req.getParameter("pop_units_collat")));
				l.setTotal_units_collat(Float.parseFloat(req.getParameter("total_units_collat")));
			}
			l.setAlcohol_notes_collat(req.getParameter("alcohol_notes_collat"));
		}
		
		
		//Smoking
		String smoking_check = req.getParameter("smoke_check");
		if(smoking_check.equalsIgnoreCase("on"))
		{
			l.setSmoking(true);
			l.setPackets(req.getParameter("packets"));
		}
		l.setSmoking_notes("smoking_notes");
		
		String collat_smoking = req.getParameter("smoking_collat");
		if(collat_smoking.equalsIgnoreCase("shown"))
		{
			l.setCollat_smoking(true);
			String smoking_check_collat = req.getParameter("smoke_check_collat");
			if(smoking_check_collat.equalsIgnoreCase("on"))
			{
				l.setSmoking_collat(true);
				l.setPackets_collat(req.getParameter("packets_collat"));
			}
			l.setSmoking_notes_Collat("smoking_notes_collat");
		}
		
		//Drugs
		l.setDrugs(req.getParameter("drug_check").equalsIgnoreCase("on") ? true : false);
		l.setDrug_notes("drugs_notes");
		String collat_drugs = req.getParameter("drugs_collat");
		if(collat_drugs.equalsIgnoreCase("shown"))
		{
			l.setDrugs_collat(req.getParameter("drug_check_collat").equalsIgnoreCase("on") ? true : false);
			l.setDrug_notes_collat(req.getParameter("drugs_notes_collat"));
		}
	}
}
