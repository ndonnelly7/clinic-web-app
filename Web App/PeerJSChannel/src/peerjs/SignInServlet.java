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
		
		//Assign a channel to the user using the user's username as the token
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String token = channelService.createChannel(name);
		//Send the channel token back to the user so they know exactly what it is
		req.setAttribute("channel", token);
		
		//Add the User to the active list of users
		MExUser u = new MExUser(name, token);
		UserList ul = UserList.GetUserList();
		ul.addUser(u);
		UserList.PutBackUserList(ul);
		
		//Send the user to the movieExchange page
		RequestDispatcher view = req.getRequestDispatcher("/MovieExchange.jsp");
		view.forward(req, resp);
	}

}
