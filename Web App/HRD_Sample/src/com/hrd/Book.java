package com.hrd;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key bookID;
	
	@Basic
	Date bPublishDate;

	String bAuthor;
	String bName;
	String bPublisher;
	int bLength;
	
	public Book()
	{
		bName = bPublisher = "";
		bLength = 0;
		bPublishDate = new Date();
	}
	
	public void setDetails(String name, String author, Date date, String publisher, int length)
	{
		bName = name;
		bAuthor = author;
		bPublishDate = date;
		bPublisher = publisher;
		bLength = length;
	}

	public Key getBookID() {
		return bookID;
	}

	public void setBookID(Key bookID) {
		this.bookID = bookID;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthors() {
		return bAuthor;
	}

	public void setbAuthors(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bPublishDate=" + bPublishDate
				+ ", bAuthor=" + bAuthor + ", bName=" + bName + ", bPublisher="
				+ bPublisher + ", bLength=" + bLength + "]";
	}

	public Date getbPublishDate() {
		return bPublishDate;
	}

	public void setbPublishDate(Date bPublishDate) {
		this.bPublishDate = bPublishDate;
	}

	public String getbPublisher() {
		return bPublisher;
	}

	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}

	public int getbLength() {
		return bLength;
	}

	public void setbLength(int bLength) {
		this.bLength = bLength;
	}
}
