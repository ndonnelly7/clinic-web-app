package com.cloud.clinic.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * This is used to open a jsp when a link for it is clicked
 */
@SuppressWarnings("serial")
public class FileDispatchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String page = req.getParameter("page");
		
		req.setAttribute("hidden", page);
		req.setAttribute("patient", "no");
		req.setAttribute("source", "file_dispatch");
		RequestDispatcher view = req.getRequestDispatcher("/patientform/" + page + ".jsp");
		view.forward(req, resp);
	}
}
