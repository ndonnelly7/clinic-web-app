package project.beta.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/*
 * Patient Class used by Program
 * This class is what's stored in the SQL
 */
@Entity(name="Patient")
public class Patient implements java.io.Serializable{
	
	@Transient
	private static final long serialVersionUID = 8153440730792060761L;

	@Id
	@Column(name = "patientID", unique = true, nullable = false)
	private int patientID;	
	
	private String userCreatedID;
	private String originalClinic;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PersonalDetailsPatient personalDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PatientHistory patientHistory;
	@OneToOne(cascade = CascadeType.ALL)
	private GP_Info gpInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private Concerns concerns;
	@OneToOne(cascade = CascadeType.ALL)
	private NeuroHistory neuroHistory;
	@OneToOne(cascade = CascadeType.ALL)
	private EventsActivities eventsActivities;
	@OneToOne(cascade = CascadeType.ALL)
	private LivingSit livingSit;
	@OneToOne(cascade = CascadeType.ALL)
	private Lifestyle lifestyle;
	@OneToOne(cascade = CascadeType.ALL)
	private TestBattery testBattery;
	@OneToOne(cascade = CascadeType.ALL)
	private Analysis analysis;
	
	public Patient(){
		
	}
	

	public int getPatientID() {
		return patientID;
	}


	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	
	public String getOriginalClinic() {
		return originalClinic;
	}


	public void setOriginalClinic(String originalClinic) {
		this.originalClinic = originalClinic;
	}


	public String getUserCreatedID() {
		return userCreatedID;
	}


	public void setUserCreatedID(String userCreatedID) {
		this.userCreatedID = userCreatedID;
	}


	public PersonalDetailsPatient getPersonalDetails() {
		return personalDetails;
	}


	public void setPersonalDetails(PersonalDetailsPatient personalDetails) {
		this.personalDetails = personalDetails;
	}


	public PatientHistory getPatientHistory() {
		return patientHistory;
	}


	public void setPatientHistory(PatientHistory patientHistory) {
		this.patientHistory = patientHistory;
	}


	public GP_Info getGpInfo() {
		return gpInfo;
	}


	public void setGpInfo(GP_Info gpInfo) {
		this.gpInfo = gpInfo;
	}


	public Concerns getConcerns() {
		return concerns;
	}


	public void setConcerns(Concerns concerns) {
		this.concerns = concerns;
	}


	public NeuroHistory getNeuroHistory() {
		return neuroHistory;
	}


	public void setNeuroHistory(NeuroHistory neuroHistory) {
		this.neuroHistory = neuroHistory;
	}


	public EventsActivities getEventsActivities() {
		return eventsActivities;
	}


	public void setEventsActivities(EventsActivities eventsActivities) {
		this.eventsActivities = eventsActivities;
	}


	public LivingSit getLivingSit() {
		return livingSit;
	}


	public void setLivingSit(LivingSit livingSit) {
		this.livingSit = livingSit;
	}


	public Lifestyle getLifestyle() {
		return lifestyle;
	}


	public void setLifestyle(Lifestyle lifestyle) {
		this.lifestyle = lifestyle;
	}


	public TestBattery getTestBattery() {
		return testBattery;
	}


	public void setTestBattery(TestBattery testBattery) {
		this.testBattery = testBattery;
	}


	public Analysis getAnalysis() {
		return analysis;
	}


	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}
	
}
