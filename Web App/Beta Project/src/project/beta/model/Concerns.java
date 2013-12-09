package project.beta.model;

public class Concerns {

	int pID;
	
	boolean recEventsCheck, facesCheck, namesCheck, losingThingsCheck, followConversationsCheck;
	boolean rightWordsCheck, decisionMakingCheck, calculationsCheck, prospMemoryCheck, anxietyCheck, commentsCheck;
	String recEventsTime, recEventsFreq, recEventsNotes;
	String facesTime, facesFreq, facesNotes;
	String namesTime, namesFreq, namesNotes;
	String losingThingsTime, losingThingsFreq, losingThingsNotes;
	String followConversationTime, followConversationFreq, followConversationNotes;
	String rightWordsTime, rightWordsFreq, rightWordsNotes;
	String decisionMakingTime, decisionMakingFreq, decisionMakingNotes;
	String calculationsTime, calculationsFreq, calculationsNotes;
	String prospMemoryTime, prospMemoryFreq, prospMemoryNotes;
	String anxietyTime, anxietyFreq, anxietyNotes;
	String commentsTime, commentsFreq, commentsNotes;
	
	boolean recEventsCollatCheck, facesCollatCheck, namesCollatCheck, losingThingsCollatCheck, followConversationsCollatCheck;
	boolean rightWordsCollatCheck, decisionMakingCollatCheck, calculationsCollatCheck, prospMemoryCollatCheck, anxietyCollatCheck, commentsCollatCheck;
	String recEventsCollatTime, recEventsCollatFreq, recEventsCollatNotes;
	String facesCollatTime, facesCollatFreq, facesCollatNotes;
	String namesCollatTime, namesCollatFreq, namesCollatNotes;
	String losingThingsCollatTime, losingThingsCollatFreq, losingThingsCollatNotes;
	String followConversationCollatTime, followConversationCollatFreq, followConversationCollatNotes;
	String rightWordsCollatTime, rightWordsCollatFreq, rightWordsCollatNotes;
	String decisionMakingCollatTime, decisionMakingCollatFreq, decisionMakingCollatNotes;
	String calculationsCollatTime, calculationsCollatFreq, calculationsCollatNotes;
	String prospMemoryCollatTime, prospMemoryCollatFreq, prospMemoryCollatNotes;
	String anxietyCollatTime, anxietyCollatFreq, anxietyCollatNotes;
	String commentsCollatTime, commentsCollatFreq, commentsCollatNotes;
	
	public Concerns(int pid){
		pID = pid;
		
		recEventsCheck = facesCheck = namesCheck = losingThingsCheck = followConversationsCheck = false;
		rightWordsCheck = decisionMakingCheck = calculationsCheck = prospMemoryCheck = anxietyCheck = commentsCheck = false;
		recEventsCollatCheck = facesCollatCheck = namesCollatCheck = losingThingsCollatCheck = followConversationsCollatCheck = false;
		rightWordsCollatCheck = decisionMakingCollatCheck = calculationsCollatCheck = prospMemoryCollatCheck = anxietyCollatCheck = commentsCollatCheck = false;
	
		recEventsTime = recEventsFreq = recEventsNotes = "";
		facesTime = facesFreq = facesNotes = "";
		namesTime = namesFreq = namesNotes = "";
		losingThingsTime = losingThingsFreq = losingThingsNotes = "";
		followConversationTime = followConversationFreq = followConversationNotes = "";
		rightWordsTime = rightWordsFreq = rightWordsNotes = "";
		decisionMakingTime = decisionMakingFreq = decisionMakingNotes = "";
		calculationsTime = calculationsFreq = calculationsNotes = "";
		prospMemoryTime = prospMemoryFreq = prospMemoryNotes = "";
		anxietyTime = anxietyFreq = anxietyNotes = "";
		commentsTime = commentsFreq = commentsNotes = "";
		
		recEventsCollatTime = recEventsCollatFreq = recEventsCollatNotes = "";
		facesCollatTime = facesCollatFreq = facesCollatNotes = "";
		namesCollatTime = namesCollatFreq = namesCollatNotes = "";
		losingThingsCollatTime = losingThingsCollatFreq = losingThingsCollatNotes = "";
		followConversationCollatTime = followConversationCollatFreq = followConversationCollatNotes = "";
		rightWordsCollatTime = rightWordsCollatFreq = rightWordsCollatNotes = "";
		decisionMakingCollatTime = decisionMakingCollatFreq = decisionMakingCollatNotes = "";
		calculationsCollatTime = calculationsCollatFreq = calculationsCollatNotes = "";
		prospMemoryCollatTime = prospMemoryCollatFreq = prospMemoryCollatNotes = "";
		anxietyCollatTime = anxietyCollatFreq = anxietyCollatNotes = "";
		commentsCollatTime = commentsCollatFreq = commentsCollatNotes = "";
	}

