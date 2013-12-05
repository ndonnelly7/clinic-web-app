package channel.experiment.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import channel.experiment.model.ChatBox;

@SuppressWarnings("serial")
public class NameCheckServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String username = req.getParameter("username");
		String chatname = req.getParameter("chatname");
		
		ChatBox cb = ChatBox.GetIfExistsChatBox(chatname);
		if(cb == null)
		{
			resp.setContentType("text/plain");
			resp.getWriter().print("no_box");
			ChatBox.PutBackChatBox("chatboxkey", cb);
			return;
		}
		
		if(cb.validateUser(username)){
			resp.setContentType("text/plain");
			resp.getWriter().print("name_taken");
			ChatBox.PutBackChatBox("chatboxkey", cb);
			return;
		}
		System.out.println(cb.getName());
		ChatBox.PutBackChatBox("chatboxkey", cb);
		resp.setContentType("text/plain");
		resp.getWriter().print("good");
	}
}
