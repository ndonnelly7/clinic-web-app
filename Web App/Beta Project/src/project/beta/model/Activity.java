package project.beta.model;

public class Activity {
	String type, involvement, time_changed, notes;
	int current_hours, prev_hours;
	
	public Activity(String type, String involvement){
		this.type= type;
		this.involvement = involvement;
		
		time_changed = "";
		notes = "";
		current_hours = -1;
		prev_hours = -1;
	}

	@Override
	public String toString() {
		return "Activity [type=" + type + ", involvement=" + involvement
				+ ", time_changed=" + time_changed + ", notes=" + notes
				+ ", current_hours=" + current_hours + ", prev_hours="
				+ prev_hours + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInvolvement() {
		return involvement;
	}

	public void setInvolvement(String involvement) {
		this.involvement = involvement;
	}

	public String getTime_changed() {
		return time_changed;
	}

	public void setTime_changed(String time_changed) {
		this.time_changed = time_changed;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCurrent_hours() {
		return current_hours;
	}

	public void setCurrent_hours(int current_hours) {
		this.current_hours = current_hours;
	}

	public int getPrev_hours() {
		return prev_hours;
	}

	public void setPrev_hours(int prev_hours) {
		this.prev_hours = prev_hours;
	}
	
}
