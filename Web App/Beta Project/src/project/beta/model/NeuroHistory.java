package project.beta.model;

public class NeuroHistory {

	int pID;
	boolean blackout, blank, blurred_vision, dizziness, fainting, headaches, falling, seizures;
	boolean blackout_collat, blank_collat, blurred_vision_collat, dizziness_collat;
	boolean fainting_collat, headaches_collat, falling_collat, seizures_collat;
	
	String blackout_time, blackout_freq, blackout_notes;
	String blanks_time, blanks_freq, blanks_notes;
	String blurred_time, blurred_freq, blurred_notes;
	String dizzy_time, dizzy_freq, dizzy_notes;
	String faint_time, faint_freq, faint_notes;
	String headaches_time, headaches_freq, headaches_notes;
	String falling_time, falling_freq, falling_notes;
	String seizures_time, seizures_freq, seizures_notes;
	
	String blackout_collat_time, blackout_collat_freq, blackout_collat_notes;
	String blanks_collat_time, blanks_collat_freq, blanks_collat_notes;
	String blurred_collat_time, blurred_collat_freq, blurred_collat_notes;
	String dizzy_collat_time, dizzy_collat_freq, dizzy_collat_notes;
	String faint_collat_time, faint_collat_freq, faint_collat_notes;
	String headaches_collat_time, headaches_collat_freq, headaches_collat_notes;
	String falling_collat_time, falling_collat_freq, falling_collat_notes;
	String seizures_collat_time, seizures_collat_freq, seizures_collat_notes;
	
	public NeuroHistory(int id)
	{
		pID = id;
		blackout = blank = blurred_vision = dizziness = fainting = headaches = falling = seizures = false;
		blackout_collat = blank_collat = blurred_vision_collat = dizziness_collat = false;
		fainting_collat = headaches_collat = falling_collat = seizures_collat = false;
		
		blackout_time = blackout_freq = blackout_notes = "";
		blanks_time = blanks_freq = blanks_notes = "";
		blurred_time = blurred_freq = blurred_notes = "";
		dizzy_time = dizzy_freq = dizzy_notes = "";
		faint_time = faint_freq = faint_notes = "";
		headaches_time = headaches_freq = headaches_notes = "";
		falling_time = falling_freq = falling_notes = "";
		seizures_time = seizures_freq = seizures_notes = "";
		
		blackout_collat_time = blackout_collat_freq = blackout_collat_notes = "";
		blanks_collat_time = blanks_collat_freq = blanks_collat_notes = "";
		blurred_collat_time = blurred_collat_freq = blurred_collat_notes = "";
		dizzy_collat_time = dizzy_collat_freq = dizzy_collat_notes = "";
		faint_collat_time = faint_collat_freq = faint_collat_notes = "";
		headaches_collat_time = headaches_collat_freq = headaches_collat_notes = "";
		falling_collat_time = falling_collat_freq = falling_collat_notes = "";
		seizures_collat_time = seizures_collat_freq = seizures_collat_notes = "";
	}

