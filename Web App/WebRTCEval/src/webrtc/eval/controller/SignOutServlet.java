package webrtc.eval.controller;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SignOutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		//Sign user out of system
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}