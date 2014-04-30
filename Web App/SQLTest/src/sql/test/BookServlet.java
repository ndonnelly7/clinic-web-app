package sql.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.utils.SystemProperty;

@SuppressWarnings("serial")
public class BookServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {
		
		Map<String, String> properties = new HashMap<String, String>();
	    if (SystemProperty.environment.value() ==
	    		SystemProperty.Environment.Value.Production) {
	    		System.out.println("In production???!!!");
	    } else {
	      properties.put("javax.persistence.jdbc.driver",
	          "com.mysql.jdbc.Driver");
	      properties.put("javax.persistence.jdbc.url",
	          System.getProperty("cloudsql.url.dev"));
	    }

		String bT;
		int id = 0;
		
		bT = req.getParameter("title");
		
		FullWork work = new FullWork(bT);
		BookPart bp = new BookPart();
		BeanPopulate.populateBean(bp, req);
		work.setBook(bp);
		WorkDAO dao = new WorkDAO();
		id = dao.addFullWork(work);
		
		req.setAttribute("id", id);
		RequestDispatcher view = req.getRequestDispatcher("/jsp/second.jsp");
		view.forward(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {
		
		doPost(req, resp);
	}
}


