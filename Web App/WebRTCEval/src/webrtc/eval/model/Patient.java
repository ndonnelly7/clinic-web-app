package webrtc.eval.model;

import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Patient {

	private String ppsn;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private ArrayList<Key> clinicians;
	private Key clinicID;
	
	public boolean stress, memory, alcohol, diet, sleep, dementia;
	public String stress_cause;
	public int weight, alcoPoints, sleep_hours, mem_score;
	
	public Patient(String ppsn, Client addingClient, Key clinic, String weight,
			String alcoPoints, String stressCause, String sleepHours, String mem, String dementiaString) {
		super();
		this.ppsn = ppsn;
		clinicians = new ArrayList<Key>();
		clinicians.add(addingClient.getcID());
		
		this.clinicID = clinic;
		
		stress_cause = stressCause;
		stress = !(stress_cause.equalsIgnoreCase("on"));
		
		mem_score = Integer.parseInt(mem);
		memory = (mem_score < 50);
		
		this.alcoPoints = Integer.parseInt(alcoPoints);
		alcohol = (this.alcoPoints > 16);
		
		this.weight = Integer.parseInt(weight);
		diet = (this.weight > 90 || this.weight < 50);
		
		this.sleep_hours = Integer.parseInt(sleepHours);
		sleep = (sleep_hours > 12 || sleep_hours < 5);
		
		this.dementia = dementiaString.equalsIgnoreCase("on");
	}

	public ArrayList<Key> getClinicians() {
		return clinicians;
	}

	public void addClinician(Client c){
		clinicians.add(c.getcID());
	}

	public Key getClinicID() {
		return clinicID;
	}

	public void setClinicID(Key clinic) {
		this.clinicID = clinic;
	}

	public String getPpsn() {
		return ppsn;
	}

	public Key getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "Patient [ppsn=" + ppsn + ", id=" + key
				+ ", clinicians=" + clinicians + ", clinic="
				+ clinicID + "]";
	}
	
}