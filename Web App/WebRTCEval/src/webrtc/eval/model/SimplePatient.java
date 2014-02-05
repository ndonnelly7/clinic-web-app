package webrtc.eval.model;

public class SimplePatient {

	private String ppsn;
	public boolean stress, memory, alcohol, diet, sleep, dementia; 
	public SimplePatient(Patient p){
		this.ppsn = p.getPpsn();
		this.stress = p.stress;
		this.memory = p.memory;
		this.alcohol = p.alcohol;
		this.diet = p.diet;
		this.sleep = p.sleep;
		this.dementia = p.dementia;
	}
	
	public String getPPSN(){
		return ppsn;
	}
}
