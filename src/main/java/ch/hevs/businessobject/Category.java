package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String description;
	
	//Constructors
	public Category(String name, String description) {
		
		this.books = new HashSet<Book>();
		this.name = name;
		this.description = description;
	}
	
	
	public Category() {
		super();
	}
	
	@ManyToMany(mappedBy="categories")
	private Set<Book> books;
	
	public Set<Book> getBooks(){
		return books;
	}
	
	public void setBooks(Set<Book> books){
		this.books=books;
	}


	//Getters & Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
