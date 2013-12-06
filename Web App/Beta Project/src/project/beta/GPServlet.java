package project.beta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		buildGPInfo(info, req);
		
		//Add GP_Info to Patient then update patient on system
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/concerns.jsp");
		view.forward(req, resp);
		
	}
	
	private void buildGPInfo(GP_Info info, HttpServletRequest req)
	{
		String gpCheck = req.getParameter("gp_talked");
		if(gpCheck != null && gpCheck != ""){
			info.setDiscuss_gp(gpCheck.equalsIgnoreCase("on") ? true:false);
			info.setGp_result(req.getParameter("gp_results"));
			info.setGp_meds(req.getParameter("gp_meds"));
			info.setGp_notes(req.getParameter("gp_notes"));
		}
		
		String ch = req.getParameter("cholest_test");
		String th = req.getParameter("thryoid_test");
		String b12 = req.getParameter("b12_test");
		String iron = req.getParameter("iron_test");
		String cal = req.getParameter("calc_test");
		String sod = req.getParameter("sodium_test");
		
		if(ch != "" && ch != null){
			info.setCholesterol(Float.parseFloat(ch));
			info.setChol_time(req.getParameter("chol_time"));
		}
		
		if(th != "" && th != null){
			info.setThyroid(Float.parseFloat(th));
			info.setThyroid_time(req.getParameter("thyroid_time"));
		}
		
		if(b12 != "" && b12 != null){
			info.setB12(Float.parseFloat(b12));
			info.setB12_time(req.getParameter("b12_time"));
		}
		
		if(iron != "" && iron != null){
			info.setIron(Float.parseFloat(iron));
			info.setIron_time(req.getParameter("iron_time"));
		}
		
		if(cal != "" && cal != null){
			info.setCalcium(Float.parseFloat(cal));
			info.setCalcium_time(req.getParameter("calc_time"));
		}
		
		if(cal != "" && cal != null){
			info.setSodium(Float.parseFloat(sod));
			info.setSodium_time(req.getParameter("sodium_time"));
		}
		
		info.setTest_result_notes(req.getParameter("med_test_notes"));
		
		info.setFamily_reaction("kin_response");
		info.setReaction_length("response_time");
		info.setFamily_reaction_notes("kin_notes");
	}
}
