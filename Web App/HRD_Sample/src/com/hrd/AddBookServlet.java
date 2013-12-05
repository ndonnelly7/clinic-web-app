package com.hrd;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddBookServlet  extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String bookName = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		int length = Integer.parseInt(req.getParameter("length"));
		Date publishDate = new Date();
		try {
			publishDate = (new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(req.getParameter("date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Book b = new Book();
		b.setDetails(bookName, author, publishDate, publisher, length);
		System.out.println(b);
		
		boolean res = Library.addBook(b);
		System.out.println(Library.getLibrary());
		
		resp.setContentType("text/plain");
		resp.getWriter().print(Boolean.toString(res));
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req,resp);
	}
}
