package orm.model;

import java.util.Date;

public class Actor {
	private String name;
	private Date dateOfBirth;
	
	public Actor(String name, Date dob) {
		this.name = name;
		this.dateOfBirth = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

}