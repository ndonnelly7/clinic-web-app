package project.alpha.model;

import java.util.Date;

import com.google.appengine.api.datastore.Key;

public class Patient {
	
	private Key key;
	
	private Object userCreated;
	
	public String pName, pGender, pAddress, pHomeTelNumber, pMobNumber, pEmail, pAreaOfStudy, pOccupation, pCounty;
	public String gpName, gpAddress, gpCounty;
	public Date pDOB;
	public int pID, pAge, pAgeLeftEdu;
	public boolean pJunior, pSenior, pThird;
	
	public Patient(int patientID){
		pID = patientID;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Object getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(Object userCreated) {
		this.userCreated = userCreated;
	}

	public String getName() {
		return pName;
	}

	public void setName(String pName) {
		this.pName = pName;
	}

	public String getGender() {
		return pGender;
	}

	public void setGender(String pGender) {
		this.pGender = pGender;
	}

	public String getAddress() {
		return pAddress;
	}

	public void setAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public String getHomeTelNumber() {
		return pHomeTelNumber;
	}

	public void setHomeTelNumber(String pHomeTelNumber) {
		this.pHomeTelNumber = pHomeTelNumber;
	}

	public String getMobNumber() {
		return pMobNumber;
	}

	public void setMobNumber(String pMobNumber) {
		this.pMobNumber = pMobNumber;
	}

	public String getEmail() {
		return pEmail;
	}

	public void setEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public String getAreaOfStudy() {
		return pAreaOfStudy;
	}

	public void setAreaOfStudy(String pAreaOfStudy) {
		this.pAreaOfStudy = pAreaOfStudy;
	}

	public String getOccupation() {
		return pOccupation;
	}

	public void setOccupation(String pOccupation) {
		this.pOccupation = pOccupation;
	}

	public String getCounty() {
		return pCounty;
	}

	public void setCounty(String pCounty) {
		this.pCounty = pCounty;
	}

	public String getGpName() {
		return gpName;
	}

	public void setGpName(String gpName) {
		this.gpName = gpName;
	}

	public String getGpAddress() {
		return gpAddress;
	}

	public void setGpAddress(String gpAddress) {
		this.gpAddress = gpAddress;
	}

	public String getGpCounty() {
		return gpCounty;
	}

	public void setGpCounty(String gpCounty) {
		this.gpCounty = gpCounty;
	}

	public Date getDOB() {
		return pDOB;
	}

	public void setDOB(Date pDOB) {
		this.pDOB = pDOB;
	}

	public int getID() {
		return pID;
	}

	public void setID(int pID) {
		this.pID = pID;
	}

	public int getAge() {
		return pAge;
	}

	public void setAge(int pAge) {
		this.pAge = pAge;
	}

	public int getAgeLeftEdu() {
		return pAgeLeftEdu;
	}

	public void setAgeLeftEdu(int pAgeLeftEdu) {
		this.pAgeLeftEdu = pAgeLeftEdu;
	}

	public boolean hasJuniorEdu() {
		return pJunior;
	}

	public void setJunior(boolean pJunior) {
		this.pJunior = pJunior;
	}

	public boolean hasSeniorEdu() {
		return pSenior;
	}

	public void setSenior(boolean pSenior) {
		this.pSenior = pSenior;
	}

	public boolean hasThirdEdu() {
		return pThird;
	}

	public void setThird(boolean pThird) {
		this.pThird = pThird;
	}
}
