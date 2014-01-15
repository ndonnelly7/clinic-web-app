package peerjs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

@SuppressWarnings("serial")
public class SignInServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String name = req.getParameter("username");
		
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String token = channelService.createChannel(name);
		req.setAttribute("channel", token);
		
		MExUser u = new MExUser(name, token);
		UserList ul = UserList.GetUserList();
		ul.addUser(u);
		UserList.PutBackChatBox(ul);
		
		RequestDispatcher view = req.getRequestDispatcher("/MovieExchange.jsp");
		view.forward(req, resp);
	}

}
