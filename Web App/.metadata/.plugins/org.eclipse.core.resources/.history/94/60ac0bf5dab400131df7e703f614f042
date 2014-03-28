package webrtc.eval.model;

public class SimplePatient {

	private String ppsn;
	public boolean stress, memory, alcohol, diet, sleep, dementia;
	String stress_cause; 
	public int weight, alcoPoints, sleep_hours, mem_score;
	public SimplePatient(Patient p){
		this.ppsn = p.getPpsn();
		this.stress = p.stress;
		this.memory = p.memory;
		this.alcohol = p.alcohol;
		this.diet = p.diet;
		this.sleep = p.sleep;
		this.dementia = p.dementia;
		
		this.stress_cause = p.stress_cause;
		this.weight = p.weight;
		this.alcoPoints = p.alcoPoints;
		this.sleep_hours = p.sleep_hours;
		this.mem_score = p.mem_score;
	}
	
	public String getPPSN(){
		return ppsn;
	}
}
