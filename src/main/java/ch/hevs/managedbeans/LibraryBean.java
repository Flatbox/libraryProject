package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bankservice.Library;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;



public class LibraryBean {
	
	
	private Library library;
	
	//Books
	private Book book;
	private String bookTitle;
	List <Book> books;
	
	//Categories
	private Category category;
	private long categoryid;
	
	 List<Category> categories;
	
	
	
	
	
	@PostConstruct
	public void initialize() throws NamingException {
		
		// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		library = (Library) ctx.lookup("java:global/libraryProject-0.0.1-SNAPSHOT/LibraryBean!ch.hevs.bankservice.Library");
		//Books
		this.bookTitle = library.getBook().getTitle();
		//Categories
		this.categories = library.getCategories();
		
	}
	

	//Books
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	//Category
	
	public String bookCategory(long id){
		setCategoryid(id);
		this.books = library.getBooksByCategory(id);
		
		return  "ok";
	}
	//Getters & Setters
	
	
	public Library getLibrary() {
		return library;
	}




	public long getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}


	public void setLibrary(Library library) {
		this.library = library;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	
	
}
