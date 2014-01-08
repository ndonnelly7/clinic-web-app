package project.beta.model;

import java.util.ArrayList;
/*
 * Class used for the representation of the Events and Activities page
 */

//TODO: Add the JPA stuff for this
public class EventsActivities {

	private int pID;
	
	boolean divorce, bereavement, moving_house, redundancy, family_disharmony;
	boolean other_disharmony, financial, retirement, job;
	
	boolean divorce_collat, bereavement_collat, moving_house_collat, redundancy_collat, family_disharmony_collat;
	boolean other_disharmony_collat, financial_collat, retirement_collat, job_collat;
	
	String other, other_time, other_notes;
	String divorce_time, divorce_notes;
	String bereavement_time, bereavement_notes;
	String moving_house_time, moving_house_notes;
	String redundancy_time, redundancy_notes;
	String family_disharmony_time, family_disharmony_notes;
	String other_disharmony_time, other_disharmony_notes;
	String financial_time, financial_notes;
	String retirement_time, retirement_notes;
	String job_time, job_notes;
	
	String other_collat, other_collat_time, other_collat_notes;
	String divorce_collat_time, divorce_collat_notes;
	String bereavement_collat_time, bereavement_collat_notes;
	String moving_house_collat_time, moving_house_collat_notes;
	String redundancy_collat_time, redundancy_collat_notes;
	String family_disharmony_collat_time, family_disharmony_collat_notes;
	String other_disharmony_collat_time, other_disharmony_collat_notes;
	String financial_collat_time, financial_collat_notes;
	String retirement_collat_time, retirement_collat_notes;
	String job_collat_time, job_collat_notes;
	
	private ArrayList<Activity> activities;
	private ArrayList<Activity> collat_activities;
	
	boolean anx_check, dep_check;
	String anx_time, anx_related, anx_notes;
	String dep_time, dep_related, dep_notes;
	
	public EventsActivities(int id) {
		pID = id;
		
		divorce = bereavement = moving_house = redundancy = family_disharmony = false;
		other_disharmony = financial = retirement = job = false;
		
		divorce_collat = bereavement_collat = moving_house_collat = redundancy_collat = family_disharmony_collat = false;
		other_disharmony_collat = financial_collat = retirement_collat = job_collat = false;
		
		other = other_time = other_notes = "";
		divorce_time = divorce_notes = "";
		bereavement_time = bereavement_notes = "";
		moving_house_time = moving_house_notes = "";
		redundancy_time = redundancy_notes = "";
		family_disharmony_time = family_disharmony_notes = "";
		other_disharmony_time = other_disharmony_notes = "";
		financial_time = financial_notes = "";
		retirement_time = retirement_notes = "";
		job_time = job_notes = "";
		
		other_collat = other_collat_time = other_collat_notes = "";
		divorce_collat_time = divorce_collat_notes = "";
		bereavement_collat_time = bereavement_collat_notes = "";
		moving_house_collat_time = moving_house_collat_notes = "";
		redundancy_collat_time = redundancy_collat_notes = "";
		family_disharmony_collat_time = family_disharmony_collat_notes = "";
		other_disharmony_collat_time = other_disharmony_collat_notes = "";
		financial_collat_time = financial_collat_notes = "";
		retirement_collat_time = retirement_collat_notes = "";
		job_collat_time = job_collat_notes = "";
		
		activities = new ArrayList<Activity>();
		collat_activities = new ArrayList<Activity>();
		
		anx_check = dep_check = false;
		anx_time = anx_related = anx_notes = "";
		dep_time = dep_related = dep_notes = "";
	}
	