	@Override
	public String toString() {
		return "Concerns [pID=" + pID + ", recEventsCheck=" + recEventsCheck
				+ ", facesCheck=" + facesCheck + ", namesCheck=" + namesCheck
				+ ", losingThingsCheck=" + losingThingsCheck
				+ ", followConversationsCheck=" + followConversationsCheck
				+ ", rightWordsCheck=" + rightWordsCheck
				+ ", decisionMakingCheck=" + decisionMakingCheck
				+ ", calculationsCheck=" + calculationsCheck
				+ ", prospMemoryCheck=" + prospMemoryCheck + ", anxietyCheck="
				+ anxietyCheck + ", commentsCheck=" + commentsCheck
				+ ", recEventsTime=" + recEventsTime + ", recEventsFreq="
				+ recEventsFreq + ", recEventsNotes=" + recEventsNotes
				+ ", facesTime=" + facesTime + ", facesFreq=" + facesFreq
				+ ", facesNotes=" + facesNotes + ", namesTime=" + namesTime
				+ ", namesFreq=" + namesFreq + ", namesNotes=" + namesNotes
				+ ", losingThingsTime=" + losingThingsTime
				+ ", losingThingsFreq=" + losingThingsFreq
				+ ", losingThingsNotes=" + losingThingsNotes
				+ ", followConversationTime=" + followConversationTime
				+ ", followConversationFreq=" + followConversationFreq
				+ ", followConversationNotes=" + followConversationNotes
				+ ", rightWordsTime=" + rightWordsTime + ", rightWordsFreq="
				+ rightWordsFreq + ", rightWordsNotes=" + rightWordsNotes
				+ ", decisionMakingTime=" + decisionMakingTime
				+ ", decisionMakingFreq=" + decisionMakingFreq
				+ ", decisionMakingNotes=" + decisionMakingNotes
				+ ", calculationsTime=" + calculationsTime
				+ ", calculationsFreq=" + calculationsFreq
				+ ", calculationsNotes=" + calculationsNotes
				+ ", prospMemoryTime=" + prospMemoryTime + ", prospMemoryFreq="
				+ prospMemoryFreq + ", prospMemoryNotes=" + prospMemoryNotes
				+ ", anxietyTime=" + anxietyTime + ", anxietyFreq="
				+ anxietyFreq + ", anxietyNotes=" + anxietyNotes
				+ ", commentsTime=" + commentsTime + ", commentsFreq="
				+ commentsFreq + ", commentsNotes=" + commentsNotes
				+ ", recEventsCollatCheck=" + recEventsCollatCheck
				+ ", facesCollatCheck=" + facesCollatCheck
				+ ", namesCollatCheck=" + namesCollatCheck
				+ ", losingThingsCollatCheck=" + losingThingsCollatCheck
				+ ", followConversationsCollatCheck="
				+ followConversationsCollatCheck + ", rightWordsCollatCheck="
				+ rightWordsCollatCheck + ", decisionMakingCollatCheck="
				+ decisionMakingCollatCheck + ", calculationsCollatCheck="
				+ calculationsCollatCheck + ", prospMemoryCollatCheck="
				+ prospMemoryCollatCheck + ", anxietyCollatCheck="
				+ anxietyCollatCheck + ", commentsCollatCheck="
				+ commentsCollatCheck + ", recEventsCollatTime="
				+ recEventsCollatTime + ", recEventsCollatFreq="
				+ recEventsCollatFreq + ", recEventsCollatNotes="
				+ recEventsCollatNotes + ", facesCollatTime=" + facesCollatTime
				+ ", facesCollatFreq=" + facesCollatFreq
				+ ", facesCollatNotes=" + facesCollatNotes
				+ ", namesCollatTime=" + namesCollatTime + ", namesCollatFreq="
				+ namesCollatFreq + ", namesCollatNotes=" + namesCollatNotes
				+ ", losingThingsCollatTime=" + losingThingsCollatTime
				+ ", losingThingsCollatFreq=" + losingThingsCollatFreq
				+ ", losingThingsCollatNotes=" + losingThingsCollatNotes
				+ ", followConversationCollatTime="
				+ followConversationCollatTime
				+ ", followConversationCollatFreq="
				+ followConversationCollatFreq
				+ ", followConversationCollatNotes="
				+ followConversationCollatNotes + ", rightWordsCollatTime="
				+ rightWordsCollatTime + ", rightWordsCollatFreq="
				+ rightWordsCollatFreq + ", rightWordsCollatNotes="
				+ rightWordsCollatNotes + ", decisionMakingCollatTime="
				+ decisionMakingCollatTime + ", decisionMakingCollatFreq="
				+ decisionMakingCollatFreq + ", decisionMakingCollatNotes="
				+ decisionMakingCollatNotes + ", calculationsCollatTime="
				+ calculationsCollatTime + ", calculationsCollatFreq="
				+ calculationsCollatFreq + ", calculationsCollatNotes="
				+ calculationsCollatNotes + ", prospMemoryCollatTime="
				+ prospMemoryCollatTime + ", prospMemoryCollatFreq="
				+ prospMemoryCollatFreq + ", prospMemoryCollatNotes="
				+ prospMemoryCollatNotes + ", anxietyCollatTime="
				+ anxietyCollatTime + ", anxietyCollatFreq="
				+ anxietyCollatFreq + ", anxietyCollatNotes="
				+ anxietyCollatNotes + ", commentsCollatTime="
				+ commentsCollatTime + ", commentsCollatFreq="
				+ commentsCollatFreq + ", commentsCollatNotes="
				+ commentsCollatNotes + "]";
	}

