package channel.experiment.view;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import channel.experiment.model.ChatBox;

@SuppressWarnings("serial")
public class SignOutServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(SignOutServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
				
		String clientUsername = req.getParameter("name");
		String chatName = req.getParameter("chat");
		log.warning(clientUsername + " is leaving the room " + chatName);
		
		ChatBox cb = ChatBox.GetChatBox(chatName);
		System.err.println("Num users: " + cb.getNumUsers());
		log.warning("Unsubscribing " + clientUsername);
		cb.unsubWithUsername(clientUsername);
		System.err.println("Client " + clientUsername + " has disconnected");
		if(cb.getNumUsers() > 0)
			ChatBox.PutBackChatBox(cb.getName(), cb);
		else {
			System.err.println("Clearing the cache of the box as no more users");
			ChatBox.ClearBoxFromCache(cb.getName());
		}

		System.err.println("Forwarding to signout.jsp");
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/signout.jsp");
		view.forward(req, resp);
	}
}