	@Override
	public String toString() {
		return "EventsActivities [pID=" + pID + ", divorce=" + divorce
				+ ", bereavement=" + bereavement + ", moving_house="
				+ moving_house + ", redundancy=" + redundancy
				+ ", family_disharmony=" + family_disharmony
				+ ", other_disharmony=" + other_disharmony + ", financial="
				+ financial + ", retirement=" + retirement + ", job=" + job
				+ ", divorce_collat=" + divorce_collat
				+ ", bereavement_collat=" + bereavement_collat
				+ ", moving_house_collat=" + moving_house_collat
				+ ", redundancy_collat=" + redundancy_collat
				+ ", family_disharmony_collat=" + family_disharmony_collat
				+ ", other_disharmony_collat=" + other_disharmony_collat
				+ ", financial_collat=" + financial_collat
				+ ", retirement_collat=" + retirement_collat + ", job_collat="
				+ job_collat + ", other=" + other + ", other_time="
				+ other_time + ", other_notes=" + other_notes
				+ ", divorce_time=" + divorce_time + ", divorce_notes="
				+ divorce_notes + ", bereavement_time=" + bereavement_time
				+ ", bereavement_notes=" + bereavement_notes
				+ ", moving_house_time=" + moving_house_time
				+ ", moving_house_notes=" + moving_house_notes
				+ ", redundancy_time=" + redundancy_time
				+ ", redundancy_notes=" + redundancy_notes
				+ ", family_disharmony_time=" + family_disharmony_time
				+ ", family_disharmony_notes=" + family_disharmony_notes
				+ ", other_disharmony_time=" + other_disharmony_time
				+ ", other_disharmony_notes=" + other_disharmony_notes
				+ ", financial_time=" + financial_time + ", financial_notes="
				+ financial_notes + ", retirement_time=" + retirement_time
				+ ", retirement_notes=" + retirement_notes + ", job_time="
				+ job_time + ", job_notes=" + job_notes + ", other_collat="
				+ other_collat + ", other_collat_time=" + other_collat_time
				+ ", other_collat_notes=" + other_collat_notes
				+ ", divorce_collat_time=" + divorce_collat_time
				+ ", divorce_collat_notes=" + divorce_collat_notes
				+ ", bereavement_collat_time=" + bereavement_collat_time
				+ ", bereavement_collat_notes=" + bereavement_collat_notes
				+ ", moving_house_collat_time=" + moving_house_collat_time
				+ ", moving_house_collat_notes=" + moving_house_collat_notes
				+ ", redundancy_collat_time=" + redundancy_collat_time
				+ ", redundancy_collat_notes=" + redundancy_collat_notes
				+ ", family_disharmony_collat_time="
				+ family_disharmony_collat_time
				+ ", family_disharmony_collat_notes="
				+ family_disharmony_collat_notes
				+ ", other_disharmony_collat_time="
				+ other_disharmony_collat_time
				+ ", other_disharmony_collat_notes="
				+ other_disharmony_collat_notes + ", financial_collat_time="
				+ financial_collat_time + ", financial_collat_notes="
				+ financial_collat_notes + ", retirement_collat_time="
				+ retirement_collat_time + ", retirement_collat_notes="
				+ retirement_collat_notes + ", job_collat_time="
				+ job_collat_time + ", job_collat_notes=" + job_collat_notes
				+ ", activities=" + activities + ", collat_activities="
				+ collat_activities + ", anx_check=" + anx_check
				+ ", dep_check=" + dep_check + ", anx_time=" + anx_time
				+ ", anx_related=" + anx_related + ", anx_notes=" + anx_notes
				+ ", dep_time=" + dep_time + ", dep_related=" + dep_related
				+ ", dep_notes=" + dep_notes + "]";
	}

	public boolean isDivorce() {
		return divorce;
	}

	public void setDivorce(boolean divorce) {
		this.divorce = divorce;
	}

	public boolean isBereavement() {
		return bereavement;
	}

	public void setBereavement(boolean bereavement) {
		this.bereavement = bereavement;
	}

	public boolean isMoving_house() {
		return moving_house;
	}

	public void setMoving_house(boolean moving_house) {
		this.moving_house = moving_house;
	}

	public boolean isRedundancy() {
		return redundancy;
	}

	public void setRedundancy(boolean redundancy) {
		this.redundancy = redundancy;
	}

	public boolean isFamily_disharmony() {
		return family_disharmony;
	}