	public boolean isRecEventsCheck() {
		return recEventsCheck;
	}

	public void setRecEventsCheck(boolean recEventsCheck) {
		this.recEventsCheck = recEventsCheck;
	}

	public boolean isFacesCheck() {
		return facesCheck;
	}

	public void setFacesCheck(boolean facesCheck) {
		this.facesCheck = facesCheck;
	}

	public boolean isNamesCheck() {
		return namesCheck;
	}

	public void setNamesCheck(boolean namesCheck) {
		this.namesCheck = namesCheck;
	}

	public boolean isLosingThingsCheck() {
		return losingThingsCheck;
	}

	public void setLosingThingsCheck(boolean losingThingsCheck) {
		this.losingThingsCheck = losingThingsCheck;
	}

	public boolean isFollowConversationsCheck() {
		return followConversationsCheck;
	}

	public void setFollowConversationsCheck(boolean followConversationsCheck) {
		this.followConversationsCheck = followConversationsCheck;
	}

	public boolean isRightWordsCheck() {
		return rightWordsCheck;
	}

	public void setRightWordsCheck(boolean rightWordsCheck) {
		this.rightWordsCheck = rightWordsCheck;
	}

	public boolean isDecisionMakingCheck() {
		return decisionMakingCheck;
	}

	public void setDecisionMakingCheck(boolean decisionMakingCheck) {
		this.decisionMakingCheck = decisionMakingCheck;
	}

	public boolean isCalculationsCheck() {
		return calculationsCheck;
	}

	public void setCalculationsCheck(boolean calculationsCheck) {
		this.calculationsCheck = calculationsCheck;
	}

	public boolean isProspMemoryCheck() {
		return prospMemoryCheck;
	}

	public void setProspMemoryCheck(boolean prospMemoryCheck) {
		this.prospMemoryCheck = prospMemoryCheck;
	}

	public boolean isAnxietyCheck() {
		return anxietyCheck;
	}

	public void setAnxietyCheck(boolean anxietyCheck) {
		this.anxietyCheck = anxietyCheck;
	}

	public boolean isCommentsCheck() {
		return commentsCheck;
	}

