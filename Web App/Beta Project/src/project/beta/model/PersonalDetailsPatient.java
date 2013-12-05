package project.beta.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class PersonalDetailsPatient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key key;
	
	private int pID;
	private String pName, pGender, pAddress, pHomeTelNumber, pMobNumber, pEmail, pAreaOfStudy, pOccupation, pCounty;
	private String gpName, gpAddress, gpCounty, pFamilyPresent;
	
	@Basic
	private Date pDOB;
	private int pAge, pAgeLeftEdu;
	private boolean pJunior, pSenior, pThird, pIsFamilyPresent;
	
	public PersonalDetailsPatient(int pid)
	{
		pID = pid;
		pName = pGender = pAddress = pHomeTelNumber = pMobNumber = pEmail = pAreaOfStudy = pOccupation = pCounty = "";
		gpName = gpAddress = gpCounty = pFamilyPresent = "";
		pDOB = new Date();
		pAge = pAgeLeftEdu = 0;
		pJunior = pSenior = pThird = pIsFamilyPresent = false;
	}
	
	public String getName() {
		return pName;
	}

	public void setName(String pName) {
		this.pName = pName;
	}
	
	public int getID() {
		return pID;
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

	public String getFamilyPresent() {
		return pFamilyPresent;
	}

	public void setFamilyPresent(String pFamilyPresent) {
		this.pFamilyPresent = pFamilyPresent;
	}

	public Date getDOB() {
		return pDOB;
	}

	public void setDOB(Date pDOB) {
		this.pDOB = pDOB;
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

	public boolean isJunior() {
		return pJunior;
	}

	public void setJunior(boolean pJunior) {
		this.pJunior = pJunior;
	}

	public boolean isSenior() {
		return pSenior;
	}

	public void setSenior(boolean pSenior) {
		this.pSenior = pSenior;
	}

	public boolean isThird() {
		return pThird;
	}

	public void setThird(boolean pThird) {
		this.pThird = pThird;
	}

	public boolean isIsFamilyPresent() {
		return pIsFamilyPresent;
	}

	public void setIsFamilyPresent(boolean pIsFamilyPresent) {
		this.pIsFamilyPresent = pIsFamilyPresent;
	}

	@Override
	public String toString() {
		return "PersonalDetailsPatient [pName=" + pName + ", pGender="
				+ pGender + ", pAddress=" + pAddress + ", pHomeTelNumber="
				+ pHomeTelNumber + ", pMobNumber=" + pMobNumber + ", pEmail="
				+ pEmail + ", pAreaOfStudy=" + pAreaOfStudy + ", pOccupation="
				+ pOccupation + ", pCounty=" + pCounty + ", gpName=" + gpName
				+ ", gpAddress=" + gpAddress + ", gpCounty=" + gpCounty
				+ ", pFamilyPresent=" + pFamilyPresent + ", pDOB=" + pDOB
				+ ", pAge=" + pAge + ", pAgeLeftEdu=" + pAgeLeftEdu
				+ ", pJunior=" + pJunior + ", pSenior=" + pSenior + ", pThird="
				+ pThird + ", pIsFamilyPresent=" + pIsFamilyPresent + "]";
	}
}
