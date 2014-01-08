package project.beta.model;

import java.util.ArrayList;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class PatientHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key key;
	
	int pID;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	ArrayList<MedHistory> med_histories, med_collat_histories;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	ArrayList<DrugHistory> drug_histories, drug_collat_histories;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	ArrayList<PsychHistory> psych_histories, psych_collat_histories;
	
	String current_therapy_check, past_therapy_check;
	String collat_current_therapy_check, collat_past_therapy_check;
	
	public PatientHistory(int pid)
	{
		pID = pid;
		med_histories = new ArrayList<MedHistory>();
		med_collat_histories = new ArrayList<MedHistory>();
		
		drug_histories = new ArrayList<DrugHistory>();
		drug_collat_histories = new ArrayList<DrugHistory>();
		
		psych_histories = new ArrayList<PsychHistory>();
		psych_collat_histories = new ArrayList<PsychHistory>();
		
		current_therapy_check = past_therapy_check = "";
		collat_current_therapy_check = collat_past_therapy_check = "";
	}
	
	public int getID() {
		return pID;
	}
	
	public String getCurrent_therapy_check() {
		return current_therapy_check;
	}

	public void setCurrent_therapy_check(String current_therapy_check) {
		this.current_therapy_check = current_therapy_check;
	}

	public String getPast_therapy_check() {
		return past_therapy_check;
	}

	public void setPast_therapy_check(String past_therapy_check) {
		this.past_therapy_check = past_therapy_check;
	}

	public String getCollat_current_therapy_check() {
		return collat_current_therapy_check;
	}

	public void setCollat_current_therapy_check(String collat_current_therapy_check) {
		this.collat_current_therapy_check = collat_current_therapy_check;
	}

	public String getCollat_past_therapy_check() {
		return collat_past_therapy_check;
	}

	public void setCollat_past_therapy_check(String collat_past_therapy_check) {
		this.collat_past_therapy_check = collat_past_therapy_check;
	}

	public ArrayList<MedHistory> getMed_histories() {
		return med_histories;
	}

	public ArrayList<MedHistory> getMed_collat_histories() {
		return med_collat_histories;
	}

	public ArrayList<DrugHistory> getDrug_histories() {
		return drug_histories;
	}

	public ArrayList<DrugHistory> getDrug_collat_histories() {
		return drug_collat_histories;
	}

	public ArrayList<PsychHistory> getPsych_histories() {
		return psych_histories;
	}

	public ArrayList<PsychHistory> getPsych_collat_histories() {
		return psych_collat_histories;
	}

	public void addMedHistory(String c, String t, String n)
	{
		med_histories.add(new MedHistory(c,t,n));
	}
	
	public void addCollatMedHistory(String c, String t, String n)
	{
		med_collat_histories.add(new MedHistory(c,t,n));
	}
	
	public void addDrugHistory(String d, String t, String n)
	{
		drug_histories.add(new DrugHistory(d,t,n));
	}
	
	public void addCollatDrugHistory(String d, String t, String n)
	{
		drug_collat_histories.add(new DrugHistory(d,t,n));
	}
	
	public void addPsychHistory(String p, String t, String n)
	{
		psych_histories.add(new PsychHistory(p, t, n));
	}
	
	public void addCollatPsychHistory(String p, String t, String n)
	{
		psych_collat_histories.add(new PsychHistory(p, t, n));
	}
	
	@Override
	public String toString() {
		return "PatientHistory [med_histories=" + med_histories
				+ ", med_collat_histories=" + med_collat_histories
				+ ", drug_histories=" + drug_histories
				+ ", drug_collat_histories=" + drug_collat_histories
				+ ", psych_histories=" + psych_histories
				+ ", psych_collat_histories=" + psych_collat_histories
				+ ", current_therapy_check=" + current_therapy_check
				+ ", past_therapy_check=" + past_therapy_check
				+ ", collat_current_therapy_check="
				+ collat_current_therapy_check + ", collat_past_therapy_check="
				+ collat_past_therapy_check + "]";
	}
	
}
