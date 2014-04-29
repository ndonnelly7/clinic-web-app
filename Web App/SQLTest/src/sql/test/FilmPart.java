package sql.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class FilmPart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long filmID;
	
	
	@Transient
	protected Object[] jdoDetachedState;
	
	String title, director, production;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "releaseDate")
	Date release;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filmPart", cascade = CascadeType.ALL)
	List<Actor> actors;
	
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

	public Long getFilmID(){
		return filmID;
	}
	
	public void setActors(ArrayList<Actor> actors){
		this.actors = actors;
	}
	
	public List<Actor> getActors(){
		return actors;
	}
}
