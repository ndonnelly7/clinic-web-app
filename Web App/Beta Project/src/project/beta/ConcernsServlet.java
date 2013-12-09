package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Concerns;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ConcernsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		Concerns cons = new Concerns(0);
		buildConcerns(cons, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/neuro.jsp");
		view.forward(req, resp);
	}
	
	private void buildConcerns(Concerns c, HttpServletRequest req) {
		String[] times = req.getParameterValues("time_frame");
		String[] frequencies = req.getParameterValues("frequency");
		int index = 0;
		
		String recCheck = req.getParameter("rec_events_check");
		if(recCheck != "" && recCheck != null) {
			c.setRecEventsCheck(recCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isRecEventsCheck()){
				c.setRecEventsTime(times[index]);
				c.setRecEventsFreq(frequencies[index]);
				c.setRecEventsNotes(req.getParameter("rec_event_notes"));
				index++;
			}
		}
		
		String facesCheck = req.getParameter("faces_check");
		if(facesCheck != "" && facesCheck != null) {
			c.setFacesCheck(facesCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isFacesCheck()){
				c.setFacesTime(times[index]);
				c.setFacesFreq(frequencies[index]);
				c.setFacesNotes(req.getParameter("faces_notes"));
				index++;
			}
		}
		
		String namesCheck = req.getParameter("names_check");
		if(namesCheck != "" && namesCheck != null) {
			c.setNamesCheck(namesCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isNamesCheck()){
				c.setNamesTime(times[index]);
				c.setNamesFreq(frequencies[index]);
				c.setNamesNotes(req.getParameter("names_notes"));
			}
		}
		
		String losingCheck = req.getParameter("losing_things_check");
		if(losingCheck != "" && losingCheck != null) {
			c.setLosingThingsCheck(losingCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isLosingThingsCheck()){
				c.setLosingThingsTime(times[index]);
				c.setLosingThingsFreq(frequencies[index]);
				c.setLosingThingsNotes(req.getParameter("losing_things_notes"));
			}
		}
		
		String followCheck = req.getParameter("follow_conv_check");
		if(followCheck != "" && followCheck != null) {
			c.setFollowConversationsCheck(followCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isFollowConversationsCheck()) {
				c.setFollowConversationTime(times[index]);
				c.setFollowConversationFreq(frequencies[index]);
				c.setFollowConversationNotes(req.getParameter("follow_conv_notes"));
			}
		}
		
		String wordsCheck = req.getParameter("right_words_check");
		if(wordsCheck != "" && wordsCheck != null) {
			c.setRightWordsCheck(wordsCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isRightWordsCheck()) {
				c.setRightWordsTime(times[index]);
				c.setRightWordsFreq(frequencies[index]);
				c.setRightWordsNotes(req.getParameter("right_words_notes"));
			}
		}
		
		String decisionCheck = req.getParameter("decision_making_check");
		if(decisionCheck != "" && decisionCheck != null) {
			c.setDecisionMakingCheck(decisionCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isDecisionMakingCheck()) {
				c.setDecisionMakingTime(times[index]);
				c.setDecisionMakingFreq(frequencies[index]);
				c.setDecisionMakingNotes(req.getParameter("decision_making_notes"));
			}
		}
		
		String calculationsCheck = req.getParameter("calculations_check");
		if(calculationsCheck != "" && calculationsCheck != null) {
			c.setCalculationsCheck(calculationsCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isCalculationsCheck()) {
				c.setCalculationsTime(times[index]);
				c.setCalculationsFreq(frequencies[index]);
				c.setCalculationsNotes(req.getParameter("calculations_notes"));
			}
		}
		
		String prospCheck = req.getParameter("prospective_check");
		if(prospCheck != "" && prospCheck != null) {
			c.setProspMemoryCheck(prospCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isProspMemoryCheck()) {
				c.setProspMemoryTime(times[index]);
				c.setProspMemoryFreq(frequencies[index]);
				c.setProspMemoryNotes(req.getParameter("prospective_notes"));
			}
		}
		
		String anxCheck = req.getParameter("anxiety_check");
		if(anxCheck != "" && anxCheck != null) {
			c.setAnxietyCheck(anxCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isAnxietyCheck()) {
				c.setAnxietyTime(times[index]);
				c.setAnxietyFreq(frequencies[index]);
				c.setAnxietyNotes(req.getParameter("anxiety_notes"));
			}
		}
		
		String commentsCheck = req.getParameter("comments_check");
		if(commentsCheck != "" && commentsCheck != null) {
			c.setCommentsCheck(commentsCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isCommentsCheck()) {
				c.setCommentsTime(times[index]);
				c.setCommentsFreq(frequencies[index]);
				c.setCommentsNotes(req.getParameter("comments_notes"));
			}
		}
		
		
		//Collateral
		String recCollatCheck = req.getParameter("rec_events_check_collat");
		if(recCollatCheck != "" && recCollatCheck != null) {
			c.setRecEventsCollatCheck(recCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isRecEventsCollatCheck()){
				c.setRecEventsCollatTime(times[index]);
				c.setRecEventsCollatFreq(frequencies[index]);
				c.setRecEventsCollatNotes(req.getParameter("rec_event_notes_collat"));
				index++;
			}
		}
		
		String facesCollatCheck = req.getParameter("faces_check_collat");
		if(facesCollatCheck != "" && facesCollatCheck != null) {
			c.setFacesCollatCheck(facesCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isFacesCollatCheck()){
				c.setFacesCollatTime(times[index]);
				c.setFacesCollatFreq(frequencies[index]);
				c.setFacesCollatNotes(req.getParameter("faces_notes_collat"));
				index++;
			}
		}
		
		String namesCollatCheck = req.getParameter("names_check_collat");
		if(namesCollatCheck != "" && namesCollatCheck != null) {
			c.setNamesCollatCheck(namesCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isNamesCollatCheck()){
				c.setNamesCollatTime(times[index]);
				c.setNamesCollatFreq(frequencies[index]);
				c.setNamesCollatNotes(req.getParameter("names_notes_collat"));
			}
		}
		
		String losingCollatCheck = req.getParameter("losing_things_check_collat");
		if(losingCollatCheck != "" && losingCollatCheck != null) {
			c.setLosingThingsCollatCheck(losingCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isLosingThingsCollatCheck()){
				c.setLosingThingsCollatTime(times[index]);
				c.setLosingThingsCollatFreq(frequencies[index]);
				c.setLosingThingsCollatNotes(req.getParameter("losing_things_notes_collat"));
			}
		}
		
		String followCollatCheck = req.getParameter("follow_conv_check_collat");
		if(followCollatCheck != "" && followCollatCheck != null) {
			c.setFollowConversationsCollatCheck(followCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isFollowConversationsCollatCheck()) {
				c.setFollowConversationCollatTime(times[index]);
				c.setFollowConversationCollatFreq(frequencies[index]);
				c.setFollowConversationCollatNotes(req.getParameter("follow_conv_notes_collat"));
			}
		}
		
		String wordsCollatCheck = req.getParameter("right_words_check_collat");
		if(wordsCollatCheck != "" && wordsCollatCheck != null) {
			c.setRightWordsCollatCheck(wordsCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isRightWordsCollatCheck()) {
				c.setRightWordsCollatTime(times[index]);
				c.setRightWordsCollatFreq(frequencies[index]);
				c.setRightWordsCollatNotes(req.getParameter("right_words_notes_collat"));
			}
		}
		
		String decisionCollatCheck = req.getParameter("decision_making_check_collat");
		if(decisionCollatCheck != "" && decisionCollatCheck != null) {
			c.setDecisionMakingCollatCheck(decisionCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isDecisionMakingCollatCheck()) {
				c.setDecisionMakingCollatTime(times[index]);
				c.setDecisionMakingCollatFreq(frequencies[index]);
				c.setDecisionMakingCollatNotes(req.getParameter("decision_making_notes_collat"));
			}
		}
		
		String calculationsCollatCheck = req.getParameter("calculations_check_collat");
		if(calculationsCollatCheck != "" && calculationsCollatCheck != null) {
			c.setCalculationsCollatCheck(calculationsCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isCalculationsCollatCheck()) {
				c.setCalculationsCollatTime(times[index]);
				c.setCalculationsCollatFreq(frequencies[index]);
				c.setCalculationsCollatNotes(req.getParameter("calculations_notes_collat"));
			}
		}
		
		String prospCollatCheck = req.getParameter("prospective_check_collat");
		if(prospCollatCheck != "" && prospCollatCheck != null) {
			c.setProspMemoryCollatCheck(prospCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isProspMemoryCollatCheck()) {
				c.setProspMemoryCollatTime(times[index]);
				c.setProspMemoryCollatFreq(frequencies[index]);
				c.setProspMemoryCollatNotes(req.getParameter("prospective_notes_collat"));
			}
		}
		
		String anxCollatCheck = req.getParameter("anxiety_check_collat");
		if(anxCollatCheck != "" && anxCollatCheck != null) {
			c.setAnxietyCollatCheck(anxCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isAnxietyCollatCheck()) {
				c.setAnxietyCollatTime(times[index]);
				c.setAnxietyCollatFreq(frequencies[index]);
				c.setAnxietyCollatNotes(req.getParameter("anxiety_notes_collat"));
			}
		}
		
		String commentsCollatCheck = req.getParameter("comments_check_collat");
		if(commentsCollatCheck != "" && commentsCollatCheck != null) {
			c.setCommentsCollatCheck(commentsCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(c.isCommentsCollatCheck()) {
				c.setCommentsCollatTime(times[index]);
				c.setCommentsCollatFreq(frequencies[index]);
				c.setCommentsCollatNotes(req.getParameter("comments_notes_collat"));
			}
		}
	}
}
