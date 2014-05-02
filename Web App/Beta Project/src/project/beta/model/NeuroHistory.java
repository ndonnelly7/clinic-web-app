package project.beta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*
 * Class used for the Neurological History page of the form
 */

@Entity
public class NeuroHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "neuroHistoryID", unique = true, nullable = false)
	int neuroHistoryID;

	@Transient
	protected Object[] jdoDetachedState;
	
	boolean blackout_check, blanks_check, blurred_vision_check, dizziness_check, fainting_check, headaches_check, falling_check, seizures_check;
	boolean blackout_check_collat, blanks_check_collat, blurred_vision_check_collat, dizziness_check_collat;
	boolean fainting_check_collat, headaches_check_collat, falling_check_collat, seizures_check_collat;
	
	String blackout_time, blackout_freq;
	@Column(columnDefinition="TEXT")
	String blackout_notes;
	
	String blanks_time, blanks_freq;
	@Column(columnDefinition="TEXT")
	String blanks_notes;
	
	String blurred_time, blurred_freq;
	@Column(columnDefinition="TEXT")
	String blurred_notes;
	
	String dizzy_time, dizzy_freq;
	@Column(columnDefinition="TEXT")
	String dizzy_notes;
	
	String faint_time, faint_freq;
	@Column(columnDefinition="TEXT")
	String faint_notes;
	
	String headaches_time, headaches_freq;
	@Column(columnDefinition="TEXT")
	String headaches_notes;
	
	String falling_time, falling_freq;
	@Column(columnDefinition="TEXT")
	String falling_notes;
	
	String seizures_time, seizures_freq;
	@Column(columnDefinition="TEXT")
	String seizures_notes;
	
	String blackout_time_collat, blackout_freq_collat;
	@Column(columnDefinition="TEXT")
	String blackout_notes_collat;
	
	String blanks_time_collat, blanks_freq_collat;
	@Column(columnDefinition="TEXT")
	String blanks_notes_collat;
	
	String blurred_time_collat, blurred_freq_collat;
	@Column(columnDefinition="TEXT")
	String blurred_notes_collat;
	
	String dizzy_time_collat, dizzy_freq_collat;
	@Column(columnDefinition="TEXT")
	String dizzy_notes_collat;
	
	String faint_time_collat, faint_freq_collat;
	@Column(columnDefinition="TEXT")
	String faint_notes_collat;
	
	String headaches_time_collat, headaches_freq_collat;
	@Column(columnDefinition="TEXT")
	String headaches_notes_collat;
	
	String falling_time_collat, falling_freq_collat;
	@Column(columnDefinition="TEXT")
	String falling_notes_collat;
	
	String seizures_time_collat, seizures_freq_collat;
	@Column(columnDefinition="TEXT")
	String seizures_notes_collat;	
	
	public NeuroHistory()
	{
		
	}


	public int getNeuroHistoryID() {
		return neuroHistoryID;
	}


	public void setNeuroHistoryID(int neuroHistoryID) {
		this.neuroHistoryID = neuroHistoryID;
	}


	public boolean isBlackout_check() {
		return blackout_check;
	}


	public void setBlackout_check(boolean blackout_check) {
		this.blackout_check = blackout_check;
	}


	public boolean isBlanks_check() {
		return blanks_check;
	}


	public void setBlanks_check(boolean blanks_check) {
		this.blanks_check = blanks_check;
	}


	public boolean isBlurred_vision_check() {
		return blurred_vision_check;
	}


	public void setBlurred_vision_check(boolean blurred_vision_check) {
		this.blurred_vision_check = blurred_vision_check;
	}


	public boolean isDizziness_check() {
		return dizziness_check;
	}


	public void setDizziness_check(boolean dizziness_check) {
		this.dizziness_check = dizziness_check;
	}


	public boolean isFainting_check() {
		return fainting_check;
	}


	public void setFainting_check(boolean fainting_check) {
		this.fainting_check = fainting_check;
	}


	public boolean isHeadaches_check() {
		return headaches_check;
	}


	public void setHeadaches_check(boolean headaches_check) {
		this.headaches_check = headaches_check;
	}


	public boolean isFalling_check() {
		return falling_check;
	}


	public void setFalling_check(boolean falling_check) {
		this.falling_check = falling_check;
	}


	public boolean isSeizures_check() {
		return seizures_check;
	}


	public void setSeizures_check(boolean seizures_check) {
		this.seizures_check = seizures_check;
	}


	public boolean isBlackout_check_collat() {
		return blackout_check_collat;
	}


	public void setBlackout_check_collat(boolean blackout_check_collat) {
		this.blackout_check_collat = blackout_check_collat;
	}


	public boolean isBlank_check_collat() {
		return blanks_check_collat;
	}


	public void setBlank_check_collat(boolean blank_check_collat) {
		this.blanks_check_collat = blank_check_collat;
	}


	public boolean isBlurred_vision_check_collat() {
		return blurred_vision_check_collat;
	}


	public void setBlurred_vision_check_collat(boolean blurred_vision_check_collat) {
		this.blurred_vision_check_collat = blurred_vision_check_collat;
	}


	public boolean isDizziness_check_collat() {
		return dizziness_check_collat;
	}


	public void setDizziness_check_collat(boolean dizziness_check_collat) {
		this.dizziness_check_collat = dizziness_check_collat;
	}


	public boolean isFainting_check_collat() {
		return fainting_check_collat;
	}


	public void setFainting_check_collat(boolean fainting_check_collat) {
		this.fainting_check_collat = fainting_check_collat;
	}


	public boolean isHeadaches_check_collat() {
		return headaches_check_collat;
	}


	public void setHeadaches_check_collat(boolean headaches_check_collat) {
		this.headaches_check_collat = headaches_check_collat;
	}


	public boolean isFalling_check_collat() {
		return falling_check_collat;
	}


	public void setFalling_check_collat(boolean falling_check_collat) {
		this.falling_check_collat = falling_check_collat;
	}


	public boolean isSeizures_check_collat() {
		return seizures_check_collat;
	}


	public void setSeizures_check_collat(boolean seizures_check_collat) {
		this.seizures_check_collat = seizures_check_collat;
	}


	public String getBlackout_time() {
		return blackout_time;
	}


	public void setBlackout_time(String blackout_time) {
		this.blackout_time = blackout_time;
	}


	public String getBlackout_freq() {
		return blackout_freq;
	}


	public void setBlackout_freq(String blackout_freq) {
		this.blackout_freq = blackout_freq;
	}


	public String getBlackout_notes() {
		return blackout_notes;
	}


	public void setBlackout_notes(String blackout_notes) {
		this.blackout_notes = blackout_notes;
	}


	public String getBlanks_time() {
		return blanks_time;
	}


	public void setBlanks_time(String blanks_time) {
		this.blanks_time = blanks_time;
	}


	public String getBlanks_freq() {
		return blanks_freq;
	}


	public void setBlanks_freq(String blanks_freq) {
		this.blanks_freq = blanks_freq;
	}


	public String getBlanks_notes() {
		return blanks_notes;
	}


	public void setBlanks_notes(String blanks_notes) {
		this.blanks_notes = blanks_notes;
	}


	public String getBlurred_time() {
		return blurred_time;
	}


	public void setBlurred_time(String blurred_time) {
		this.blurred_time = blurred_time;
	}


	public String getBlurred_freq() {
		return blurred_freq;
	}


	public void setBlurred_freq(String blurred_freq) {
		this.blurred_freq = blurred_freq;
	}


	public String getBlurred_notes() {
		return blurred_notes;
	}


	public void setBlurred_notes(String blurred_notes) {
		this.blurred_notes = blurred_notes;
	}


	public String getDizzy_time() {
		return dizzy_time;
	}


	public void setDizzy_time(String dizzy_time) {
		this.dizzy_time = dizzy_time;
	}


	public String getDizzy_freq() {
		return dizzy_freq;
	}


	public void setDizzy_freq(String dizzy_freq) {
		this.dizzy_freq = dizzy_freq;
	}


	public String getDizzy_notes() {
		return dizzy_notes;
	}


	public void setDizzy_notes(String dizzy_notes) {
		this.dizzy_notes = dizzy_notes;
	}


	public String getFaint_time() {
		return faint_time;
	}


	public void setFaint_time(String faint_time) {
		this.faint_time = faint_time;
	}


	public String getFaint_freq() {
		return faint_freq;
	}


	public void setFaint_freq(String faint_freq) {
		this.faint_freq = faint_freq;
	}


	public String getFaint_notes() {
		return faint_notes;
	}


	public void setFaint_notes(String faint_notes) {
		this.faint_notes = faint_notes;
	}


	public String getHeadaches_time() {
		return headaches_time;
	}


	public void setHeadaches_time(String headaches_time) {
		this.headaches_time = headaches_time;
	}


	public String getHeadaches_freq() {
		return headaches_freq;
	}


	public void setHeadaches_freq(String headaches_freq) {
		this.headaches_freq = headaches_freq;
	}


	public String getHeadaches_notes() {
		return headaches_notes;
	}


	public void setHeadaches_notes(String headaches_notes) {
		this.headaches_notes = headaches_notes;
	}


	public String getFalling_time() {
		return falling_time;
	}


	public void setFalling_time(String falling_time) {
		this.falling_time = falling_time;
	}


	public String getFalling_freq() {
		return falling_freq;
	}


	public void setFalling_freq(String falling_freq) {
		this.falling_freq = falling_freq;
	}


	public String getFalling_notes() {
		return falling_notes;
	}


	public void setFalling_notes(String falling_notes) {
		this.falling_notes = falling_notes;
	}


	public String getSeizures_time() {
		return seizures_time;
	}


	public void setSeizures_time(String seizures_time) {
		this.seizures_time = seizures_time;
	}


	public String getSeizures_freq() {
		return seizures_freq;
	}


	public void setSeizures_freq(String seizures_freq) {
		this.seizures_freq = seizures_freq;
	}


	public String getSeizures_notes() {
		return seizures_notes;
	}


	public void setSeizures_notes(String seizures_notes) {
		this.seizures_notes = seizures_notes;
	}


	public String getBlackout_time_collat() {
		return blackout_time_collat;
	}


	public void setBlackout_time_collat(String blackout_time_collat) {
		this.blackout_time_collat = blackout_time_collat;
	}


	public String getBlackout_freq_collat() {
		return blackout_freq_collat;
	}


	public void setBlackout_freq_collat(String blackout_freq_collat) {
		this.blackout_freq_collat = blackout_freq_collat;
	}


	public String getBlackout_notes_collat() {
		return blackout_notes_collat;
	}


	public void setBlackout_notes_collat(String blackout_notes_collat) {
		this.blackout_notes_collat = blackout_notes_collat;
	}


	public String getBlanks_time_collat() {
		return blanks_time_collat;
	}


	public void setBlanks_time_collat(String blanks_time_collat) {
		this.blanks_time_collat = blanks_time_collat;
	}


	public String getBlanks_freq_collat() {
		return blanks_freq_collat;
	}


	public void setBlanks_freq_collat(String blanks_freq_collat) {
		this.blanks_freq_collat = blanks_freq_collat;
	}


	public String getBlanks_notes_collat() {
		return blanks_notes_collat;
	}


	public void setBlanks_notes_collat(String blanks_notes_collat) {
		this.blanks_notes_collat = blanks_notes_collat;
	}


	public String getBlurred_time_collat() {
		return blurred_time_collat;
	}


	public void setBlurred_time_collat(String blurred_time_collat) {
		this.blurred_time_collat = blurred_time_collat;
	}


	public String getBlurred_freq_collat() {
		return blurred_freq_collat;
	}


	public void setBlurred_freq_collat(String blurred_freq_collat) {
		this.blurred_freq_collat = blurred_freq_collat;
	}


	public String getBlurred_notes_collat() {
		return blurred_notes_collat;
	}


	public void setBlurred_notes_collat(String blurred_notes_collat) {
		this.blurred_notes_collat = blurred_notes_collat;
	}


	public String getDizzy_time_collat() {
		return dizzy_time_collat;
	}


	public void setDizzy_time_collat(String dizzy_time_collat) {
		this.dizzy_time_collat = dizzy_time_collat;
	}


	public String getDizzy_freq_collat() {
		return dizzy_freq_collat;
	}


	public void setDizzy_freq_collat(String dizzy_freq_collat) {
		this.dizzy_freq_collat = dizzy_freq_collat;
	}


	public String getDizzy_notes_collat() {
		return dizzy_notes_collat;
	}


	public void setDizzy_notes_collat(String dizzy_notes_collat) {
		this.dizzy_notes_collat = dizzy_notes_collat;
	}


	public String getFaint_time_collat() {
		return faint_time_collat;
	}


	public void setFaint_time_collat(String faint_time_collat) {
		this.faint_time_collat = faint_time_collat;
	}


	public String getFaint_freq_collat() {
		return faint_freq_collat;
	}


	public void setFaint_freq_collat(String faint_freq_collat) {
		this.faint_freq_collat = faint_freq_collat;
	}


	public String getFaint_notes_collat() {
		return faint_notes_collat;
	}


	public void setFaint_notes_collat(String faint_notes_collat) {
		this.faint_notes_collat = faint_notes_collat;
	}


	public String getHeadaches_time_collat() {
		return headaches_time_collat;
	}


	public void setHeadaches_time_collat(String headaches_time_collat) {
		this.headaches_time_collat = headaches_time_collat;
	}


	public String getHeadaches_freq_collat() {
		return headaches_freq_collat;
	}


	public void setHeadaches_freq_collat(String headaches_freq_collat) {
		this.headaches_freq_collat = headaches_freq_collat;
	}


	public String getHeadaches_notes_collat() {
		return headaches_notes_collat;
	}


	public void setHeadaches_notes_collat(String headaches_notes_collat) {
		this.headaches_notes_collat = headaches_notes_collat;
	}


	public String getFalling_time_collat() {
		return falling_time_collat;
	}


	public void setFalling_time_collat(String falling_time_collat) {
		this.falling_time_collat = falling_time_collat;
	}


	public String getFalling_freq_collat() {
		return falling_freq_collat;
	}


	public void setFalling_freq_collat(String falling_freq_collat) {
		this.falling_freq_collat = falling_freq_collat;
	}


	public String getFalling_notes_collat() {
		return falling_notes_collat;
	}


	public void setFalling_notes_collat(String falling_notes_collat) {
		this.falling_notes_collat = falling_notes_collat;
	}


	public String getSeizures_time_collat() {
		return seizures_time_collat;
	}


	public void setSeizures_time_collat(String seizures_time_collat) {
		this.seizures_time_collat = seizures_time_collat;
	}


	public String getSeizures_freq_collat() {
		return seizures_freq_collat;
	}


	public void setSeizures_freq_collat(String seizures_freq_collat) {
		this.seizures_freq_collat = seizures_freq_collat;
	}


	public String getSeizures_notes_collat() {
		return seizures_notes_collat;
	}


	public void setSeizures_notes_collat(String seizures_notes_collat) {
		this.seizures_notes_collat = seizures_notes_collat;
	}	
	
}
