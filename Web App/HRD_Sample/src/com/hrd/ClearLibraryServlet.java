package com.hrd;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ClearLibraryServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String suc = Boolean.toString(Library.ClearLibrary());
		
		resp.setContentType("text/plain");
		resp.getWriter().print("Cleared Library: " + suc);
	}
}
