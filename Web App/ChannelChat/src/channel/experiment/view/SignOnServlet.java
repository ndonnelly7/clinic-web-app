package channel.experiment.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import channel.experiment.model.ChatBox;
import channel.experiment.model.ChatUser;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class SignOnServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		String username = req.getParameter("username");
		String chatName = req.getParameter("chatname");
		String create_or_join = req.getParameter("choice");
		
		System.out.println("Choice param: " + create_or_join);
		req.setAttribute("user", user);
		req.setAttribute("username", username);
		req.setAttribute("chatname", chatName);
		
		ChatBox cb;
		if(create_or_join.equals("join")){
			cb = ChatBox.GetIfExistsChatBox(chatName);
		} else if(create_or_join.equals("create")){
			cb = ChatBox.GetChatBox(chatName);
		} else if(create_or_join.equals("clear")){
			System.out.println("Entered clear cache check");
			cb = ChatBox.GetChatBox(chatName);
			ChatBox.ClearCache();
			RequestDispatcher view = req.getRequestDispatcher("/jsp/clear.jsp");
			view.forward(req, resp);
			return;
		} else {
			RequestDispatcher view = req.getRequestDispatcher("/jsp/error.jsp");
			view.forward(req, resp);
			return;
		}
		
		ChatUser u = new ChatUser(username, user, user.getUserId());
		
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String token = channelService.createChannel(user.getUserId());
		req.setAttribute("channeltoken", token);
		
		cb.subscribe(u);
		System.out.println("From SignOnServlet: ");
		System.out.println(username + " has joined " + chatName);
		System.out.println("Current number of users: " + cb.getNumUsers() + "\n");
		ChatBox.PutBackChatBox(chatName, cb);
		cb.broadcastMessage(username + " has joined the chat", "Announcement");
		RequestDispatcher view = req.getRequestDispatcher("/jsp/chat.jsp");
		view.forward(req, resp);
	}
}