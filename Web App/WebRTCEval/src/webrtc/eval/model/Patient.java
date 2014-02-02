package webrtc.eval.model;

import java.util.ArrayList;

public class Patient {

	private String name;
	private String email;
	private String ppsn;
	private int id;
	private ArrayList<Client> clinicians;
	private Clinic clinic;
	
	public Patient(String name, String email, String ppsn, int id, Client addingClient, Clinic clinic) {
		super();
		this.name = name;
		this.email = email;
		this.ppsn = ppsn;
		this.id = id;
		clinicians = new ArrayList<Client>();
		clinicians.add(addingClient);
		
		this.clinic = clinic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Client> getClinicians() {
		return clinicians;
	}

	public void setClinicians(ArrayList<Client> clinicians) {
		this.clinicians = clinicians;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public String getPpsn() {
		return ppsn;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", email=" + email + ", ppsn=" + ppsn
				+ ", id=" + id + ", clinicians=" + clinicians + ", clinic="
				+ clinic + "]";
	}
	
}
