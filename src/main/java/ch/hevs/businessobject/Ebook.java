package ch.hevs.businessobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Ebook extends Book {
	
	@Column(nullable = true)
	private String format;
	private String permissions;

	
	//Constructors
	public Ebook(String title, Date publicationDate, String isbn, String format, String permissions) {
		super(title, publicationDate, isbn);
		this.format = format;
		this.permissions = permissions;
	}

	public Ebook() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters & Setters
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	

}
