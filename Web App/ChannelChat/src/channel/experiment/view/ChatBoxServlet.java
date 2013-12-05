package channel.experiment.view;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import channel.experiment.model.ChatBox;

@SuppressWarnings("serial")
public class ChatBoxServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ChatBoxServlet.class.getName());
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String sender = req.getParameter("name");
		String message = req.getParameter("message");
		String chatName = req.getParameter("chat");
		
		ChatBox cb = ChatBox.GetChatBox(chatName);
		cb.broadcastMessage(message, sender);
		System.err.println("From ChatBoxServlet: " + sender + " has said: " + message);
		ChatBox.PutBackChatBox(chatName, cb);
		
		log.info("Sending message from " + sender + " with message: " + message);
		resp.setContentType("text/plain");
		resp.getWriter().print("good.");
	}
}
