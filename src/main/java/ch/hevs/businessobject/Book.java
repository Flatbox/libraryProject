package ch.hevs.businessobject;




import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hsqldb.lib.HashSet;


@Entity
@org.hibernate.annotations.DiscriminatorOptions(force=true)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String title;
	private String publicationDate;
	private String isbn;

	//Relations
	@ManyToMany(cascade= CascadeType.REFRESH) //TODO V�rifier le type de cascade pour voir s'il est correspondant
	private Set<Writer> writers;

	public Set<Writer> getWriters(){
		return writers;
	}

	public void setWriters(Set<Writer> writers){

		this.writers = writers;
	}

	public void addWriter(Writer writer){
		writers.add(writer);
	}

	@ManyToMany(cascade= CascadeType.REFRESH)//TODO V�rifier le type de cascade pour voir s'il est correspondant
	private Set<Category> categories;

	public Set<Category> getCategories(){
		return categories;
	}

	public void setCategory(Set<Category> categories){

		this.categories = categories;
	}

	public void addCategory(Category category){
		categories.add(category);
	}


	// Constructors

	public Book(String title, String publicationDate, String isbn) {

		this.categories = new java.util.HashSet <Category>();
		this.title = title;
		this.publicationDate = publicationDate;
		this.isbn = isbn;
		
	}
	public Book(String title, String isbn) {

		this.title = title;
		
		this.isbn = isbn;
		
	}

	public Book() {
		super();
	}

	// Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	



}
