package indexed.db;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class InfoRetrievalServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String key_str = req.getParameter("key");
		
		long key = 0;
		if(key_str!= null && key_str != ""){
			key = Long.parseLong(key_str);
		}		
		
		Gson gson = new Gson();
		Customer c = CustomerStore.findCustomer(key);
		System.out.println(c);
		String json_resp = gson.toJson(c);
		System.out.println(json_resp);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json_resp);
	}	
}
