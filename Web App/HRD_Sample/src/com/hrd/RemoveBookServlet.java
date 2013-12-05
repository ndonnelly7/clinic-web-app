package com.hrd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@SuppressWarnings("serial")
public class RemoveBookServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String bookName = req.getParameter("title");
		System.out.println(bookName);
		
		Library l = Library.getLibrary();
		ArrayList<Book> books = l.findBookByName(bookName);
		System.out.println(books);
		
		Gson gson = new Gson();
		String returnStr = "";
		if(books.size() > 0)
		{
			String json = gson.toJson(books.get(0));
			JsonObject o = (JsonObject) new JsonParser().parse(json);
			JsonElement a = o.get("bAuthor");
			JsonElement n = o.get("bName");
			JsonElement d = o.get("bPublishDate");
			JsonElement p = o.get("bPublisher");
			JsonElement s = o.get("bLength");
			
			returnStr = ("Author: " + a + ", Title: " + n + ", Date: " + d + ", Publisher: " + p + ", Length: " + s + " pages");
		
			returnStr += "\nRemoved confirmation: " + Boolean.toString(Library.removeBook(bookName));
			
		} else {
			returnStr = "Book: " + bookName + " not found to remove";
		}
		resp.setContentType("text/plain");
		resp.getWriter().print(returnStr);
	}
}