package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.LivingSit;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LivingServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		LivingSit ls = new LivingSit(0);
		BuildLivingSit(ls, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/lifestyle.jsp");
		view.forward(req, resp);
	}
	
	private void BuildLivingSit(LivingSit ls, HttpServletRequest req)
	{
		//Lifestyle
		ls.setHousemates(req.getParameter("housemates"));
		ls.setHousemate_note(req.getParameter("housemates_note"));
		ls.setHouse_type(req.getParameter("house_type"));
		ls.setHouse_type_note(req.getParameter("housetype_note"));
		ls.setHouse_location(req.getParameter("house_location"));
		ls.setHouse_location_note(req.getParameter("houselocation_note"));
		ls.setCarer(req.getParameter("carer_check").equalsIgnoreCase("on") ? true : false);
		ls.setCarer_note(req.getParameter("carer_note"));
		ls.setHome_help(req.getParameter("home_help_check").equalsIgnoreCase("on") ? true : false);
		ls.setHome_help_note(req.getParameter("home_help_note"));
		
		String life_collat = req.getParameter("life_collat_pressed");
		if(life_collat.equalsIgnoreCase("shown")){		
			ls.setHousemates_collat(req.getParameter("housemates_collat"));
			ls.setHousemate_note_collat(req.getParameter("housemates_note_collat"));
			ls.setHouse_type_collat(req.getParameter("house_type_collat"));
			ls.setHouse_type_note_collat(req.getParameter("housetype_note_collat"));
			ls.setHouse_location_collat(req.getParameter("house_location_collat"));
			ls.setHouse_location_note_collat(req.getParameter("houselocation_note_collat"));
			ls.setCarer_collat(req.getParameter("carer_check_collat").equalsIgnoreCase("on") ? true : false);
			ls.setCarer_note_collat(req.getParameter("carer_note_collat"));
			ls.setHome_help_collat(req.getParameter("home_help_check_collat").equalsIgnoreCase("on") ? true : false);
			ls.setHome_help_note_collat(req.getParameter("home_help_note_collat"));
		}
		
		//Driving
		String driving_check = req.getParameter("driving_check");
		if(driving_check.equalsIgnoreCase("on"))
		{
			ls.setDrive(true);
			String unknown_arrival_check = req.getParameter("unknown_arrival_check");
			if(unknown_arrival_check.equalsIgnoreCase("on")){
				ls.setUnknown_arrival(true);
				ls.setUnknown_arrival_severity(req.getParameter("unknown_arrival_severity"));
				ls.setUnknown_arrival_freq(req.getParameter("unknown_arrival_freq"));
				ls.setUnknown_arrival_notes(req.getParameter("unknown_arrival_notes"));
			}
			
			String lost_check = req.getParameter("lost_check");
			if(lost_check.equalsIgnoreCase("on")){
				ls.setLost(true);
				ls.setLost_severity(req.getParameter("lost_severity"));
				ls.setLost_freq(req.getParameter("lost_freq"));
				ls.setLost_notes(req.getParameter("lost_notes"));
			}
			
			String tips_check = req.getParameter("tips_check");
			if(tips_check.equalsIgnoreCase("on")){
				ls.setTips(true);
				ls.setTips_severity(req.getParameter("tips_severity"));
				ls.setTips_freq(req.getParameter("tips_freq"));
				ls.setTips_notes(req.getParameter("tips_notes"));
			}
			
			String park_big_check = req.getParameter("park_big_check");
			if(park_big_check.equalsIgnoreCase("on")){
				ls.setPark_big(true);
				ls.setPark_big_success(req.getParameter("park_big_success"));
				ls.setPark_big_notes(req.getParameter("park_big_notes"));
			}
			
			String day_drive_check = req.getParameter("day_drive_check");
			if(day_drive_check.equalsIgnoreCase("on")){
				ls.setDay_drive(true);
				ls.setDay_drive_success(req.getParameter("day_drive_success"));
				ls.setDay_drive_notes(req.getParameter("day_drive_notes"));
			}
			
			String known_places_check = req.getParameter("known_places_check");
			if(known_places_check.equalsIgnoreCase("on")){
				ls.setKnown_places(true);
				ls.setKnown_places_success(req.getParameter("known_places_success"));
				ls.setKnown_places_notes(req.getParameter("known_places_notes"));
			}
			
			String take_friend_check = req.getParameter("take_friend_check");
			if(take_friend_check.equalsIgnoreCase("on")){
				ls.setTake_friend(true);
				ls.setTake_friend_success(req.getParameter("take_friend_success"));
				ls.setTake_friend_notes(req.getParameter("take_friend_notes"));
			}
			
			String dry_run_check = req.getParameter("dry_run_check");
			if(dry_run_check.equalsIgnoreCase("on")){
				ls.setDry_run(true);
				ls.setDry_run_success(req.getParameter("dry_run_success"));
				ls.setDry_run_notes(req.getParameter("dry_run_notes"));
			}
			
			String use_map_check = req.getParameter("use_map_check");
			if(use_map_check.equalsIgnoreCase("on")){
				ls.setMap(true);
				ls.setMap_success(req.getParameter("use_map_success"));
				ls.setMap_notes(req.getParameter("use_map_notes"));
			}
			
			String take_phone_check = req.getParameter("take_phone_check");
			if(take_phone_check.equalsIgnoreCase("on")){
				ls.setTake_phone(true);
				ls.setTake_phone_success(req.getParameter("take_phone_success"));
				ls.setTake_phone_notes(req.getParameter("take_phone_notes"));
			}			
			
			//Collateral
			String drive_collat = req.getParameter("driving_collat_pressed");
			if(drive_collat.equalsIgnoreCase("shown"))
			{
				ls.setDrive_collat(true);
				String unknown_arrival_check_collat = req.getParameter("unknown_arrival_check_collat");
				if(unknown_arrival_check_collat.equalsIgnoreCase("on")){
					ls.setUnknown_arrival_collat(true);
					ls.setUnkown_arrival_severity_collat(req.getParameter("unknown_arrival_severity_collat"));
					ls.setUnknown_arrival_freq_collat(req.getParameter("unknown_arrival_freq_collat"));
					ls.setUnknown_arrival_notes_collat(req.getParameter("unknown_arrival_notes_collat"));
				}
				
				String lost_check_collat = req.getParameter("lost_check_collat");
				if(lost_check_collat.equalsIgnoreCase("on")){
					ls.setLost_collat(true);
					ls.setLost_severity_collat(req.getParameter("lost_severity_collat"));
					ls.setLost_freq_collat(req.getParameter("lost_freq_collat"));
					ls.setLost_notes_collat(req.getParameter("lost_notes_collat"));
				}
				
				String tips_check_collat = req.getParameter("tips_check_collat");
				if(tips_check_collat.equalsIgnoreCase("on")){
					ls.setTips_collat(true);
					ls.setTips_severity_collat(req.getParameter("tips_severity_collat"));
					ls.setTips_freq_collat(req.getParameter("tips_freq_collat"));
					ls.setTips_notes_collat(req.getParameter("tips_notes_collat"));
				}
				
				String park_big_check_collat = req.getParameter("park_big_check_collat");
				if(park_big_check_collat.equalsIgnoreCase("on")){
					ls.setPark_big_collat(true);
					ls.setPark_big_success(req.getParameter("park_big_success"));
					ls.setPark_big_notes_collat(req.getParameter("park_big_notes_collat"));
				}
				
				String day_drive_check_collat = req.getParameter("day_drive_check_collat");
				if(day_drive_check_collat.equalsIgnoreCase("on")){
					ls.setDay_drive_collat(true);
					ls.setDay_drive_success(req.getParameter("day_drive_success"));
					ls.setDay_drive_notes_collat(req.getParameter("day_drive_notes_collat"));
				}
				
				String known_places_check_collat = req.getParameter("known_places_check_collat");
				if(known_places_check_collat.equalsIgnoreCase("on")){
					ls.setKnown_places_collat(true);
					ls.setKnown_places_success(req.getParameter("known_places_success"));
					ls.setKnown_places_notes_collat(req.getParameter("known_places_notes_collat"));
				}
				
				String take_friend_check_collat = req.getParameter("take_friend_check_collat");
				if(take_friend_check_collat.equalsIgnoreCase("on")){
					ls.setTake_friend_collat(true);
					ls.setTake_friend_success(req.getParameter("take_friend_success"));
					ls.setTake_friend_notes_collat(req.getParameter("take_friend_notes_collat"));
				}
				
				String dry_run_check_collat = req.getParameter("dry_run_check_collat");
				if(dry_run_check_collat.equalsIgnoreCase("on")){
					ls.setDry_run_collat(true);
					ls.setDry_run_success(req.getParameter("dry_run_success"));
					ls.setDry_run_notes_collat(req.getParameter("dry_run_notes_collat"));
				}
				
				String use_map_check_collat = req.getParameter("use_map_check_collat");
				if(use_map_check_collat.equalsIgnoreCase("on")){
					ls.setMap_collat(true);
					ls.setMap_success(req.getParameter("use_map_success"));
					ls.setMap_notes_collat(req.getParameter("use_map_notes_collat"));
				}
				
				String take_phone_check_collat = req.getParameter("take_phone_check_collat");
				if(take_phone_check_collat.equalsIgnoreCase("on")){
					ls.setTake_phone_collat(true);
					ls.setTake_phone_success(req.getParameter("take_phone_success"));
					ls.setTake_phone_notes_collat(req.getParameter("take_phone_notes_collat"));
				}
			}
		}
		
		//Cooking
		String cooking_check = req.getParameter("cooking_check");
		if(cooking_check.equalsIgnoreCase("on"))
		{
			ls.setCook(true);
			
			String forgot_cooking_check = req.getParameter("forgot_cooking_check");
			if(forgot_cooking_check.equalsIgnoreCase("on"))
			{
				ls.setForgot_cooking(true);
				ls.setForgot_cooking_freq(req.getParameter("forgot_cooking_freq"));
				ls.setForgot_cooking_notes(req.getParameter("forgot_cooking_notes"));
			}
			
			String burnt_food_check = req.getParameter("burnt_food_check");
			if(burnt_food_check.equalsIgnoreCase("on"))
			{
				ls.setBurnt_food(true);
				ls.setBurnt_food_freq(req.getParameter("burnt_food_freq"));
				ls.setBurnt_food_notes(req.getParameter("burnt_food_notes"));
			}
			
			String started_fire_check = req.getParameter("started_fire_check");
			if(started_fire_check.equalsIgnoreCase("on"))
			{
				ls.setStarted_fire(true);
				ls.setStarted_fire_freq(req.getParameter("started_fire_freq"));
				ls.setStarted_fire_notes(req.getParameter("started_fire_notes"));
			}
			
			String smoke_alarm_check = req.getParameter("smoke_alarm_check");
			if(smoke_alarm_check.equalsIgnoreCase("on"))
			{
				ls.setSmoke_alarm(true);
				ls.setSmoke_alarm_freq(req.getParameter("smoke_alarm_freq"));
				ls.setSmoke_alarm_notes(req.getParameter("smoke_alarm_notes"));
			}
			
			String undercooked_check = req.getParameter("undercooked_check");
			if(undercooked_check.equalsIgnoreCase("on"))
			{
				ls.setUndercooked(true);
				ls.setUndercooked_freq(req.getParameter("undercooked_freq"));
				ls.setUndercooked_notes(req.getParameter("undercooked_notes"));
			}
			
			String timer_check = req.getParameter("timer_check");
			if(timer_check.equalsIgnoreCase("on"))
			{
				ls.setTimer(true);
				ls.setTimer_success(req.getParameter("timer_success"));
				ls.setTimer_notes(req.getParameter("timer_notes"));
			}
			
			String reminders_check = req.getParameter("reminders_check");
			if(reminders_check.equalsIgnoreCase("on"))
			{
				ls.setReminders(true);
				ls.setReminders_success(req.getParameter("reminders_success"));
				ls.setReminders_notes(req.getParameter("reminders_notes"));
			}
			
			String simple_cooking_check = req.getParameter("simple_cooking_check");
			if(simple_cooking_check.equalsIgnoreCase("on"))
			{
				ls.setSimple_cooking(true);
				ls.setSimple_cooking_success(req.getParameter("simple_cooking_success"));
				ls.setSimple_cooking_notes(req.getParameter("simple_cooking_notes"));
			}
			
			String salad_check = req.getParameter("salad_check");
			if(salad_check.equalsIgnoreCase("on"))
			{
				ls.setSalad(true);
				ls.setSalad_success(req.getParameter("salad_success"));
				ls.setSalad_notes(req.getParameter("salad_notes"));
			}
			
			String go_out_check = req.getParameter("go_out_check");
			if(go_out_check.equalsIgnoreCase("on"))
			{
				ls.setGo_out(true);
				ls.setGo_out_success(req.getParameter("go_out_success"));
				ls.setGo_out_notes(req.getParameter("go_out_notes"));
			}
			
			String get_help_check = req.getParameter("get_help");
			if(get_help_check.equalsIgnoreCase("on"))
			{
				ls.setGet_help(true);
				ls.setGet_help_success(req.getParameter("get_help_success"));
				ls.setGet_help_notes(req.getParameter("get_help_notes"));
			}			
			
			//Collateral Cooking
			String cooking_collat = req.getParameter("cooking_collat");
			if(cooking_collat.equalsIgnoreCase("shown")){
			
				ls.setCooking_collat(true);
				String forgot_cooking_check_collat = req.getParameter("forgot_cooking_check_collat");
				if(forgot_cooking_check_collat.equalsIgnoreCase("on"))
				{
					ls.setForgot_cooking_collat(true);
					ls.setForgot_cooking_freq_collat(req.getParameter("forgot_cooking_freq_collat"));
					ls.setForgot_cooking_notes_collat(req.getParameter("forgot_cooking_notes_collat"));
				}
				
				String burnt_food_check_collat = req.getParameter("burnt_food_check_collat");
				if(burnt_food_check_collat.equalsIgnoreCase("on"))
				{
					ls.setBurnt_food_collat(true);
					ls.setBurnt_food_freq_collat(req.getParameter("burnt_food_freq_collat"));
					ls.setBurnt_food_notes_collat(req.getParameter("burnt_food_notes_collat"));
				}
				
				String started_fire_check_collat = req.getParameter("started_fire_check_collat");
				if(started_fire_check_collat.equalsIgnoreCase("on"))
				{
					ls.setStarted_fire_collat(true);
					ls.setStarted_fire_freq_collat(req.getParameter("started_fire_freq_collat"));
					ls.setStarted_fire_notes_collat(req.getParameter("started_fire_notes_collat"));
				}
				
				String smoke_alarm_check_collat = req.getParameter("smoke_alarm_check_collat");
				if(smoke_alarm_check_collat.equalsIgnoreCase("on"))
				{
					ls.setSmoke_alarm_collat(true);
					ls.setSmoke_alarm_freq_collat(req.getParameter("smoke_alarm_freq_collat"));
					ls.setSmoke_alarm_notes_collat(req.getParameter("smoke_alarm_notes_collat"));
				}
				
				String undercooked_check_collat = req.getParameter("undercooked_check_collat");
				if(undercooked_check_collat.equalsIgnoreCase("on"))
				{
					ls.setUndercooked_collat(true);
					ls.setUndercooked_freq_collat(req.getParameter("undercooked_freq_collat"));
					ls.setUndercooked_notes_collat(req.getParameter("undercooked_notes_collat"));
				}
				
				String timer_check_collat = req.getParameter("timer_check_collat");
				if(timer_check_collat.equalsIgnoreCase("on"))
				{
					ls.setTimer_collat(true);
					ls.setTimer_success_collat(req.getParameter("timer_success_collat"));
					ls.setTimer_notes_collat(req.getParameter("timer_notes_collat"));
				}
				
				String reminders_check_collat = req.getParameter("reminders_check_collat");
				if(reminders_check_collat.equalsIgnoreCase("on"))
				{
					ls.setReminders_collat(true);
					ls.setReminders_success_collat(req.getParameter("reminders_success_collat"));
					ls.setReminders_notes_collat(req.getParameter("reminders_notes_collat"));
				}
				
				String simple_cooking_check_collat = req.getParameter("simple_cooking_check_collat");
				if(simple_cooking_check_collat.equalsIgnoreCase("on"))
				{
					ls.setSimple_cooking_collat(true);
					ls.setSimple_cooking_success_collat(req.getParameter("simple_cooking_success_collat"));
					ls.setSimple_cooking_notes_collat(req.getParameter("simple_cooking_notes_collat"));
				}
				
				String salad_check_collat = req.getParameter("salad_check_collat");
				if(salad_check_collat.equalsIgnoreCase("on"))
				{
					ls.setSalad_collat(true);
					ls.setSalad_success_collat(req.getParameter("salad_success_collat"));
					ls.setSalad_notes_collat(req.getParameter("salad_notes_collat"));
				}
				
				String go_out_check_collat = req.getParameter("go_out_check_collat");
				if(go_out_check_collat.equalsIgnoreCase("on"))
				{
					ls.setGo_out_collat(true);
					ls.setGo_out_success_collat(req.getParameter("go_out_success_collat"));
					ls.setGo_out_notes_collat(req.getParameter("go_out_notes_collat"));
				}
				
				String get_help_check_collat = req.getParameter("get_help_check_collat");
				if(get_help_check_collat.equalsIgnoreCase("on"))
				{
					ls.setGet_help_collat(true);
					ls.setGet_help_success_collat(req.getParameter("get_help_success_collat"));
					ls.setGet_help_notes_collat(req.getParameter("get_help_notes_collat"));
				}
			}
		}
		else {
			ls.setCook_help(req.getParameter("cook_help"));
			ls.setCook_help_notes(req.getParameter("cook_help_notes"));
			
			String cooking_not_collat = req.getParameter("cooking_not_collat");
			if(cooking_not_collat.equalsIgnoreCase("shown")){
				ls.setCooking_not_collat(true);
				ls.setCook_help_collat(req.getParameter("cook_help_collat"));
				ls.setCook_help_notes_collat("cook_help_notes_collat");
			}
		}
		
		//Shopping
		String shopping_check = req.getParameter("shopping_check");
		if(shopping_check.equalsIgnoreCase("on"))
		{
			ls.setShop(true);
			
			String list_check = req.getParameter("list_check");
			if(list_check.equalsIgnoreCase("on")){
				ls.setList_check(true);
				ls.setList_success(req.getParameter("list_success"));
				ls.setList_notes(req.getParameter("list_notes"));
			}
			
			String small_shop_check = req.getParameter("small_shop_check");
			if(small_shop_check.equalsIgnoreCase("on")){
				ls.setSmall_shop_check(true);
				ls.setSmall_shop_success(req.getParameter("small_shop_success"));
				ls.setSmall_shop_notes(req.getParameter("small_shop_notes"));
			}
			
			//Collateral
			String shopping_collat = req.getParameter("shopping_collat");
			if(shopping_collat.equalsIgnoreCase("shown"))
			{
				ls.setShopping_collat(true);
				String list_check_collat = req.getParameter("list_check_collat");
				if(list_check_collat.equalsIgnoreCase("on")){
					ls.setList_check_collat(true);
					ls.setList_success_collat(req.getParameter("list_success_collat"));
					ls.setList_notes_collat(req.getParameter("list_notes_collat"));
				}
				
				String small_shop_check_collat = req.getParameter("small_shop_check_collat");
				if(small_shop_check_collat.equalsIgnoreCase("on")){
					ls.setSmall_shop_check_collat(true);
					ls.setSmall_shop_success_collat(req.getParameter("small_shop_success_collat"));
					ls.setSmall_shop_notes_collat(req.getParameter("small_shop_notes_collat"));
				}
			}			
		}
		else
		{
			ls.setShop_help(req.getParameter("shop_help"));
			ls.setShop_help_notes(req.getParameter("shop_help_notes"));
			ls.setShop_help_time(req.getParameter("shop_help_time"));
			ls.setShop_time_notes(req.getParameter("shop_time_notes"));
			
			String shopping_not_collat = req.getParameter("shopping_not_collat");
			if(shopping_not_collat.equalsIgnoreCase("shown"))
			{
				ls.setShopping_not_collat(true);
				ls.setShop_help_collat(req.getParameter("shop_help"));
				ls.setShop_help_notes_collat(req.getParameter("shop_help_notes"));
				ls.setShop_help_time_collat(req.getParameter("shop_help_time"));
				ls.setShop_time_notes_collat(req.getParameter("shop_time_notes"));
			}
		}
		
		//Bills
		ls.setBills_method(req.getParameter("bills_method"));
		ls.setBill_method_notes(req.getParameter("bill_method_notes"));
		ls.setBills_help(req.getParameter("bills_help"));
		ls.setBill_help_notes(req.getParameter("bill_help_notes"));
		ls.setBill_problems(req.getParameter("bills_problem"));
		ls.setBill_problem_notes(req.getParameter("bill_problem_notes"));
		
		String bills_collat = req.getParameter("bills_collat");
		if(bills_collat.equalsIgnoreCase("shown"))
		{
			ls.setBills_method_collat(req.getParameter("bills_method_collat"));
			ls.setBills_method_notes_collat(req.getParameter("bill_method_notes_collat"));
			ls.setBills_help_collat(req.getParameter("bills_help_collat"));
			ls.setBills_help_notes_collat(req.getParameter("bill_help_notes_collat"));
			ls.setBill_problems_collat(req.getParameter("bills_problem_collat"));
			ls.setBill_problems_notes_collat(req.getParameter("bill_problem_notes_collat"));
		}
	}
}
