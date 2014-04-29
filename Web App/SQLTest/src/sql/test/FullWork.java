package sql.test;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name="Work")
public class FullWork {

	String title;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer workID;
	
	@OneToOne(cascade = CascadeType.ALL)
	FilmPart film;
	
	@OneToOne(cascade = CascadeType.ALL)
	BookPart book;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	FullWork(String name){
		this.title = name;
	}
	
	FullWork(){
		
	}
	
	public void setFilm(FilmPart f){
		film = f;
	}
	
	public void setBook(BookPart b){
		book = b;
	}
	
	public FilmPart getFilm(){
		return film;
	}
	
	public BookPart getBook(){
		return book;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getWorkID(){
		return workID;
	}
}
