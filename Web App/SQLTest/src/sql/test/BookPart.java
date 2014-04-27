package sql.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookPart {
	
	String title, director, production;
	Date release;
	
	public BookPart(String t, String a, String p, String d){
		title = t;
		director = a;
		production = p;
		try {
			release = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}
}
