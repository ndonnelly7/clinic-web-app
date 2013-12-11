package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.Analysis;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class AnalysisServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		Analysis a = new Analysis(0);
		BuildAnalysis(a, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/results.jsp");
		view.forward(req, resp);
	}
	
	private void BuildAnalysis(Analysis a, HttpServletRequest req)
	{
		a.setMmse_result(req.getParameter("mmse_result"));
		a.setCdt_result(req.getParameter("cdt_result"));
		a.setMini_cog_result(req.getParameter("mini_cog_result"));
		a.setGds_result(req.getParameter("gds_result"));
		
		a.setImpression(req.getParameter("impression"));
		a.setImpression_notes(req.getParameter("impression_notes"));
		a.setFollow_up(req.getParameter("follow_up"));
		a.setFollow_notes(req.getParameter("follow_notes"));
		
		String[] outcomes = req.getParameterValues("outcome_select");
		String[] outcome_notes = req.getParameterValues("outcome_entry_notes");
		for(int i = 0; i < outcomes.length; i++)
		{
			a.addOutcome(outcomes[i]);
			a.addOutcomeNotes(outcome_notes[i]);
		}
		
		a.setLetter(req.getParameter("letter_notes"));
		a.setNotes(req.getParameter("extra_notes"));
	}
}
