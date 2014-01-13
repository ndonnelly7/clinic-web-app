package orm.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
	private String title;
	private Date releaseDate;
	private String director;
	private String tagline;
	private ArrayList<Actor> actors;
	
	public Movie(String title, Date release, String director, String tagline, ArrayList<Actor> actors){
		this.title = title;
		this.releaseDate = release;
		this.director = director;
		this.tagline = tagline;
		this.actors = actors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate
				+ ", director=" + director + ", tagline=" + tagline
				+ ", actors=" + actors + "]";
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public ArrayList<Actor> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
}
