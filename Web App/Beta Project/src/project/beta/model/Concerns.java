package project.beta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*
 * Concerns Class for the Concerns page of the form
 */
@Entity
public class Concerns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "concernsID", unique = true, nullable = false)
	int concernsID;

	@Transient
	protected Object[] jdoDetachedState;
	
	boolean rec_events_check, faces_check, names_check, losing_things_check, follow_conv_check;
	boolean right_words_check, decisions_check, calculations_check, prospective_check, anxiety_check, comments_check;
	
	String rec_events_time, rec_events_freq;
	@Column(columnDefinition="TEXT")
	String rec_events_notes;
	
	String faces_time, faces_freq;
	@Column(columnDefinition="TEXT")
	String faces_notes;
	
	String names_time, names_freq;
	@Column(columnDefinition="TEXT")
	String names_notes;
	
	String losing_things_time, losing_things_freq;
	@Column(columnDefinition="TEXT")
	String losing_things_notes;
	
	String follow_conv_time, follow_conv_freq;
	@Column(columnDefinition="TEXT")
	String follow_conv_notes;
	
	String right_words_time, right_words_freq;
	@Column(columnDefinition="TEXT")
	String right_words_notes;
	
	String decisions_time, decisions_freq;
	@Column(columnDefinition="TEXT")
	String decisions_notes;
	
	String calculations_time, calculations_freq;
	@Column(columnDefinition="TEXT")
	String calculations_notes;
	
	String prospective_time, prospective_freq;
	@Column(columnDefinition="TEXT")
	String prospective_notes;
	
	String anxiety_time, anxiety_freq;
	@Column(columnDefinition="TEXT")
	String anxiety_notes;
	
	String comments_time, comments_freq;
	@Column(columnDefinition="TEXT")
	String comments_notes;
	
	boolean rec_events_check_collat, faces_check_collat, names_check_collat, losing_things_check_collat, follow_conv_check_collat;
	boolean right_words_check_collat, decisions_check_collat, calculations_check_collat, prospective_check_collat, anxiety_check_collat, comments_check_collat;
	
	String rec_events_time_collat, rec_events_freq_collat;
	@Column(columnDefinition="TEXT")
	String rec_events_notes_collat;
	
	String faces_time_collat, faces_freq_collat;
	@Column(columnDefinition="TEXT")
	String faces_notes_collat;
	
	String names_time_collat, names_freq_collat;
	@Column(columnDefinition="TEXT")
	String names_notes_collat;
	
	String losing_things_time_collat, losing_things_freq_collat;
	@Column(columnDefinition="TEXT")
	String losing_things_notes_collat;
	
	String follow_conv_time_collat, follow_conv_freq_collat;
	@Column(columnDefinition="TEXT")
	String follow_conv_notes_collat;
	
	String right_words_time_collat, right_words_freq_collat;
	@Column(columnDefinition="TEXT")
	String right_words_notes_collat;
	
	String decisions_time_collat, decisions_freq_collat;
	@Column(columnDefinition="TEXT")
	String decisions_notes_collat;
	
	String calculations_time_collat, calculations_freq_collat;
	@Column(columnDefinition="TEXT")
	String calculations_notes_collat;
	
	String prospective_time_collat, prospective_freq_collat;
	@Column(columnDefinition="TEXT")
	String prospective_notes_collat;
	
	String anxiety_time_collat, anxiety_freq_collat;
	@Column(columnDefinition="TEXT")
	String anxiety_notes_collat;
	
	String comments_time_collat, comments_freq_collat;
	@Column(columnDefinition="TEXT")
	String comments_notes_collat;
	
	public Concerns(){
		
	}

	public int getConcernsID() {
		return concernsID;
	}

	public void setConcernsID(int concernsID) {
		this.concernsID = concernsID;
	}

	public boolean isRec_events_check() {
		return rec_events_check;
	}

	public void setRec_events_check(boolean rec_events_check) {
		this.rec_events_check = rec_events_check;
	}

	public boolean isFaces_check() {
		return faces_check;
	}

	public void setFaces_check(boolean faces_check) {
		this.faces_check = faces_check;
	}

	public boolean isNames_check() {
		return names_check;
	}

	public void setNames_check(boolean names_check) {
		this.names_check = names_check;
	}

	public boolean isLosing_things_check() {
		return losing_things_check;
	}

	public void setLosing_things_check(boolean losing_things_check) {
		this.losing_things_check = losing_things_check;
	}

	public boolean isFollow_conv_check() {
		return follow_conv_check;
	}

	public void setFollow_conv_check(boolean follow_conv_check) {
		this.follow_conv_check = follow_conv_check;
	}

	public boolean isRight_words_check() {
		return right_words_check;
	}

	public void setRight_words_check(boolean right_words_check) {
		this.right_words_check = right_words_check;
	}

	public boolean isDecisions_check() {
		return decisions_check;
	}

	public void setDecisions_check(boolean decisions_check) {
		this.decisions_check = decisions_check;
	}

	public boolean isCalculations_check() {
		return calculations_check;
	}

	public void setCalculations_check(boolean calculations_check) {
		this.calculations_check = calculations_check;
	}

	public boolean isProspective_check() {
		return prospective_check;
	}

	public void setProspective_check(boolean prospective_check) {
		this.prospective_check = prospective_check;
	}

	public boolean isAnxiety_check() {
		return anxiety_check;
	}

	public void setAnxiety_check(boolean anxiety_check) {
		this.anxiety_check = anxiety_check;
	}

	public boolean isComments_check() {
		return comments_check;
	}

	public void setComments_check(boolean comments_check) {
		this.comments_check = comments_check;
	}

	public String getRec_events_time() {
		return rec_events_time;
	}

	public void setRec_events_time(String rec_events_time) {
		this.rec_events_time = rec_events_time;
	}

	public String getRec_events_freq() {
		return rec_events_freq;
	}

	public void setRec_events_freq(String rec_events_freq) {
		this.rec_events_freq = rec_events_freq;
	}

	public String getRec_events_notes() {
		return rec_events_notes;
	}

	public void setRec_events_notes(String rec_events_notes) {
		this.rec_events_notes = rec_events_notes;
	}

	public String getFaces_time() {
		return faces_time;
	}

	public void setFaces_time(String faces_time) {
		this.faces_time = faces_time;
	}

	public String getFaces_freq() {
		return faces_freq;
	}

	public void setFaces_freq(String faces_freq) {
		this.faces_freq = faces_freq;
	}

	public String getFaces_notes() {
		return faces_notes;
	}

	public void setFaces_notes(String faces_notes) {
		this.faces_notes = faces_notes;
	}

	public String getNames_time() {
		return names_time;
	}

	public void setNames_time(String names_time) {
		this.names_time = names_time;
	}

	public String getNames_freq() {
		return names_freq;
	}

	public void setNames_freq(String names_freq) {
		this.names_freq = names_freq;
	}

	public String getNames_notes() {
		return names_notes;
	}

	public void setNames_notes(String names_notes) {
		this.names_notes = names_notes;
	}

	public String getLosing_things_time() {
		return losing_things_time;
	}

	public void setLosing_things_time(String losing_things_time) {
		this.losing_things_time = losing_things_time;
	}

	public String getLosing_things_freq() {
		return losing_things_freq;
	}

	public void setLosing_things_freq(String losing_things_freq) {
		this.losing_things_freq = losing_things_freq;
	}

	public String getLosing_things_notes() {
		return losing_things_notes;
	}

	public void setLosing_things_notes(String losing_things_notes) {
		this.losing_things_notes = losing_things_notes;
	}

	public String getFollow_conv_time() {
		return follow_conv_time;
	}

	public void setFollow_conv_time(String follow_conv_time) {
		this.follow_conv_time = follow_conv_time;
	}

	public String getFollow_conv_freq() {
		return follow_conv_freq;
	}

	public void setFollow_conv_freq(String follow_conv_freq) {
		this.follow_conv_freq = follow_conv_freq;
	}

	public String getFollow_conv_notes() {
		return follow_conv_notes;
	}

	public void setFollow_conv_notes(String follow_conv_notes) {
		this.follow_conv_notes = follow_conv_notes;
	}

	public String getRight_words_time() {
		return right_words_time;
	}

	public void setRight_words_time(String right_words_time) {
		this.right_words_time = right_words_time;
	}

	public String getRight_words_freq() {
		return right_words_freq;
	}

	public void setRight_words_freq(String right_words_freq) {
		this.right_words_freq = right_words_freq;
	}

	public String getRight_words_notes() {
		return right_words_notes;
	}

	public void setRight_words_notes(String right_words_notes) {
		this.right_words_notes = right_words_notes;
	}

	public String getDecisions_time() {
		return decisions_time;
	}

	public void setDecisions_time(String decisions_time) {
		this.decisions_time = decisions_time;
	}

	public String getDecisions_freq() {
		return decisions_freq;
	}

	public void setDecisions_freq(String decisions_freq) {
		this.decisions_freq = decisions_freq;
	}

	public String getDecisions_notes() {
		return decisions_notes;
	}

	public void setDecisions_notes(String decisions_notes) {
		this.decisions_notes = decisions_notes;
	}

	public String getCalculations_time() {
		return calculations_time;
	}

	public void setCalculations_time(String calculations_time) {
		this.calculations_time = calculations_time;
	}

	public String getCalculations_freq() {
		return calculations_freq;
	}

	public void setCalculations_freq(String calculations_freq) {
		this.calculations_freq = calculations_freq;
	}

	public String getCalculations_notes() {
		return calculations_notes;
	}

	public void setCalculations_notes(String calculations_notes) {
		this.calculations_notes = calculations_notes;
	}

	public String getProspective_time() {
		return prospective_time;
	}

	public void setProspective_time(String prospective_time) {
		this.prospective_time = prospective_time;
	}

	public String getProspective_freq() {
		return prospective_freq;
	}

	public void setProspective_freq(String prospective_freq) {
		this.prospective_freq = prospective_freq;
	}

	public String getProspective_notes() {
		return prospective_notes;
	}

	public void setProspective_notes(String prospective_notes) {
		this.prospective_notes = prospective_notes;
	}

	public String getAnxiety_time() {
		return anxiety_time;
	}

	public void setAnxiety_time(String anxiety_time) {
		this.anxiety_time = anxiety_time;
	}

	public String getAnxiety_freq() {
		return anxiety_freq;
	}

	public void setAnxiety_freq(String anxiety_freq) {
		this.anxiety_freq = anxiety_freq;
	}

	public String getAnxiety_notes() {
		return anxiety_notes;
	}

	public void setAnxiety_notes(String anxiety_notes) {
		this.anxiety_notes = anxiety_notes;
	}

	public String getComments_time() {
		return comments_time;
	}

	public void setComments_time(String comments_time) {
		this.comments_time = comments_time;
	}

	public String getComments_freq() {
		return comments_freq;
	}

	public void setComments_freq(String comments_freq) {
		this.comments_freq = comments_freq;
	}

	public String getComments_notes() {
		return comments_notes;
	}

	public void setComments_notes(String comments_notes) {
		this.comments_notes = comments_notes;
	}

	public boolean isRec_events_check_collat() {
		return rec_events_check_collat;
	}

	public void setRec_events_check_collat(boolean rec_events_check_collat) {
		this.rec_events_check_collat = rec_events_check_collat;
	}

	public boolean isFaces_check_collat() {
		return faces_check_collat;
	}

	public void setFaces_check_collat(boolean faces_check_collat) {
		this.faces_check_collat = faces_check_collat;
	}

	public boolean isNames_check_collat() {
		return names_check_collat;
	}

	public void setNames_check_collat(boolean names_check_collat) {
		this.names_check_collat = names_check_collat;
	}

	public boolean isLosing_things_check_collat() {
		return losing_things_check_collat;
	}

	public void setLosing_things_check_collat(boolean losing_things_check_collat) {
		this.losing_things_check_collat = losing_things_check_collat;
	}

	public boolean isFollow_conv_check_collat() {
		return follow_conv_check_collat;
	}

	public void setFollow_conv_check_collat(boolean follow_conv_check_collat) {
		this.follow_conv_check_collat = follow_conv_check_collat;
	}

	public boolean isRight_words_check_collat() {
		return right_words_check_collat;
	}

	public void setRight_words_check_collat(boolean right_words_check_collat) {
		this.right_words_check_collat = right_words_check_collat;
	}

	public boolean isDecisions_check_collat() {
		return decisions_check_collat;
	}

	public void setDecisions_check_collat(boolean decisions_check_collat) {
		this.decisions_check_collat = decisions_check_collat;
	}

	public boolean isCalculations_check_collat() {
		return calculations_check_collat;
	}

	public void setCalculations_check_collat(boolean calculations_check_collat) {
		this.calculations_check_collat = calculations_check_collat;
	}

	public boolean isProspective_check_collat() {
		return prospective_check_collat;
	}

	public void setProspective_check_collat(boolean prospective_check_collat) {
		this.prospective_check_collat = prospective_check_collat;
	}

	public boolean isAnxiety_check_collat() {
		return anxiety_check_collat;
	}

	public void setAnxiety_check_collat(boolean anxiety_check_collat) {
		this.anxiety_check_collat = anxiety_check_collat;
	}

	public boolean isComments_check_collat() {
		return comments_check_collat;
	}

	public void setComments_check_collat(boolean comments_check_collat) {
		this.comments_check_collat = comments_check_collat;
	}

	public String getRec_events_time_collat() {
		return rec_events_time_collat;
	}

	public void setRec_events_time_collat(String rec_events_time_collat) {
		this.rec_events_time_collat = rec_events_time_collat;
	}

	public String getRec_events_freq_collat() {
		return rec_events_freq_collat;
	}

	public void setRec_events_freq_collat(String rec_events_freq_collat) {
		this.rec_events_freq_collat = rec_events_freq_collat;
	}

	public String getRec_events_notes_collat() {
		return rec_events_notes_collat;
	}

	public void setRec_events_notes_collat(String rec_events_notes_collat) {
		this.rec_events_notes_collat = rec_events_notes_collat;
	}

	public String getFaces_time_collat() {
		return faces_time_collat;
	}

	public void setFaces_time_collat(String faces_time_collat) {
		this.faces_time_collat = faces_time_collat;
	}

	public String getFaces_freq_collat() {
		return faces_freq_collat;
	}

	public void setFaces_freq_collat(String faces_freq_collat) {
		this.faces_freq_collat = faces_freq_collat;
	}

	public String getFaces_notes_collat() {
		return faces_notes_collat;
	}

	public void setFaces_notes_collat(String faces_notes_collat) {
		this.faces_notes_collat = faces_notes_collat;
	}

	public String getNames_time_collat() {
		return names_time_collat;
	}

	public void setNames_time_collat(String names_time_collat) {
		this.names_time_collat = names_time_collat;
	}

	public String getNames_freq_collat() {
		return names_freq_collat;
	}

	public void setNames_freq_collat(String names_freq_collat) {
		this.names_freq_collat = names_freq_collat;
	}

	public String getNames_notes_collat() {
		return names_notes_collat;
	}

	public void setNames_notes_collat(String names_notes_collat) {
		this.names_notes_collat = names_notes_collat;
	}

	public String getLosing_things_time_collat() {
		return losing_things_time_collat;
	}

	public void setLosing_things_time_collat(String losing_things_time_collat) {
		this.losing_things_time_collat = losing_things_time_collat;
	}

	public String getLosing_things_freq_collat() {
		return losing_things_freq_collat;
	}

	public void setLosing_things_freq_collat(String losing_things_freq_collat) {
		this.losing_things_freq_collat = losing_things_freq_collat;
	}

	public String getLosing_things_notes_collat() {
		return losing_things_notes_collat;
	}

	public void setLosing_things_notes_collat(String losing_things_notes_collat) {
		this.losing_things_notes_collat = losing_things_notes_collat;
	}

	public String getFollow_conv_time_collat() {
		return follow_conv_time_collat;
	}

	public void setFollow_conv_time_collat(String follow_conv_time_collat) {
		this.follow_conv_time_collat = follow_conv_time_collat;
	}

	public String getFollow_conv_freq_collat() {
		return follow_conv_freq_collat;
	}

	public void setFollow_conv_freq_collat(String follow_conv_freq_collat) {
		this.follow_conv_freq_collat = follow_conv_freq_collat;
	}

	public String getFollow_conv_notes_collat() {
		return follow_conv_notes_collat;
	}

	public void setFollow_conv_notes_collat(String follow_conv_notes_collat) {
		this.follow_conv_notes_collat = follow_conv_notes_collat;
	}

	public String getRight_words_time_collat() {
		return right_words_time_collat;
	}

	public void setRight_words_time_collat(String right_words_time_collat) {
		this.right_words_time_collat = right_words_time_collat;
	}

	public String getRight_words_freq_collat() {
		return right_words_freq_collat;
	}

	public void setRight_words_freq_collat(String right_words_freq_collat) {
		this.right_words_freq_collat = right_words_freq_collat;
	}

	public String getRight_words_notes_collat() {
		return right_words_notes_collat;
	}

	public void setRight_words_notes_collat(String right_words_notes_collat) {
		this.right_words_notes_collat = right_words_notes_collat;
	}

	public String getDecisions_time_collat() {
		return decisions_time_collat;
	}

	public void setDecisions_time_collat(String decisions_time_collat) {
		this.decisions_time_collat = decisions_time_collat;
	}

	public String getDecisions_freq_collat() {
		return decisions_freq_collat;
	}

	public void setDecisions_freq_collat(String decisions_freq_collat) {
		this.decisions_freq_collat = decisions_freq_collat;
	}

	public String getDecisions_notes_collat() {
		return decisions_notes_collat;
	}

	public void setDecisions_notes_collat(String decisions_notes_collat) {
		this.decisions_notes_collat = decisions_notes_collat;
	}

	public String getCalculations_time_collat() {
		return calculations_time_collat;
	}

	public void setCalculations_time_collat(String calculations_time_collat) {
		this.calculations_time_collat = calculations_time_collat;
	}

	public String getCalculations_freq_collat() {
		return calculations_freq_collat;
	}

	public void setCalculations_freq_collat(String calculations_freq_collat) {
		this.calculations_freq_collat = calculations_freq_collat;
	}

	public String getCalculations_notes_collat() {
		return calculations_notes_collat;
	}

	public void setCalculations_notes_collat(String calculations_notes_collat) {
		this.calculations_notes_collat = calculations_notes_collat;
	}

	public String getProspective_time_collat() {
		return prospective_time_collat;
	}

	public void setProspective_time_collat(String prospective_time_collat) {
		this.prospective_time_collat = prospective_time_collat;
	}

	public String getProspective_freq_collat() {
		return prospective_freq_collat;
	}

	public void setProspective_freq_collat(String prospective_freq_collat) {
		this.prospective_freq_collat = prospective_freq_collat;
	}

	public String getProspective_notes_collat() {
		return prospective_notes_collat;
	}

	public void setProspective_notes_collat(String prospective_notes_collat) {
		this.prospective_notes_collat = prospective_notes_collat;
	}

	public String getAnxiety_time_collat() {
		return anxiety_time_collat;
	}

	public void setAnxiety_time_collat(String anxiety_time_collat) {
		this.anxiety_time_collat = anxiety_time_collat;
	}

	public String getAnxiety_freq_collat() {
		return anxiety_freq_collat;
	}

	public void setAnxiety_freq_collat(String anxiety_freq_collat) {
		this.anxiety_freq_collat = anxiety_freq_collat;
	}

	public String getAnxiety_notes_collat() {
		return anxiety_notes_collat;
	}

	public void setAnxiety_notes_collat(String anxiety_notes_collat) {
		this.anxiety_notes_collat = anxiety_notes_collat;
	}

	public String getComments_time_collat() {
		return comments_time_collat;
	}

	public void setComments_time_collat(String comments_time_collat) {
		this.comments_time_collat = comments_time_collat;
	}

	public String getComments_freq_collat() {
		return comments_freq_collat;
	}

	public void setComments_freq_collat(String comments_freq_collat) {
		this.comments_freq_collat = comments_freq_collat;
	}

	public String getComments_notes_collat() {
		return comments_notes_collat;
	}

	public void setComments_notes_collat(String comments_notes_collat) {
		this.comments_notes_collat = comments_notes_collat;
	}

}
