package project.alpha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PatDetailsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String age = req.getParameter("gender");
		String adrs = req.getParameter("address");
		String home_tel = req.getParameter("home_tel");
		String mob_tel = req.getParameter("mob_number");
		String email = req.getParameter("email");
		
		req.setAttribute("name", name);
		req.setAttribute("dob", dob);
		req.setAttribute("age", age);
		req.setAttribute("address", adrs);
		req.setAttribute("home_tel", home_tel);
		req.setAttribute("mob_tel", mob_tel);
		req.setAttribute("email", email);
		RequestDispatcher view = req.getRequestDispatcher("/jsp/test.jsp");
		view.forward(req, resp);		
	}
}