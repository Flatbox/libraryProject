package ch.hevs.managedbeans;




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
	private String publicationDate;
	private String isbn;
	private List <Book> books;
	
	//Categories
	private Category category;
	private long categoryid;
	private String categoryname;
	
	private List<Category> categories;
	
	
	
	
	
	@PostConstruct
	public void initialize() throws NamingException {
		
		// JNDI
    	InitialContext ctx = new InitialContext();
		library = (Library) ctx.lookup("java:global/libraryProject-0.0.1-SNAPSHOT/LibraryBean!ch.hevs.bankservice.Library");
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
	

	public String addBook()
	{
	 
	Book book = new Book(bookTitle ,publicationDate,isbn);
		
		library.addBook(book, categories.get((int) categoryid /10 - 1));

		bookTitle = "";
		
		isbn = "";
		
		bookCategory(getCategoryid());
		return "ok";		
	}
	
	public void deleteBook(long id){
		
		library.deleteBook(id);
		bookCategory(getCategoryid());
	}
	
	//Category
	
	// Goto Books by category
	public String bookCategory(long id){
		setCategoryid(id);
		setCategoryname(library.getCategoryName(categories.get((int) id/10 - 1)));
		this.setBooks(library.getBooksByCategory(id));
		
		return  "ok";
	}
	
	
	
	//Getters & Setters	
	
	public Library getLibrary() {
		return library;
	}




	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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


	public List <Book> getBooks() {
		return books;
	}


	public void setBooks(List <Book> books) {
		this.books = books;
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