	@Override
	public String toString() {
		return "NeuroHistory [pID=" + pID + ", blackout=" + blackout
				+ ", blank=" + blank + ", blurred_vision=" + blurred_vision
				+ ", dizziness=" + dizziness + ", fainting=" + fainting
				+ ", headaches=" + headaches + ", balance=" + falling
				+ ", seizures=" + seizures + ", blackout_collat="
				+ blackout_collat + ", blank_collat=" + blank_collat
				+ ", blurred_vision_collat=" + blurred_vision_collat
				+ ", dizziness_collat=" + dizziness_collat
				+ ", fainting_collat=" + fainting_collat
				+ ", headaches_collat=" + headaches_collat
				+ ", balance_collat=" + falling_collat + ", seizures_collat="
				+ seizures_collat + ", blackout_time=" + blackout_time
				+ ", blackout_freq=" + blackout_freq + ", blackout_notes="
				+ blackout_notes + ", blanks_time=" + blanks_time
				+ ", blanks_freq=" + blanks_freq + ", blanks_notes="
				+ blanks_notes + ", blurred_time=" + blurred_time
				+ ", blurred_freq=" + blurred_freq + ", blurred_notes="
				+ blurred_notes + ", dizzy_time=" + dizzy_time
				+ ", dizzy_freq=" + dizzy_freq + ", dizzy_notes=" + dizzy_notes
				+ ", faint_time=" + faint_time + ", faint_freq=" + faint_freq
				+ ", faint_notes=" + faint_notes + ", headaches_time="
				+ headaches_time + ", headaches_freq=" + headaches_freq
				+ ", headaches_notes=" + headaches_notes + ", falling_time="
				+ falling_time + ", falling_freq=" + falling_freq
				+ ", falling_notes=" + falling_notes + ", seizures_time="
				+ seizures_time + ", seizures_freq=" + seizures_freq
				+ ", seizures_notes=" + seizures_notes
				+ ", blackout_collat_time=" + blackout_collat_time
				+ ", blackout_collat_freq=" + blackout_collat_freq
				+ ", blackout_collat_notes=" + blackout_collat_notes
				+ ", blanks_collat_time=" + blanks_collat_time
				+ ", blanks_collat_freq=" + blanks_collat_freq
				+ ", blanks_collat_notes=" + blanks_collat_notes
				+ ", blurred_collat_time=" + blurred_collat_time
				+ ", blurred_collat_freq=" + blurred_collat_freq
				+ ", blurred_collat_notes=" + blurred_collat_notes
				+ ", dizzy_collat_time=" + dizzy_collat_time
				+ ", dizzy_collat_freq=" + dizzy_collat_freq
				+ ", dizzy_collat_notes=" + dizzy_collat_notes
				+ ", faint_collat_time=" + faint_collat_time
				+ ", faint_collat_freq=" + faint_collat_freq
				+ ", faint_collat_notes=" + faint_collat_notes
				+ ", headaches_collat_time=" + headaches_collat_time
				+ ", headaches_collat_freq=" + headaches_collat_freq
				+ ", headaches_collat_notes=" + headaches_collat_notes
				+ ", falling_collat_time=" + falling_collat_time
				+ ", falling_collat_freq=" + falling_collat_freq
				+ ", falling_collat_notes=" + falling_collat_notes
				+ ", seizures_collat_time=" + seizures_collat_time
				+ ", seizures_collat_freq=" + seizures_collat_freq
				+ ", seizures_collat_notes=" + seizures_collat_notes + "]";
	}

	public boolean isBlackout() {
		return blackout;
	}

	public void setBlackout(boolean blackout) {
		this.blackout = blackout;
	}

	public boolean isBlank() {
		return blank;
	}

	public void setBlank(boolean blank) {
		this.blank = blank;
	}

	public boolean isBlurred_vision() {
		return blurred_vision;
	}

	public void setBlurred_vision(boolean blurred_vision) {
		this.blurred_vision = blurred_vision;
	}

	public boolean isDizziness() {
		return dizziness;
	}

	public void setDizziness(boolean dizziness) {
		this.dizziness = dizziness;
	}

	public boolean isFainting() {
		return fainting;
	}

	public void setFainting(boolean fainting) {
		this.fainting = fainting;
	}

	public boolean isHeadaches() {
		return headaches;
	}