	public void setCommentsCheck(boolean commentsCheck) {
		this.commentsCheck = commentsCheck;
	}

	public String getRecEventsTime() {
		return recEventsTime;
	}

	public void setRecEventsTime(String recEventsTime) {
		this.recEventsTime = recEventsTime;
	}

	public String getRecEventsFreq() {
		return recEventsFreq;
	}

	public void setRecEventsFreq(String recEventsFreq) {
		this.recEventsFreq = recEventsFreq;
	}

	public String getRecEventsNotes() {
		return recEventsNotes;
	}

	public void setRecEventsNotes(String recEventsNotes) {
		this.recEventsNotes = recEventsNotes;
	}

	public String getFacesTime() {
		return facesTime;
	}

	public void setFacesTime(String facesTime) {
		this.facesTime = facesTime;
	}

	public String getFacesFreq() {
		return facesFreq;
	}

	public void setFacesFreq(String facesFreq) {
		this.facesFreq = facesFreq;
	}

	public String getFacesNotes() {
		return facesNotes;
	}

	public void setFacesNotes(String facesNotes) {
		this.facesNotes = facesNotes;
	}

	public String getNamesTime() {
		return namesTime;
	}

	public void setNamesTime(String namesTime) {
		this.namesTime = namesTime;
	}

	public String getNamesFreq() {
		return namesFreq;
	}

	public void setNamesFreq(String namesFreq) {
		this.namesFreq = namesFreq;
	}

	public String getNamesNotes() {
		return namesNotes;
	}

	public void setNamesNotes(String namesNotes) {
		this.namesNotes = namesNotes;
	}

	public String getLosingThingsTime() {
		return losingThingsTime;
	}

	public void setLosingThingsTime(String losingThingsTime) {
		this.losingThingsTime = losingThingsTime;
	}

	public String getLosingThingsFreq() {
		return losingThingsFreq;
	}

	public void setLosingThingsFreq(String losingThingsFreq) {
		this.losingThingsFreq = losingThingsFreq;
	}

	public String getLosingThingsNotes() {
		return losingThingsNotes;
	}

	public void setLosingThingsNotes(String losingThingsNotes) {
		this.losingThingsNotes = losingThingsNotes;
	}

	public String getFollowConversationTime() {
		return followConversationTime;
	}

	public void setFollowConversationTime(String followConversationTime) {
		this.followConversationTime = followConversationTime;
	}

	public String getFollowConversationFreq() {
		return followConversationFreq;
	}

	public void setFollowConversationFreq(String followConversationFreq) {
		this.followConversationFreq = followConversationFreq;
	}

	public String getFollowConversationNotes() {
		return followConversationNotes;
	}

	public void setFollowConversationNotes(String followConversationNotes) {
		this.followConversationNotes = followConversationNotes;
	}

	public String getRightWordsTime() {
		return rightWordsTime;
	}

	public void setRightWordsTime(String rightWordsTime) {
		this.rightWordsTime = rightWordsTime;
	}

	public String getRightWordsFreq() {
		return rightWordsFreq;
	}

	public void setRightWordsFreq(String rightWordsFreq) {
		this.rightWordsFreq = rightWordsFreq;
	}

	public String getRightWordsNotes() {
		return rightWordsNotes;
	}

	public void setRightWordsNotes(String rightWordsNotes) {
		this.rightWordsNotes = rightWordsNotes;
	}

	public String getDecisionMakingTime() {
		return decisionMakingTime;
	}

	public void setDecisionMakingTime(String decisionMakingTime) {
		this.decisionMakingTime = decisionMakingTime;
	}

	public String getDecisionMakingFreq() {
		return decisionMakingFreq;
	}

	public void setDecisionMakingFreq(String decisionMakingFreq) {
		this.decisionMakingFreq = decisionMakingFreq;
	}

	public String getDecisionMakingNotes() {
		return decisionMakingNotes;
	}

	public void setDecisionMakingNotes(String decisionMakingNotes) {
		this.decisionMakingNotes = decisionMakingNotes;
	}

	public String getCalculationsTime() {
		return calculationsTime;
	}

	public void setCalculationsTime(String calculationsTime) {
		this.calculationsTime = calculationsTime;
	}

