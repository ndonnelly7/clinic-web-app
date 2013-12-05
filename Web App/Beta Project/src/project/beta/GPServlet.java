package project.beta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.GP_Info;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GPServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		System.out.println("User name: " + user.getNickname());
		System.out.println("User id: " + user.getUserId());
		System.out.println("User email: " + user.getEmail());
		
		//TODO: Put in User Store and Patient Store stuff
		
		GP_Info info = new GP_Info(0);
		
	}
	
	private void buildGPInfo(GP_Info info, HttpServletRequest req)
	{
		String gpCheck = req.getParameter("gp_talked");
		if(gpCheck != null){
			info.setDiscuss_gp(gpCheck.equalsIgnoreCase("on") ? true:false);
			info.setGp_result(req.getParameter("gp_results"));
			info.setGp_meds(req.getParameter("gp_meds"));
		}
		
	}
}