	public void setHeadaches(boolean headaches) {
		this.headaches = headaches;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isSeizures() {
		return seizures;
	}

	public void setSeizures(boolean seizures) {
		this.seizures = seizures;
	}

	public boolean isBlackout_collat() {
		return blackout_collat;
	}

	public void setBlackout_collat(boolean blackout_collat) {
		this.blackout_collat = blackout_collat;
	}

	public boolean isBlank_collat() {
		return blank_collat;
	}

	public void setBlank_collat(boolean blank_collat) {
		this.blank_collat = blank_collat;
	}

	public boolean isBlurred_vision_collat() {
		return blurred_vision_collat;
	}

	public void setBlurred_vision_collat(boolean blurred_vision_collat) {
		this.blurred_vision_collat = blurred_vision_collat;
	}

	public boolean isDizziness_collat() {
		return dizziness_collat;
	}

	public void setDizziness_collat(boolean dizziness_collat) {
		this.dizziness_collat = dizziness_collat;
	}

	public boolean isFainting_collat() {
		return fainting_collat;
	}

	public void setFainting_collat(boolean fainting_collat) {
		this.fainting_collat = fainting_collat;
	}

	public boolean isHeadaches_collat() {
		return headaches_collat;
	}

	public void setHeadaches_collat(boolean headaches_collat) {
		this.headaches_collat = headaches_collat;
	}

	public boolean isFalling_collat() {
		return falling_collat;
	}

	public void setFalling_collat(boolean falling_collat) {
		this.falling_collat = falling_collat;
	}

	public boolean isSeizures_collat() {
		return seizures_collat;
	}

	public void setSeizures_collat(boolean seizures_collat) {
		this.seizures_collat = seizures_collat;
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

	public String getBlackout_collat_time() {
		return blackout_collat_time;
	}

	public void setBlackout_collat_time(String blackout_collat_time) {
		this.blackout_collat_time = blackout_collat_time;
	}

	public String getBlackout_collat_freq() {
		return blackout_collat_freq;
	}

	public void setBlackout_collat_freq(String blackout_collat_freq) {
		this.blackout_collat_freq = blackout_collat_freq;
	}

	public String getBlackout_collat_notes() {
		return blackout_collat_notes;
	}

	public void setBlackout_collat_notes(String blackout_collat_notes) {
		this.blackout_collat_notes = blackout_collat_notes;
	}

	public String getBlanks_collat_time() {
		return blanks_collat_time;
	}

	public void setBlanks_collat_time(String blanks_collat_time) {
		this.blanks_collat_time = blanks_collat_time;
	}

	public String getBlanks_collat_freq() {
		return blanks_collat_freq;
	}

	public void setBlanks_collat_freq(String blanks_collat_freq) {
		this.blanks_collat_freq = blanks_collat_freq;
	}

	public String getBlanks_collat_notes() {
		return blanks_collat_notes;
	}

	public void setBlanks_collat_notes(String blanks_collat_notes) {
		this.blanks_collat_notes = blanks_collat_notes;
	}

	public String getBlurred_collat_time() {
		return blurred_collat_time;
	}

	public void setBlurred_collat_time(String blurred_collat_time) {
		this.blurred_collat_time = blurred_collat_time;
	}

	public String getBlurred_collat_freq() {
		return blurred_collat_freq;
	}

	public void setBlurred_collat_freq(String blurred_collat_freq) {
		this.blurred_collat_freq = blurred_collat_freq;
	}

	public String getBlurred_collat_notes() {
		return blurred_collat_notes;
	}

	public void setBlurred_collat_notes(String blurred_collat_notes) {
		this.blurred_collat_notes = blurred_collat_notes;
	}

	public String getDizzy_collat_time() {
		return dizzy_collat_time;
	}

	public void setDizzy_collat_time(String dizzy_collat_time) {
		this.dizzy_collat_time = dizzy_collat_time;
	}

	public String getDizzy_collat_freq() {
		return dizzy_collat_freq;
	}

	public void setDizzy_collat_freq(String dizzy_collat_freq) {
		this.dizzy_collat_freq = dizzy_collat_freq;
	}

	public String getDizzy_collat_notes() {
		return dizzy_collat_notes;
	}

	public void setDizzy_collat_notes(String dizzy_collat_notes) {
		this.dizzy_collat_notes = dizzy_collat_notes;
	}

	public String getFaint_collat_time() {
		return faint_collat_time;
	}

	public void setFaint_collat_time(String faint_collat_time) {
		this.faint_collat_time = faint_collat_time;
	}

	public String getFaint_collat_freq() {
		return faint_collat_freq;
	}

	public void setFaint_collat_freq(String faint_collat_freq) {
		this.faint_collat_freq = faint_collat_freq;
	}

	public String getFaint_collat_notes() {
		return faint_collat_notes;
	}

	public void setFaint_collat_notes(String faint_collat_notes) {
		this.faint_collat_notes = faint_collat_notes;
	}

	public String getHeadaches_collat_time() {
		return headaches_collat_time;
	}

	public void setHeadaches_collat_time(String headaches_collat_time) {
		this.headaches_collat_time = headaches_collat_time;
	}

	public String getHeadaches_collat_freq() {
		return headaches_collat_freq;
	}

	public void setHeadaches_collat_freq(String headaches_collat_freq) {
		this.headaches_collat_freq = headaches_collat_freq;
	}

	public String getHeadaches_collat_notes() {
		return headaches_collat_notes;
	}

	public void setHeadaches_collat_notes(String headaches_collat_notes) {
		this.headaches_collat_notes = headaches_collat_notes;
	}

	public String getFalling_collat_time() {
		return falling_collat_time;
	}

	public void setFalling_collat_time(String falling_collat_time) {
		this.falling_collat_time = falling_collat_time;
	}

	public String getFalling_collat_freq() {
		return falling_collat_freq;
	}

	public void setFalling_collat_freq(String falling_collat_freq) {
		this.falling_collat_freq = falling_collat_freq;
	}

	public String getFalling_collat_notes() {
		return falling_collat_notes;
	}

	public void setFalling_collat_notes(String falling_collat_notes) {
		this.falling_collat_notes = falling_collat_notes;
	}

	public String getSeizures_collat_time() {
		return seizures_collat_time;
	}

	public void setSeizures_collat_time(String seizures_collat_time) {
		this.seizures_collat_time = seizures_collat_time;
	}

	public String getSeizures_collat_freq() {
		return seizures_collat_freq;
	}

	public void setSeizures_collat_freq(String seizures_collat_freq) {
		this.seizures_collat_freq = seizures_collat_freq;
	}

	public String getSeizures_collat_notes() {
		return seizures_collat_notes;
	}

	public void setSeizures_collat_notes(String seizures_collat_notes) {
		this.seizures_collat_notes = seizures_collat_notes;
	}

	public int getpID() {
		return pID;
	}
}
