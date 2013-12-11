package project.beta.model;

import java.util.ArrayList;

public class Analysis {

	private int pID;
	
	String mmse_result, cdt_result, mini_cog_result, gds_result;
	String impression, impression_notes, follow_up, follow_notes;
	
	ArrayList<String> outcomes;
	ArrayList<String> outcome_notes;
	
	String letter, notes;
	
	public Analysis(int id)
	{
		pID = id;
		mmse_result = cdt_result = mini_cog_result = gds_result = "";
		impression = impression_notes = follow_up = follow_notes = "";

		outcomes = new ArrayList<String>();
		outcome_notes = new ArrayList<String>();
		
		letter = notes = "";
	}

	@Override
	public String toString() {
		return "Analysis [pID=" + pID + ", mmse_result=" + mmse_result
				+ ", cdt_result=" + cdt_result + ", mini_cog_result="
				+ mini_cog_result + ", gds_result=" + gds_result
				+ ", impression=" + impression + ", impression_notes="
				+ impression_notes + ", follow_up=" + follow_up
				+ ", follow_notes=" + follow_notes + ", outcomes=" + outcomes
				+ ", outcome_notes=" + outcome_notes + ", letter=" + letter
				+ ", notes=" + notes + "]";
	}
	
	public void addOutcome(String o) {
		outcomes.add(o);
	}
	
	public void addOutcomeNotes(String o) {
		outcome_notes.add(o);
	}

	public String getMmse_result() {
		return mmse_result;
	}

	public void setMmse_result(String mmse_result) {
		this.mmse_result = mmse_result;
	}

	public String getCdt_result() {
		return cdt_result;
	}

	public void setCdt_result(String cdt_result) {
		this.cdt_result = cdt_result;
	}

	public String getMini_cog_result() {
		return mini_cog_result;
	}

	public void setMini_cog_result(String mini_cog_result) {
		this.mini_cog_result = mini_cog_result;
	}

	public String getGds_result() {
		return gds_result;
	}

	public void setGds_result(String gds_result) {
		this.gds_result = gds_result;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getImpression_notes() {
		return impression_notes;
	}

	public void setImpression_notes(String impression_notes) {
		this.impression_notes = impression_notes;
	}

	public String getFollow_up() {
		return follow_up;
	}

	public void setFollow_up(String follow_up) {
		this.follow_up = follow_up;
	}

	public String getFollow_notes() {
		return follow_notes;
	}

	public void setFollow_notes(String follow_notes) {
		this.follow_notes = follow_notes;
	}

	public ArrayList<String> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(ArrayList<String> outcomes) {
		this.outcomes = outcomes;
	}

	public ArrayList<String> getOutcome_notes() {
		return outcome_notes;
	}

	public void setOutcome_notes(ArrayList<String> outcome_notes) {
		this.outcome_notes = outcome_notes;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getpID() {
		return pID;
	}
	
}
