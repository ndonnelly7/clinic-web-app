package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.EventsActivities;
import project.beta.model.LivingSit;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LivingServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		LivingSit ls = new LivingSit(0);
		BuildLivingSit(ls, req);
		
		//Add Concerns to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/events_activities.jsp");
		view.forward(req, resp);
	}
	
	private void BuildLivingSit(LivingSit ls, HttpServletRequest req)
	{
		
	}
}
