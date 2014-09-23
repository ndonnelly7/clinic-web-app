package com.cloud.clinic.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * 
 * Test battery bean
 * 
 */

@Entity
public class TestBattery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testBatteryID", unique = true, nullable = false)
	int testBatteryID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Form form;
	
	//HADS
	@Expose
	String hads_wound_up, hads_enjoy, hads_frightened, hads_funny, hads_worry, hads_cheerful, hads_relaxed;
	@Expose
	String hads_slowed, hads_butterflies, hads_appearance, hads_restless, hads_enjoyment, hads_pasttime, hads_panic;
	@Expose
	String hads_total;
	
	
	//GDS
	@Expose
	String gds_satisfied, gds_dropping_interests, gds_life_empty, gds_bored, gds_future, gds_thoughts, gds_spirits;
	@Expose
	String gds_afraid, gds_happy, gds_helpless, gds_fidgety, gds_stay_home, gds_future_worry, gds_mem_problems, gds_alive;
	@Expose
	String gds_blue, gds_worthless, gds_exciting, gds_new_projects, gds_energy, gds_hopeless, gds_better_off, gds_little_things;
	@Expose
	String gds_crying, gds_concentrating, gds_morning, gds_social_occasions, gds_decisions, gds_clear_mind;
	@Expose
	String gds_total;
	
	//MOCA
	@Expose
	String moca_visuo, moca_attention, moca_language, moca_abstraction;
	@Expose
	String moca_naming, moca_recall, moca_orientation, moca_total;
	@Expose
	String MOCA_Upload;
	
	//MOCA_Blind
	@Expose
	String b_attention, b_language, b_abstract, b_recall;
	@Expose
	String b_orientation, b_moca_total, b_MOCA_Upload;
	
	//MMSE
	@Expose
	String mmse_orientation, mmse_registration, mmse_attention, mmse_recall;
	@Expose
	String mmse_language, mmse_copying, mmse_total, MMSE_Upload;

	@Transient
	protected Object[] jdoDetachedState;
	
	public TestBattery() {
		
	}

	public int getTestBatteryID() {
		return testBatteryID;
	}

	public void setTestBatteryID(int testBatteryID) {
		this.testBatteryID = testBatteryID;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getHads_wound_up() {
		return hads_wound_up;
	}

	public void setHads_wound_up(String hads_wound_up) {
		this.hads_wound_up = hads_wound_up;
	}

	public String getHads_enjoy() {
		return hads_enjoy;
	}

	public void setHads_enjoy(String hads_enjoy) {
		this.hads_enjoy = hads_enjoy;
	}

	public String getHads_frightened() {
		return hads_frightened;
	}

	public void setHads_frightened(String hads_frightened) {
		this.hads_frightened = hads_frightened;
	}

	public String getHads_funny() {
		return hads_funny;
	}

	public void setHads_funny(String hads_funny) {
		this.hads_funny = hads_funny;
	}

	public String getHads_worry() {
		return hads_worry;
	}

	public void setHads_worry(String hads_worry) {
		this.hads_worry = hads_worry;
	}

	public String getHads_cheerful() {
		return hads_cheerful;
	}

	public void setHads_cheerful(String hads_cheerful) {
		this.hads_cheerful = hads_cheerful;
	}

	public String getHads_relaxed() {
		return hads_relaxed;
	}

	public void setHads_relaxed(String hads_relaxed) {
		this.hads_relaxed = hads_relaxed;
	}

	public String getHads_slowed() {
		return hads_slowed;
	}

	public void setHads_slowed(String hads_slowed) {
		this.hads_slowed = hads_slowed;
	}

	public String getHads_butterflies() {
		return hads_butterflies;
	}

	public void setHads_butterflies(String hads_butterflies) {
		this.hads_butterflies = hads_butterflies;
	}

	public String getHads_appearance() {
		return hads_appearance;
	}

	public void setHads_appearance(String hads_appearance) {
		this.hads_appearance = hads_appearance;
	}

	public String getHads_restless() {
		return hads_restless;
	}

	public void setHads_restless(String hads_restless) {
		this.hads_restless = hads_restless;
	}

	public String getHads_enjoyment() {
		return hads_enjoyment;
	}

	public void setHads_enjoyment(String hads_enjoyment) {
		this.hads_enjoyment = hads_enjoyment;
	}

	public String getHads_pasttime() {
		return hads_pasttime;
	}

	public void setHads_pasttime(String hads_pasttime) {
		this.hads_pasttime = hads_pasttime;
	}

	public String getHads_panic() {
		return hads_panic;
	}

	public void setHads_panic(String hads_panic) {
		this.hads_panic = hads_panic;
	}

	public String getHads_total() {
		return hads_total;
	}

	public void setHads_total(String hads_total) {
		this.hads_total = hads_total;
	}

	public String getGds_satisfied() {
		return gds_satisfied;
	}

	public void setGds_satisfied(String gds_satisfied) {
		this.gds_satisfied = gds_satisfied;
	}

	public String getGds_dropping_interests() {
		return gds_dropping_interests;
	}

	public void setGds_dropping_interests(String gds_dropping_interests) {
		this.gds_dropping_interests = gds_dropping_interests;
	}

	public String getGds_life_empty() {
		return gds_life_empty;
	}

	public void setGds_life_empty(String gds_life_empty) {
		this.gds_life_empty = gds_life_empty;
	}

	public String getGds_bored() {
		return gds_bored;
	}

	public void setGds_bored(String gds_bored) {
		this.gds_bored = gds_bored;
	}

	public String getGds_future() {
		return gds_future;
	}

	public void setGds_future(String gds_future) {
		this.gds_future = gds_future;
	}

	public String getGds_thoughts() {
		return gds_thoughts;
	}

	public void setGds_thoughts(String gds_thoughts) {
		this.gds_thoughts = gds_thoughts;
	}

	public String getGds_spirits() {
		return gds_spirits;
	}

	public void setGds_spirits(String gds_spirits) {
		this.gds_spirits = gds_spirits;
	}

	public String getGds_afraid() {
		return gds_afraid;
	}

	public void setGds_afraid(String gds_afraid) {
		this.gds_afraid = gds_afraid;
	}

	public String getGds_happy() {
		return gds_happy;
	}

	public void setGds_happy(String gds_happy) {
		this.gds_happy = gds_happy;
	}

	public String getGds_helpless() {
		return gds_helpless;
	}

	public void setGds_helpless(String gds_helpless) {
		this.gds_helpless = gds_helpless;
	}

	public String getGds_fidgety() {
		return gds_fidgety;
	}

	public void setGds_fidgety(String gds_fidgety) {
		this.gds_fidgety = gds_fidgety;
	}

	public String getGds_stay_home() {
		return gds_stay_home;
	}

	public void setGds_stay_home(String gds_stay_home) {
		this.gds_stay_home = gds_stay_home;
	}

	public String getGds_future_worry() {
		return gds_future_worry;
	}

	public void setGds_future_worry(String gds_future_worry) {
		this.gds_future_worry = gds_future_worry;
	}

	public String getGds_mem_problems() {
		return gds_mem_problems;
	}

	public void setGds_mem_problems(String gds_mem_problems) {
		this.gds_mem_problems = gds_mem_problems;
	}

	public String getGds_alive() {
		return gds_alive;
	}

	public void setGds_alive(String gds_alive) {
		this.gds_alive = gds_alive;
	}

	public String getGds_blue() {
		return gds_blue;
	}

	public void setGds_blue(String gds_blue) {
		this.gds_blue = gds_blue;
	}

	public String getGds_worthless() {
		return gds_worthless;
	}

	public void setGds_worthless(String gds_worthless) {
		this.gds_worthless = gds_worthless;
	}

	public String getGds_exciting() {
		return gds_exciting;
	}

	public void setGds_exciting(String gds_exciting) {
		this.gds_exciting = gds_exciting;
	}

	public String getGds_new_projects() {
		return gds_new_projects;
	}

	public void setGds_new_projects(String gds_new_projects) {
		this.gds_new_projects = gds_new_projects;
	}

	public String getGds_energy() {
		return gds_energy;
	}

	public void setGds_energy(String gds_energy) {
		this.gds_energy = gds_energy;
	}

	public String getGds_hopeless() {
		return gds_hopeless;
	}

	public void setGds_hopeless(String gds_hopeless) {
		this.gds_hopeless = gds_hopeless;
	}

	public String getGds_better_off() {
		return gds_better_off;
	}

	public void setGds_better_off(String gds_better_off) {
		this.gds_better_off = gds_better_off;
	}

	public String getGds_little_things() {
		return gds_little_things;
	}

	public void setGds_little_things(String gds_little_things) {
		this.gds_little_things = gds_little_things;
	}

	public String getGds_crying() {
		return gds_crying;
	}

	public void setGds_crying(String gds_crying) {
		this.gds_crying = gds_crying;
	}

	public String getGds_concentrating() {
		return gds_concentrating;
	}

	public void setGds_concentrating(String gds_concentrating) {
		this.gds_concentrating = gds_concentrating;
	}

	public String getGds_morning() {
		return gds_morning;
	}

	public void setGds_morning(String gds_morning) {
		this.gds_morning = gds_morning;
	}

	public String getGds_social_occasions() {
		return gds_social_occasions;
	}

	public void setGds_social_occasions(String gds_social_occasions) {
		this.gds_social_occasions = gds_social_occasions;
	}

	public String getGds_decisions() {
		return gds_decisions;
	}

	public void setGds_decisions(String gds_decisions) {
		this.gds_decisions = gds_decisions;
	}

	public String getGds_clear_mind() {
		return gds_clear_mind;
	}

	public void setGds_clear_mind(String gds_clear_mind) {
		this.gds_clear_mind = gds_clear_mind;
	}

	public String getGds_total() {
		return gds_total;
	}

	public void setGds_total(String gds_total) {
		this.gds_total = gds_total;
	}

	public String getMoca_visuo() {
		return moca_visuo;
	}

	public void setMoca_visuo(String moca_visuo) {
		this.moca_visuo = moca_visuo;
	}

	public String getMoca_attention() {
		return moca_attention;
	}

	public void setMoca_attention(String moca_attention) {
		this.moca_attention = moca_attention;
	}

	public String getMoca_language() {
		return moca_language;
	}

	public void setMoca_language(String moca_language) {
		this.moca_language = moca_language;
	}

	public String getMoca_abstraction() {
		return moca_abstraction;
	}

	public void setMoca_abstraction(String moca_abstraction) {
		this.moca_abstraction = moca_abstraction;
	}

	public String getMoca_naming() {
		return moca_naming;
	}

	public void setMoca_naming(String moca_naming) {
		this.moca_naming = moca_naming;
	}

	public String getMoca_recall() {
		return moca_recall;
	}

	public void setMoca_recall(String moca_recall) {
		this.moca_recall = moca_recall;
	}

	public String getMoca_orientation() {
		return moca_orientation;
	}

	public void setMoca_orientation(String moca_orientation) {
		this.moca_orientation = moca_orientation;
	}

	public String getMoca_total() {
		return moca_total;
	}

	public void setMoca_total(String moca_total) {
		this.moca_total = moca_total;
	}

	public String getMOCA_Upload() {
		return MOCA_Upload;
	}

	public void setMOCA_Upload(String mOCA_Upload) {
		MOCA_Upload = mOCA_Upload;
	}

	public String getB_attention() {
		return b_attention;
	}

	public void setB_attention(String b_attention) {
		this.b_attention = b_attention;
	}

	public String getB_language() {
		return b_language;
	}

	public void setB_language(String b_language) {
		this.b_language = b_language;
	}

	public String getB_abstract() {
		return b_abstract;
	}

	public void setB_abstract(String b_abstract) {
		this.b_abstract = b_abstract;
	}

	public String getB_recall() {
		return b_recall;
	}

	public void setB_recall(String b_recall) {
		this.b_recall = b_recall;
	}

	public String getB_orientation() {
		return b_orientation;
	}

	public void setB_orientation(String b_orientation) {
		this.b_orientation = b_orientation;
	}

	public String getB_moca_total() {
		return b_moca_total;
	}

	public void setB_moca_total(String b_moca_total) {
		this.b_moca_total = b_moca_total;
	}

	public String getB_MOCA_Upload() {
		return b_MOCA_Upload;
	}

	public void setB_MOCA_Upload(String b_MOCA_Upload) {
		this.b_MOCA_Upload = b_MOCA_Upload;
	}

	public String getMmse_orientation() {
		return mmse_orientation;
	}

	public void setMmse_orientation(String mmse_orientation) {
		this.mmse_orientation = mmse_orientation;
	}

	public String getMmse_registration() {
		return mmse_registration;
	}

	public void setMmse_registration(String mmse_registration) {
		this.mmse_registration = mmse_registration;
	}

	public String getMmse_attention() {
		return mmse_attention;
	}

	public void setMmse_attention(String mmse_attention) {
		this.mmse_attention = mmse_attention;
	}

	public String getMmse_recall() {
		return mmse_recall;
	}

	public void setMmse_recall(String mmse_recall) {
		this.mmse_recall = mmse_recall;
	}

	public String getMmse_language() {
		return mmse_language;
	}

	public void setMmse_language(String mmse_language) {
		this.mmse_language = mmse_language;
	}

	public String getMmse_copying() {
		return mmse_copying;
	}

	public void setMmse_copying(String mmse_copying) {
		this.mmse_copying = mmse_copying;
	}

	public String getMmse_total() {
		return mmse_total;
	}

	public void setMmse_total(String mmse_total) {
		this.mmse_total = mmse_total;
	}

	public String getMMSE_Upload() {
		return MMSE_Upload;
	}

	public void setMMSE_Upload(String mMSE_Upload) {
		MMSE_Upload = mMSE_Upload;
	}
	
}
