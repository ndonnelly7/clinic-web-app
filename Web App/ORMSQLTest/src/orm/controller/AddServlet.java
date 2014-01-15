package orm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.model.Actor;
import orm.model.Movie;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String title = req.getParameter("title");
		String director = req.getParameter("director");
		String tag = req.getParameter("tag");
		Date release = new Date();
		if(req.getParameter("release_date") != null && req.getParameter("release_date") != "") {
			try {
				release = (new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(req.getParameter("release_date")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		String[] actor_names = req.getParameterValues("actor_name");
		String[] actor_dates = req.getParameterValues("actor_dob");
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for(int i = 0; i < actor_names.length; i++){
			Date dob = new Date();
			if(actor_dates[i] != null && actor_dates[i] != "") {
				try {
					dob = (new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(actor_dates[i]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			Actor a = new Actor(actor_names[i], dob);
			actors.add(a);
		}
		
		Movie m = new Movie(title, release, director, tag, actors);
		
		System.out.println(m);
		
		RequestDispatcher view = req.getRequestDispatcher("/success.jsp");
		view.forward(req, resp);	
	}
}