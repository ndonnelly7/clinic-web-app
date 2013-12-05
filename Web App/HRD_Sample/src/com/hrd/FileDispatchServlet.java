package com.hrd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FileDispatchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String page = req.getParameter("page");
		
		RequestDispatcher view = req.getRequestDispatcher("/jsp/" + page + ".jsp");
		view.forward(req, resp);
	}
}
