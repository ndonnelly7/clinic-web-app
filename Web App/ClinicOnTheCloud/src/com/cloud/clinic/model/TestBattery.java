package com.cloud.clinic.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class TestBattery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testBatteryID", unique = true, nullable = false)
	int testBatteryID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Patient patient;
	
	//HADS
	String wound_up, enjoy, frightened, funny, worry, cheerful, relaxed;
	String slowed, butterflies, appearance, restless, enjoyment, pasttime, panic;
	
	
	//GDS
	String satisfied, dropping_interests, life_empty, bored, future, thoughts, spirits;
	String afraid, happy, helpless, fidgety, stay_home, future_worry, mem_problems, alive;
	String blue, worthless, exciting, new_projects, energy, hopeless, better_off, little_things;
	String crying, concentrating, morning, social_occasions, decisions, clear_mind;
	
	//MOCA
	String visuo, attention, language, abstraction;
	String naming, recall, orientation, moca_total;
	String MOCA_Upload;
	
	//MOCA_Blind
	String b_attention, b_language, b_abstract, b_recall;
	String b_orientation, b_moca_total, b_MOCA_Upload;
	
	//MMSE
	String mmse_orientation, mmse_registration, mmse_attention, mmse_recall;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getWound_up() {
		return wound_up;
	}

	public void setWound_up(String wound_up) {
		this.wound_up = wound_up;
	}

	public String getEnjoy() {
		return enjoy;
	}

	public void setEnjoy(String enjoy) {
		this.enjoy = enjoy;
	}

	public String getFrightened() {
		return frightened;
	}

	public void setFrightened(String frightened) {
		this.frightened = frightened;
	}

	public String getFunny() {
		return funny;
	}

	public void setFunny(String funny) {
		this.funny = funny;
	}

	public String getWorry() {
		return worry;
	}

	public void setWorry(String worry) {
		this.worry = worry;
	}

	public String getCheerful() {
		return cheerful;
	}

	public void setCheerful(String cheerful) {
		this.cheerful = cheerful;
	}

	public String getRelaxed() {
		return relaxed;
	}

	public void setRelaxed(String relaxed) {
		this.relaxed = relaxed;
	}

	public String getSlowed() {
		return slowed;
	}

	public void setSlowed(String slowed) {
		this.slowed = slowed;
	}

	public String getButterflies() {
		return butterflies;
	}

	public void setButterflies(String butterflies) {
		this.butterflies = butterflies;
	}

	public String getAppearance() {
		return appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public String getRestless() {
		return restless;
	}

	public void setRestless(String restless) {
		this.restless = restless;
	}

	public String getEnjoyment() {
		return enjoyment;
	}

	public void setEnjoyment(String enjoyment) {
		this.enjoyment = enjoyment;
	}

	public String getPasttime() {
		return pasttime;
	}

	public void setPasttime(String pasttime) {
		this.pasttime = pasttime;
	}

	public String getPanic() {
		return panic;
	}

	public void setPanic(String panic) {
		this.panic = panic;
	}

	public String getSatisfied() {
		return satisfied;
	}

	public void setSatisfied(String satisfied) {
		this.satisfied = satisfied;
	}

	public String getDropping_interests() {
		return dropping_interests;
	}

	public void setDropping_interests(String dropping_interests) {
		this.dropping_interests = dropping_interests;
	}

	public String getLife_empty() {
		return life_empty;
	}

	public void setLife_empty(String life_empty) {
		this.life_empty = life_empty;
	}

	public String getBored() {
		return bored;
	}

	public void setBored(String bored) {
		this.bored = bored;
	}

	public String getFuture() {
		return future;
	}

	public void setFuture(String future) {
		this.future = future;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public String getSpirits() {
		return spirits;
	}

	public void setSpirits(String spirits) {
		this.spirits = spirits;
	}

	public String getAfraid() {
		return afraid;
	}

	public void setAfraid(String afraid) {
		this.afraid = afraid;
	}

	public String getHappy() {
		return happy;
	}

	public void setHappy(String happy) {
		this.happy = happy;
	}

	public String getHelpless() {
		return helpless;
	}

	public void setHelpless(String helpless) {
		this.helpless = helpless;
	}

	public String getFidgety() {
		return fidgety;
	}

	public void setFidgety(String fidgety) {
		this.fidgety = fidgety;
	}

	public String getStay_home() {
		return stay_home;
	}

	public void setStay_home(String stay_home) {
		this.stay_home = stay_home;
	}

	public String getFuture_worry() {
		return future_worry;
	}

	public void setFuture_worry(String future_worry) {
		this.future_worry = future_worry;
	}

	public String getMem_problems() {
		return mem_problems;
	}

	public void setMem_problems(String mem_problems) {
		this.mem_problems = mem_problems;
	}

	public String getAlive() {
		return alive;
	}

	public void setAlive(String alive) {
		this.alive = alive;
	}

	public String getBlue() {
		return blue;
	}

	public void setBlue(String blue) {
		this.blue = blue;
	}

	public String getWorthless() {
		return worthless;
	}

	public void setWorthless(String worthless) {
		this.worthless = worthless;
	}

	public String getExciting() {
		return exciting;
	}

	public void setExciting(String exciting) {
		this.exciting = exciting;
	}

	public String getNew_projects() {
		return new_projects;
	}

	public void setNew_projects(String new_projects) {
		this.new_projects = new_projects;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getHopeless() {
		return hopeless;
	}

	public void setHopeless(String hopeless) {
		this.hopeless = hopeless;
	}

	public String getBetter_off() {
		return better_off;
	}

	public void setBetter_off(String better_off) {
		this.better_off = better_off;
	}

	public String getLittle_things() {
		return little_things;
	}

	public void setLittle_things(String little_things) {
		this.little_things = little_things;
	}

	public String getCrying() {
		return crying;
	}

	public void setCrying(String crying) {
		this.crying = crying;
	}

	public String getConcentrating() {
		return concentrating;
	}

	public void setConcentrating(String concentrating) {
		this.concentrating = concentrating;
	}

	public String getMorning() {
		return morning;
	}

	public void setMorning(String morning) {
		this.morning = morning;
	}

	public String getSocial_occasions() {
		return social_occasions;
	}

	public void setSocial_occasions(String social_occasions) {
		this.social_occasions = social_occasions;
	}

	public String getDecisions() {
		return decisions;
	}

	public void setDecisions(String decisions) {
		this.decisions = decisions;
	}

	public String getClear_mind() {
		return clear_mind;
	}

	public void setClear_mind(String clear_mind) {
		this.clear_mind = clear_mind;
	}

	public String getVisuo() {
		return visuo;
	}

	public void setVisuo(String visuo) {
		this.visuo = visuo;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAbstraction() {
		return abstraction;
	}

	public void setAbstraction(String abstraction) {
		this.abstraction = abstraction;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getRecall() {
		return recall;
	}

	public void setRecall(String recall) {
		this.recall = recall;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
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