	public void setFamily_disharmony(boolean family_disharmony) {
		this.family_disharmony = family_disharmony;
	}

	public boolean isOther_disharmony() {
		return other_disharmony;
	}

	public void setOther_disharmony(boolean other_disharmony) {
		this.other_disharmony = other_disharmony;
	}

	public boolean isFinancial() {
		return financial;
	}

	public void setFinancial(boolean financial) {
		this.financial = financial;
	}

	public boolean isRetirement() {
		return retirement;
	}

	public void setRetirement(boolean retirement) {
		this.retirement = retirement;
	}

	public boolean isJob() {
		return job;
	}

	public void setJob(boolean job) {
		this.job = job;
	}

	public boolean isDivorce_collat() {
		return divorce_collat;
	}

	public void setDivorce_collat(boolean divorce_collat) {
		this.divorce_collat = divorce_collat;
	}

	public boolean isBereavement_collat() {
		return bereavement_collat;
	}

	public void setBereavement_collat(boolean bereavement_collat) {
		this.bereavement_collat = bereavement_collat;
	}

	public boolean isMoving_house_collat() {
		return moving_house_collat;
	}

	public void setMoving_house_collat(boolean moving_house_collat) {
		this.moving_house_collat = moving_house_collat;
	}

	public boolean isRedundancy_collat() {
		return redundancy_collat;
	}

	public void setRedundancy_collat(boolean redundancy_collat) {
		this.redundancy_collat = redundancy_collat;
	}

	public boolean isFamily_disharmony_collat() {
		return family_disharmony_collat;
	}

	public void setFamily_disharmony_collat(boolean family_disharmony_collat) {
		this.family_disharmony_collat = family_disharmony_collat;
	}

	public boolean isOther_disharmony_collat() {
		return other_disharmony_collat;
	}

	public void setOther_disharmony_collat(boolean other_disharmony_collat) {
		this.other_disharmony_collat = other_disharmony_collat;
	}

	public boolean isFinancial_collat() {
		return financial_collat;
	}

	public void setFinancial_collat(boolean financial_collat) {
		this.financial_collat = financial_collat;
	}

	public boolean isRetirement_collat() {
		return retirement_collat;
	}

	public void setRetirement_collat(boolean retirement_collat) {
		this.retirement_collat = retirement_collat;
	}

	public boolean isJob_collat() {
		return job_collat;
	}

