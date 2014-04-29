package sql.test;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Actor implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long actorID;
	
	String firstname, surname;
	
	@Transient
	protected Object[] jdoDetachedState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	FilmPart filmPart;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Long getActorID(){
		return actorID;
	}
	
	public FilmPart getFilmPart(){
		return filmPart;
	}
	
	public void setFilmPart(FilmPart filmPart){
		this.filmPart = filmPart;
	}
}
