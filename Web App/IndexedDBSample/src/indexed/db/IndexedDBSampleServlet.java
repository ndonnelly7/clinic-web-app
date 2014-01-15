package indexed.db;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class IndexedDBSampleServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String number = req.getParameter("number");
		String email = req.getParameter("email");
		String item = req.getParameter("bought_item");
		String location = req.getParameter("location");
		String sales_person = req.getParameter("sales_person");
		String dob = req.getParameter("dob");
		String key_str = req.getParameter("key"); //This is a an attempt at random key generated by client
		
		Date ddob = new Date();
		if(dob!=null && dob!=""){
			try {
				ddob = (new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		int random_id = 0;
		if(key_str!= null && key_str != ""){
			random_id = Integer.parseInt(key_str);
		}
		
		Customer c = new Customer(name,address,number,email,item,sales_person,location, ddob);
		if(!CustomerStore.addCustomer(c)){
			System.out.println("Failed to add customer: " + name);
		}
		System.out.println(CustomerStore.findCustomer(c.getKey()));
		
		//The random number generated by client is returned to the client to confirm that this is the customer they're talking about
		//The server also provides a randomly generated long which should be completely unique
		//This long can then be set as the key of the correct customer
		req.setAttribute("id", random_id);
		req.setAttribute("key", c.getKey());
		RequestDispatcher view = req.getRequestDispatcher("/success.jsp");
		view.forward(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		CustomerStore.ClearStore();
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("Cleared");
	}
}
