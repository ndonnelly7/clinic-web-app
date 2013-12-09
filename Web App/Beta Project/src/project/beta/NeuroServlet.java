package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.NeuroHistory;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class NeuroServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		NeuroHistory neuro = new NeuroHistory(0);
		BuildNeuro(neuro, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/events_activities.jsp");
		view.forward(req, resp);
	}
	
	private void BuildNeuro(NeuroHistory n, HttpServletRequest req) {
		String[] times = req.getParameterValues("time_frame");
		String[] frequencies = req.getParameterValues("frequency");
		int index = 0;
		
		String blackoutCheck = req.getParameter("blackout_check");
		if(blackoutCheck != "" && blackoutCheck != null) {
			n.setBlackout(blackoutCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isBlackout()){
				n.setBlackout_time(times[index]);
				n.setBlackout_freq(frequencies[index]);
				n.setBlackout_notes(req.getParameter("blackout_notes"));
				index++;
			}
		}
		
		String blankCheck = req.getParameter("blank_check");
		if(blankCheck != "" && blankCheck != null) {
			n.setBlank(blankCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isBlank()){
				n.setBlanks_time(times[index]);
				n.setBlanks_freq(frequencies[index]);
				n.setBlanks_notes(req.getParameter("blank_notes"));
				index++;
			}
		}
		
		String blurred_visionCheck = req.getParameter("vision_check");
		if(blurred_visionCheck != "" && blurred_visionCheck != null) {
			n.setBlurred_vision(blurred_visionCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isBlurred_vision()){
				n.setBlurred_time(times[index]);
				n.setBlurred_freq(frequencies[index]);
				n.setBlurred_notes(req.getParameter("vision_notes"));
				index++;
			}
		}
		
		String dizzinessCheck = req.getParameter("dizziness_check");
		if(dizzinessCheck != "" && dizzinessCheck != null) {
			n.setDizziness(dizzinessCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isDizziness()){
				n.setDizzy_time(times[index]);
				n.setDizzy_freq(frequencies[index]);
				n.setDizzy_notes(req.getParameter("dizziness_notes"));
				index++;
			}
		}
		
		String faintingCheck = req.getParameter("fainting_check");
		if(faintingCheck != "" && faintingCheck != null) {
			n.setFainting(faintingCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isFainting()){
				n.setFaint_time(times[index]);
				n.setFaint_freq(frequencies[index]);
				n.setFaint_notes(req.getParameter("fainting_notes"));
				index++;
			}
		}
		
		String headachesCheck = req.getParameter("headaches_check");
		if(headachesCheck != "" && headachesCheck != null) {
			n.setHeadaches(headachesCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isHeadaches()){
				n.setHeadaches_time(times[index]);
				n.setHeadaches_freq(frequencies[index]);
				n.setHeadaches_notes(req.getParameter("headaches_notes"));
				index++;
			}
		}
		
		String fallingCheck = req.getParameter("falling_check");
		if(fallingCheck != "" && fallingCheck != null) {
			n.setFalling(fallingCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isFalling()){
				n.setFalling_time(times[index]);
				n.setFalling_freq(frequencies[index]);
				n.setFalling_notes(req.getParameter("falling_notes"));
				index++;
			}
		}
		
		String seizuresCheck = req.getParameter("seizures_check");
		if(seizuresCheck != "" && seizuresCheck != null) {
			n.setSeizures(seizuresCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isSeizures()){
				n.setSeizures_time(times[index]);
				n.setSeizures_freq(frequencies[index]);
				n.setSeizures_notes(req.getParameter("seizures_notes"));
				index++;
			}
		}
		
		String blackoutCollatCheck = req.getParameter("blackout_collat_check");
		if(blackoutCollatCheck != "" && blackoutCollatCheck != null) {
			n.setBlackout(blackoutCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isBlackout()){
				n.setBlackout_collat_time(times[index]);
				n.setBlackout_collat_freq(frequencies[index]);
				n.setBlackout_collat_notes(req.getParameter("blackout_collat_notes"));
				index++;
			}
		}
		
		String blankCollatCheck = req.getParameter("blank_collat_check");
		if(blankCollatCheck != "" && blankCollatCheck != null) {
			n.setBlank(blankCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isBlank()){
				n.setBlanks_collat_time(times[index]);
				n.setBlanks_collat_freq(frequencies[index]);
				n.setBlanks_collat_notes(req.getParameter("blank_collat_notes"));
				index++;
			}
		}
		
		String blurred_visionCollatCheck = req.getParameter("vision_collat_check");
		if(blurred_visionCollatCheck != "" && blurred_visionCollatCheck != null) {
			n.setBlurred_vision(blurred_visionCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isBlurred_vision()){
				n.setBlurred_collat_time(times[index]);
				n.setBlurred_collat_freq(frequencies[index]);
				n.setBlurred_collat_notes(req.getParameter("vision_collat_notes"));
				index++;
			}
		}
		
		String dizzinessCollatCheck = req.getParameter("dizziness_collat_check");
		if(dizzinessCollatCheck != "" && dizzinessCollatCheck != null) {
			n.setDizziness(dizzinessCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isDizziness()){
				n.setDizzy_collat_time(times[index]);
				n.setDizzy_collat_freq(frequencies[index]);
				n.setDizzy_collat_notes(req.getParameter("dizziness_collat_notes"));
				index++;
			}
		}
		
		String faintingCollatCheck = req.getParameter("fainting_collat_check");
		if(faintingCollatCheck != "" && faintingCollatCheck != null) {
			n.setFainting(faintingCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isFainting()){
				n.setFaint_collat_time(times[index]);
				n.setFaint_collat_freq(frequencies[index]);
				n.setFaint_collat_notes(req.getParameter("fainting_collat_notes"));
				index++;
			}
		}
		
		String headachesCollatCheck = req.getParameter("headaches_collat_check");
		if(headachesCollatCheck != "" && headachesCollatCheck != null) {
			n.setHeadaches(headachesCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isHeadaches()){
				n.setHeadaches_collat_time(times[index]);
				n.setHeadaches_collat_freq(frequencies[index]);
				n.setHeadaches_collat_notes(req.getParameter("headaches_collat_notes"));
				index++;
			}
		}
		
		String fallingCollatCheck = req.getParameter("falling_collat_check");
		if(fallingCollatCheck != "" && fallingCollatCheck != null) {
			n.setFalling(fallingCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isFalling()){
				n.setFalling_collat_time(times[index]);
				n.setFalling_collat_freq(frequencies[index]);
				n.setFalling_collat_notes(req.getParameter("falling_collat_notes"));
				index++;
			}
		}
		
		String seizuresCollatCheck = req.getParameter("seizures_collat_check");
		if(seizuresCollatCheck != "" && seizuresCollatCheck != null) {
			n.setSeizures(seizuresCollatCheck.equalsIgnoreCase("on") ? true : false);
			if(n.isSeizures()){
				n.setSeizures_collat_time(times[index]);
				n.setSeizures_collat_freq(frequencies[index]);
				n.setSeizures_collat_notes(req.getParameter("seizures_collat_notes"));
				index++;
			}
		}
	}
}
