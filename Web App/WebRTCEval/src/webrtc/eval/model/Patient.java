package webrtc.eval.model;

import java.util.ArrayList;
import java.util.Random;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Patient {

	private String ppsn;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	@ElementCollection
	private ArrayList<Key> clinicians;
	private Key clinicID;
	
	public boolean stress, memory, alcohol, diet, sleep, dementia;
	
	public Patient(String ppsn, Client addingClient, Key clinic) {
		super();
		this.ppsn = ppsn;
		clinicians = new ArrayList<Key>();
		clinicians.add(addingClient.getcID());
		
		this.clinicID = clinic;
		Random r = new Random(System.currentTimeMillis());
		stress = r.nextInt(10)%2==0;
		memory = r.nextInt(10)%2==0;
		alcohol = r.nextInt(10)%2==0;
		diet = r.nextInt(10)%2==0;
		sleep = r.nextInt(10)%2==0;
		dementia = r.nextInt(10)%2==0;
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
