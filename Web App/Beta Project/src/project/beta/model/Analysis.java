package project.beta.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*
 * Representative of the Patient Analysis page of the form
 */
@Entity
public class Analysis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "analysisID", unique = true, nullable = false)
	private int analysisID;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	String mmse_result, cdt_result, mini_cog_result, gds_result;
	String impression, impression_notes, follow_up, follow_notes;
	
	@ElementCollection
	@CollectionTable(name = "outcomes")
	@Column(name = "outcome")
	List<String> outcomes;
	
	@ElementCollection
	@CollectionTable(name = "outcome_notes")
	@Column(name = "outcome_note", columnDefinition="TEXT")
	List<String> outcome_notes;
	
	@Column(name = "letter", columnDefinition="TEXT")
	String letter;
	@Column(name = "notes", columnDefinition="TEXT")
	String notes;
	
	public Analysis()
	{
		
	}

	public int getAnalysisID() {
		return analysisID;
	}

	public void setAnalysisID(int analysisID) {
		this.analysisID = analysisID;
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

	public List<String> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<String> outcomes) {
		this.outcomes = outcomes;
	}

	public List<String> getOutcome_notes() {
		return outcome_notes;
	}

	public void setOutcome_notes(List<String> outcome_notes) {
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
}
