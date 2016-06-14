package ch.hevs.businessobject;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Writer extends Person{
	
	@ManyToMany(mappedBy="writers")
	private Set<Book> books;
	
	public Set<Book> getBooks(){
		return books;
	}
	public void setBooks(Set<Book> books){
		this.books=books;
	}

	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Writer(String firstname, String lastname, Date birthday, Date deathday) {
		super(firstname, lastname, birthday, deathday);
		// TODO Auto-generated constructor stub
	}

	
}
