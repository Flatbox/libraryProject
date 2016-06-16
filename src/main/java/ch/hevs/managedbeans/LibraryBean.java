package ch.hevs.managedbeans;




import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import ch.hevs.bankservice.Library;
import ch.hevs.businessobject.AudioBook;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Ebook;
import ch.hevs.businessobject.Writer;




public class LibraryBean {
	
	
	private Library library;
	
	//Books
	private Book book;
	private String bookTitle;
<<<<<<< HEAD
	private String publicationDate;
	private String isbn;
	private List <Book> books;
=======
	private List<Book> books;
	private AudioBook audiobook;
	private List<AudioBook> audiobooks;
	private List<Ebook> ebooks;
>>>>>>> origin/master
	
	//Categories
	private Category category;
	private long categoryid;
	private String categoryname;
	
	private List<Category> categories;
	
	//Writers
	private Writer writer;
	private long writerid;
	private String writerLastname;
	private List<Writer> writers;
	
	
	
	
	
	@PostConstruct
	public void initialize() throws NamingException {
		
		// JNDI
    	InitialContext ctx = new InitialContext();
		library = (Library) ctx.lookup("java:global/libraryProject-0.0.1-SNAPSHOT/LibraryBean!ch.hevs.bankservice.Library");
<<<<<<< HEAD
=======
		//Books
		this.bookTitle = library.getBook().getTitle();
		this.books = library.booksList();
		this.audiobooks=library.audiobooksList();
		this.ebooks=library.ebooksList();
>>>>>>> origin/master
		//Categories
		this.categories = library.getCategories();
		//Writer
		this.writers = library.getWriters();
		
	}
	

	public void updateTaken(AudioBook audiobook) {
		library.updateTaken(audiobook);
		
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
		
		return "ok";

	}
	
	//Writer
	
	public String bookWriter(long id){
		setWriterid(id);
		this.setBooks(library.getBooksByWriter(id));
		
		return "ok";
	}
<<<<<<< HEAD
=======
	


	//Getters & Setters
>>>>>>> origin/master
	
	public void setWriters(List<Writer> writers) {
		this.writers = writers;
		
	}
	
	public List<Writer> getWriters(){
		return writers;
	}


	public void setWriterid(long writerid) {
		this.writerid = writerid;
		
	}
	
	public Long getWriterid(){
		return writerid;
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


<<<<<<< HEAD
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
=======
	public Writer getWriter() {
		return writer;
	}


	public void setWriter(Writer writer) {
		this.writer = writer;
	}


	public String getWriterLastname() {
		return writerLastname;
	}


	public void setWriterLastname(String writerLastname) {
		this.writerLastname = writerLastname;
	}


	public List<AudioBook> getAudiobooks() {
		return audiobooks;
	}


	public void setAudiobooks(List<AudioBook> audiobooks) {
		this.audiobooks = audiobooks;
	}


	public List<Ebook> getEbooks() {
		return ebooks;
	}


	public void setEbooks(List<Ebook> ebooks) {
		this.ebooks = ebooks;
>>>>>>> origin/master
	}


	
	
}
