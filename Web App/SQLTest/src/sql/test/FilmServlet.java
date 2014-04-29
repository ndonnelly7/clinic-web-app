package sql.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FilmServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		WorkDAO dao = new WorkDAO();
		String id = req.getParameter("id");
		FullWork fW = null;
		int workID = -1;
		if(id != "")
			workID = Integer.parseInt(id);
		
		if(workID > 0)
			fW = dao.getFullWork(workID);
		
		String[] names = req.getParameterValues("actor_firstname");
		String[] surnames = req.getParameterValues("actor_surname");
		
		FilmPart fp = new FilmPart();
		BeanPopulate.populateBean(fp, req);
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for(int i = 0; i < names.length; i++){
			Actor a = new Actor();
			a.firstname = names[i];
			a.setSurname(surnames[i]);
			actors.add(a);
			a.filmPart = fp;
		}
		fp.setActors(actors);
		if(fW == null){
			fW = new FullWork(fp.title);
			fW.setFilm(fp);
			
			//Once added to DB, then retrieve ID
			dao.addFullWork(fW);
		} else {
			fW.setFilm(fp);
			dao.updateFullWork(fW);
		}
		
		req.setAttribute("id", id);
		RequestDispatcher view = req.getRequestDispatcher("/jsp/review.jsp");
		view.forward(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {
		
		doPost(req, resp);
	}
}