	public String getCalculationsFreq() {
		return calculationsFreq;
	}

	public void setCalculationsFreq(String calculationsFreq) {
		this.calculationsFreq = calculationsFreq;
	}

	public String getCalculationsNotes() {
		return calculationsNotes;
	}

	public void setCalculationsNotes(String calculationsNotes) {
		this.calculationsNotes = calculationsNotes;
	}

	public String getProspMemoryTime() {
		return prospMemoryTime;
	}

	public void setProspMemoryTime(String prospMemoryTime) {
		this.prospMemoryTime = prospMemoryTime;
	}

	public String getProspMemoryFreq() {
		return prospMemoryFreq;
	}

	public void setProspMemoryFreq(String prospMemoryFreq) {
		this.prospMemoryFreq = prospMemoryFreq;
	}

	public String getProspMemoryNotes() {
		return prospMemoryNotes;
	}

	public void setProspMemoryNotes(String prospMemoryNotes) {
		this.prospMemoryNotes = prospMemoryNotes;
	}

	public String getAnxietyTime() {
		return anxietyTime;
	}

	public void setAnxietyTime(String anxietyTime) {
		this.anxietyTime = anxietyTime;
	}

	public String getAnxietyFreq() {
		return anxietyFreq;
	}

	public void setAnxietyFreq(String anxietyFreq) {
		this.anxietyFreq = anxietyFreq;
	}

	public String getAnxietyNotes() {
		return anxietyNotes;
	}

	public void setAnxietyNotes(String anxietyNotes) {
		this.anxietyNotes = anxietyNotes;
	}

	public String getCommentsTime() {
		return commentsTime;
	}

	public void setCommentsTime(String commentsTime) {
		this.commentsTime = commentsTime;
	}

	public String getCommentsFreq() {
		return commentsFreq;
	}

	public void setCommentsFreq(String commentsFreq) {
		this.commentsFreq = commentsFreq;
	}

	public String getCommentsNotes() {
		return commentsNotes;
	}

	public void setCommentsNotes(String commentsNotes) {
		this.commentsNotes = commentsNotes;
	}

	public boolean isRecEventsCollatCheck() {
		return recEventsCollatCheck;
	}

	public void setRecEventsCollatCheck(boolean recEventsCollatCheck) {
		this.recEventsCollatCheck = recEventsCollatCheck;
	}

	public boolean isFacesCollatCheck() {
		return facesCollatCheck;
	}

	public void setFacesCollatCheck(boolean facesCollatCheck) {
		this.facesCollatCheck = facesCollatCheck;
	}

	public boolean isNamesCollatCheck() {
		return namesCollatCheck;
	}

	public void setNamesCollatCheck(boolean namesCollatCheck) {
		this.namesCollatCheck = namesCollatCheck;
	}

	public boolean isLosingThingsCollatCheck() {
		return losingThingsCollatCheck;
	}

	public void setLosingThingsCollatCheck(boolean losingThingsCollatCheck) {
		this.losingThingsCollatCheck = losingThingsCollatCheck;
	}

	public boolean isFollowConversationsCollatCheck() {
		return followConversationsCollatCheck;
	}

	public void setFollowConversationsCollatCheck(
			boolean followConversationsCollatCheck) {
		this.followConversationsCollatCheck = followConversationsCollatCheck;
	}

	public boolean isRightWordsCollatCheck() {
		return rightWordsCollatCheck;
	}

	public void setRightWordsCollatCheck(boolean rightWordsCollatCheck) {
		this.rightWordsCollatCheck = rightWordsCollatCheck;
	}

	public boolean isDecisionMakingCollatCheck() {
		return decisionMakingCollatCheck;
	}

	public void setDecisionMakingCollatCheck(boolean decisionMakingCollatCheck) {
		this.decisionMakingCollatCheck = decisionMakingCollatCheck;
	}

	public boolean isCalculationsCollatCheck() {
		return calculationsCollatCheck;
	}

	public void setCalculationsCollatCheck(boolean calculationsCollatCheck) {
		this.calculationsCollatCheck = calculationsCollatCheck;
	}

	public boolean isProspMemoryCollatCheck() {
		return prospMemoryCollatCheck;
	}

