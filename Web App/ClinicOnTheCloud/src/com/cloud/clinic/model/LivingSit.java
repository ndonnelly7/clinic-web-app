package com.cloud.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/*
 * Living Situation class for form
 */
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * 
 * Bean for Living Situation object
 * 
 */

@Entity
public class LivingSit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livingSitID", unique = true, nullable = false)
	private int livingSitID;

	@OneToOne(fetch = FetchType.LAZY)
	private Form form;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	//Lifestyle stuff
	@Expose
	String housemates, house_type, house_location;
	@Expose
	String housemates_collat, house_type_collat, house_location_collat;
	@Expose
	boolean carer, home_help, carer_collat, home_help_collat; 
	@Expose
	String is_carer, collat_is_carer, collat_getting_homehelp, getting_homehelp;
	@Expose
	@Column(columnDefinition="TEXT")
	String housemates_note;
	@Expose
	@Column(columnDefinition="TEXT")
	String house_type_note;
	@Expose
	@Column(columnDefinition="TEXT")
	String house_location_note;
	@Expose
	@Column(columnDefinition="TEXT")
	String home_help_note;
	@Expose
	@Column(columnDefinition="TEXT")
	String carer_note;
	@Expose
	@Column(columnDefinition="TEXT")
	String housemates_note_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String house_location_note_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String carer_note_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String home_help_note_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String house_type_note_collat;

	@Expose
	String drive, cook, shop, drive_collat, cooking_collat, shopping_collat;
	@Expose
	boolean life_collat, cooking_not_collat, shopping_not_collat, bills_collat;
	
	//Driving stuff
	@Expose
	boolean unknown_arrival, lost, tips;
	@Expose
	String unknown_arrival_severity, unknown_arrival_freq;
	@Expose
	String lost_severity, lost_freq;
	@Expose
	String tips_severity, tips_freq;
	@Expose
	boolean park_big, day_drive, known_places, take_friend, dry_run, map, take_phone;
	@Expose
	String park_big_success, day_drive_success;
	@Expose
	String known_places_success, take_friend_success;
	@Expose
	String dry_run_success, map_success, take_phone_success;
	@Expose
	String driving_other_incident, driving_other_severity, driving_other_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String driving_other_notes;
	@Expose
	String collat_driving_other_incident, collat_driving_other_severity, collat_driving_other_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String collat_driving_other_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String unknown_arrival_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String lost_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String tips_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String park_big_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String day_drive_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String known_places_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String take_friend_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String dry_run_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String map_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String take_phone_notes;
	
	@Expose
	@Column(columnDefinition="TEXT")
	String driving_notes;
	
	@Expose
	@Column(columnDefinition="TEXT")
	String driving_notes_collat;

	@Expose
	boolean unknown_arrival_collat, lost_collat, tips_collat;
	@Expose
	String unkown_arrival_severity_collat, unknown_arrival_freq_collat;
	@Expose
	String lost_severity_collat, lost_freq_collat;
	@Expose
	String tips_severity_collat, tips_freq_collat;
	@Expose
	boolean park_big_collat, day_drive_collat, known_places_collat, take_friend_collat, dry_run_collat, map_collat, take_phone_collat;
	@Expose
	String park_big_success_collat, day_drive_success_collat;
	@Expose
	String known_places_success_collat, take_friend_success_collat;
	@Expose
	String dry_run_success_collat, map_success_collat, take_phone_success_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String unknown_arrival_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String lost_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String tips_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String park_big_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String day_drive_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String known_places_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String take_friend_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String dry_run_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String map_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String take_phone_notes_collat;
	
	
	//Cooking
	//If does not cook
	@Expose
	String cook_help, cook_help_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String cook_help_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String cook_help_notes_collat;
	
	//If cooks
	//Problems
	@Expose
	boolean forgot_cooking, burnt_food, started_fire, smoke_alarm, undercooked;
	@Expose
	String forgot_cooking_freq, burnt_food_freq, started_fire_freq, smoke_alarm_freq;
	@Expose
	String undercooked_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String forgot_cooking_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String burnt_food_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String started_fire_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String smoke_alarm_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String undercooked_notes;
	@Expose
	String cooking_other_incident, cooking_other_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String cooking_other_notes;
	@Expose
	String collat_cooking_other_incident, collat_cooking_other_freq;
	@Expose
	@Column(columnDefinition="TEXT")
	String collat_cooking_other_notes;
	
	//Coping Strategies
	@Expose
	boolean timer, reminders, simple_cooking, salad, go_out, get_help;
	@Expose
	String timer_success, reminders_success, simple_cooking_success, salad_success, go_out_success, get_help_success;
	@Expose
	@Column(columnDefinition="TEXT")
	String timer_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String reminders_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String simple_cooking_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String salad_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String go_out_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String get_help_notes;
	
	//Collateral
	//Problems
	@Expose
	boolean forgot_cooking_collat, burnt_food_collat, started_fire_collat, smoke_alarm_collat, undercooked_collat;
	@Expose
	String forgot_cooking_freq_collat, burnt_food_freq_collat;
	@Expose
	String started_fire_freq_collat, smoke_alarm_freq_collat, undercooked_freq_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String forgot_cooking_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String burnt_food_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String started_fire_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String smoke_alarm_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String undercooked_notes_collat;
	
	//Coping Strategies
	@Expose
	boolean timer_collat, reminders_collat, simple_cooking_collat, salad_collat, go_out_collat, get_help_collat;
	@Expose
	String timer_success_collat, reminders_success_collat, simple_cooking_success_collat, salad_success_collat, go_out_success_collat, get_help_success_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String timer_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String reminders_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String simple_cooking_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String salad_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String go_out_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String get_help_notes_collat;

	//Shopping
	@Expose
	String shop_help, shop_help_time;
	@Expose
	String shop_help_collat, shop_help_time_collat;
	@Expose
	boolean list_check, small_shop_check, list_check_collat, small_shop_check_collat;
	@Expose
	String shopping_tougher, shopping_tougher_collat;
	@Expose
	String list_success, small_shop_success;
	@Expose
	String list_success_collat, small_shop_success_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String shop_help_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String shop_time_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String shop_help_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String shop_time_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String list_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String small_shop_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String list_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String small_shop_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String shop_tough_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String shop_tough_notes_collat;
	
	//Bills
	@Expose
	String bills_method, bills_help, bill_problems;
	@Expose
	String bills_method_collat, bills_help_collat, bill_problems_collat;
	@Expose
	String bills_method_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String  bills_help_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_problems_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_method_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_help_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_problem_notes;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_method_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_help_notes_collat;
	@Expose
	@Column(columnDefinition="TEXT")
	String bill_problem_notes_collat;
	
	@Expose
	String collat_drive, collat_cook, collat_shop, collat_bills, collat_homelife;
	
	public LivingSit()
	{
		
	}

	public int getLivingSitID() {
		return livingSitID;
	}

	public void setLivingSitID(int livingSitID) {
		this.livingSitID = livingSitID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getDriving_other_incident() {
		return driving_other_incident;
	}

	public void setDriving_other_incident(String driving_other_incident) {
		this.driving_other_incident = driving_other_incident;
	}

	public String getDriving_other_severity() {
		return driving_other_severity;
	}

	public void setDriving_other_severity(String driving_other_severity) {
		this.driving_other_severity = driving_other_severity;
	}

	public String getIs_carer() {
		return is_carer;
	}

	public void setIs_carer(String is_carer) {
		this.is_carer = is_carer;
	}

	public String getCollat_is_carer() {
		return collat_is_carer;
	}

	public void setCollat_is_carer(String collat_is_carer) {
		this.collat_is_carer = collat_is_carer;
	}

	public String getCollat_getting_homehelp() {
		return collat_getting_homehelp;
	}

	public void setCollat_getting_homehelp(String collat_getting_homehelp) {
		this.collat_getting_homehelp = collat_getting_homehelp;
	}

	public String getGetting_homehelp() {
		return getting_homehelp;
	}

	public void setGetting_homehelp(String getting_homehelp) {
		this.getting_homehelp = getting_homehelp;
	}

	public String getDriving_other_freq() {
		return driving_other_freq;
	}

	public void setDriving_other_freq(String driving_other_freq) {
		this.driving_other_freq = driving_other_freq;
	}

	public String getDriving_other_notes() {
		return driving_other_notes;
	}

	public void setDriving_other_notes(String driving_other_notes) {
		this.driving_other_notes = driving_other_notes;
	}

	public String getCollat_driving_other_incident() {
		return collat_driving_other_incident;
	}

	public void setCollat_driving_other_incident(
			String collat_driving_other_incident) {
		this.collat_driving_other_incident = collat_driving_other_incident;
	}

	public String getCollat_driving_other_severity() {
		return collat_driving_other_severity;
	}

	public void setCollat_driving_other_severity(
			String collat_driving_other_severity) {
		this.collat_driving_other_severity = collat_driving_other_severity;
	}

	public String getCollat_driving_other_freq() {
		return collat_driving_other_freq;
	}

	public void setCollat_driving_other_freq(String collat_driving_other_freq) {
		this.collat_driving_other_freq = collat_driving_other_freq;
	}

	public String getCollat_driving_other_notes() {
		return collat_driving_other_notes;
	}

	public void setCollat_driving_other_notes(String collat_driving_other_notes) {
		this.collat_driving_other_notes = collat_driving_other_notes;
	}

	public String getCooking_other_incident() {
		return cooking_other_incident;
	}

	public void setCooking_other_incident(String cooking_other_incident) {
		this.cooking_other_incident = cooking_other_incident;
	}

	public String getCooking_other_freq() {
		return cooking_other_freq;
	}

	public void setCooking_other_freq(String cooking_other_freq) {
		this.cooking_other_freq = cooking_other_freq;
	}

	public String getCooking_other_notes() {
		return cooking_other_notes;
	}

	public void setCooking_other_notes(String cooking_other_notes) {
		this.cooking_other_notes = cooking_other_notes;
	}

	public String getCollat_cooking_other_incident() {
		return collat_cooking_other_incident;
	}

	public void setCollat_cooking_other_incident(
			String collat_cooking_other_incident) {
		this.collat_cooking_other_incident = collat_cooking_other_incident;
	}

	public String getCollat_cooking_other_freq() {
		return collat_cooking_other_freq;
	}

	public void setCollat_cooking_other_freq(String collat_cooking_other_freq) {
		this.collat_cooking_other_freq = collat_cooking_other_freq;
	}

	public String getCollat_cooking_other_notes() {
		return collat_cooking_other_notes;
	}

	public void setCollat_cooking_other_notes(String collat_cooking_other_notes) {
		this.collat_cooking_other_notes = collat_cooking_other_notes;
	}

	public String getCollat_homelife() {
		return collat_homelife;
	}

	public void setCollat_homelife(String collat_homelife) {
		this.collat_homelife = collat_homelife;
	}

	public String getCollat_drive() {
		return collat_drive;
	}

	public String getCollat_cook() {
		return collat_cook;
	}

	public String getCollat_shop() {
		return collat_shop;
	}

	public String getCollat_bills() {
		return collat_bills;
	}

	public String isCollat_drive() {
		return collat_drive;
	}

	public void setCollat_drive(String collat_drive) {
		this.collat_drive = collat_drive;
	}

	public String isCollat_cook() {
		return collat_cook;
	}

	public void setCollat_cook(String collat_cook) {
		this.collat_cook = collat_cook;
	}

	public String isCollat_shop() {
		return collat_shop;
	}

	public void setCollat_shop(String collat_shop) {
		this.collat_shop = collat_shop;
	}

	public String isCollat_bills() {
		return collat_bills;
	}

	public void setCollat_bills(String collat_bills) {
		this.collat_bills = collat_bills;
	}

	public String getHousemates_note() {
		return housemates_note;
	}

	public void setHousemates_note(String housemates_note) {
		this.housemates_note = housemates_note;
	}

	public String getHousemates_note_collat() {
		return housemates_note_collat;
	}

	public void setHousemates_note_collat(String housemates_note_collat) {
		this.housemates_note_collat = housemates_note_collat;
	}

	public String getDriving_notes() {
		return driving_notes;
	}

	public void setDriving_notes(String driving_notes) {
		this.driving_notes = driving_notes;
	}

	public String getDriving_notes_collat() {
		return driving_notes_collat;
	}

	public void setDriving_notes_collat(String driving_notes_collat) {
		this.driving_notes_collat = driving_notes_collat;
	}

	public String getBill_method_notes_collat() {
		return bill_method_notes_collat;
	}

	public void setBill_method_notes_collat(String bill_method_notes_collat) {
		this.bill_method_notes_collat = bill_method_notes_collat;
	}

	public String getBill_help_notes_collat() {
		return bill_help_notes_collat;
	}

	public void setBill_help_notes_collat(String bill_help_notes_collat) {
		this.bill_help_notes_collat = bill_help_notes_collat;
	}

	public String getBill_problem_notes_collat() {
		return bill_problem_notes_collat;
	}

	public void setBill_problem_notes_collat(String bill_problem_notes_collat) {
		this.bill_problem_notes_collat = bill_problem_notes_collat;
	}

	public String getDrive() {
		return drive;
	}

	public String getCook() {
		return cook;
	}

	public String getShop() {
		return shop;
	}

	public String getDrive_collat() {
		return drive_collat;
	}

	public String getCooking_collat() {
		return cooking_collat;
	}

	public String getShopping_collat() {
		return shopping_collat;
	}

	public String getHousemates() {
		return housemates;
	}

	public void setHousemates(String housemates) {
		this.housemates = housemates;
	}

	public String getHousemate_note() {
		return housemates_note;
	}

	public void setHousemate_note(String housemate_note) {
		this.housemates_note = housemate_note;
	}

	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	public String getHouse_type_note() {
		return house_type_note;
	}

	public void setHouse_type_note(String house_type_note) {
		this.house_type_note = house_type_note;
	}

	public String getHouse_location() {
		return house_location;
	}

	public void setHouse_location(String house_location) {
		this.house_location = house_location;
	}

	public String getHouse_location_note() {
		return house_location_note;
	}

	public void setHouse_location_note(String house_location_note) {
		this.house_location_note = house_location_note;
	}

	public String getCarer_note() {
		return carer_note;
	}

	public void setCarer_note(String carer_note) {
		this.carer_note = carer_note;
	}

	public String getHome_help_note() {
		return home_help_note;
	}

	public void setHome_help_note(String home_help_note) {
		this.home_help_note = home_help_note;
	}

	public String getHousemates_collat() {
		return housemates_collat;
	}

	public void setHousemates_collat(String housemates_collat) {
		this.housemates_collat = housemates_collat;
	}

	public String getHousemate_note_collat() {
		return housemates_note_collat;
	}

	public void setHousemate_note_collat(String housemate_note_collat) {
		this.housemates_note_collat = housemate_note_collat;
	}

	public String getHouse_type_collat() {
		return house_type_collat;
	}

	public void setHouse_type_collat(String house_type_collat) {
		this.house_type_collat = house_type_collat;
	}

	public String getHouse_type_note_collat() {
		return house_type_note_collat;
	}

	public void setHouse_type_note_collat(String house_type_note_collat) {
		this.house_type_note_collat = house_type_note_collat;
	}

	public String getHouse_location_collat() {
		return house_location_collat;
	}

	public void setHouse_location_collat(String house_location_collat) {
		this.house_location_collat = house_location_collat;
	}

	public String getHouse_location_note_collat() {
		return house_location_note_collat;
	}

	public void setHouse_location_note_collat(String house_location_note_collat) {
		this.house_location_note_collat = house_location_note_collat;
	}

	public String getCarer_note_collat() {
		return carer_note_collat;
	}

	public void setCarer_note_collat(String carer_note_collat) {
		this.carer_note_collat = carer_note_collat;
	}

	public String getHome_help_note_collat() {
		return home_help_note_collat;
	}

	public void setHome_help_note_collat(String home_help_note_collat) {
		this.home_help_note_collat = home_help_note_collat;
	}

	public boolean isCarer() {
		return carer;
	}

	public void setCarer(boolean carer) {
		this.carer = carer;
	}

	public boolean isHome_help() {
		return home_help;
	}

	public void setHome_help(boolean home_help) {
		this.home_help = home_help;
	}

	public boolean isCarer_collat() {
		return carer_collat;
	}

	public void setCarer_collat(boolean carer_collat) {
		this.carer_collat = carer_collat;
	}

	public boolean isHome_help_collat() {
		return home_help_collat;
	}

	public void setHome_help_collat(boolean home_help_collat) {
		this.home_help_collat = home_help_collat;
	}

	public String isDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String isCook() {
		return cook;
	}

	public void setCook(String cook) {
		this.cook = cook;
	}

	public String isShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public boolean isLife_collat() {
		return life_collat;
	}

	public void setLife_collat(boolean life_collat) {
		this.life_collat = life_collat;
	}

	public String isDrive_collat() {
		return drive_collat;
	}

	public void setDrive_collat(String drive_collat) {
		this.drive_collat = drive_collat;
	}

	public String isCooking_collat() {
		return cooking_collat;
	}

	public void setCooking_collat(String cooking_collat) {
		this.cooking_collat = cooking_collat;
	}

	public String isShopping_collat() {
		return shopping_collat;
	}

	public void setShopping_collat(String shopping_collat) {
		this.shopping_collat = shopping_collat;
	}

	public boolean isCooking_not_collat() {
		return cooking_not_collat;
	}

	public void setCooking_not_collat(boolean cooking_not_collat) {
		this.cooking_not_collat = cooking_not_collat;
	}

	public boolean isShopping_not_collat() {
		return shopping_not_collat;
	}

	public void setShopping_not_collat(boolean shopping_not_collat) {
		this.shopping_not_collat = shopping_not_collat;
	}

	public boolean isBills_collat() {
		return bills_collat;
	}

	public void setBills_collat(boolean bills_collat) {
		this.bills_collat = bills_collat;
	}

	public boolean isUnknown_arrival() {
		return unknown_arrival;
	}

	public void setUnknown_arrival(boolean unknown_arrival) {
		this.unknown_arrival = unknown_arrival;
	}

	public boolean isLost() {
		return lost;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}

	public boolean isTips() {
		return tips;
	}

	public void setTips(boolean tips) {
		this.tips = tips;
	}

	public String getUnknown_arrival_severity() {
		return unknown_arrival_severity;
	}

	public void setUnknown_arrival_severity(String unknown_arrival_severity) {
		this.unknown_arrival_severity = unknown_arrival_severity;
	}

	public String getUnknown_arrival_freq() {
		return unknown_arrival_freq;
	}

	public void setUnknown_arrival_freq(String unknown_arrival_freq) {
		this.unknown_arrival_freq = unknown_arrival_freq;
	}

	public String getUnknown_arrival_notes() {
		return unknown_arrival_notes;
	}

	public void setUnknown_arrival_notes(String unknown_arrival_notes) {
		this.unknown_arrival_notes = unknown_arrival_notes;
	}

	public String getLost_severity() {
		return lost_severity;
	}

	public void setLost_severity(String lost_severity) {
		this.lost_severity = lost_severity;
	}

	public String getLost_freq() {
		return lost_freq;
	}

	public void setLost_freq(String lost_freq) {
		this.lost_freq = lost_freq;
	}

	public String getLost_notes() {
		return lost_notes;
	}

	public void setLost_notes(String lost_notes) {
		this.lost_notes = lost_notes;
	}

	public String getTips_severity() {
		return tips_severity;
	}

	public void setTips_severity(String tips_severity) {
		this.tips_severity = tips_severity;
	}

	public String getTips_freq() {
		return tips_freq;
	}

	public void setTips_freq(String tips_freq) {
		this.tips_freq = tips_freq;
	}

	public String getTips_notes() {
		return tips_notes;
	}

	public void setTips_notes(String tips_notes) {
		this.tips_notes = tips_notes;
	}

	public boolean isPark_big() {
		return park_big;
	}

	public void setPark_big(boolean park_big) {
		this.park_big = park_big;
	}

	public boolean isDay_drive() {
		return day_drive;
	}

	public void setDay_drive(boolean day_drive) {
		this.day_drive = day_drive;
	}

	public boolean isKnown_places() {
		return known_places;
	}

	public void setKnown_places(boolean known_places) {
		this.known_places = known_places;
	}

	public boolean isTake_friend() {
		return take_friend;
	}

	public void setTake_friend(boolean take_friend) {
		this.take_friend = take_friend;
	}

	public boolean isDry_run() {
		return dry_run;
	}

	public void setDry_run(boolean dry_run) {
		this.dry_run = dry_run;
	}

	public boolean isMap() {
		return map;
	}

	public void setMap(boolean map) {
		this.map = map;
	}

	public boolean isTake_phone() {
		return take_phone;
	}

	public void setTake_phone(boolean take_phone) {
		this.take_phone = take_phone;
	}

	public String getPark_big_success() {
		return park_big_success;
	}

	public void setPark_big_success(String park_big_success) {
		this.park_big_success = park_big_success;
	}

	public String getPark_big_notes() {
		return park_big_notes;
	}

	public void setPark_big_notes(String park_big_notes) {
		this.park_big_notes = park_big_notes;
	}

	public String getDay_drive_success() {
		return day_drive_success;
	}

	public void setDay_drive_success(String day_drive_success) {
		this.day_drive_success = day_drive_success;
	}

	public String getDay_drive_notes() {
		return day_drive_notes;
	}

	public void setDay_drive_notes(String day_drive_notes) {
		this.day_drive_notes = day_drive_notes;
	}

	public String getKnown_places_success() {
		return known_places_success;
	}

	public void setKnown_places_success(String known_places_success) {
		this.known_places_success = known_places_success;
	}

	public String getKnown_places_notes() {
		return known_places_notes;
	}

	public void setKnown_places_notes(String known_places_notes) {
		this.known_places_notes = known_places_notes;
	}

	public String getTake_friend_success() {
		return take_friend_success;
	}

	public void setTake_friend_success(String take_friend_success) {
		this.take_friend_success = take_friend_success;
	}

	public String getTake_friend_notes() {
		return take_friend_notes;
	}

	public void setTake_friend_notes(String take_friend_notes) {
		this.take_friend_notes = take_friend_notes;
	}

	public String getDry_run_success() {
		return dry_run_success;
	}

	public void setDry_run_success(String dry_run_success) {
		this.dry_run_success = dry_run_success;
	}

	public String getDry_run_notes() {
		return dry_run_notes;
	}

	public void setDry_run_notes(String dry_run_notes) {
		this.dry_run_notes = dry_run_notes;
	}

	public String getMap_success() {
		return map_success;
	}

	public void setMap_success(String map_success) {
		this.map_success = map_success;
	}

	public String getMap_notes() {
		return map_notes;
	}

	public void setMap_notes(String map_notes) {
		this.map_notes = map_notes;
	}

	public String getTake_phone_success() {
		return take_phone_success;
	}

	public void setTake_phone_success(String take_phone_success) {
		this.take_phone_success = take_phone_success;
	}

	public String getTake_phone_notes() {
		return take_phone_notes;
	}

	public void setTake_phone_notes(String take_phone_notes) {
		this.take_phone_notes = take_phone_notes;
	}

	public boolean isUnknown_arrival_collat() {
		return unknown_arrival_collat;
	}

	public void setUnknown_arrival_collat(boolean unknown_arrival_collat) {
		this.unknown_arrival_collat = unknown_arrival_collat;
	}

	public boolean isLost_collat() {
		return lost_collat;
	}

	public void setLost_collat(boolean lost_collat) {
		this.lost_collat = lost_collat;
	}

	public boolean isTips_collat() {
		return tips_collat;
	}

	public void setTips_collat(boolean tips_collat) {
		this.tips_collat = tips_collat;
	}

	public String getUnkown_arrival_severity_collat() {
		return unkown_arrival_severity_collat;
	}

	public void setUnkown_arrival_severity_collat(
			String unkown_arrival_severity_collat) {
		this.unkown_arrival_severity_collat = unkown_arrival_severity_collat;
	}

	public String getUnknown_arrival_freq_collat() {
		return unknown_arrival_freq_collat;
	}

	public void setUnknown_arrival_freq_collat(String unknown_arrival_freq_collat) {
		this.unknown_arrival_freq_collat = unknown_arrival_freq_collat;
	}

	public String getUnknown_arrival_notes_collat() {
		return unknown_arrival_notes_collat;
	}

	public void setUnknown_arrival_notes_collat(String unknown_arrival_notes_collat) {
		this.unknown_arrival_notes_collat = unknown_arrival_notes_collat;
	}

	public String getLost_severity_collat() {
		return lost_severity_collat;
	}

	public void setLost_severity_collat(String lost_severity_collat) {
		this.lost_severity_collat = lost_severity_collat;
	}

	public String getLost_freq_collat() {
		return lost_freq_collat;
	}

	public void setLost_freq_collat(String lost_freq_collat) {
		this.lost_freq_collat = lost_freq_collat;
	}

	public String getLost_notes_collat() {
		return lost_notes_collat;
	}

	public void setLost_notes_collat(String lost_notes_collat) {
		this.lost_notes_collat = lost_notes_collat;
	}

	public String getTips_severity_collat() {
		return tips_severity_collat;
	}

	public void setTips_severity_collat(String tips_severity_collat) {
		this.tips_severity_collat = tips_severity_collat;
	}

	public String getTips_freq_collat() {
		return tips_freq_collat;
	}

	public void setTips_freq_collat(String tips_freq_collat) {
		this.tips_freq_collat = tips_freq_collat;
	}

	public String getTips_notes_collat() {
		return tips_notes_collat;
	}

	public void setTips_notes_collat(String tips_notes_collat) {
		this.tips_notes_collat = tips_notes_collat;
	}

	public boolean isPark_big_collat() {
		return park_big_collat;
	}

	public void setPark_big_collat(boolean park_big_collat) {
		this.park_big_collat = park_big_collat;
	}

	public boolean isDay_drive_collat() {
		return day_drive_collat;
	}

	public void setDay_drive_collat(boolean day_drive_collat) {
		this.day_drive_collat = day_drive_collat;
	}

	public boolean isKnown_places_collat() {
		return known_places_collat;
	}

	public void setKnown_places_collat(boolean known_places_collat) {
		this.known_places_collat = known_places_collat;
	}

	public boolean isTake_friend_collat() {
		return take_friend_collat;
	}

	public void setTake_friend_collat(boolean take_friend_collat) {
		this.take_friend_collat = take_friend_collat;
	}

	public boolean isDry_run_collat() {
		return dry_run_collat;
	}

	public void setDry_run_collat(boolean dry_run_collat) {
		this.dry_run_collat = dry_run_collat;
	}

	public boolean isMap_collat() {
		return map_collat;
	}

	public void setMap_collat(boolean map_collat) {
		this.map_collat = map_collat;
	}

	public boolean isTake_phone_collat() {
		return take_phone_collat;
	}

	public void setTake_phone_collat(boolean take_phone_collat) {
		this.take_phone_collat = take_phone_collat;
	}

	public String getPark_big_success_collat() {
		return park_big_success_collat;
	}

	public void setPark_big_success_collat(String park_big_success_collat) {
		this.park_big_success_collat = park_big_success_collat;
	}

	public String getPark_big_notes_collat() {
		return park_big_notes_collat;
	}

	public void setPark_big_notes_collat(String park_big_notes_collat) {
		this.park_big_notes_collat = park_big_notes_collat;
	}

	public String getDay_drive_success_collat() {
		return day_drive_success_collat;
	}

	public void setDay_drive_success_collat(String day_drive_success_collat) {
		this.day_drive_success_collat = day_drive_success_collat;
	}

	public String getDay_drive_notes_collat() {
		return day_drive_notes_collat;
	}

	public void setDay_drive_notes_collat(String day_drive_notes_collat) {
		this.day_drive_notes_collat = day_drive_notes_collat;
	}

	public String getKnown_places_success_collat() {
		return known_places_success_collat;
	}

	public void setKnown_places_success_collat(String known_places_success_collat) {
		this.known_places_success_collat = known_places_success_collat;
	}

	public String getKnown_places_notes_collat() {
		return known_places_notes_collat;
	}

	public void setKnown_places_notes_collat(String known_places_notes_collat) {
		this.known_places_notes_collat = known_places_notes_collat;
	}

	public String getTake_friend_success_collat() {
		return take_friend_success_collat;
	}

	public void setTake_friend_success_collat(String take_friend_success_collat) {
		this.take_friend_success_collat = take_friend_success_collat;
	}

	public String getTake_friend_notes_collat() {
		return take_friend_notes_collat;
	}

	public void setTake_friend_notes_collat(String take_friend_notes_collat) {
		this.take_friend_notes_collat = take_friend_notes_collat;
	}

	public String getDry_run_success_collat() {
		return dry_run_success_collat;
	}

	public void setDry_run_success_collat(String dry_run_success_collat) {
		this.dry_run_success_collat = dry_run_success_collat;
	}

	public String getDry_run_notes_collat() {
		return dry_run_notes_collat;
	}

	public void setDry_run_notes_collat(String dry_run_notes_collat) {
		this.dry_run_notes_collat = dry_run_notes_collat;
	}

	public String getMap_success_collat() {
		return map_success_collat;
	}

	public void setMap_success_collat(String map_success_collat) {
		this.map_success_collat = map_success_collat;
	}

	public String getMap_notes_collat() {
		return map_notes_collat;
	}

	public void setMap_notes_collat(String map_notes_collat) {
		this.map_notes_collat = map_notes_collat;
	}

	public String getTake_phone_success_collat() {
		return take_phone_success_collat;
	}

	public void setTake_phone_success_collat(String take_phone_success_collat) {
		this.take_phone_success_collat = take_phone_success_collat;
	}

	public String getTake_phone_notes_collat() {
		return take_phone_notes_collat;
	}

	public void setTake_phone_notes_collat(String take_phone_notes_collat) {
		this.take_phone_notes_collat = take_phone_notes_collat;
	}

	public String getCook_help() {
		return cook_help;
	}

	public void setCook_help(String cook_help) {
		this.cook_help = cook_help;
	}

	public String getCook_help_notes() {
		return cook_help_notes;
	}

	public void setCook_help_notes(String cook_help_notes) {
		this.cook_help_notes = cook_help_notes;
	}

	public String getCook_help_collat() {
		return cook_help_collat;
	}

	public void setCook_help_collat(String cook_help_collat) {
		this.cook_help_collat = cook_help_collat;
	}

	public String getCook_help_notes_collat() {
		return cook_help_notes_collat;
	}

	public void setCook_help_notes_collat(String cook_help_notes_collat) {
		this.cook_help_notes_collat = cook_help_notes_collat;
	}

	public boolean isForgot_cooking() {
		return forgot_cooking;
	}

	public void setForgot_cooking(boolean forgot_cooking) {
		this.forgot_cooking = forgot_cooking;
	}

	public boolean isBurnt_food() {
		return burnt_food;
	}

	public void setBurnt_food(boolean burnt_food) {
		this.burnt_food = burnt_food;
	}

	public boolean isStarted_fire() {
		return started_fire;
	}

	public void setStarted_fire(boolean started_fire) {
		this.started_fire = started_fire;
	}

	public boolean isSmoke_alarm() {
		return smoke_alarm;
	}

	public void setSmoke_alarm(boolean smoke_alarm) {
		this.smoke_alarm = smoke_alarm;
	}

	public boolean isUndercooked() {
		return undercooked;
	}

	public void setUndercooked(boolean undercooked) {
		this.undercooked = undercooked;
	}

	public String getForgot_cooking_freq() {
		return forgot_cooking_freq;
	}

	public void setForgot_cooking_freq(String forgot_cooking_freq) {
		this.forgot_cooking_freq = forgot_cooking_freq;
	}

	public String getForgot_cooking_notes() {
		return forgot_cooking_notes;
	}

	public void setForgot_cooking_notes(String forgot_cooking_notes) {
		this.forgot_cooking_notes = forgot_cooking_notes;
	}

	public String getBurnt_food_freq() {
		return burnt_food_freq;
	}

	public void setBurnt_food_freq(String burnt_food_freq) {
		this.burnt_food_freq = burnt_food_freq;
	}

	public String getBurnt_food_notes() {
		return burnt_food_notes;
	}

	public void setBurnt_food_notes(String burnt_food_notes) {
		this.burnt_food_notes = burnt_food_notes;
	}

	public String getStarted_fire_freq() {
		return started_fire_freq;
	}

	public void setStarted_fire_freq(String started_fire_freq) {
		this.started_fire_freq = started_fire_freq;
	}

	public String getStarted_fire_notes() {
		return started_fire_notes;
	}

	public void setStarted_fire_notes(String started_fire_notes) {
		this.started_fire_notes = started_fire_notes;
	}

	public String getSmoke_alarm_freq() {
		return smoke_alarm_freq;
	}

	public void setSmoke_alarm_freq(String smoke_alarm_freq) {
		this.smoke_alarm_freq = smoke_alarm_freq;
	}

	public String getSmoke_alarm_notes() {
		return smoke_alarm_notes;
	}

	public void setSmoke_alarm_notes(String smoke_alarm_notes) {
		this.smoke_alarm_notes = smoke_alarm_notes;
	}

	public String getUndercooked_freq() {
		return undercooked_freq;
	}

	public void setUndercooked_freq(String undercooked_freq) {
		this.undercooked_freq = undercooked_freq;
	}

	public String getUndercooked_notes() {
		return undercooked_notes;
	}

	public void setUndercooked_notes(String undercooked_notes) {
		this.undercooked_notes = undercooked_notes;
	}

	public boolean isTimer() {
		return timer;
	}

	public void setTimer(boolean timer) {
		this.timer = timer;
	}

	public boolean isReminders() {
		return reminders;
	}

	public void setReminders(boolean reminders) {
		this.reminders = reminders;
	}

	public boolean isSimple_cooking() {
		return simple_cooking;
	}

	public void setSimple_cooking(boolean simple_cooking) {
		this.simple_cooking = simple_cooking;
	}

	public boolean isSalad() {
		return salad;
	}

	public void setSalad(boolean salad) {
		this.salad = salad;
	}

	public boolean isGo_out() {
		return go_out;
	}

	public void setGo_out(boolean go_out) {
		this.go_out = go_out;
	}

	public boolean isGet_help() {
		return get_help;
	}

	public void setGet_help(boolean get_help) {
		this.get_help = get_help;
	}

	public String getTimer_success() {
		return timer_success;
	}

	public void setTimer_success(String timer_success) {
		this.timer_success = timer_success;
	}

	public String getReminders_success() {
		return reminders_success;
	}

	public void setReminders_success(String reminders_success) {
		this.reminders_success = reminders_success;
	}

	public String getSimple_cooking_success() {
		return simple_cooking_success;
	}

	public void setSimple_cooking_success(String simple_cooking_success) {
		this.simple_cooking_success = simple_cooking_success;
	}

	public String getSalad_success() {
		return salad_success;
	}

	public void setSalad_success(String salad_success) {
		this.salad_success = salad_success;
	}

	public String getGo_out_success() {
		return go_out_success;
	}

	public void setGo_out_success(String go_out_success) {
		this.go_out_success = go_out_success;
	}

	public String getGet_help_success() {
		return get_help_success;
	}

	public void setGet_help_success(String get_help_success) {
		this.get_help_success = get_help_success;
	}

	public String getTimer_notes() {
		return timer_notes;
	}

	public void setTimer_notes(String timer_notes) {
		this.timer_notes = timer_notes;
	}

	public String getReminders_notes() {
		return reminders_notes;
	}

	public void setReminders_notes(String reminders_notes) {
		this.reminders_notes = reminders_notes;
	}

	public String getSimple_cooking_notes() {
		return simple_cooking_notes;
	}

	public void setSimple_cooking_notes(String simple_cooking_notes) {
		this.simple_cooking_notes = simple_cooking_notes;
	}

	public String getSalad_notes() {
		return salad_notes;
	}

	public void setSalad_notes(String salad_notes) {
		this.salad_notes = salad_notes;
	}

	public String getGo_out_notes() {
		return go_out_notes;
	}

	public void setGo_out_notes(String go_out_notes) {
		this.go_out_notes = go_out_notes;
	}

	public String getGet_help_notes() {
		return get_help_notes;
	}

	public void setGet_help_notes(String get_help_notes) {
		this.get_help_notes = get_help_notes;
	}

	public boolean isForgot_cooking_collat() {
		return forgot_cooking_collat;
	}

	public void setForgot_cooking_collat(boolean forgot_cooking_collat) {
		this.forgot_cooking_collat = forgot_cooking_collat;
	}

	public boolean isBurnt_food_collat() {
		return burnt_food_collat;
	}

	public void setBurnt_food_collat(boolean burnt_food_collat) {
		this.burnt_food_collat = burnt_food_collat;
	}

	public boolean isStarted_fire_collat() {
		return started_fire_collat;
	}

	public void setStarted_fire_collat(boolean started_fire_collat) {
		this.started_fire_collat = started_fire_collat;
	}

	public boolean isSmoke_alarm_collat() {
		return smoke_alarm_collat;
	}

	public void setSmoke_alarm_collat(boolean smoke_alarm_collat) {
		this.smoke_alarm_collat = smoke_alarm_collat;
	}

	public boolean isUndercooked_collat() {
		return undercooked_collat;
	}

	public void setUndercooked_collat(boolean undercooked_collat) {
		this.undercooked_collat = undercooked_collat;
	}

	public String getForgot_cooking_freq_collat() {
		return forgot_cooking_freq_collat;
	}

	public void setForgot_cooking_freq_collat(String forgot_cooking_freq_collat) {
		this.forgot_cooking_freq_collat = forgot_cooking_freq_collat;
	}

	public String getForgot_cooking_notes_collat() {
		return forgot_cooking_notes_collat;
	}

	public void setForgot_cooking_notes_collat(String forgot_cooking_notes_collat) {
		this.forgot_cooking_notes_collat = forgot_cooking_notes_collat;
	}

	public String getBurnt_food_freq_collat() {
		return burnt_food_freq_collat;
	}

	public void setBurnt_food_freq_collat(String burnt_food_freq_collat) {
		this.burnt_food_freq_collat = burnt_food_freq_collat;
	}

	public String getBurnt_food_notes_collat() {
		return burnt_food_notes_collat;
	}

	public void setBurnt_food_notes_collat(String burnt_food_notes_collat) {
		this.burnt_food_notes_collat = burnt_food_notes_collat;
	}

	public String getStarted_fire_freq_collat() {
		return started_fire_freq_collat;
	}

	public void setStarted_fire_freq_collat(String started_fire_freq_collat) {
		this.started_fire_freq_collat = started_fire_freq_collat;
	}

	public String getStarted_fire_notes_collat() {
		return started_fire_notes_collat;
	}

	public void setStarted_fire_notes_collat(String started_fire_notes_collat) {
		this.started_fire_notes_collat = started_fire_notes_collat;
	}

	public String getSmoke_alarm_freq_collat() {
		return smoke_alarm_freq_collat;
	}

	public void setSmoke_alarm_freq_collat(String smoke_alarm_freq_collat) {
		this.smoke_alarm_freq_collat = smoke_alarm_freq_collat;
	}

	public String getSmoke_alarm_notes_collat() {
		return smoke_alarm_notes_collat;
	}

	public void setSmoke_alarm_notes_collat(String smoke_alarm_notes_collat) {
		this.smoke_alarm_notes_collat = smoke_alarm_notes_collat;
	}

	public String getUndercooked_freq_collat() {
		return undercooked_freq_collat;
	}

	public void setUndercooked_freq_collat(String undercooked_freq_collat) {
		this.undercooked_freq_collat = undercooked_freq_collat;
	}

	public String getUndercooked_notes_collat() {
		return undercooked_notes_collat;
	}

	public void setUndercooked_notes_collat(String undercooked_notes_collat) {
		this.undercooked_notes_collat = undercooked_notes_collat;
	}

	public boolean isTimer_collat() {
		return timer_collat;
	}

	public void setTimer_collat(boolean timer_collat) {
		this.timer_collat = timer_collat;
	}

	public boolean isReminders_collat() {
		return reminders_collat;
	}

	public void setReminders_collat(boolean reminders_collat) {
		this.reminders_collat = reminders_collat;
	}

	public boolean isSimple_cooking_collat() {
		return simple_cooking_collat;
	}

	public void setSimple_cooking_collat(boolean simple_cooking_collat) {
		this.simple_cooking_collat = simple_cooking_collat;
	}

	public boolean isSalad_collat() {
		return salad_collat;
	}

	public void setSalad_collat(boolean salad_collat) {
		this.salad_collat = salad_collat;
	}

	public boolean isGo_out_collat() {
		return go_out_collat;
	}

	public void setGo_out_collat(boolean go_out_collat) {
		this.go_out_collat = go_out_collat;
	}

	public boolean isGet_help_collat() {
		return get_help_collat;
	}

	public void setGet_help_collat(boolean get_help_collat) {
		this.get_help_collat = get_help_collat;
	}

	public String getTimer_success_collat() {
		return timer_success_collat;
	}

	public void setTimer_success_collat(String timer_success_collat) {
		this.timer_success_collat = timer_success_collat;
	}

	public String getReminders_success_collat() {
		return reminders_success_collat;
	}

	public void setReminders_success_collat(String reminders_success_collat) {
		this.reminders_success_collat = reminders_success_collat;
	}

	public String getSimple_cooking_success_collat() {
		return simple_cooking_success_collat;
	}

	public void setSimple_cooking_success_collat(
			String simple_cooking_success_collat) {
		this.simple_cooking_success_collat = simple_cooking_success_collat;
	}

	public String getSalad_success_collat() {
		return salad_success_collat;
	}

	public void setSalad_success_collat(String salad_success_collat) {
		this.salad_success_collat = salad_success_collat;
	}

	public String getGo_out_success_collat() {
		return go_out_success_collat;
	}

	public void setGo_out_success_collat(String go_out_success_collat) {
		this.go_out_success_collat = go_out_success_collat;
	}

	public String getGet_help_success_collat() {
		return get_help_success_collat;
	}

	public void setGet_help_success_collat(String get_help_success_collat) {
		this.get_help_success_collat = get_help_success_collat;
	}

	public String getTimer_notes_collat() {
		return timer_notes_collat;
	}

	public void setTimer_notes_collat(String timer_notes_collat) {
		this.timer_notes_collat = timer_notes_collat;
	}

	public String getReminders_notes_collat() {
		return reminders_notes_collat;
	}

	public void setReminders_notes_collat(String reminders_notes_collat) {
		this.reminders_notes_collat = reminders_notes_collat;
	}

	public String getSimple_cooking_notes_collat() {
		return simple_cooking_notes_collat;
	}

	public void setSimple_cooking_notes_collat(String simple_cooking_notes_collat) {
		this.simple_cooking_notes_collat = simple_cooking_notes_collat;
	}

	public String getSalad_notes_collat() {
		return salad_notes_collat;
	}

	public void setSalad_notes_collat(String salad_notes_collat) {
		this.salad_notes_collat = salad_notes_collat;
	}

	public String getGo_out_notes_collat() {
		return go_out_notes_collat;
	}

	public void setGo_out_notes_collat(String go_out_notes_collat) {
		this.go_out_notes_collat = go_out_notes_collat;
	}

	public String getGet_help_notes_collat() {
		return get_help_notes_collat;
	}

	public void setGet_help_notes_collat(String get_help_notes_collat) {
		this.get_help_notes_collat = get_help_notes_collat;
	}

	public String getShop_help() {
		return shop_help;
	}

	public void setShop_help(String shop_help) {
		this.shop_help = shop_help;
	}

	public String getShop_help_notes() {
		return shop_help_notes;
	}

	public void setShop_help_notes(String shop_help_notes) {
		this.shop_help_notes = shop_help_notes;
	}

	public String getShop_help_time() {
		return shop_help_time;
	}

	public void setShop_help_time(String shop_help_time) {
		this.shop_help_time = shop_help_time;
	}

	public String getShop_time_notes() {
		return shop_time_notes;
	}

	public void setShop_time_notes(String shop_time_notes) {
		this.shop_time_notes = shop_time_notes;
	}

	public String getShop_help_collat() {
		return shop_help_collat;
	}

	public void setShop_help_collat(String shop_help_collat) {
		this.shop_help_collat = shop_help_collat;
	}

	public String getShop_help_notes_collat() {
		return shop_help_notes_collat;
	}

	public void setShop_help_notes_collat(String shop_help_notes_collat) {
		this.shop_help_notes_collat = shop_help_notes_collat;
	}

	public String getShop_help_time_collat() {
		return shop_help_time_collat;
	}

	public void setShop_help_time_collat(String shop_help_time_collat) {
		this.shop_help_time_collat = shop_help_time_collat;
	}

	public String getShop_time_notes_collat() {
		return shop_time_notes_collat;
	}

	public void setShop_time_notes_collat(String shop_time_notes_collat) {
		this.shop_time_notes_collat = shop_time_notes_collat;
	}

	public boolean isList_check() {
		return list_check;
	}

	public void setList_check(boolean list_check) {
		this.list_check = list_check;
	}

	public boolean isSmall_shop_check() {
		return small_shop_check;
	}

	public void setSmall_shop_check(boolean small_shop_check) {
		this.small_shop_check = small_shop_check;
	}

	public boolean isList_check_collat() {
		return list_check_collat;
	}

	public void setList_check_collat(boolean list_check_collat) {
		this.list_check_collat = list_check_collat;
	}

	public boolean isSmall_shop_check_collat() {
		return small_shop_check_collat;
	}

	public void setSmall_shop_check_collat(boolean small_shop_check_collat) {
		this.small_shop_check_collat = small_shop_check_collat;
	}

	public String getList_success() {
		return list_success;
	}

	public void setList_success(String list_success) {
		this.list_success = list_success;
	}

	public String getList_notes() {
		return list_notes;
	}

	public void setList_notes(String list_notes) {
		this.list_notes = list_notes;
	}

	public String getSmall_shop_success() {
		return small_shop_success;
	}

	public void setSmall_shop_success(String small_shop_success) {
		this.small_shop_success = small_shop_success;
	}

	public String getSmall_shop_notes() {
		return small_shop_notes;
	}

	public void setSmall_shop_notes(String small_shop_notes) {
		this.small_shop_notes = small_shop_notes;
	}

	public String getList_success_collat() {
		return list_success_collat;
	}

	public void setList_success_collat(String list_success_collat) {
		this.list_success_collat = list_success_collat;
	}

	public String getList_notes_collat() {
		return list_notes_collat;
	}

	public void setList_notes_collat(String list_notes_collat) {
		this.list_notes_collat = list_notes_collat;
	}

	public String getSmall_shop_success_collat() {
		return small_shop_success_collat;
	}

	public void setSmall_shop_success_collat(String small_shop_success_collat) {
		this.small_shop_success_collat = small_shop_success_collat;
	}

	public String getSmall_shop_notes_collat() {
		return small_shop_notes_collat;
	}

	public void setSmall_shop_notes_collat(String small_shop_notes_collat) {
		this.small_shop_notes_collat = small_shop_notes_collat;
	}

	public String getBills_method() {
		return bills_method;
	}

	public void setBills_method(String bills_method) {
		this.bills_method = bills_method;
	}

	public String getBills_help() {
		return bills_help;
	}

	public void setBills_help(String bills_help) {
		this.bills_help = bills_help;
	}

	public String getBill_problems() {
		return bill_problems;
	}

	public void setBill_problems(String bill_problems) {
		this.bill_problems = bill_problems;
	}

	public String getBill_method_notes() {
		return bill_method_notes;
	}

	public void setBill_method_notes(String bill_method_notes) {
		this.bill_method_notes = bill_method_notes;
	}

	public String getBill_help_notes() {
		return bill_help_notes;
	}

	public void setBill_help_notes(String bill_help_notes) {
		this.bill_help_notes = bill_help_notes;
	}

	public String getBill_problem_notes() {
		return bill_problem_notes;
	}

	public void setBill_problem_notes(String bill_problem_notes) {
		this.bill_problem_notes = bill_problem_notes;
	}

	public String getBills_method_collat() {
		return bills_method_collat;
	}

	public void setBills_method_collat(String bills_method_collat) {
		this.bills_method_collat = bills_method_collat;
	}

	public String getBills_help_collat() {
		return bills_help_collat;
	}

	public void setBills_help_collat(String bills_help_collat) {
		this.bills_help_collat = bills_help_collat;
	}

	public String getBill_problems_collat() {
		return bill_problems_collat;
	}

	public void setBill_problems_collat(String bill_problems_collat) {
		this.bill_problems_collat = bill_problems_collat;
	}

	public String getBills_method_notes_collat() {
		return bills_method_notes_collat;
	}

	public void setBills_method_notes_collat(String bills_method_notes_collat) {
		this.bills_method_notes_collat = bills_method_notes_collat;
	}

	public String getBills_help_notes_collat() {
		return bills_help_notes_collat;
	}

	public void setBills_help_notes_collat(String bills_help_notes_collat) {
		this.bills_help_notes_collat = bills_help_notes_collat;
	}

	public String getBill_problems_notes_collat() {
		return bill_problems_notes_collat;
	}

	public void setBill_problems_notes_collat(String bill_problems_notes_collat) {
		this.bill_problems_notes_collat = bill_problems_notes_collat;
	}

	public String getShopping_tougher() {
		return shopping_tougher;
	}

	public void setShopping_tougher(String shopping_tougher) {
		this.shopping_tougher = shopping_tougher;
	}

	public String getShopping_tougher_collat() {
		return shopping_tougher_collat;
	}

	public void setShopping_tougher_collat(String shopping_tougher_collat) {
		this.shopping_tougher_collat = shopping_tougher_collat;
	}

	public String getShop_tough_notes() {
		return shop_tough_notes;
	}

	public void setShop_tough_notes(String shop_tough_notes) {
		this.shop_tough_notes = shop_tough_notes;
	}

	public String getShop_tough_notes_collat() {
		return shop_tough_notes_collat;
	}

	public void setShop_tough_notes_collat(String shop_tough_notes_collat) {
		this.shop_tough_notes_collat = shop_tough_notes_collat;
	}
	
}
