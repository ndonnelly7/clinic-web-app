package project.beta.model;

public class NeuroHistory {

	int pID;
	boolean blackout, blank, blurred_vision, dizziness, fainting, headaches, balance, seizures;
	boolean blackout_collat, blank_collat, blurred_vision_collat, dizziness_collat;
	boolean fainting_collat, headaches_collat, balance_collat, seizures_collat;
	
	
	
	public NeuroHistory(int id)
	{
		pID = id;
	}
}
