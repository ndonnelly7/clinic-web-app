package project.beta.model;

public class LivingSit {

	private int pID;
	
	//Lifestyle stuff
	String housemates, housemate_note, house_type, house_type_not, house_location, house_location_note;
	String carer_note, home_help_note;
	String housemates_collat, housemate_note_collat, house_type_collat, house_type_note_collat;
	String house_location_collat, house_location_note_collat, carer_note_collat, home_help_note_collat;
	
	boolean carer, home_help, carer_collat, home_help_collat; 
	boolean drive, cook, shop;
	
	//Driving stuff
	boolean unknown_arrival, lost, tips;
	String unkown_arrival_severity, unknown_arrival_freq, unknown_arrival_notes;
	String lost_severity, lost_freq, lost_notes;
	String tips_severity, tips_freq, tips_notes;
	boolean park_big, day_drive, known_places, take_friend, dry_run, map, take_phone;
	String park_big_success, park_big_notes, day_drive_success, day_drive_notes;
	String known_places_success, known_places_notes, take_friend_success, take_friend_notes;
	String dry_run_success, dry_run_notes, map_success, map_notes, take_phone_success, take_phone_notes;
	
	boolean unknown_arrival_collat, lost_collat, tips_collat;
	String unkown_arrival_severity_collat, unknown_arrival_freq_collat, unknown_arrival_notes_collat;
	String lost_severity_collat, lost_freq_collat, lost_notes_collat;
	String tips_severity_collat, tips_freq_collat, tips_notes_collat;
	boolean park_big_collat, day_drive_collat, known_places_collat, take_friend_collat, dry_run_collat, map_collat, take_phone_collat;
	String park_big_success_collat, park_big_notes_collat, day_drive_success_collat, day_drive_notes_collat;
	String known_places_success_collat, known_places_notes_collat, take_friend_success_collat, take_friend_notes_collat;
	String dry_run_success_collat, dry_run_notes_collat, map_success_collat, map_notes_collat, take_phone_success_collat, take_phone_notes_collat;
	
	//Cooking
	//If does not cook
	String cook_help, cook_help_notes; 
	//If cooks
	//Problems
	boolean forgot_cooking, burnt_food, started_fire, smoke_alarm, undercooked;
	String forgot_cooking_freq, forgot_cooking_notes, burnt_food_freq, burnt_food_notes;
	String started_fire_freq, started_fire_notes, smoke_alarm_freq, smoke_alarm_notes;
	String undercooked_freq, undercooked_notes;
	//Coping Strategies
	boolean timer, reminders, simple_cooking, salad, go_out, get_help;
	String timer_success, reminders_success, simple_cooking_success, salad_success, go_out_success, get_help_success;
	String timer_notes, reminders_notes, simple_cooking_notes, salad_notes, go_out_notes, get_help_notes;
	
	//Collateral
	//Problems
	boolean forgot_cooking_collat, burnt_food_collat, started_fire_collat, smoke_alarm_collat, undercooked_collat;
	String forgot_cooking_freq_collat, forgot_cooking_notes_collat, burnt_food_freq_collat, burnt_food_notes_collat;
	String started_fire_freq_collat, started_fire_notes_collat, smoke_alarm_freq_collat, smoke_alarm_notes_collat;
	String undercooked_freq_collat, undercooked_notes_collat;
	//Coping Strategies
	boolean timer_collat, reminders_collat, simple_cooking_collat, salad_collat, go_out_collat, get_help_collat;
	String timer_success_collat, reminders_success_collat, simple_cooking_success_collat, salad_success_collat, go_out_success_collat, get_help_success_collat;
	String timer_notes_collat, reminders_notes_collat, simple_cooking_notes_collat, salad_notes_collat, go_out_notes_collat, get_help_notes_collat;

	//Shopping
	
	
	//Bills
	
	
	public LivingSit(int id)
	{
		pID = id;
	}
}