	public void setProspMemoryCollatCheck(boolean prospMemoryCollatCheck) {
		this.prospMemoryCollatCheck = prospMemoryCollatCheck;
	}

	public boolean isAnxietyCollatCheck() {
		return anxietyCollatCheck;
	}

	public void setAnxietyCollatCheck(boolean anxietyCollatCheck) {
		this.anxietyCollatCheck = anxietyCollatCheck;
	}

	public boolean isCommentsCollatCheck() {
		return commentsCollatCheck;
	}

	public void setCommentsCollatCheck(boolean commentsCollatCheck) {
		this.commentsCollatCheck = commentsCollatCheck;
	}

	public String getRecEventsCollatTime() {
		return recEventsCollatTime;
	}

	public void setRecEventsCollatTime(String recEventsCollatTime) {
		this.recEventsCollatTime = recEventsCollatTime;
	}

	public String getRecEventsCollatFreq() {
		return recEventsCollatFreq;
	}

	public void setRecEventsCollatFreq(String recEventsCollatFreq) {
		this.recEventsCollatFreq = recEventsCollatFreq;
	}

	public String getRecEventsCollatNotes() {
		return recEventsCollatNotes;
	}

	public void setRecEventsCollatNotes(String recEventsCollatNotes) {
		this.recEventsCollatNotes = recEventsCollatNotes;
	}

	public String getFacesCollatTime() {
		return facesCollatTime;
	}

	public void setFacesCollatTime(String facesCollatTime) {
		this.facesCollatTime = facesCollatTime;
	}

	public String getFacesCollatFreq() {
		return facesCollatFreq;
	}

	public void setFacesCollatFreq(String facesCollatFreq) {
		this.facesCollatFreq = facesCollatFreq;
	}

	public String getFacesCollatNotes() {
		return facesCollatNotes;
	}

	public void setFacesCollatNotes(String facesCollatNotes) {
		this.facesCollatNotes = facesCollatNotes;
	}

	public String getNamesCollatTime() {
		return namesCollatTime;
	}

	public void setNamesCollatTime(String namesCollatTime) {
		this.namesCollatTime = namesCollatTime;
	}

	public String getNamesCollatFreq() {
		return namesCollatFreq;
	}

	public void setNamesCollatFreq(String namesCollatFreq) {
		this.namesCollatFreq = namesCollatFreq;
	}

	public String getNamesCollatNotes() {
		return namesCollatNotes;
	}

	public void setNamesCollatNotes(String namesCollatNotes) {
		this.namesCollatNotes = namesCollatNotes;
	}

	public String getLosingThingsCollatTime() {
		return losingThingsCollatTime;
	}

	public void setLosingThingsCollatTime(String losingThingsCollatTime) {
		this.losingThingsCollatTime = losingThingsCollatTime;
	}

	public String getLosingThingsCollatFreq() {
		return losingThingsCollatFreq;
	}

	public void setLosingThingsCollatFreq(String losingThingsCollatFreq) {
		this.losingThingsCollatFreq = losingThingsCollatFreq;
	}

	public String getLosingThingsCollatNotes() {
		return losingThingsCollatNotes;
	}

	public void setLosingThingsCollatNotes(String losingThingsCollatNotes) {
		this.losingThingsCollatNotes = losingThingsCollatNotes;
	}

	public String getFollowConversationCollatTime() {
		return followConversationCollatTime;
	}

	public void setFollowConversationCollatTime(String followConversationCollatTime) {
		this.followConversationCollatTime = followConversationCollatTime;
	}

	public String getFollowConversationCollatFreq() {
		return followConversationCollatFreq;
	}

	public void setFollowConversationCollatFreq(String followConversationCollatFreq) {
		this.followConversationCollatFreq = followConversationCollatFreq;
	}

	public String getFollowConversationCollatNotes() {
		return followConversationCollatNotes;
	}

	public void setFollowConversationCollatNotes(
			String followConversationCollatNotes) {
		this.followConversationCollatNotes = followConversationCollatNotes;
	}

	public String getRightWordsCollatTime() {
		return rightWordsCollatTime;
	}

	public void setRightWordsCollatTime(String rightWordsCollatTime) {
		this.rightWordsCollatTime = rightWordsCollatTime;
	}

