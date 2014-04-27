package sql.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FilmPart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	String title, author, publisher;
	@Basic
	Date release;
	
	public FilmPart(String t, String a, String p, String d){
		title = t;
		author = a;
		publisher = p;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}
}
