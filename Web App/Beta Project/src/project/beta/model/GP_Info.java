package project.beta.model;

public class GP_Info {

	int pID;
	boolean discuss_gp;
	String gp_result, gp_meds, gp_notes;
	float cholesterol, thyroid, b12, iron, calcium, sodium;
	String test_result_notes;
	String family_reaction, reaction_length, family_reaction_notes;
	
	public GP_Info(int pid)
	{
		pID = pid;
		discuss_gp = false;
		gp_result = gp_meds = gp_notes = "";
		cholesterol = thyroid = b12 = iron = calcium = sodium = 0.f;
		test_result_notes = "";
		family_reaction = reaction_length = family_reaction_notes = "";
	}

	public boolean isDiscuss_gp() {
		return discuss_gp;
	}

	public void setDiscuss_gp(boolean discuss_gp) {
		this.discuss_gp = discuss_gp;
	}

	public String getGp_result() {
		return gp_result;
	}

	public void setGp_result(String gp_result) {
		this.gp_result = gp_result;
	}

	public String getGp_meds() {
		return gp_meds;
	}

	public void setGp_meds(String gp_meds) {
		this.gp_meds = gp_meds;
	}

	public String getGp_notes() {
		return gp_notes;
	}

	public void setGp_notes(String gp_notes) {
		this.gp_notes = gp_notes;
	}

	public float getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(float cholesterol) {
		this.cholesterol = cholesterol;
	}

	public float getThyroid() {
		return thyroid;
	}

	public void setThyroid(float thyroid) {
		this.thyroid = thyroid;
	}

	public float getB12() {
		return b12;
	}

	public void setB12(float b12) {
		this.b12 = b12;
	}

	public float getIron() {
		return iron;
	}

	public void setIron(float iron) {
		this.iron = iron;
	}

	public float getCalcium() {
		return calcium;
	}

	public void setCalcium(float calcium) {
		this.calcium = calcium;
	}

	public float getSodium() {
		return sodium;
	}

	public void setSodium(float sodium) {
		this.sodium = sodium;
	}

	public String getTest_result_notes() {
		return test_result_notes;
	}

	public void setTest_result_notes(String test_result_notes) {
		this.test_result_notes = test_result_notes;
	}

	public String getFamily_reaction() {
		return family_reaction;
	}

	public void setFamily_reaction(String family_reaction) {
		this.family_reaction = family_reaction;
	}

	public String getReaction_length() {
		return reaction_length;
	}

	public void setReaction_length(String reaction_length) {
		this.reaction_length = reaction_length;
	}

	public String getFamily_reaction_notes() {
		return family_reaction_notes;
	}

	public void setFamily_reaction_notes(String family_reaction_notes) {
		this.family_reaction_notes = family_reaction_notes;
	}

	public int getpID() {
		return pID;
	}

	@Override
	public String toString() {
		return "GP_Info [pID=" + pID + ", discuss_gp=" + discuss_gp
				+ ", gp_result=" + gp_result + ", gp_meds=" + gp_meds
				+ ", gp_notes=" + gp_notes + ", cholesterol=" + cholesterol
				+ ", thyroid=" + thyroid + ", b12=" + b12 + ", iron=" + iron
				+ ", calcium=" + calcium + ", sodium=" + sodium
				+ ", test_result_notes=" + test_result_notes
				+ ", family_reaction=" + family_reaction + ", reaction_length="
				+ reaction_length + ", family_reaction_notes="
				+ family_reaction_notes + "]";
	}
	
}