	public String getRightWordsCollatFreq() {
		return rightWordsCollatFreq;
	}

	public void setRightWordsCollatFreq(String rightWordsCollatFreq) {
		this.rightWordsCollatFreq = rightWordsCollatFreq;
	}

	public String getRightWordsCollatNotes() {
		return rightWordsCollatNotes;
	}

	public void setRightWordsCollatNotes(String rightWordsCollatNotes) {
		this.rightWordsCollatNotes = rightWordsCollatNotes;
	}

	public String getDecisionMakingCollatTime() {
		return decisionMakingCollatTime;
	}

	public void setDecisionMakingCollatTime(String decisionMakingCollatTime) {
		this.decisionMakingCollatTime = decisionMakingCollatTime;
	}

	public String getDecisionMakingCollatFreq() {
		return decisionMakingCollatFreq;
	}

	public void setDecisionMakingCollatFreq(String decisionMakingCollatFreq) {
		this.decisionMakingCollatFreq = decisionMakingCollatFreq;
	}

	public String getDecisionMakingCollatNotes() {
		return decisionMakingCollatNotes;
	}

	public void setDecisionMakingCollatNotes(String decisionMakingCollatNotes) {
		this.decisionMakingCollatNotes = decisionMakingCollatNotes;
	}

	public String getCalculationsCollatTime() {
		return calculationsCollatTime;
	}

	public void setCalculationsCollatTime(String calculationsCollatTime) {
		this.calculationsCollatTime = calculationsCollatTime;
	}

	public String getCalculationsCollatFreq() {
		return calculationsCollatFreq;
	}

	public void setCalculationsCollatFreq(String calculationsCollatFreq) {
		this.calculationsCollatFreq = calculationsCollatFreq;
	}

	public String getCalculationsCollatNotes() {
		return calculationsCollatNotes;
	}

	public void setCalculationsCollatNotes(String calculationsCollatNotes) {
		this.calculationsCollatNotes = calculationsCollatNotes;
	}

	public String getProspMemoryCollatTime() {
		return prospMemoryCollatTime;
	}

	public void setProspMemoryCollatTime(String prospMemoryCollatTime) {
		this.prospMemoryCollatTime = prospMemoryCollatTime;
	}

	public String getProspMemoryCollatFreq() {
		return prospMemoryCollatFreq;
	}

	public void setProspMemoryCollatFreq(String prospMemoryCollatFreq) {
		this.prospMemoryCollatFreq = prospMemoryCollatFreq;
	}

	public String getProspMemoryCollatNotes() {
		return prospMemoryCollatNotes;
	}

	public void setProspMemoryCollatNotes(String prospMemoryCollatNotes) {
		this.prospMemoryCollatNotes = prospMemoryCollatNotes;
	}

	public String getAnxietyCollatTime() {
		return anxietyCollatTime;
	}

	public void setAnxietyCollatTime(String anxietyCollatTime) {
		this.anxietyCollatTime = anxietyCollatTime;
	}

	public String getAnxietyCollatFreq() {
		return anxietyCollatFreq;
	}

	public void setAnxietyCollatFreq(String anxietyCollatFreq) {
		this.anxietyCollatFreq = anxietyCollatFreq;
	}

	public String getAnxietyCollatNotes() {
		return anxietyCollatNotes;
	}

	public void setAnxietyCollatNotes(String anxietyCollatNotes) {
		this.anxietyCollatNotes = anxietyCollatNotes;
	}

	public String getCommentsCollatTime() {
		return commentsCollatTime;
	}

	public void setCommentsCollatTime(String commentsCollatTime) {
		this.commentsCollatTime = commentsCollatTime;
	}

	public String getCommentsCollatFreq() {
		return commentsCollatFreq;
	}

	public void setCommentsCollatFreq(String commentsCollatFreq) {
		this.commentsCollatFreq = commentsCollatFreq;
	}

	public String getCommentsCollatNotes() {
		return commentsCollatNotes;
	}

	public void setCommentsCollatNotes(String commentsCollatNotes) {
		this.commentsCollatNotes = commentsCollatNotes;
	}

	public int getpID() {
		return pID;
	}
}