	public void setJob_collat(boolean job_collat) {
		this.job_collat = job_collat;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getOther_time() {
		return other_time;
	}

	public void setOther_time(String other_time) {
		this.other_time = other_time;
	}

	public String getOther_notes() {
		return other_notes;
	}

	public void setOther_notes(String other_notes) {
		this.other_notes = other_notes;
	}

	public String getDivorce_time() {
		return divorce_time;
	}

	public void setDivorce_time(String divorce_time) {
		this.divorce_time = divorce_time;
	}

	public String getDivorce_notes() {
		return divorce_notes;
	}

	public void setDivorce_notes(String divorce_notes) {
		this.divorce_notes = divorce_notes;
	}

	public String getBereavement_time() {
		return bereavement_time;
	}

	public void setBereavement_time(String bereavement_time) {
		this.bereavement_time = bereavement_time;
	}

	public String getBereavement_notes() {
		return bereavement_notes;
	}

	public void setBereavement_notes(String bereavement_notes) {
		this.bereavement_notes = bereavement_notes;
	}

	public String getMoving_house_time() {
		return moving_house_time;
	}

	public void setMoving_house_time(String moving_house_time) {
		this.moving_house_time = moving_house_time;
	}

	public String getMoving_house_notes() {
		return moving_house_notes;
	}

	public void setMoving_house_notes(String moving_house_notes) {
		this.moving_house_notes = moving_house_notes;
	}

	public String getRedundancy_time() {
		return redundancy_time;
	}

	public void setRedundancy_time(String redundancy_time) {
		this.redundancy_time = redundancy_time;
	}

	public String getRedundancy_notes() {
		return redundancy_notes;
	}

	public void setRedundancy_notes(String redundancy_notes) {
		this.redundancy_notes = redundancy_notes;
	}

	public String getFamily_disharmony_time() {
		return family_disharmony_time;
	}

	public void setFamily_disharmony_time(String family_disharmony_time) {
		this.family_disharmony_time = family_disharmony_time;
	}

	public String getFamily_disharmony_notes() {
		return family_disharmony_notes;
	}

	public void setFamily_disharmony_notes(String family_disharmony_notes) {
		this.family_disharmony_notes = family_disharmony_notes;
	}

	public String getOther_disharmony_time() {
		return other_disharmony_time;
	}

	public void setOther_disharmony_time(String other_disharmony_time) {
		this.other_disharmony_time = other_disharmony_time;
	}

	public String getOther_disharmony_notes() {
		return other_disharmony_notes;
	}

	public void setOther_disharmony_notes(String other_disharmony_notes) {
		this.other_disharmony_notes = other_disharmony_notes;
	}

	public String getFinancial_time() {
		return financial_time;
	}

	public void setFinancial_time(String financial_time) {
		this.financial_time = financial_time;
	}

	public String getFinancial_notes() {
		return financial_notes;
	}

	public void setFinancial_notes(String financial_notes) {
		this.financial_notes = financial_notes;
	}

	public String getRetirement_time() {
		return retirement_time;
	}

	public void setRetirement_time(String retirement_time) {
		this.retirement_time = retirement_time;
	}

	public String getRetirement_notes() {
		return retirement_notes;
	}

	public void setRetirement_notes(String retirement_notes) {
		this.retirement_notes = retirement_notes;
	}

	public String getJob_time() {
		return job_time;
	}

	public void setJob_time(String job_time) {
		this.job_time = job_time;
	}

	public String getJob_notes() {
		return job_notes;
	}

	public void setJob_notes(String job_notes) {
		this.job_notes = job_notes;
	}

	public String getOther_collat() {
		return other_collat;
	}

	public void setOther_collat(String other_collat) {
		this.other_collat = other_collat;
	}

	public String getOther_collat_time() {
		return other_collat_time;
	}

	public void setOther_collat_time(String other_collat_time) {
		this.other_collat_time = other_collat_time;
	}

	public String getOther_collat_notes() {
		return other_collat_notes;
	}

	public void setOther_collat_notes(String other_collat_notes) {
		this.other_collat_notes = other_collat_notes;
	}

	public String getDivorce_collat_time() {
		return divorce_collat_time;
	}

	public void setDivorce_collat_time(String divorce_collat_time) {
		this.divorce_collat_time = divorce_collat_time;
	}

	public String getDivorce_collat_notes() {
		return divorce_collat_notes;
	}

	public void setDivorce_collat_notes(String divorce_collat_notes) {
		this.divorce_collat_notes = divorce_collat_notes;
	}

	public String getBereavement_collat_time() {
		return bereavement_collat_time;
	}

	public void setBereavement_collat_time(String bereavement_collat_time) {
		this.bereavement_collat_time = bereavement_collat_time;
	}

	public String getBereavement_collat_notes() {
		return bereavement_collat_notes;
	}

	public void setBereavement_collat_notes(String bereavement_collat_notes) {
		this.bereavement_collat_notes = bereavement_collat_notes;
	}

	public String getMoving_house_collat_time() {
		return moving_house_collat_time;
	}

	public void setMoving_house_collat_time(String moving_house_collat_time) {
		this.moving_house_collat_time = moving_house_collat_time;
	}

	public String getMoving_house_collat_notes() {
		return moving_house_collat_notes;
	}

	public void setMoving_house_collat_notes(String moving_house_collat_notes) {
		this.moving_house_collat_notes = moving_house_collat_notes;
	}

	public String getRedundancy_collat_time() {
		return redundancy_collat_time;
	}

	public void setRedundancy_collat_time(String redundancy_collat_time) {
		this.redundancy_collat_time = redundancy_collat_time;
	}

	public String getRedundancy_collat_notes() {
		return redundancy_collat_notes;
	}

	public void setRedundancy_collat_notes(String redundancy_collat_notes) {
		this.redundancy_collat_notes = redundancy_collat_notes;
	}

	public String getFamily_disharmony_collat_time() {
		return family_disharmony_collat_time;
	}

	public void setFamily_disharmony_collat_time(
			String family_disharmony_collat_time) {
		this.family_disharmony_collat_time = family_disharmony_collat_time;
	}

	public String getFamily_disharmony_collat_notes() {
		return family_disharmony_collat_notes;
	}

	public void setFamily_disharmony_collat_notes(
			String family_disharmony_collat_notes) {
		this.family_disharmony_collat_notes = family_disharmony_collat_notes;
	}

	public String getOther_disharmony_collat_time() {
		return other_disharmony_collat_time;
	}

	public void setOther_disharmony_collat_time(String other_disharmony_collat_time) {
		this.other_disharmony_collat_time = other_disharmony_collat_time;
	}

	public String getOther_disharmony_collat_notes() {
		return other_disharmony_collat_notes;
	}

	public void setOther_disharmony_collat_notes(
			String other_disharmony_collat_notes) {
		this.other_disharmony_collat_notes = other_disharmony_collat_notes;
	}

	public String getFinancial_collat_time() {
		return financial_collat_time;
	}

	public void setFinancial_collat_time(String financial_collat_time) {
		this.financial_collat_time = financial_collat_time;
	}

	public String getFinancial_collat_notes() {
		return financial_collat_notes;
	}

	public void setFinancial_collat_notes(String financial_collat_notes) {
		this.financial_collat_notes = financial_collat_notes;
	}

	public String getRetirement_collat_time() {
		return retirement_collat_time;
	}

	public void setRetirement_collat_time(String retirement_collat_time) {
		this.retirement_collat_time = retirement_collat_time;
	}

	public String getRetirement_collat_notes() {
		return retirement_collat_notes;
	}

	public void setRetirement_collat_notes(String retirement_collat_notes) {
		this.retirement_collat_notes = retirement_collat_notes;
	}

	public String getJob_collat_time() {
		return job_collat_time;
	}

	public void setJob_collat_time(String job_collat_time) {
		this.job_collat_time = job_collat_time;
	}

	public String getJob_collat_notes() {
		return job_collat_notes;
	}

	public void setJob_collat_notes(String job_collat_notes) {
		this.job_collat_notes = job_collat_notes;
	}

	public boolean isAnx_check() {
		return anx_check;
	}

	public void setAnx_check(boolean anx_check) {
		this.anx_check = anx_check;
	}

	public boolean isDep_check() {
		return dep_check;
	}

	public void setDep_check(boolean dep_check) {
		this.dep_check = dep_check;
	}

	public String getAnx_time() {
		return anx_time;
	}

	public void setAnx_time(String anx_time) {
		this.anx_time = anx_time;
	}

	public String getAnx_related() {
		return anx_related;
	}

	public void setAnx_related(String anx_related) {
		this.anx_related = anx_related;
	}

	public String getAnx_notes() {
		return anx_notes;
	}

	public void setAnx_notes(String anx_notes) {
		this.anx_notes = anx_notes;
	}

	public String getDep_time() {
		return dep_time;
	}

	public void setDep_time(String dep_time) {
		this.dep_time = dep_time;
	}

	public String getDep_related() {
		return dep_related;
	}

	public void setDep_related(String dep_related) {
		this.dep_related = dep_related;
	}

	public String getDep_notes() {
		return dep_notes;
	}

	public void setDep_notes(String dep_notes) {
		this.dep_notes = dep_notes;
	}

	public int getpID() {
		return pID;
	}

	public void addActivity(Activity a)
	{
		activities.add(a);
	}
	
	public void addCollatActivity(Activity a)
	{
		collat_activities.add(a);
	}
}
